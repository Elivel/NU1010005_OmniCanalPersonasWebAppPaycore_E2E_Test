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

public class ValidarMovimientosPrestamosFecha implements Task {
    private List<Transferencias> datosDCA;

    public ValidarMovimientosPrestamosFecha(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} valida 'Movimientos de Préstamos'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(5);
        actor.attemptsTo(
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
                WaitUntil.the(RANGO_FECHAS, isClickable()).forNoMoreThan(60).seconds(),
                SeleccEnCalendFechLista.laFecha(datosDCA));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                Click.on(BTN_BUSCAR_MOVIMIENTOS));
        //        WaitUntil.the(LBL_MOVIMIENTOS_PR, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
        //        Scroll.to(TABLA_MOV_CA).andAlignToTop());
        //actor.should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de movimientos"));
        //actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
    }

    public static ValidarMovimientosPrestamosFecha datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidarMovimientosPrestamosFecha.class).withProperties(datosDCA);
    }
}
