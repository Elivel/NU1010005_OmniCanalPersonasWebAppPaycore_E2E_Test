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

public class ConsultaDetalleExtrafinanciamiento implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleExtrafinanciamiento(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de extrafinanciamiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(TOTAL_CUENTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(ALIAS_EF.of(ca.getExtrafinanciamiento())).andAlignToTop(),
                Ensure.that(ALIAS_EF.of(ca.getExtrafinanciamiento())).isDisplayed(),
                Ensure.that(TIPO_CA.of(ca.getExtrafinanciamiento())).isDisplayed(),
                Ensure.that(DEUDA_TOTAL_EF.of(ca.getExtrafinanciamiento())).isDisplayed(),
                Ensure.that(NUM_EF.of(ca.getExtrafinanciamiento())).isDisplayed(),
                Ensure.that(FECHA_PAGO_EF.of(ca.getExtrafinanciamiento())).isDisplayed(),
                Ensure.that(ESTADO_EF.of(ca.getExtrafinanciamiento())).isDisplayed());
        actor.remember(VariablesSesion.ALIASEF.toString(), ALIAS_EF.of(ca.getExtrafinanciamiento()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOEF.toString(), TIPO_CA.of(ca.getExtrafinanciamiento()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.DEUDATEF.toString(), DEUDA_TOTAL_EF.of(ca.getExtrafinanciamiento()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", "."));
        actor.remember(VariablesSesion.NUMEF.toString(), NUM_EF.of(ca.getExtrafinanciamiento()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.FECHAPAGEF.toString(), FECHA_PAGO_EF.of(ca.getExtrafinanciamiento()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOEF.toString(), ESTADO_EF.of(ca.getExtrafinanciamiento()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_EXTRAFINANCIAMIENTO.of(ca.getExtrafinanciamiento()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_EXTRAFINANCIAMIENTO.of(ca.getExtrafinanciamiento())),
                WaitUntil.the(TTL_RESUMEN_EXTRAFINANCIAMIENTO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_RESUMEN_EXTRAFINANCIAMIENTO).isDisplayed(),
                Ensure.that(ALIAS_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASEF.toString())),
                Ensure.that(DEUDA_TOTAL_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.DEUDATEF.toString())),
                Ensure.that(TIPO_PRD2).attribute("innerText").isEqualToIgnoringCase(actor.recall(VariablesSesion.TIPOEF.toString())),
                Ensure.that(NUM_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMEF.toString())),
                Ensure.that(FECHA_PAGO_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHAPAGEF.toString())),
                Ensure.that(ULT_PAGO_EF).isDisplayed(),
                Ensure.that(CUOTA_EF).isDisplayed(),
                Ensure.that(ESTADO_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOEF.toString())));
        actor.remember(VariablesSesion.ALIASEF2.toString(), ALIAS_EF2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOEF2.toString(), TIPO_PRD2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.DEUDATEF2.toString(), DEUDA_TOTAL_EF2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMEF2.toString(), NUM_EF2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.FECHAPAGEF2.toString(), FECHA_PAGO_EF2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOEF2.toString(), ESTADO_EF2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ULTPAGOEF.toString(), ULT_PAGO_EF.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.CUOTAEF.toString(), CUOTA_EF.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE_EF, isVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIAS_EF3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASEF2.toString())),
                Ensure.that(TIPO_PRD3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIPOEF2.toString())),
                Ensure.that(NUM_EF3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMEF2.toString())),
                Ensure.that(ESTADO_EF3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOEF2.toString())),
                Ensure.that(SBTTL_DATOS_GEN_EF).isDisplayed(),
                Ensure.that(MONTO_EF).isDisplayed(),
                Ensure.that(SALDO_EF).isDisplayed(),
                Ensure.that(TASA_EF).isDisplayed(),
                Ensure.that(GARANTIA_EF).isDisplayed(),
                Ensure.that(FECHA_AP_EF).isDisplayed(),
                Ensure.that(ULTMOV_EF).isDisplayed(),
                Ensure.that(ULT_PAGO_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHAPAGEF2.toString())),
                Ensure.that(VENC_EF).isDisplayed(),
                Ensure.that(SALDO_AHO_EF).isDisplayed(),
                Ensure.that(ESTADO_ACTUAL_EF).isDisplayed(),
                Scroll.to(SBTTL_CM_EF).andAlignToTop(),
                Ensure.that(SBTTL_CM_EF).isDisplayed(),
                Ensure.that(CUOTA_NORMAL).isDisplayed(),
                Ensure.that(SEGURO_EF).isDisplayed(),
                Ensure.that(COMISION_ADM_EF).isDisplayed(),
                Ensure.that(IVA).isDisplayed(),
                Ensure.that(CUOTA_AHORRO).isDisplayed(),
                Ensure.that(CUOTA_EF2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.CUOTAEF.toString())),
                Ensure.that(SEGURO_DIF_COVID).isDisplayed(),
                Ensure.that(INT_DIF_COVID).isDisplayed(),
                Scroll.to(SBTTL_CT_EF).andAlignToTop(),
                Ensure.that(SBTTL_CT_EF).isDisplayed(),
                Ensure.that(SALD_CAP).isDisplayed(),
                Ensure.that(SEGURO_EF2).isDisplayed(),
                Ensure.that(COMISION_ADM_EF2).isDisplayed(),
                Ensure.that(IVA2).isDisplayed(),
                Ensure.that(RECARGO_MORA_EF).isDisplayed(),
                Ensure.that(INTERESES_EF).isDisplayed(),
                Ensure.that(HONOR_COBEXT_EF).isDisplayed(),
                Ensure.that(DEUDA_TOTAL_EF3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.DEUDATEF2.toString())),
                //Ensure.that(INT_COVID_EF).isDisplayed(),
                //Ensure.that(SEG_COVID_EF).isDisplayed(),
                Ensure.that(SBTTL_DETALLEM).isDisplayed(),
                Ensure.that(VAL_CUOMORA).isDisplayed(),
                Ensure.that(SEGURO_EF3).isDisplayed(),
                Ensure.that(COMISION_ADM_EF3).isDisplayed(),
                Ensure.that(IVA3).isDisplayed(),
                Ensure.that(RECARGO_MORA_EF2).isDisplayed(),
                Ensure.that(CUOTA_AHORRO2).isDisplayed(),
                Ensure.that(MORA_EF).isDisplayed(),
                Ensure.that(HONOR_COBEXT_EF2).isDisplayed(),
                Ensure.that(VALPENPAG_EF).isDisplayed(),
                Ensure.that(CUOMORA_EF).isDisplayed(),
                Ensure.that(DIAMORA_EF).isDisplayed(),
                Ensure.that(FECHINIMORA_EF).isDisplayed());
    }

    public static ConsultaDetalleExtrafinanciamiento datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleExtrafinanciamiento.class).withProperties(datosDCA);
    }
}