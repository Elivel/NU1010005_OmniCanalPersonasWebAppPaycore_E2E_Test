package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;


import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarAClick;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_ACEPTAR_C;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INTEGRACION_CUENTAS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IntegrarCtaPrincipalesyAsociarOtrasTDD implements Task {
    private List<Servicios> datos;

    public IntegrarCtaPrincipalesyAsociarOtrasTDD(List<Servicios> datos) {
        this.datos = datos;
    }

    @Step("{0} 'Integrar Cta Principal y Asociar Otra TDD'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SELECCIONAR_CTA_ASOCIAR.of(datos.get(0).getCtaAsociar()), isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(SELECCIONAR_CTA_ASOCIAR.of(datos.get(0).getCtaAsociar()), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(SELECCIONAR_CTA_ASOCIAR.of(datos.get(0).getCtaAsociar())),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VENT_EMERG, isVisible()),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_ACEPTAR_C));
    }
    public static IntegrarCtaPrincipalesyAsociarOtrasTDD cuentas(List<Servicios> datos) {
        return Instrumented.instanceOf(IntegrarCtaPrincipalesyAsociarOtrasTDD.class).withProperties(datos);
    }
}
