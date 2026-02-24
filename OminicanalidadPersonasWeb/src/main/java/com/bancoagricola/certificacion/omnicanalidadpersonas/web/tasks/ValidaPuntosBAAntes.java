package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasPuntosBA;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaPuntosBAAntes implements Task {
    @Step("{0} Valida 'Puntos BA' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresoVerMasPuntosBA.inicio(),
                WaitUntil.the(OPC_MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE, isCurrentlyVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        actor.remember(VariablesSesion.PUNTOSBA_ANTES_TRX.toString(), PUNTOS_ACUMULADOS.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",",""));
        actor.attemptsTo(
                Ensure.that(actor.recall(VariablesSesion.PUNTOSBA_ANTES_TRX.toString()).toString().replace(",","")).isEqualTo
                        (PUNTOS_ACUMULADOS.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",","")));
        System.out.println("Puntos BA antes: "+Double.parseDouble(PUNTOS_ACUMULADOS.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",","")));

    }
    public static ValidaPuntosBAAntes puntos(){ return Instrumented.instanceOf(ValidaPuntosBAAntes.class).withProperties();
    }
}