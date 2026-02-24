package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.LINK_IMPRIMIR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Imprimir implements Task {

    @Step("{0} 'realiza proceso de imprimir'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(LINK_IMPRIMIR).andAlignToBottom(),
                WaitUntil.the(LINK_IMPRIMIR, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_IMPRIMIR, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_IMPRIMIR, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LINK_IMPRIMIR));
    }
    public static Imprimir datos() {
        return Instrumented.instanceOf(Imprimir.class).withProperties();
    }
}