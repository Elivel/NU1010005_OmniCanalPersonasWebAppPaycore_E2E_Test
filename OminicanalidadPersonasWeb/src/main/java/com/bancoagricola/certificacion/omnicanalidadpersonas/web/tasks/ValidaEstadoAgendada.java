package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REG_TABLA_ESTADO;

public class ValidaEstadoAgendada implements Task {

    private String estado;
    public ValidaEstadoAgendada(String estado) {
        this.estado = estado;
    }
    private static List<String> listaObtenida = new ArrayList<>();

    @Step("{0} valida que solo se muestren resultados con el estado '#estado'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        REG_TABLA_ESTADO.resolveAllFor(actor).forEach(
                elementosLista -> { listaObtenida.clear();
                });

        REG_TABLA_ESTADO.resolveAllFor(actor).forEach(
                elementosLista -> { listaObtenida.add(elementosLista.getText());
        });
        System.out.println("Estado: " +estado);
        System.out.println("Listado: " + listaObtenida);
        Task.where(actor+" valida que solo se muestren registros con el estado "+"'"+estado+"'"+" en la tabla",  Ensure.that(listaObtenida).containsOnly(estado)).performAs(actor);
    }

    public static ValidaEstadoAgendada datosAud(String estado) {
        return Instrumented.instanceOf(ValidaEstadoAgendada.class).withProperties(estado);
    }
}