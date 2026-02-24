package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.model.util.EnvironmentVariables;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.TTL_BIENVENIDO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;



public class IrA implements Task {
    EnvironmentVariables environmentVariables = null;
    @Step("{0} ingresa a la URL")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Open.url(EnvironmentSpecificConfiguration.from(environmentVariables).getProperty("home.page")).performAs(actor);
        WaitUntil.the(TTL_BIENVENIDO, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
    }

    public static IrA bancoagricola() {
        return Instrumented.instanceOf(IrA.class).withProperties();
    }
}
