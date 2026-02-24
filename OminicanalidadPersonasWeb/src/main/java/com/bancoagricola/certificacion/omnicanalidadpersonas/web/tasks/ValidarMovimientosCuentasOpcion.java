package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

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
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ValidarMovimientosCuentasOpcion implements Task {
    private List<Transferencias> datosDCA;

    public ValidarMovimientosCuentasOpcion(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} valida 'Movimientos de Cuentas'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);

        actor.attemptsTo(
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_FILTRAR),
                WaitUntil.the(PERIODO_TIEMPO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PERIODO.of(ca.getPeriodo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PERIODO.of(ca.getPeriodo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PERIODO.of(ca.getPeriodo())));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR_MOVIMIENTOS),
                Scroll.to(TTL_MOVIMIENTOS2).andAlignToTop(),
                WaitUntil.the(TTL_MOVIMIENTOS2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_MOVIMIENTOS2, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(5);

    }

    public static ValidarMovimientosCuentasOpcion datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidarMovimientosCuentasOpcion.class).withProperties(datosDCA);
    }
}
