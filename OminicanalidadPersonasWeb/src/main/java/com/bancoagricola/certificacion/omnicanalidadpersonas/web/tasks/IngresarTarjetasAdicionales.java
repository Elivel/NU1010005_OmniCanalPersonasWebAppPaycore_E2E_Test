package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasTarjetas;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;


import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import java.util.List;

public class IngresarTarjetasAdicionales implements Task {
    private List<Transferencias>datosTDC;

    public IngresarTarjetasAdicionales(List<Transferencias> datosTDC) {
        this.datosTDC = datosTDC;
    }


    public static IngresarTarjetasAdicionales inicio(List<Transferencias> datosTDC) {
        return Instrumented.instanceOf(IngresarTarjetasAdicionales.class).withProperties(datosTDC);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t=datosTDC.get(0);

        actor.attemptsTo((IngresoVerMasTarjetas.inicio(datosTDC)));
        actor.attemptsTo(
                WaitUntil.the(TARJETAS_ADICIONALES,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(TARJETAS_ADICIONALES),
                WaitUntil.the(TTL_CONSUL_TDC_ADICIONALES,isVisible()).forNoMoreThan(15).seconds()
        );

    }
}
