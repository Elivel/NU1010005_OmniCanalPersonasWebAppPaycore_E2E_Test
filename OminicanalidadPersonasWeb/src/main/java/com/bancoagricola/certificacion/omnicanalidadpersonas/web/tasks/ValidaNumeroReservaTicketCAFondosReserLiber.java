package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR2;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR3;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaNumeroReservaTicketCAFondosReserLiber implements Task {
    private static List<String> listaObtenida = new ArrayList<>();

    @Step("{0} 'valida que no se muestre el número de referencia de la liberación de fondos'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(MOVIMIENTOS).andAlignToTop(),
                WaitUntil.the(MOVIMIENTOS, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(OTROS, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(OTROS, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(OTROS));
        WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        TABLA_MOVIMIENTOS_REFERENCIA_FON_RES.resolveAllFor(actor).forEach(
                elementosLista -> {
                    listaObtenida.clear();
                });

        TABLA_MOVIMIENTOS_REFERENCIA_FON_RES.resolveAllFor(actor).forEach(
                elementosLista -> {
                    listaObtenida.add(elementosLista.getText());
                });
        System.out.println("Número de reserva: " + actor.recall(REFERENCIA_TICKET_VAR3.toString()).toString());
        System.out.println("Listado: " + listaObtenida);
        Task.where(actor + " valida que no se muestre el número de reserva " + "'" + actor.recall(REFERENCIA_TICKET_VAR3.toString()).toString() + "'" + " en la tabla de fondos reservados", Ensure.that(listaObtenida).doesNotContain(actor.recall(VariablesSesion.REFERENCIA_TICKET_VAR3.toString()).toString())).performAs(actor);
    }

    public static ValidaNumeroReservaTicketCAFondosReserLiber conLaReferencia() {
        return Instrumented.instanceOf(ValidaNumeroReservaTicketCAFondosReserLiber.class).withProperties();
    }
}