package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.DISPONIBILIDAD_TARJETA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;

public class ValidaSaldoDispTCDespues implements Task {
    private List<Transferencias> datosCAP;
    public ValidaSaldoDispTCDespues(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Saldo disponible' de 'Tarjeta de crédito' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(1);
        double saldoTCDesD = Double.parseDouble(DISPONIBILIDAD_TARJETA.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "").replace("$", "").trim());
        double saldoTCAntD = Double.parseDouble(actor.recall(VariablesSesion.SALDOTC_ANT.toString()).toString());
        double valorAPagar = Double.parseDouble(datosCAP.get(0).getMonto());
        double calculo = Math.round((saldoTCAntD - valorAPagar) * 100.0) / 100.0;
        System.out.println("Saldo TC despues: "+saldoTCDesD);
        System.out.println("Valor a pagar: "+valorAPagar);
        System.out.println("Calculo: "+calculo);
        actor.attemptsTo(
                Ensure.that(saldoTCDesD).isEqualTo(calculo));
    }
    public static ValidaSaldoDispTCDespues datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaSaldoDispTCDespues.class).withProperties(datosCAP);
    }
}