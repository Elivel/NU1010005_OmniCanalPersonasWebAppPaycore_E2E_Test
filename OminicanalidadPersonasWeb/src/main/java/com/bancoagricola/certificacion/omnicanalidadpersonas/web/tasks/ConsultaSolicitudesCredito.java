package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConsultaSolicitudesCredito implements Task {

    private final String numero;

    public ConsultaSolicitudesCredito(String numero) {
        this.numero = numero;
    }

    @Step("{0} realiza consulta de solicitud de créditos ")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(SOLIC_ESTCRED, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SOLIC_ESTCRED, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SOLIC_ESTCRED),
                WaitUntil.the(TTL_SOLIC_ESTCRED, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_SOLIC_ESTCRED, isEnabled()).forNoMoreThan(60).seconds()
        );
        assertFalse("No se encontro la solicitud: " + SOLICITUD.of(numero) + " favor validar", NO_HAY_SOLICTUDES.resolveFor(actor).isVisible());
        assertTrue("Favor validar, se estan presentando problemas de ambiente", SOLICITUD.of(numero).resolveFor(actor).isVisible());
        actor.remember(VariablesSesion.SOLICITUD_CSC.toString(), SOLICITUD.of(numero).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.remember(VariablesSesion.PRODUCTO_CSC.toString(), PRODUCTO.of(numero).resolveFor(actor).getAttribute(TEXT_CONTENT));
        actor.attemptsTo(
                WaitUntil.the(SOLICITUD.of(numero), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SOLICITUD.of(numero), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SOLICITUD.of(numero)),
                WaitUntil.the(TTL_CONSUL_SOLIC_ESTCRED, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_CONSUL_SOLIC_ESTCRED, isVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(SOLICITUD2).textContent().isEqualTo(actor.recall(VariablesSesion.SOLICITUD_CSC.toString()).toString()),
                Ensure.that(PRODUCTO2).textContent().isEqualToIgnoringCase(actor.recall(VariablesSesion.PRODUCTO_CSC.toString()).toString())
        );

    }

    public static ConsultaSolicitudesCredito con(String numero) {
        return Instrumented.instanceOf(ConsultaSolicitudesCredito.class).withProperties(numero);
    }
}