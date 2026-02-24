package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoCalculoCuotaTablaAmortizacion implements Task {
    private List<Servicios> datosAmort;

    public ProcesoCalculoCuotaTablaAmortizacion(List<Servicios> datosAmort) {
        this.datosAmort = datosAmort;
    }

    @Step("{0} realiza proceso de Cálculo de Cuota y Tabla de Amortización")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Servicios da = datosAmort.get(0);
        actor.attemptsTo(
                WaitUntil.the(LNK_CCTA, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(LNK_CCTA, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(LNK_CCTA),
                WaitUntil.the(TTL_CCTA, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(TTL_CCTA, isEnabled()).forNoMoreThan(15).seconds(),
                SendKeys.of(da.getMonto()).into(MONTO),
                SendKeys.of(da.getTasa()).into(TASA_INTERES),
                WaitUntil.the(SELECTOR_PLAZO, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(SELECTOR_PLAZO, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(SELECTOR_PLAZO),
                WaitUntil.the(SELECTOR_PLAZO_OPCION.of(da.getSelectorPlazo()), isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(SELECTOR_PLAZO_OPCION.of(da.getSelectorPlazo()), isClickable()).forNoMoreThan(15).seconds(),
                Click.on(SELECTOR_PLAZO_OPCION.of(da.getSelectorPlazo())),
                SendKeys.of(da.getPlazo()).into(PLAZO),
                WaitUntil.the(SELECTOR_FRECUENCIA_PAGO, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(SELECTOR_FRECUENCIA_PAGO, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(SELECTOR_FRECUENCIA_PAGO),
                WaitUntil.the(SELECTOR_FRECUENCIA_PAGO_OPCION.of(da.getFrecuencia()), isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(SELECTOR_FRECUENCIA_PAGO_OPCION.of(da.getFrecuencia()), isClickable()).forNoMoreThan(15).seconds(),
                Click.on(SELECTOR_FRECUENCIA_PAGO_OPCION.of(da.getFrecuencia())),
                Scroll.to(BTN_CALCULAR),
                WaitUntil.the(BTN_CALCULAR, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(BTN_CALCULAR, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CALCULAR),
                Scroll.to(TABLA_AMORTIZ));
        LeerArchivoProperties.esperar(1);
    }

    public static ProcesoCalculoCuotaTablaAmortizacion conlosdatos(List<Servicios> datosAmort) {
        return Instrumented.instanceOf(ProcesoCalculoCuotaTablaAmortizacion.class).withProperties(datosAmort);
    }
}

