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

public class ConsultaDetalleEcard implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleEcard(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de e-card'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(TARJETAS), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of(TARJETAS)),
                WaitUntil.the(TOTAL_TDC, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(LOGO_TDC1.of(ca.getTarjetaCredito())).andAlignToTop(),
                Ensure.that(LOGO_TDC1.of(ca.getTarjetaCredito())).isDisplayed(),
                Ensure.that(ALIASTDC1.of(ca.getTarjetaCredito())).isDisplayed(),
                Ensure.that(SALDO_TDC1.of(ca.getTarjetaCredito())).isDisplayed(),
                Ensure.that(FECHA_PAGO_TDC1.of(ca.getTarjetaCredito())).isDisplayed(),
                Ensure.that(ESTADO_TDC1.of(ca.getTarjetaCredito())).isDisplayed(),
                Ensure.that(NUM_TDC1.of(ca.getTarjetaCredito())).isDisplayed(),
                Ensure.that(TIPO_TDC1.of(ca.getTarjetaCredito())).isDisplayed());
        actor.remember(VariablesSesion.ALIAS_TDC1.toString(), ALIASTDC1.of(ca.getTarjetaCredito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP_TDC1.toString(), SALDO_TDC1.of(ca.getTarjetaCredito()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", "."));
        actor.remember(VariablesSesion.FECHA_DE_PAGO_TDC1.toString(), FECHA_PAGO_TDC1.of(ca.getTarjetaCredito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOTDC1.toString(), ESTADO_TDC1.of(ca.getTarjetaCredito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMERO_TDC1.toString(), NUM_TDC1.of(ca.getTarjetaCredito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOTDC1.toString(), TIPO_TDC1.of(ca.getTarjetaCredito()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_CUENTA_TC.of(ca.getTarjetaCredito()), isVisible()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(ca.getTarjetaCredito())),
                WaitUntil.the(TTL_RESUMEN_ECARD, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIASTDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS_TDC1.toString())),
                Ensure.that(NUM_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMERO_TDC1.toString())),
                Ensure.that(TIPO_TDC2).attribute("innerText").isEqualTo(actor.recall(VariablesSesion.TIPOTDC1.toString())),
                Ensure.that(SALDO_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDO_DISP_TDC1.toString())),
                Ensure.that(FECHA_PAGO_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHA_DE_PAGO_TDC1.toString())),
                Ensure.that(PAGO_CONTADO_TDC1).isDisplayed(),
                Ensure.that(SALDO_PAGAR_TDC1).isDisplayed(),
                Ensure.that(SALDO_RETENIDO_TDC1).isDisplayed(),
                Ensure.that(ESTADO_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOTDC1.toString())),
                Ensure.that(TARJ_CRED1).isDisplayed());
        actor.remember(VariablesSesion.ALIAS_TDC2.toString(), ALIASTDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMERO_TDC2.toString(), NUM_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP_TDC2.toString(), SALDO_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.FECHA_DE_PAGO_TDC2.toString(), FECHA_PAGO_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOTDC2.toString(), ESTADO_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOTDC2.toString(), TIPO_TDC2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.PAGCONT_TDC1.toString(), PAGO_CONTADO_TDC1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDPAG_TDC1.toString(), SALDO_PAGAR_TDC1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDRET_TDC1.toString(), SALDO_RETENIDO_TDC1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TARJCRED1.toString(), TARJ_CRED1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE_ECARD, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIASTDC3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS_TDC2.toString())),
                Ensure.that(TIPO_TDC3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIPOTDC2.toString())),
                Ensure.that(NUM_TDC3).attribute(TEXT_CONTENT).isEqualTo("**** **** "+actor.recall(VariablesSesion.NUMERO_TDC2.toString())),
                Ensure.that(ESTADO_TDC3).attribute("innerText").isEqualToIgnoringCase(actor.recall(VariablesSesion.ESTADOTDC2.toString())),
                Ensure.that(FRANQUICIA_TDC).isDisplayed(),
                Ensure.that(LIMITE_OTORGADO).isDisplayed(),
                Ensure.that(SALDO_UTILIZADO).isDisplayed(),
                Ensure.that(DISPONIBILIDAD).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDO_DISP_TDC2.toString())),
                Ensure.that(SALDO_RETENIDO_TDC2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDRET_TDC1.toString())),
                Ensure.that(PAGO_MINIMO).isDisplayed(),
                Ensure.that(PAGO_CONTADO).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PAGCONT_TDC1.toString())),
                Ensure.that(FECHA_PAGO_TDC3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHA_DE_PAGO_TDC2.toString())),
                Ensure.that(DIA_CORTE).isDisplayed(),
                Scroll.to(MORA_).andAlignToTop(),
                Ensure.that(DIAS30).isDisplayed(),
                Ensure.that(DIAS60).isDisplayed(),
                Ensure.that(DIAS90).isDisplayed(),
                Ensure.that(MORA_TOTAL).isDisplayed(),
                Ensure.that(HONO_COBR_EXT).isDisplayed(),
                Ensure.that(TOTAL_PAGO).isDisplayed());
    }

    public static ConsultaDetalleEcard datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleEcard.class).withProperties(datosDCA);
    }
}