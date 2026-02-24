package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OPC_MAS_DETALLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCION_MENU;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TARJETAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetalleTarjetaDebito implements Task {
    private List<Transferencias> datosDCA;

    public ConsultaDetalleTarjetaDebito(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de tarjeta de débito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(TARJETAS), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of(TARJETAS)),
                WaitUntil.the(TOTAL_TDC, isCurrentlyVisible()).forNoMoreThan(400).seconds(),
                Scroll.to(LOGO_TDC1.of(ca.getTarjetaDebito())).andAlignToTop(),
                Ensure.that(LOGO_TDC1.of(ca.getTarjetaDebito())).isDisplayed(),
                Ensure.that(ALIASTDC1.of(ca.getTarjetaDebito())).isDisplayed(),
                Ensure.that(SALDO_TDC1.of(ca.getTarjetaDebito())).isDisplayed(),
                Ensure.that(ESTADO_TDD1.of(ca.getTarjetaDebito())).isDisplayed(),
                Ensure.that(NUM_TDD1.of(ca.getTarjetaDebito())).isDisplayed(),
                Ensure.that(TIPO_TDC1.of(ca.getTarjetaDebito())).isDisplayed());

        actor.remember(VariablesSesion.ALIAS_TDC1.toString(), ALIASTDC1.of(ca.getTarjetaDebito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP_TDC1.toString(), SALDO_TDC1.of(ca.getTarjetaDebito()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", "."));
        actor.remember(VariablesSesion.ESTADOTDC1.toString(), ESTADO_TDD1.of(ca.getTarjetaDebito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMERO_TDC1.toString(), NUM_TDD1.of(ca.getTarjetaDebito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOTDC1.toString(), TIPO_TDC1.of(ca.getTarjetaDebito()).resolveFor(actor).getAttribute(TEXT_CONTENT));

        actor.attemptsTo(
                WaitUntil.the(VER_MAS_CUENTA_TC.of(ca.getTarjetaDebito()), isVisible()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(ca.getTarjetaDebito())),
                WaitUntil.the(TTL_RES_DETALLE_TDD, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIASTDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS_TDC1.toString())),
                Ensure.that(NUM_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMERO_TDC1.toString())),
                Ensure.that(TIPO_TDC2).attribute("innerText").isEqualTo(actor.recall(VariablesSesion.TIPOTDC1.toString())),
                Ensure.that(SALDO_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDO_DISP_TDC1.toString())),
                Ensure.that(TARJ_CRED1).isDisplayed());

        actor.remember(VariablesSesion.ALIAS_TDC2.toString(), ALIASTDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMERO_TDC2.toString(), NUM_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOTDC2.toString(), TIPO_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP_TDC2.toString(), SALDO_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TARJCRED1.toString(), TARJ_CRED1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE_TDD, isCurrentlyVisible()).forNoMoreThan(60).seconds());
    }

    public static ConsultaDetalleTarjetaDebito datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleTarjetaDebito.class).withProperties(datosDCA);
    }
}