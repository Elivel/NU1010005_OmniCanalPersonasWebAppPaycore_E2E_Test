package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;

public class ConsultaRegistroAuditoriaTRX implements Task {
    private List<Transferencias> datosAud;

    public ConsultaRegistroAuditoriaTRX(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }
    private static List<String> listaTRX = new ArrayList<String>();

    @Step("{0} 'valida que se muestre el registro por el valor de '<monto>' en la tabla'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias aud = datosAud.get(0);

        REG_TABLA_MONTO.resolveAllFor(actor).forEach(
                elementosLista -> {
                    listaTRX.add(elementosLista.getText().replace("$", ""));
                });
        System.out.println("listaTRX: "+listaTRX);
        actor.attemptsTo(Ensure.that(listaTRX).contains(aud.getMonto()));
    }

    public static ConsultaRegistroAuditoriaTRX datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(ConsultaRegistroAuditoriaTRX.class).withProperties(datosAud);
    }
}