package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Limites.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.LIMITE_ACUM_TRX;

public class ValidaMontoAcumulado implements Task {

    @Step("{0} valida que 'Monto acumulado a la fecha' no supere el valor máximo para realizar la prueba")
    @Override
    public <T extends Actor> void performAs(T actor) {

        //Seccion BM
        double montoAcumBM = Double.parseDouble(MONTOACUM_BM.resolveFor(actor).getValue().replace("$", "").replace(",","").trim());
        double limite = Double.valueOf(LIMITE_ACUM_TRX);
        System.out.println("montoAcumBM: " + montoAcumBM);
        System.out.println("limite: " + Double.valueOf(LIMITE_ACUM_TRX));
        actor.attemptsTo(
                Ensure.that(montoAcumBM).isLessThan(Double.valueOf(LIMITE_ACUM_TRX)));

        actor.attemptsTo(Scroll.to(STTL_LIM_EBP).andAlignToTop());

        //Seccion EBP
        double montoAcumEBP = Double.parseDouble(MONTOACUM_EBP.resolveFor(actor).getValue().replace("$", "").replace(",","").trim());
        System.out.println("montoAcumEBP: " + montoAcumEBP);
        actor.attemptsTo(
                Ensure.that(montoAcumEBP).isLessThan(Double.valueOf(LIMITE_ACUM_TRX)));
    }

    public static ValidaMontoAcumulado datosP() {
        return Instrumented.instanceOf(ValidaMontoAcumulado.class).withProperties();
    }
}

