package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetalleCuentaDeAhorro implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleCuentaDeAhorro(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de cuenta de ahorro'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(TOTAL_CUENTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(LBL_ALIAS_PRD.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(SALDO_DISPONIBLE_CA.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(TIPO_CA.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(NUMERO_CA.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(ESTADO_CA.of(ca.getCuentaOrigen())).isDisplayed());
        actor.remember(VariablesSesion.ALIAS1.toString(), LBL_ALIAS_PRD.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP1.toString(), SALDO_DISPONIBLE_CA.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", "."));
        actor.remember(VariablesSesion.TIPO1.toString(), TIPO_CA.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT).toUpperCase());
        actor.remember(VariablesSesion.NUMEROCC1.toString(), NUMERO_CA.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOCC1.toString(), ESTADO_CA.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_CUENTA.of(ca.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(ca.getCuentaOrigen())),
                WaitUntil.the(TTL_RESUMEN_CA2, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_RESUMEN_CA2).isDisplayed(),
                Ensure.that(LBL_ALIAS_PRD2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS1.toString())),
                Ensure.that(SALDO_DISPONIBLE_CA2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDO_DISP1.toString())),
                Ensure.that(TIPO_CA2).attribute("innerText").isEqualTo(actor.recall(VariablesSesion.TIPO1.toString())),
                Ensure.that(NUMERO_CA2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMEROCC1.toString())),
                Ensure.that(ESTADO_CA2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOCC1.toString())),
                Ensure.that(SALDO_RETENIDO_CA).isDisplayed());
        actor.remember(VariablesSesion.ALIAS2.toString(), LBL_ALIAS_PRD2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP2.toString(), SALDO_DISPONIBLE_CA2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPO2.toString(), TIPO_CA2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMEROCC2.toString(), NUMERO_CA2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOCC2.toString(), ESTADO_CA2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDORET1.toString(), SALDO_RETENIDO_CA.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE.of(ca.getCuentaOrigen())),
                WaitUntil.the(TTL_MAS_DETALLE_CA, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_MAS_DETALLE_CA).isDisplayed(),
                Ensure.that(LBL_ALIAS_PRD3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS2.toString())),
                Ensure.that(TIPO_CA3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIPO2.toString())),
                Ensure.that(NUMERO_CA3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMEROCC2.toString())),
                Ensure.that(ESTADO_CA3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOCC2.toString())),
                Ensure.that(SECC_SALDOS).isDisplayed(),
                Ensure.that(SALDO_CONTABLE_CA).isDisplayed(),
                Ensure.that(SALDO_DISPONIBLE_CA3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDO_DISP2.toString())),
                Ensure.that(SALDO_RETENIDO_CA2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDORET1.toString())),
                Ensure.that(SECC_PROMEDIOS).isDisplayed(),
                Ensure.that(PROM_MES_ACT).isDisplayed(),
                Ensure.that(PROM_ULT_TRM).isDisplayed());
    }

    public static ConsultaDetalleCuentaDeAhorro datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleCuentaDeAhorro.class).withProperties(datosDCA);
    }
}