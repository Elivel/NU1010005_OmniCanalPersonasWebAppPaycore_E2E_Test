package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.FECHA_APLICADA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static junit.framework.TestCase.assertEquals;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.*;

public class MovimientosSemanaActual implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(MovimientosSemanaActual.class.getName());


    @Step("{0} 'Valida datos en la tabla para 'Semana actual'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WaitUntil.the(TABLA_MOV_CA,isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
        SimpleDateFormat dateform = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cl = Calendar.getInstance();
        String semaAct = Integer.toString(cl.get(Calendar.WEEK_OF_YEAR));
        LOGGER.log(Level.INFO, "Semana actual: \"{0}\"", semaAct);
        int valordia = FECHA_APLICADA.resolveAllFor(actor).size();
        String elemento = "";
        String fechaHoy = "";
        for (int i = 0; i < valordia; i++) {
            elemento = FECHA_APLICADA.resolveAllFor(actor).get(i).getText();
            try {
                Date date = dateform.parse(elemento);
                cl.setTime(date);
                fechaHoy = Integer.toString(cl.get(Calendar.WEEK_OF_YEAR));
                LOGGER.log(Level.INFO, "Semana de fecha en tabla: \"{0}\"", fechaHoy);
                assertEquals("Una fecha no corresponde al periodo 'Semana actual'", semaAct,fechaHoy);
            } catch (ParseException e) {
                LOGGER.severe(e.getMessage());
            }
        }
    }

    public static MovimientosSemanaActual datosCA() {
        return Instrumented.instanceOf(MovimientosSemanaActual.class).withProperties();
    }
}
