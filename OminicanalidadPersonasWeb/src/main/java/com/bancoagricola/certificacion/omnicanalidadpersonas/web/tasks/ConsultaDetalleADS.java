package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
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

public class ConsultaDetalleADS implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleADS(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de adelanto de salario'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(TOTAL_CUENTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(ESTADO_CA.of(ca.getAds())).andAlignToBottom(),
                Ensure.that(LBL_ALIAS_PRD.of(ca.getAds())).isDisplayed(),
                Ensure.that(SALDO_DISPONIBLE_CA.of(ca.getAds())).isDisplayed(),
                Ensure.that(TIPO_CA.of(ca.getAds())).isDisplayed(),
                Ensure.that(NUMERO_CA.of(ca.getAds())).isDisplayed(),
                Ensure.that(ESTADO_CA.of(ca.getAds())).isDisplayed());
        actor.remember(VariablesSesion.ALIAS1.toString(), LBL_ALIAS_PRD.of(ca.getAds()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDO_DISP1.toString(), SALDO_DISPONIBLE_CA.of(ca.getAds()).resolveFor(actor).getAttribute(TEXT_CONTENT).replace(" ", ".").trim());
        actor.remember(VariablesSesion.TIPO1.toString(), TIPO_CA.of(ca.getAds()).resolveFor(actor).getAttribute(TEXT_CONTENT).toUpperCase());
        actor.remember(VariablesSesion.NUMEROCC1.toString(), NUMERO_CA.of(ca.getAds()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOCC1.toString(), ESTADO_CA.of(ca.getAds()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_CUENTA.of(ca.getAds()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(ca.getAds())),
                WaitUntil.the(TTL_RESUMEN_ADS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TTL_RESUMEN_ADS).isDisplayed(),
                Ensure.that(ALIAS_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIAS1.toString())),
                Ensure.that(SALDO_DISP_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDO_DISP1.toString().trim())),
                Ensure.that(TIPO_PROD_ADS2).attribute("innerText").isEqualTo(actor.recall(VariablesSesion.TIPO1.toString())),
                Ensure.that(NUM_CUENTA_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMEROCC1.toString())),
                Ensure.that(MONTO_APROB_ADS1).isDisplayed(),
                Ensure.that(MONTO_UTIL_ADS1).isDisplayed(),
                Ensure.that(MONTO_PAGAR_ADS1).isDisplayed(),
                Ensure.that(ESTADO_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOCC1.toString())));
        actor.remember(VariablesSesion.ALIASADS2.toString(), ALIAS_ADS2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.SALDOADS2.toString(), SALDO_DISP_ADS2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.TIPOPRDADS2.toString(), TIPO_PROD_ADS2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMCUEADS2.toString(), NUM_CUENTA_ADS2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.MONTAPRADS1.toString(), MONTO_APROB_ADS1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.MONTAUTADS1.toString(), MONTO_UTIL_ADS1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.MONTPAADS1.toString(), MONTO_PAGAR_ADS1.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTAADS2.toString(), ESTADO_ADS2.resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE.of(ca.getCuentaOrigen())),
                WaitUntil.the(TTL_MAS_RESUMEN_ADS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),

                Ensure.that(TTL_MAS_RESUMEN_ADS).isDisplayed(),
                Ensure.that(ALIAS_ADS3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASADS2.toString())),
                Ensure.that(TIPO_PROD_ADS3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIPOPRDADS2.toString())),
                Ensure.that(NUM_CUENTA_ADS3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMCUEADS2.toString())),
                Ensure.that(ESTADO_ADS3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTAADS2.toString())),
                Ensure.that(STTL_SALDOS).isDisplayed(),
                Ensure.that(MONTO_APROB_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.MONTAPRADS1.toString())),
                Ensure.that(MONTO_UTIL_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.MONTAUTADS1.toString())),
                Ensure.that(MONTO_DISP_ADS1).isDisplayed(),
                Ensure.that(STTL_MONTOPAGAR).isDisplayed(),
                Ensure.that(MONTO_PAGAR_ADS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.MONTPAADS1.toString())),
                Ensure.that(INTERESES_ADS1).isDisplayed(),
                Ensure.that(CAPITAL_ADS1).isDisplayed(),
                Ensure.that(COMISION_ADS1).isDisplayed(),
                Scroll.to(MT).andAlignToBottom(),
                Ensure.that(STTL_INTMORA).isDisplayed(),
                Ensure.that(MORA_TOTAL_ADS1).isDisplayed(),
                Ensure.that(INT_DIARIO_ADS1).isDisplayed(),
                Ensure.that(INT_PENDIENTE_ADS1).isDisplayed(),
                Ensure.that(HONO_COB_EXT_ADS1).isDisplayed());
    }

    public static ConsultaDetalleADS datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleADS.class).withProperties(datosDCA);
    }
}