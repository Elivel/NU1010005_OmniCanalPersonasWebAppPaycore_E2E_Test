package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_PRES365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_PAGO_PRESTAMO_TRANSFER365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresarFavoritoPagoPrestamoTransfer365 implements Task {
    private List<Transferencias> datosDCA;

    public IngresarFavoritoPagoPrestamoTransfer365(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'realiza proceso de pago de préstamo con favorito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosDCA.get(0);

        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Scroll.to(BTN_REALIZAR_OTRA).andAlignToTop());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(BTN_REALIZAR_OTRA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_REALIZAR_OTRA),
                WaitUntil.the(RESULTADOS.of("Pago de préstamo Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito())),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
        //new IngresarClaveDinamica(),
        WaitUntil.the(RESULTADOS_PRES365, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /*Capturar comprobante
        actor.attemptsTo(
                CapturarComprobantePrestamo365.datosC(datosDCA),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*
        actor.attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(datosDCA));
        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());*/
    }

    public static IngresarFavoritoPagoPrestamoTransfer365 inicio(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(IngresarFavoritoPagoPrestamoTransfer365.class).withProperties(datosDCA);
    }
}
