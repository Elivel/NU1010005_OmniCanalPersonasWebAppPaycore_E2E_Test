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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetalleFondoInversion implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleFondoInversion(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de fondo de inversión'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(TOTAL_CUENTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(LBL_ALIAS_PRD.of(ca.getFondoInversion())).isDisplayed(),
                Scroll.to(TIPO_FONDO_INVERSION).andAlignToBottom(),
                Ensure.that(TIPO_FONDO_INVERSION.of(ca.getFondoInversion())).isDisplayed(),
                Ensure.that(NUMERO_FONDO.of(ca.getFondoInversion())).isDisplayed(),
                Ensure.that(SALDO_DISPONIBLE_FONDO.of(ca.getFondoInversion())).isDisplayed(),
                Ensure.that(ESTADO_FONDO.of(ca.getFondoInversion())).isDisplayed());
        actor.remember(VariablesSesion.ALIAS1.toString(), LBL_ALIAS_PRD.of(ca.getFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIP_FONDO.toString(), TIPO_FONDO_INVERSION.of(ca.getFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUM_FONDO.toString(), NUMERO_FONDO.of(ca.getNumeroFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SAL_DISP_FONDO.toString(), SALDO_DISPONIBLE_FONDO.of(ca.getFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", "."));
        actor.remember(VariablesSesion.EST_FONDO.toString(), ESTADO_FONDO.of(ca.getFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_FI.of(ca.getFondoInversion()), isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(VER_MAS_FI.of(ca.getFondoInversion()), isClickable()).forNoMoreThan(15).seconds(),
                Click.on(VER_MAS_FI.of(ca.getFondoInversion())),
                WaitUntil.the(TTL_RESUMEN_FI, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_RESUMEN_FI).isDisplayed(),
                Ensure.that(LBL_ALIAS_PRD_2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS1.toString())),
                Ensure.that(SALDO_DISPONIBLE_FONDO2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SAL_DISP_FONDO.toString())),
                Ensure.that(NUMERO_FONDO2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUM_FONDO.toString())),
                Ensure.that(TIPO_FONDO_INVERSION2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIP_FONDO.toString())),
                Ensure.that(VALOR_CUOTA).isDisplayed(),
                Ensure.that(MONTO_MAX_RETIRO).isDisplayed(),
                Ensure.that(ESTADO_FONDO2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.EST_FONDO.toString())));
        actor.remember(VariablesSesion.VAL_CUOTA_FI.toString(), VALOR_CUOTA.of(ca.getFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.MAX_RET_FI.toString(), MONTO_MAX_RETIRO.of(ca.getFondoInversion()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE_FI, isVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_MAS_DETALLE_FI).isDisplayed(),
                Ensure.that(LBL_ALIAS_PRD_3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS1.toString())),
                Ensure.that(NUMERO_FONDO3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUM_FONDO.toString())),
                Ensure.that(TIPO_FONDO_INVERSION3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIP_FONDO.toString())),
                Ensure.that(ESTADO_FONDO3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.EST_FONDO.toString())),
                Ensure.that(SECC_RESUM).isDisplayed(),
                Ensure.that(SALDO_FONDO).isDisplayed(),
                Ensure.that(SALDO_DISPONIBLE_FONDO3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SAL_DISP_FONDO.toString())),
                Ensure.that(SALDO_EFECTIVIZAR).isDisplayed(),
                Ensure.that(SALDO_PROT).isDisplayed(),
                Ensure.that(CUOTAS_PARTICIPACION).isDisplayed(),
                Ensure.that(MONTO_MAX_RETIRO2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.MAX_RET_FI.toString())),
                Ensure.that(SECC_FOND).isDisplayed(),
                Ensure.that(FECHA_FI).isDisplayed(),
                Ensure.that(VALOR_CUOTA2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.VAL_CUOTA_FI.toString())),
                Ensure.that(MONEDA).isDisplayed(),
                Ensure.that(MONTO_MIN).isDisplayed(),
                Scroll.to(SECC_FECH).andAlignToTop(),
                Ensure.that(ULT_MOV_FI).isDisplayed());

    }
    public static ConsultaDetalleFondoInversion datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleFondoInversion.class).withProperties(datosDCA);
    }
}