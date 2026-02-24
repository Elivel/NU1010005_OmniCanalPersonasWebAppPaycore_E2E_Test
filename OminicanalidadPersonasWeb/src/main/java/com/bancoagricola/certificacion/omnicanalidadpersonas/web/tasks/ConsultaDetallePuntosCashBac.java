package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.TIPO_PRD2;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetallePuntosCashBac implements Task {
    String Nombre = "";

    @Step("{0} 'Consulta detalle de Puntos y CashBac'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(TOTAL_TDC, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(ALIAS_PUNTOSBA.of(Nombre)),
                Ensure.that(ALIAS_PUNTOSBA.of(Nombre)).isDisplayed(),
                Ensure.that(TIPO_PRD.of(Nombre)).isDisplayed(),
                Ensure.that(PUNTOSACUM.of(Nombre)).isDisplayed()
        );
        //Ensure.that(SALDOENDOL.of(Nombre)).isDisplayed());
        actor.remember(VariablesSesion.ALIASPCB.toString(), ALIAS_PUNTOSBA.of(Nombre).resolveFor(actor).getAttribute(TEXT_CONTENT)
        );
        actor.remember(VariablesSesion.TIPOPRDPCB.toString(), TIPO_PRD.of(Nombre).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.PUNTOSACUMPCB.toString(), PUNTOSACUM.of(Nombre).resolveFor(actor).getAttribute(TEXT_CONTENT));
        // actor.remember(VariablesSesion.SALDOPCB.toString(), SALDOENDOL.of(Nombre).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(LNK_VER_MAS_PUNTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS_PUNTOS),
                WaitUntil.the(TTL_RES_PUNTOS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIAS_PUNTOSBA2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASPCB.toString())),
                Ensure.that(TIPO_PRD2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIPOPRDPCB.toString())),
                Ensure.that(PUNTOSACUM2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PUNTOSACUMPCB.toString())),
                // Ensure.that(SALDOENDOL2).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDOPCB.toString())),
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(ALIAS_PUNTOSBA3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.ALIASPCB.toString())),
                Ensure.that(TIP_PRD3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.TIPOPRDPCB.toString())),
                Ensure.that(PUNTOSACUM3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.PUNTOSACUMPCB.toString())),
                //Ensure.that(SALDOENDOL3).attribute(TEXT_CONTENT).isEqualTo(actor.recall(VariablesSesion.SALDOPCB.toString())),
                Ensure.that(PROXVENCER).isDisplayed(),
                Ensure.that(CUERELACION).isDisplayed(),
                Ensure.that(TABCR).isDisplayed()
        );
    }

    public static ConsultaDetallePuntosCashBac datosPCB(String Nombre) {
        return Instrumented.instanceOf(ConsultaDetallePuntosCashBac.class).withProperties();
    }
}