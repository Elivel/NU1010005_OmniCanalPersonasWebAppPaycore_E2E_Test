package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TIPO_TRX_COLUMNA;

public class ValidaTipoTransaccion implements Task {
    private List<Transferencias> datosAud;
    public ValidaTipoTransaccion(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }
    private static List<String> listaObtenida = new ArrayList<>();

    @Step("{0} valida que solo se muestren resultados con el tipo de transacción seleccionado")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosAud.get(0);

        TIPO_TRX_COLUMNA.resolveAllFor(actor).forEach(
                elementosLista -> { listaObtenida.clear();
                });

        TIPO_TRX_COLUMNA.resolveAllFor(actor).forEach(
                elementosLista -> { listaObtenida.add(elementosLista.getText());
        });
        System.out.println("Transaccion: " +ca.getTipoTRX());
        System.out.println("Listado: " + listaObtenida);
        Task.where(actor+" valida que solo se muestren registros de la transaccion "+"'"+ca.getTipoTRX()+"'"+" en la tabla",  Ensure.that(listaObtenida).containsOnly(ca.getTipoTRX())).performAs(actor);
    }

    public static ValidaTipoTransaccion datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(ValidaTipoTransaccion.class).withProperties(datosAud);
    }
}