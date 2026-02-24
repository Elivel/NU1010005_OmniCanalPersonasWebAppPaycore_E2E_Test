package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OPCIONES_FAVORITOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TTL_GESTION_FAVORITOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.FAVORITO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoFavoritos implements Interaction {
    private List<Transferencias> datosDCA;

    public IngresoFavoritos(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'ingresa al menú favoritos'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosDCA.get(0);

        actor.attemptsTo(
                WaitUntil.the(FAVORITO, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(FAVORITO, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(FAVORITO));
        WaitUntil.the(TTL_GESTION_FAVORITOS, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        actor.attemptsTo(
                WaitUntil.the(OPCIONES_FAVORITOS.of(t.getOpcion()), isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(OPCIONES_FAVORITOS.of(t.getOpcion()), isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(OPCIONES_FAVORITOS.of(t.getOpcion()), isClickable()).forNoMoreThan(20).seconds(),
                Click.on(OPCIONES_FAVORITOS.of(t.getOpcion())));
    }

    public static IngresoFavoritos inicio(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(IngresoFavoritos.class).withProperties(datosDCA);
    }
}
