package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.TABLA_MOVIMIENTOS_REFERENCIA_FON_RES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_OTROS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class FondosLiberadosPagoesTDC implements Task {
    private List<Transferencias> datosTransferencias;
    private static List<String> listaObtenida = new ArrayList<>();
    public FondosLiberadosPagoesTDC(List<Transferencias> datosFR) {
        this.datosTransferencias = datosFR;
    }

    @Step("{0} 'Ver Fondos Reservados'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        String concepto  = t.getConcepto();
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(15).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito())),
                WaitUntil.the(LABEL_COMPROBANTE.of(BOTON_OTROS),isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LABEL_COMPROBANTE.of(BOTON_OTROS),isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LABEL_COMPROBANTE.of(BOTON_OTROS))
        );
        System.out.println("Referencia: " + actor.recall(VariablesSesion.REFERENCIA.toString()));
        TABLA_MOVIMIENTOS_REFERENCIA_FON_RES.resolveAllFor(actor).forEach(
                elementosLista -> {
                    listaObtenida.add(elementosLista.getText());
                });
        System.out.println("listaObtenida: " + listaObtenida);
        Task.where(actor+" valida que se muestre el número de referencia "+"'"+actor.recall(VariablesSesion.REFERENCIA_TICKET_VAR.toString()).toString()+"'"+" en la tabla movimientos",  Ensure.that(listaObtenida).doesNotContain(actor.recall(VariablesSesion.REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);

    }
    public static FondosLiberadosPagoesTDC datosFR(List<Transferencias> datosFR) {
        return Instrumented.instanceOf(FondosLiberadosPagoesTDC.class).withProperties(datosFR);
    }
}
