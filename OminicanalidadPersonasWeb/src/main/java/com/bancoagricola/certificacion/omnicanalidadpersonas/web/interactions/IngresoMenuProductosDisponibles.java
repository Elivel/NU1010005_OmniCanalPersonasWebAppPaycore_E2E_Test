package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ProductosDisponiblesPage.MENU_PRODUCTOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ProductosDisponiblesPage.TTL_PRD_DISP;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuProductosDisponibles implements Interaction {

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRODUCTOS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_PRODUCTOS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_PRODUCTOS),
                WaitUntil.the(TTL_PRD_DISP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_PRD_DISP, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngresoMenuProductosDisponibles inicio(){
        return Instrumented.instanceOf(IngresoMenuProductosDisponibles.class).withProperties();
    }
}