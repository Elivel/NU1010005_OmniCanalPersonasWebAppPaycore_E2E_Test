package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;

public class ConstanciaRenta implements Task {


    List<Servicios> datosECR;

    public ConstanciaRenta(List<Servicios> datosECR) {
        this.datosECR = datosECR;
    }


    @Step("{0} 'Emisión Constancia de Renta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Servicios ECR = datosECR.get(0);
        String anyo = ECR.getAñoRenta();

        actor.attemptsTo(
                Click.on(SELECTOR_AÑO_RENTA),
                Click.on(AÑO_RENTA.of(anyo))


        );
    }

    public static ConstanciaRenta datosECR(List<Servicios> datosECR) {
        return Instrumented.instanceOf(ConstanciaRenta.class).withProperties(datosECR);
    }

}
