package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarTransferenciasEntreAPTerceroCuenta implements Task {

    private List<Transferencias> datostransferencias;

    public RealizarTransferenciasEntreAPTerceroCuenta(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} realiza transferencia de 'Ahorro Programado' a 'Tercero' por cuenta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                WaitUntil.the(OPCION_TRANSFERIR1.of(TRANSFERIR), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_TRANSFERIR1.of(TRANSFERIR), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_TRANSFERIR1.of(TRANSFERIR)),
                WaitUntil.the(BTN_TRANSF_TERC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TRANSF_TERC, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TRANSF_TERC),
                WaitUntil.the(TTL_TRANSF_TERC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_TRANSF_TERC, isEnabled()).forNoMoreThan(60).seconds(),
                SendKeys.of(t.getCuentaDestino()).into(NUM_CUENTA),
                SendKeys.of(t.getCorreo()).into(CORR_ELECTRO),
                SendKeys.of(t.getMonto()).into(MONTO_TERC),
                SendKeys.of(t.getConcepto()).into(CONCEPTO_TERC),
                WaitUntil.the(BTN_CONTINUAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(BTN_ACEPTAR2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR2));
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
        WaitUntil.the(LBL_PAGO_TRANSF_EXITO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
    }

    public static RealizarTransferenciasEntreAPTerceroCuenta cuentasTerceros(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarTransferenciasEntreAPTerceroCuenta.class).withProperties(datostransferencias);
    }

}
