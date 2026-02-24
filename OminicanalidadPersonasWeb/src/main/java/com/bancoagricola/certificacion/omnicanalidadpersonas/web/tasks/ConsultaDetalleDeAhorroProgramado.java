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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.SECC_SALDOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetalleDeAhorroProgramado implements Task {
    private List<Transferencias> datosDCA;
    public ConsultaDetalleDeAhorroProgramado(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Consulta detalle de ahorro programado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS),
                WaitUntil.the(TOTAL_AHORROS_ACUMULADOS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(PRODUCTO1.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(ALIAS1.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(META1.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(AHORRO_ACUM1.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(NUMERO_AP1.of(ca.getCuentaOrigen())).isDisplayed(),
                Ensure.that(ESTADO_AP1.of(ca.getCuentaOrigen())).isDisplayed());
        actor.remember(VariablesSesion.PROD_AP1.toString(), PRODUCTO1.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ALIASAP1.toString(), ALIAS1.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.METAAP1.toString(), META1.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.AHORROACUMAP1.toString(), AHORRO_ACUM1.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMAP1.toString(), NUMERO_AP1.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ESTADOAP1.toString(), ESTADO_AP1.of(ca.getCuentaOrigen()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(LNK_VER_MAS.of(ca.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(ca.getCuentaOrigen())),
                WaitUntil.the(TTL_RESUMEN_AP, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(PRODUCTO2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PROD_AP1.toString())),
                //Ensure.that(ALIAS2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASAP1.toString())),
                Ensure.that(META2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.METAAP1.toString())),
                Ensure.that(AHORRO_ACUM2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.AHORROACUMAP1.toString())),
                Ensure.that(NUMERO_AP2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMAP1.toString())),
                Ensure.that(FECHA_VEN_AP1).isDisplayed());
        actor.remember(VariablesSesion.PROD_AP2.toString(), PRODUCTO2.of(ca.getCuentaCorta()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.ALIASAP2.toString(), ALIAS2.of(ca.getCuentaCorta()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.METAAP2.toString(), META2.of(ca.getCuentaCorta()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.AHORROACUMAP2.toString(), AHORRO_ACUM2.of(ca.getCuentaCorta()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.NUMAP2.toString(), NUMERO_AP2.of(ca.getCuentaCorta()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.FECHAVENAP1.toString(), FECHA_VEN_AP1.of(ca.getCuentaCorta()).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE_AP, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIAS3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASAP2.toString().toUpperCase())),
                Ensure.that(PRODUCTO3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PROD_AP2.toString())),
                Ensure.that(NUMERO_AP3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.NUMAP2.toString())),
                Ensure.that(CUOTA_MENSUAL1).isDisplayed(),
                Ensure.that(ESTADO_AP2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ESTADOAP1.toString())),
                Ensure.that(SECC_SALDOS).isDisplayed(),
                Ensure.that(CONTABLE1).isDisplayed(),
                Ensure.that(SALDO1).isDisplayed(),
                Ensure.that(DISPONIBLE1).isDisplayed(),
                Ensure.that(SECC_FECHAS).isDisplayed(),
                Ensure.that(FECHA_CONTRA1).isDisplayed(),
                Ensure.that(DIA_CARGO1).isDisplayed(),
                Ensure.that(FECHA_VEN_AP2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.FECHAVENAP1.toString())));
    }
    public static ConsultaDetalleDeAhorroProgramado datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ConsultaDetalleDeAhorroProgramado.class).withProperties(datosDCA);
    }
}