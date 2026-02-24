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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.VERSION_APP;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;

public class ValidaSaldoDispCAAntes implements Task {
    private List<Transferencias> datosCAP;

    public ValidaSaldoDispCAAntes(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Saldo disponible' de 'Cuenta de ahorro / Cuenta corriente' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(1);
        actor.remember(VariablesSesion.SALDO_DISPONIBLE_CA_ANTES_TRX.toString(), RES_MOV_SALDO_DISP.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", ""));
        Task.where("Saldo inicial: "+"'"+actor.recall(VariablesSesion.SALDO_DISPONIBLE_CA_ANTES_TRX.toString()).toString()+"'").performAs(actor);
        System.out.println("Saldo C antes: "+ actor.recall(VariablesSesion.SALDO_DISPONIBLE_CA_ANTES_TRX.toString()).toString());

    }

    public static ValidaSaldoDispCAAntes datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaSaldoDispCAAntes.class).withProperties(datosCAP);
    }
}