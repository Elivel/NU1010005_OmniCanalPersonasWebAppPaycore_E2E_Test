package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.LBL_PAGO_TRANSF_EXITO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarTransferenciasEntreAPCA implements Task {

    private List<Transferencias> datostransferencias;

    public RealizarTransferenciasEntreAPCA(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} realiza transferencia de 'Ahorro Programado' a 'Cuenta de ahorro propia'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                WaitUntil.the(OPCIÓN_TRANSF_C.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIÓN_TRANSF_C.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIÓN_TRANSF_C.of(t.getCuentaOrigen())),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCuentaDestino()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCuentaDestino()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERIR_CTA_DES.of(t.getCuentaDestino())),
                WaitUntil.the(TTL_SOLIC_TRANSF_CP, isVisible()).forNoMoreThan(30).seconds(),
                SendKeys.of(t.getMonto()).into(TXT_MONTO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_TRANSFERIR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TRANSFERIR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TRANSFERIR),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
        WaitUntil.the(LBL_PAGO_TRANSF_EXITO, isVisible()).forNoMoreThan(200).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
    }

    public static RealizarTransferenciasEntreAPCA cuentasPropias(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarTransferenciasEntreAPCA.class).withProperties(datostransferencias);
    }

}
