package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.INNER_TEXT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SeleccionarEnCalendarioFechaNV implements Interaction {
    private final List<Transferencias> datosDCA;

    public SeleccionarEnCalendarioFechaNV(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'selecciona fechas deseadas en el calendario'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);

        actor.attemptsTo(
                WaitUntil.the(FECHA_SALIDA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(FECHA_SALIDA));

        String dias = ca.getFechaSalida().substring(0, 2).trim();
        String meanio = ca.getFechaSalida().substring(2).trim();
        String fechaActual1 = FECHA_HOY_NV_SALIDA.resolveFor(actor).getAttribute(INNER_TEXT);

        //Selecciona Mes 1
        while (!fechaActual1.equals(meanio)) {
            FLECHA_ADELANTE_S.resolveFor(actor).click();
            fechaActual1 = FECHA_HOY_NV_SALIDA.resolveFor(actor).getAttribute(INNER_TEXT);
        }

        //Selecciona Dia 1
        int valordia = CAL_DIA1_NV_S.resolveAllFor(actor).size();
        String elemento = "";
        for (int i = 0; i < valordia; i++) {
            elemento = CAL_DIA1_NV_S.resolveAllFor(actor).get(i).getText();
            if (elemento.equals(String.valueOf(dias))) {
                CAL_DIA1_NV_S.resolveAllFor(actor).get(i).click();
                break;
            }
        }

        actor.attemptsTo(
                Scroll.to(FECHA_REGRESO),
                WaitUntil.the(FECHA_REGRESO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(FECHA_REGRESO));
        LeerArchivoProperties.esperar2();
        String dias2 = ca.getFechaRegreso().substring(0, 2).trim();
        String meanios2 = ca.getFechaRegreso().substring(2).trim();
        String fechaActual2 = FECHA_HOY_NV_REGRESO.resolveFor(actor).getAttribute(INNER_TEXT);

        //Selecciona Mes 2
        while (!fechaActual2.equals(meanios2)) {
            FLECHA_ADELANTE_R.resolveFor(actor).click();
            fechaActual2 = FECHA_HOY_NV_REGRESO.resolveFor(actor).getAttribute(INNER_TEXT);
        }

        //Selecciona Dia 2
        int valordia2 = CAL_DIA1_NV_R.resolveAllFor(actor).size();
        String elemento2 = "";
        for (int i = 0; i < valordia2; i++) {
            elemento2 = CAL_DIA1_NV_R.resolveAllFor(actor).get(i).getText();
            if (elemento2.equals(dias2)) {
                CAL_DIA1_NV_R.resolveAllFor(actor).get(i).click();
                break;
            }
        }
    }

    public static SeleccionarEnCalendarioFechaNV laFecha(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(SeleccionarEnCalendarioFechaNV.class).withProperties(datosDCA);
    }
}