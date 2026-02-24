package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Administrar.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoMenuAdministrar implements Interaction {

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(80).seconds(),
                Scroll.to(MENU_ADMINISTRAR).andAlignToTop(),
                WaitUntil.the(MENU_ADMINISTRAR, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_ADMINISTRAR, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_ADMINISTRAR),
                WaitUntil.the(TTL_USUARIOS, isVisible()).forNoMoreThan(60).seconds());
    }

    public static IngresoMenuAdministrar inicio(){
        return Instrumented.instanceOf(IngresoMenuAdministrar.class).withProperties();
    }
}
