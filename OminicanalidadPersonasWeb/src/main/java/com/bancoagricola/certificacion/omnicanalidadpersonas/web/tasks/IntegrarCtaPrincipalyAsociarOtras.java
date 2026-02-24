package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarAClick;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INTEGRACION_CUENTAS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IntegrarCtaPrincipalyAsociarOtras implements Task {

    private List<Servicios> datos;

    public IntegrarCtaPrincipalyAsociarOtras(List<Servicios> datos) {
        this.datos = datos;
    }

    @Step("{0} 'Integrar Cta Principal y Asociar Otra'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                EsperarAClick.elElementoConTexto(INTEGRACION_CUENTAS),
                ClickEn.elElementoConTexto(INTEGRACION_CUENTAS),
                WaitUntil.the(RESULTADOS.of(INTEGRACION_CUENTAS), isEnabled()).forNoMoreThan(10).seconds());
        String ctaPrincipal = CAPTURA_CTA_PRINCIPAL.resolveFor(theActorInTheSpotlight()).getText();
        if (ctaPrincipal.contains(datos.get(0).getCtaPrincipal1())) {
            actor.attemptsTo(
                    WaitUntil.the(ACTIVA_LISTA_CTAPRINCIPAL, isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(ACTIVA_LISTA_CTAPRINCIPAL, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(ACTIVA_LISTA_CTAPRINCIPAL),
                    WaitUntil.the(SELECCIONAR_CTA_PRINCIPAL.of(datos.get(0).getCtaPrincipal2()), isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(SELECCIONAR_CTA_PRINCIPAL.of(datos.get(0).getCtaPrincipal2()), isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(SELECCIONAR_CTA_PRINCIPAL.of(datos.get(0).getCtaPrincipal2()))
            );
        } else {
            actor.attemptsTo(
                    WaitUntil.the(ACTIVA_LISTA_CTAPRINCIPAL, isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(ACTIVA_LISTA_CTAPRINCIPAL, isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(ACTIVA_LISTA_CTAPRINCIPAL),
                    WaitUntil.the(SELECCIONAR_CTA_PRINCIPAL.of(datos.get(0).getCtaPrincipal2()), isEnabled()).forNoMoreThan(10).seconds(),
                    WaitUntil.the(SELECCIONAR_CTA_PRINCIPAL.of(datos.get(0).getCtaPrincipal2()), isClickable()).forNoMoreThan(10).seconds(),
                    Click.on(SELECCIONAR_CTA_PRINCIPAL.of(datos.get(0).getCtaPrincipal1()))
            );
        }
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

    public static IntegrarCtaPrincipalyAsociarOtras cuentas(List<Servicios> datos) {
        return Instrumented.instanceOf(IntegrarCtaPrincipalyAsociarOtras.class).withProperties(datos);
    }

}
