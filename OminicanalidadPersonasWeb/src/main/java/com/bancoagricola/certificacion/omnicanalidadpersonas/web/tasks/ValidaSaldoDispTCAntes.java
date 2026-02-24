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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.DISPONIBILIDAD_TARJETA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;

public class ValidaSaldoDispTCAntes implements Task {
    private List<Transferencias> datosCAP;

    public ValidaSaldoDispTCAntes(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Saldo disponible' de 'Tarjeta de crédito' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(2);
        actor.remember(VariablesSesion.SALDOTC_ANT.toString(), DISPONIBILIDAD_TARJETA.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "").replace("$", "").trim());
        actor.attemptsTo(
                Ensure.that(actor.recall(VariablesSesion.SALDOTC_ANT.toString()).toString()).isEqualTo
                        (DISPONIBILIDAD_TARJETA.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "").replace("$", "").trim()));
        System.out.println("Saldo TC antes: " + Double.parseDouble(DISPONIBILIDAD_TARJETA.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "").replace("$", "").trim()));

    }

    public static ValidaSaldoDispTCAntes datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaSaldoDispTCAntes.class).withProperties(datosCAP);
    }
}