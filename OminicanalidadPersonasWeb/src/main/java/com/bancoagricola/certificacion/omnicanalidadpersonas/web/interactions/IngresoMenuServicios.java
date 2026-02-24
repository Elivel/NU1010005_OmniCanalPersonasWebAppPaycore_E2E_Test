package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.MENU_SERVICIOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TTL_SERVICIOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuServicios implements Interaction {

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_SERVICIOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_SERVICIOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_SERVICIOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_SERVICIOS),
                WaitUntil.the(TTL_SERVICIOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_SERVICIOS, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoMenuServicios inicio() {
        return Instrumented.instanceOf(IngresoMenuServicios.class).withProperties();
    }
}
