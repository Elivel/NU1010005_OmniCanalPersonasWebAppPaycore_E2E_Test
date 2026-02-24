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

public class ConsultaDetalleDepositoAPlazo implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleDepositoAPlazo(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de Deposito a plazo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(TOTAL_CUENTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(DAP).andAlignToTop(),
                Ensure.that(LBL_ALIAS_PRD.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(SALDO_PRINCIPAL.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(TIPO_CA.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(NUMERCUENTA_DAP.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(ESTADO_CA.of(ca.getCuentaOrigen())).isDisplayed());
        actor.remember(VariablesSesion.ALIAS1.toString(), LBL_ALIAS_PRD.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDPRINC.toString(), SALDO_PRINCIPAL.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", "."));
        actor.remember(VariablesSesion.TIPO1.toString(), TIPO_CA.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT).toUpperCase());
        actor.remember(VariablesSesion.NUMEROCC1.toString(), NUMERCUENTA_DAP.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOCC1.toString(), ESTADO_CA.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_CUENTA.of(ca.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(ca.getCuentaOrigen())),
                WaitUntil.the(TTL_RESUMEN_DEPOSITO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_RESUMEN_DEPOSITO).isDisplayed(),
                Ensure.that(LBL_ALIAS_PRD2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS1.toString())),
                Ensure.that(SALDO_PRINCIPAL2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDPRINC.toString())),
                Ensure.that(TIPO_CA2).attribute("innerText").isEqualTo(actor.recall(VariablesSesion.TIPO1.toString())),
                Ensure.that(NUMERCUENTA_DAP2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMEROCC1.toString())),
                Ensure.that(ULTPAGO_DAP2).isDisplayed(),
                Ensure.that(MONTINIC_DAP2).isDisplayed(),
                Ensure.that(ESTADO_DAP2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOCC1.toString())));
        actor.remember(VariablesSesion.ALIAS2.toString(), LBL_ALIAS_PRD2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDPRINC2.toString(), SALDO_PRINCIPAL2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.PRODUCTO2.toString(), TIPO_CA2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMCUENT2.toString(), NUMERCUENTA_DAP2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ULTPAG2.toString(), ULTPAGO_DAP2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.MONTINI2.toString(), MONTINIC_DAP2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTDAP2.toString(), ESTADO_DAP2.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MASDETALLDAP, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_MASDETALLDAP).isDisplayed(),
                Ensure.that(ALIAS_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS2.toString())),
                Ensure.that(TIPO_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PRODUCTO2.toString())),
                Ensure.that(NUMERCUENTA_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMCUENT2.toString())),
                Ensure.that(ULTPAGO_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ULTPAG2.toString())),
                Ensure.that(ESTADO_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTDAP2.toString())),
                Ensure.that(SALD_PIGN_DAP3).isDisplayed(),
                Ensure.that(SECC_SALDOS).isDisplayed(),
                Ensure.that(MONT_INIC_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.MONTINI2.toString())),
                Ensure.that(SALDO_PRINCIPAL3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDPRINC2.toString())),
                Ensure.that(SALD_INT_DAP3).isDisplayed(),
                Ensure.that(SALD_AL_DIA_DAP3).isDisplayed(),
                Ensure.that(SBTTL_DATOS_GEN_EF).isDisplayed(),
                Ensure.that(TASA_INT_DAP3).isDisplayed(),
                Ensure.that(TASA_DIF_DAP3).isDisplayed(),
                Ensure.that(PLAZO_DAP3).isDisplayed(),
                Ensure.that(PERIO_FP_DAP3).isDisplayed(),
                Ensure.that(CUEN_RECEP_DAP3).isDisplayed(),
                Ensure.that(TIPO_DEPO_DAP3).isDisplayed(),
                Scroll.to(TTL_FECHAS_DAP3).andAlignToTop(),
                Ensure.that(TTL_FECHAS_DAP3).isDisplayed(),
                Ensure.that(APERTURA_DAP3).isDisplayed(),
                Ensure.that(ULT_PAGO_DAP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ULTPAG2.toString())),
                Ensure.that(CALC_INT_DAP3).isDisplayed(),
                Ensure.that(VENC_DAP3).isDisplayed(),
                Ensure.that(INICIO_CICL_DAP3).isDisplayed(),
                Ensure.that(CANCELACION_DAP3).isDisplayed());
    }
    public static ConsultaDetalleDepositoAPlazo datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleDepositoAPlazo.class).withProperties(datosDCA);
    }
}