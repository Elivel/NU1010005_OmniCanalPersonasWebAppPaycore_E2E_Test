package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.BTN_FINALIZAR_SEV;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidacionMensaje implements Task {

    @Step("{0} 'valida que se haya realizado la Integración'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        WaitUntil.the(RESULTADOS.of("La integración se ha realizado de forma exitosa"), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.attemptsTo(
                Scroll.to(BTN_FINALIZAR_SEV).andAlignToTop());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(BTN_FINALIZAR_SEV, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR_SEV, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FINALIZAR_SEV));
    }

    public static ValidacionMensaje con() {
        return Instrumented.instanceOf(ValidacionMensaje.class).withProperties();
    }
}
