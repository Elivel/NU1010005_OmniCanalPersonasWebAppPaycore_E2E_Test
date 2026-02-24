package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.MONTO_COLUMNA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static org.junit.Assert.assertTrue;

public class ValidaRangoMontoValido implements Task {
    private List<Transferencias> datosAud;
    public ValidaRangoMontoValido(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }
    private static List<Double> ListaDou = new ArrayList<>();

    @Step("{0} valida que solo se muestren resultados de 'Monto' dentro del rango establecido")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosAud.get(0);

        MONTO_COLUMNA.resolveAllFor(actor).forEach(
                elementosLista -> {
                    ListaDou.clear();
                });

        MONTO_COLUMNA.resolveAllFor(actor).forEach(
                elementosLista -> {
                    ListaDou.add(Double.parseDouble(elementosLista.getText().replace(",", "")));
                });
        System.out.println("Desde: " +ca.getMontoDesde());
        System.out.println("Hasta: " +ca.getMontoHasta());
        System.out.println("Listado: " + ListaDou);
        Task.where(actor+" valida que solo se muestren registros en el rango "+"'"+ca.getMontoDesde()+"'"+" - "+"'"+ca.getMontoHasta()+"'"+" en la tabla", Ensure.that(ListaDou.stream().allMatch(monto -> monto >= Double.parseDouble(ca.getMontoDesde()) && monto <= Double.parseDouble(ca.getMontoHasta()))).isTrue()).performAs(actor);
    }

    public static ValidaRangoMontoValido datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(ValidaRangoMontoValido.class).withProperties(datosAud);
    }
}

