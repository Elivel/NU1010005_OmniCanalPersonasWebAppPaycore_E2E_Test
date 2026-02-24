package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccEnCalendFechLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.is;

public class ValidarMovimientosPuntosBAFecha implements Task {
    private List<Transferencias> datosDCA;

    public ValidarMovimientosPuntosBAFecha(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} valida 'Movimientos de Préstamos'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                Click.on(OPC_FILTRAR));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(RANGO_FECHAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RANGO_FECHAS, isEnabled()).forNoMoreThan(60).seconds(),
                SeleccEnCalendFechLista.laFecha(datosDCA));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                Click.on(BTN_BUSCAR_MOVIMIENTOS),
                WaitUntil.the(TAB_EGRESOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TAB_EGRESOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TAB_EGRESOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(TAB_EGRESOS));

    }

    public static ValidarMovimientosPuntosBAFecha datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidarMovimientosPuntosBAFecha.class).withProperties(datosDCA);
    }
}
