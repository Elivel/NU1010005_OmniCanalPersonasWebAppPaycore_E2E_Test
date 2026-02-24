package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.LINK_EXPORTAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class Exportar implements Task {

    @Step("{0} 'realiza proceso de exportar'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(LINK_EXPORTAR).andAlignToBottom(),
                WaitUntil.the(LINK_EXPORTAR, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_EXPORTAR, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LINK_EXPORTAR),
                WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds());
        LeerArchivoProperties.esperar(3);
    }
    public static Exportar datos() {
        return Instrumented.instanceOf(Exportar.class).withProperties();
    }
}