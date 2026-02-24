package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccEnCalendFechLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.TTL_MOV_TARJ;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ValidarMovimientosTDCFecha implements Task {
    private List<Transferencias> datosDCA;
    public ValidarMovimientosTDCFecha(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} valida 'Movimientos de tarjetas de crédito'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);

        actor.attemptsTo(
               // WaitUntil.the(CONTROL_PAGINEO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_FILTRAR),
                WaitUntil.the(RANGO_FECHAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RANGO_FECHAS, isEnabled()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_BUSCAR_MOVIMIENTOS).andAlignToBottom(),
                SeleccEnCalendFechLista.laFecha(datosDCA));
                LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR_MOVIMIENTOS),
                WaitUntil.the(TTL_MOV_TARJ, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_MOV_TARJ, isEnabled()).forNoMoreThan(60).seconds(),
                Scroll.to(TABLA_MOV_CA).andAlignToTop());
        actor.should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de movimientos"));
        actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
    }

    public static ValidarMovimientosTDCFecha datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidarMovimientosTDCFecha.class).withProperties(datosDCA);
    }
}
