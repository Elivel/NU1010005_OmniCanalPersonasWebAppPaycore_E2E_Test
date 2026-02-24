package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.TransferenciaInternacional;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.SolicitarTransferenciaInternacional.SOLICITUD_DE_TRANSFERENCIA_INTERNACIONAL;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.SolicitudTransferenciaPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminarPlantilla implements Interaction {
    private List<TransferenciaInternacional> datos;

    public EliminarPlantilla(List<TransferenciaInternacional> datos) {
        this.datos = datos;
    }

    @Step("{0} 'elimina plantilla de transferencia internacional'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(BOTTON_REALIZAR_OTRA_SOL),
                WaitUntil.the(BOTTON_REALIZAR_OTRA_SOL, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BOTTON_REALIZAR_OTRA_SOL, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BOTTON_REALIZAR_OTRA_SOL),
                WaitUntil.the(RESULTADOS.of(SOLICITUD_DE_TRANSFERENCIA_INTERNACIONAL), isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(RESULTADOS.of(SOLICITUD_DE_TRANSFERENCIA_INTERNACIONAL), isEnabled()).forNoMoreThan(10).seconds());
        actor.attemptsTo(
                WaitUntil.the(LNK_CARGAR_P, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(LNK_CARGAR_P, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LNK_CARGAR_P));
        WaitUntil.the(VENTANA_EM, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        actor.attemptsTo(
                WaitUntil.the(VENTANA_EM_MSG, isVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(
                WaitUntil.the(ICONO_BORRAR, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(ICONO_BORRAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ICONO_BORRAR));
        WaitUntil.the(VENTANA_EM_NO_HAY, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        actor.attemptsTo(
                WaitUntil.the(BTN_CERRAR, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_CERRAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CERRAR));
    }

    public static EliminarPlantilla para(List<TransferenciaInternacional> datos) {
        return Instrumented.instanceOf(EliminarPlantilla.class).withProperties(datos);
    }
}
