package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

public class MovimntosUltimsSeisM implements Interaction {

    @Step("{0} 'Valida datos en la tabla para 'Últimos 6 meses'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitUntil.the(TABLA_MOV_CA,isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
    }

    public static MovimntosUltimsSeisM datosCA() {
        return Instrumented.instanceOf(MovimntosUltimsSeisM.class).withProperties();
    }
}
