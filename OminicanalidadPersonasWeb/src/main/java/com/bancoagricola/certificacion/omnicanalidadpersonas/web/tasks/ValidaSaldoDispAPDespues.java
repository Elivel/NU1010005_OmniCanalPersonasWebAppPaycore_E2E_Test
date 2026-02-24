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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.SALDO_DISP_AP;

public class ValidaSaldoDispAPDespues implements Task {
    private List<Transferencias> datosCAP;
    public ValidaSaldoDispAPDespues(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Saldo disponible' de 'Ahorro Programado' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(1);
        double saldoCuentaDesD = Double.parseDouble(SALDO_DISP_AP.resolveFor(actor).getAttribute("innerText").replace(",",""));
        double saldoCuentaAntD = Double.parseDouble(actor.recall(VariablesSesion.SALDO_DISP_AP_ANT_TRX.toString()).toString().replace(",",""));
        double valorAPagar = Double.parseDouble(datosCAP.get(0).getMonto());
        double calculo = Math.round((saldoCuentaAntD - valorAPagar) * 100.0) / 100.0;
        System.out.println("Saldo AP despues: "+saldoCuentaDesD);
        System.out.println("Valor a pagar: "+valorAPagar);
        System.out.println("Calculo: "+calculo);
        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo));
    }
    public static ValidaSaldoDispAPDespues datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaSaldoDispAPDespues.class).withProperties(datosCAP);
    }
}