package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccionarEnCalendarioFechaLista;
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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.BTN_BUSCAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FiltrarExportarFondos implements Task {
    private List<Transferencias> fechas;

    public FiltrarExportarFondos(List<Transferencias> fechas) {
        this.fechas = fechas;
    }

    @Step("{0} 'realiza proceso para filtrar'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MOVIMIENTOS_FONDOS_INVERSION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MOVIMIENTOS_FONDOS_INVERSION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MOVIMIENTOS_FONDOS_INVERSION));
        WaitUntil.the(TTL_MOVIMIENTOS_FONDOS_INVERSION, isVisible()).forNoMoreThan(30).seconds().performAs(actor);
        WaitUntil.the(OPCIONES_MENU, isEnabled()).forNoMoreThan(30).seconds().performAs(actor);
        WaitUntil.the(OPCIONES_MENU, isClickable()).forNoMoreThan(30).seconds().performAs(actor);
        LeerArchivoProperties.esperar(5);
        actor.attemptsTo(
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FILTRAR),
                WaitUntil.the(RANGO_FECHAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RANGO_FECHAS, isClickable()).forNoMoreThan(60).seconds(),
                SeleccionarEnCalendarioFechaLista.laFecha(fechas));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(BTN_BUSCAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_BUSCAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR));
        WaitUntil.the(TABLA_MOV_CA, isEnabled()).forNoMoreThan(60).seconds().performAs(actor);
    }

    public static FiltrarExportarFondos inversion(List<Transferencias> fechas) {
        return Instrumented.instanceOf(FiltrarExportarFondos.class).withProperties(fechas);
    }
}
