package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasMovimentos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarTransferenciaDeTc implements Task {
    private List<Transferencias> datostransferencias;

    public RealizarTransferenciaDeTc(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} 'realiza proceso de transferencia'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                IngresoVerMasTarjetas.inicio(datostransferencias),
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR)),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCuentaDestino()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCuentaDestino()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCuentaDestino())));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(TTL_SOLIC_TRANSF_CP, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                SendKeys.of(t.getMonto()).into(TXT_MONTO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                Scroll.to(BTN_TRANSFERIR).andAlignToTop(),
                WaitUntil.the(BTN_TRANSFERIR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TRANSFERIR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TRANSFERIR),
                WaitUntil.the(BTN_ACEPTAR1, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR1, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR1));
        LeerArchivoProperties.esperar(15);
        WaitUntil.the(RESULTADOS_TRANSFE, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /* Capturar Comprobante */
        actor.attemptsTo(
                CapturaComprobanteTdcCtaPropia.datosC(datostransferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* ------------------- */

        actor.attemptsTo(
                IngresoMenuCtaAhorroDestinoMovimientos.inicio(datostransferencias));

        actor.remember(VariablesSesion.MONTO_CUENTA_DESTINO_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta Destino Final").andContents(obtenerMontoDestinoFinal().toString());
        actor.attemptsTo(IngresoMenuTarjetasMovimentos.inicio(datostransferencias));
        actor.remember(VariablesSesion.MONTO_FINAL_TC.toString(), DISPONIBILIDAD_TARJETA.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Tarjeta Credito Final").andContents(obtenerMontoTarjetaFinal().toString());
    }

    public static RealizarTransferenciaDeTc cuentaPropia(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarTransferenciaDeTc.class).withProperties(datostransferencias);
    }
}
