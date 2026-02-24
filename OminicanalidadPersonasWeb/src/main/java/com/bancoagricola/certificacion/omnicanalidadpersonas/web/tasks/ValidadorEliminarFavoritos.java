package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EliminaFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoFavoritos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidadorEliminarFavoritos implements Task {
    private List<Transferencias> datosDCA;

    public ValidadorEliminarFavoritos(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Valida si existe favorito y lo elimina'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosDCA.get(0);

        actor.attemptsTo(
                IngresoFavoritos.inicio(datosDCA),
                WaitUntil.the(OPCIONES.of(t.getOpcion()), isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(OPCIONES.of(t.getOpcion()), isEnabled()).forNoMoreThan(15).seconds());
        if (SIN_FAVORITO.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(80).seconds(),
                    WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(80).seconds());
        } else if (LNK_ELIMINAR_FAVO.resolveFor(actor).isVisible()) {
            for (int i = 0; i < datosDCA.size(); i++) {
                actor.attemptsTo(
                        EliminaFavorito.datosCA(datosDCA.get(i).getNombreFavorito()));
            }
        } else {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(80).seconds(),
                    WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(80).seconds());
        }
    }

    public static ValidadorEliminarFavoritos datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidadorEliminarFavoritos.class).withProperties(datosDCA);
    }
}