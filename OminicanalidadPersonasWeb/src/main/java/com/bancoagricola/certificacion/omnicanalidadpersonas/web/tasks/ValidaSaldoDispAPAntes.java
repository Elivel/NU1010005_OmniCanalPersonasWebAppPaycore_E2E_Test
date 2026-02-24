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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;

public class ValidaSaldoDispAPAntes implements Task {
    private List<Transferencias> datosCAP;

    public ValidaSaldoDispAPAntes(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Saldo disponible' de 'Ahorro Programado' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(1);
        actor.remember(VariablesSesion.SALDO_DISP_AP_ANT_TRX.toString(), SALDO_DISP_AP.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", ""));
        actor.attemptsTo(
                Ensure.that(actor.recall(VariablesSesion.SALDO_DISP_AP_ANT_TRX.toString()).toString().replace(",", "")).isEqualTo
                        (SALDO_DISP_AP.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "")));
        System.out.println("Saldo AP antes: " + Double.parseDouble(SALDO_DISP_AP.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "")));

    }

    public static ValidaSaldoDispAPAntes datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaSaldoDispAPAntes.class).withProperties(datosCAP);
    }
}