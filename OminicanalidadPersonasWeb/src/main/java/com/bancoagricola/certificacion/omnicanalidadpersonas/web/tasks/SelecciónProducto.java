package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class SelecciónProducto implements Task {
    private List<Transferencias> datosCAP;

    public SelecciónProducto(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }


    @Step("{0} 'Selecciona Producto'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(cap.getCuentaOrigen()), isClickable()).forNoMoreThan(10).seconds(),
                Click.on(VER_MAS_CUENTA.of(cap.getCuentaOrigen()))
        );
    }

    public static SelecciónProducto datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(SelecciónProducto.class).withProperties(datosCAP);
    }
}
