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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.RES_MOV_SALDO_DISP;

public class ValidaSaldoDispCADespuesAgg implements Task {
    private List<Transferencias> datosCAP;
    public ValidaSaldoDispCADespuesAgg(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Saldo disponible' de 'Cuenta de ahorro / Cuenta corriente' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(1);
        double saldoCuentaDesD = Double.parseDouble(RES_MOV_SALDO_DISP.resolveFor(actor).getAttribute("innerText").replace(",",""));
        double saldoCuentaAntD = Double.parseDouble(actor.recall(VariablesSesion.SALDO_DISPONIBLE_CA_ANTES_TRX.toString()).toString().replace(",",""));
        double valorAPagar = Double.parseDouble(datosCAP.get(0).getMonto());
        double calculo = Math.round((saldoCuentaAntD) * 100.0) / 100.0;
        System.out.println("Saldo C despues: "+saldoCuentaDesD);
        System.out.println("Valor a pagar: "+valorAPagar);
        System.out.println("Calculo: "+calculo);
        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo));
    }
    public static ValidaSaldoDispCADespuesAgg datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaSaldoDispCADespuesAgg.class).withProperties(datosCAP);
    }
}