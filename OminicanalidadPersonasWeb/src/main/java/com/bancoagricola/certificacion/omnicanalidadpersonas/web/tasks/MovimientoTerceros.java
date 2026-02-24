package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.VER_MAS_CUENTA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCION_MENU;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_EI;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CUENTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class MovimientoTerceros implements Task {

    private List<Transferencias> datosTransferencias;

    public MovimientoTerceros(List<Transferencias> datosFR) {
        this.datosTransferencias = datosFR;
    }

    @Step("{0} 'Ver Movimiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of(CUENTAS)),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(t.getCuentaOrigen()))

        );
        System.out.println("Referencia 2: " + actor.recall(VariablesSesion.REFERENCIA2.toString()));
        System.out.println("Referencia 3: " + actor.recall(VariablesSesion.REFERENCIA3.toString()));
                actor.attemptsTo(
                Ensure.that(TABLA_CA2.resolveFor(actor).getAttribute("textContent")).isEqualTo(actor.recall(VariablesSesion.REFERENCIA2.toString())),
                Ensure.that(TABLA_CA.resolveFor(actor).getAttribute("textContent")).isEqualTo(actor.recall(VariablesSesion.REFERENCIA3.toString())),
                        Scroll.to(LABEL_COMPROBANTE.of(BOTON_EI))
        );
    }
    public static MovimientoTerceros datosM(List<Transferencias> datosM) {
        return Instrumented.instanceOf(MovimientoTerceros.class).withProperties(datosM);
    }
}
