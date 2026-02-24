package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarAClick;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarVisibilidad;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.VENTANA_EM_NO_HAY;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.SolicitudTransferenciaPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CARGAR_PLANTILLA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.NO_HAY_PLANTILLAS_PARA_LISTAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaEliminaPlantilla implements Task {

    @Step("{0} 'Valida si existe plantilla creada y la elimina'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LNK_CARGAR_P, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(LNK_CARGAR_P, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LNK_CARGAR_P));

        if (VENTANA_EM_NO_HAY.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CERRAR, isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(BTN_CERRAR, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_CERRAR));
        } else if (ICONO_BORRAR.resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(ICONO_BORRAR, isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(ICONO_BORRAR, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(ICONO_BORRAR));
            WaitUntil.the(VENTANA_EM_NO_HAY, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
            actor.attemptsTo(
                    WaitUntil.the(BTN_CERRAR, isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(BTN_CERRAR, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_CERRAR));
        } else {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CERRAR, isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(BTN_CERRAR, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(BTN_CERRAR));
        }
    }

    public static ValidaEliminaPlantilla datosCA() {
        return Instrumented.instanceOf(ValidaEliminaPlantilla.class).withProperties();
    }
}