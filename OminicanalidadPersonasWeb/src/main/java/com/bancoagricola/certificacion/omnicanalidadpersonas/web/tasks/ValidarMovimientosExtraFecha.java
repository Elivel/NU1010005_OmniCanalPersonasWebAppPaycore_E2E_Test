package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccEnCalendFechLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidarMovimientosExtraFecha implements Task {
    private List<Transferencias> datosDCA;

    public ValidarMovimientosExtraFecha(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} valida 'Movimientos de Extrafinanciamiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        LeerArchivoProperties.esperar(5);
        actor.attemptsTo(
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_FILTRAR));
                LeerArchivoProperties.esperar(5);
        actor.attemptsTo(
                WaitUntil.the(RANGO_FECHAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RANGO_FECHAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RANGO_FECHAS, isClickable()).forNoMoreThan(60).seconds(),
                SeleccEnCalendFechLista.laFecha(datosDCA));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                Scroll.to(BTN_BUSCAR_MOVIMIENTOS).andAlignToTop(),
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR_MOVIMIENTOS));
    }

    public static ValidarMovimientosExtraFecha datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidarMovimientosExtraFecha.class).withProperties(datosDCA);
    }
}
