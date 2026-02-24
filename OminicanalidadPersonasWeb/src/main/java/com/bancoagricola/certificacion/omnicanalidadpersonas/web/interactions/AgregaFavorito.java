package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class AgregaFavorito implements Interaction {

    private String nombreFavorito;

    public AgregaFavorito(String nombreFavorito) {
        this.nombreFavorito = nombreFavorito;
    }

    @Step("{0} 'agrega favorito'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(BTN_ANADIR_FAV, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ANADIR_FAV, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ANADIR_FAV),
                SendKeys.of(nombreFavorito).into(TXT_NOMBRE_FAVORITO),
                WaitUntil.the(BTN_CONFIRMAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONFIRMAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONFIRMAR));
        WaitUntil.the(MSG_CONFIRMACION, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

    }

    public static AgregaFavorito datosCA(String nombreFavorito) {
        return Instrumented.instanceOf(AgregaFavorito.class).withProperties(nombreFavorito);
    }
}