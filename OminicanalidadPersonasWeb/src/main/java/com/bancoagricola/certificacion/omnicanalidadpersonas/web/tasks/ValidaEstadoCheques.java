package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.ESTADO_TABLA_CHEQUES;

public class ValidaEstadoCheques implements Task {
    private List<Transferencias> datosDCA;

    public ValidaEstadoCheques(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }
    private static List<String> listaObtenida = new ArrayList<>();

    @Step("{0} 'valida que solo se muestren los cheques con el estado seleccionado'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        ESTADO_TABLA_CHEQUES.resolveAllFor(actor).forEach(
                elementosLista -> {
                    listaObtenida.clear();
                });

        ESTADO_TABLA_CHEQUES.resolveAllFor(actor).forEach(
                elementosLista -> {
                    listaObtenida.add(elementosLista.getText());
                });
        System.out.println("Estado de ticket: " +ca.getEstadoCheques());
        System.out.println("Listado: " + listaObtenida);
        Task.where(actor+" valida que solo se muestren los cheques con el estado "+"'"+ca.getEstadoCheques()+"'"+" en la tabla",  Ensure.that(listaObtenida).containsOnly(ca.getEstadoCheques().toUpperCase())).performAs(actor);
    }

    public static ValidaEstadoCheques conLaReferencia(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidaEstadoCheques.class).withProperties(datosDCA);
    }
}