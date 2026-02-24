package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INNER_TEXT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SeleccEnCalendFechLista implements Interaction {
    private final List<Transferencias> datosDCA;

    public SeleccEnCalendFechLista(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'selecciona fechas deseadas en el calendario'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);

        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(SEL_DESDE, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_DESDE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_DESDE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SEL_DESDE));

        String dias = ca.getFechaDesde().substring(0, 2).trim();
        String mesanio = ca.getFechaDesde().substring(2).trim();
        String fechaActual1 = FECHA_ACTUAL1.resolveFor(actor).getAttribute(INNER_TEXT);

        while (!fechaActual1.equals(mesanio)) {
            FLECHA_ATRAS.resolveFor(actor).click();
            fechaActual1 = FECHA_ACTUAL1.resolveFor(actor).getAttribute(INNER_TEXT);
        }

        //Selecciona Dia 1
        int valordia = CAL_DIA1.resolveAllFor(actor).size();
        String elemento = "";
        for (int i = 0; i < valordia; i++) {
            elemento = CAL_DIA1.resolveAllFor(actor).get(i).getText();
            if (elemento.equals(dias)) {
                CAL_DIA1.resolveAllFor(actor).get(i).click();
                break;
            }
        }

        actor.attemptsTo(
                WaitUntil.the(SEL_HASTA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_HASTA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_HASTA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SEL_HASTA));
        LeerArchivoProperties.esperar2();
        String dias2 = ca.getFechaHasta().substring(0, 2).trim();
        String mesanio2 = ca.getFechaHasta().substring(2).trim();
        String fechaActual2 = FECHA_ACTUAL2.resolveFor(actor).getAttribute(INNER_TEXT);

        //Selecciona Mes 2
        while (!fechaActual2.equals(mesanio2)) {
            FLECHA_ATRAS2.resolveFor(actor).click();
            fechaActual2 = FECHA_ACTUAL2.resolveFor(actor).getAttribute(INNER_TEXT);
        }

        //Selecciona Dia 2
        int valordia2 = CAL_DIA2.resolveAllFor(actor).size();
        String elemento2 = "";
        for (int i = 0; i < valordia2; i++) {
            elemento2 = CAL_DIA2.resolveAllFor(actor).get(i).getText();
            if (elemento2.equals(dias2)) {
                CAL_DIA2.resolveAllFor(actor).get(i).click();
                break;
            }
        }
    }

    public static SeleccEnCalendFechLista laFecha(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(SeleccEnCalendFechLista.class).withProperties(datosDCA);
    }
}