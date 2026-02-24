package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarTransferenciaTerceroFavoritoCelular implements Task {

    private List<Transferencias> datostransferencias;

    public RealizarTransferenciaTerceroFavoritoCelular(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} realiza proceso de transferencia desde favorito")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(datostransferencias));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR)),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCelular()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCelular()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCelular())),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_TERCERO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_TRANSFERIR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TRANSFERIR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TRANSFERIR),
                WaitUntil.the(RESULTADOS.of(ACEPTAR), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of(ACEPTAR), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of(ACEPTAR), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(RESULTADOS.of(ACEPTAR)),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
        WaitUntil.the(RESULTADOS.of(TRANSFERENCIA_EXITOSA), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /* Capturar comprobante */
        actor.attemptsTo(
                CapturaComprobanteCtaTercerosCelular.datosC(datostransferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* -------------------- */

        actor.attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(
                VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(),
                OBTENER_SALDO.resolveFor(actor).getText());
        actor.attemptsTo(
                IngresoFavoritos.inicio(datostransferencias),
                EliminaFavorito.datosCA(t.getNombreFavorito()));
    }

    public static RealizarTransferenciaTerceroFavoritoCelular favorito(List<Transferencias> datostransferencias) {

        return Instrumented.instanceOf(RealizarTransferenciaTerceroFavoritoCelular.class).withProperties(datostransferencias);
    }
}