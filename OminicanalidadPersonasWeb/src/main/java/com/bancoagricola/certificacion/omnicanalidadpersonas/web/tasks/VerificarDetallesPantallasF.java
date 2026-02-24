package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarDetallesPantallasF implements Task {

    public <T extends Actor> void performAs(T actor) {

        String cuenta1 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P1.toString());
        String deuda1 = theActorInTheSpotlight().recall(VariablesSesion.DEUDA_P1.toString());
        System.out.println("Deuda 1: "+deuda1);
        String estado1 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P1.toString());
        String fechapago1 = theActorInTheSpotlight().recall(VariablesSesion.FECHA_PAGO_P1.toString());

        String cuenta2 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P2.toString());
        String deuda2 = theActorInTheSpotlight().recall(VariablesSesion.DEUDA_P2.toString());
        System.out.println("Deuda 2: "+deuda2);
        String estado2 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P2.toString());
        String fechapago2 = theActorInTheSpotlight().recall(VariablesSesion.FECHA_PAGO_P2.toString());

        String cuenta3 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P3.toString());
        String deuda3 = theActorInTheSpotlight().recall(VariablesSesion.DEUDA_P3.toString());
        System.out.println("Deuda 3: "+deuda3);
        String estado3 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P3.toString());
        String fechapago3 = theActorInTheSpotlight().recall(VariablesSesion.FECHA_PAGO_P3.toString());

        actor.attemptsTo(
                Ensure.that(cuenta1).matches("Cuenta",
                        cuenta -> cuenta.equals(cuenta2)
                                & cuenta.equals(cuenta3)),
                Ensure.that(deuda1).matches("Deuda",
                        deuda -> deuda.equals(deuda2)
                                & deuda.equals(deuda3)),
                Ensure.that(estado1).matches("Estado",
                        estado -> estado.equals(estado2)
                                & estado.equals(estado3)),
                Ensure.that(fechapago1).matches("Fecha pago",
                        fechapago -> fechapago.equals(fechapago2)
                                & fechapago.equals(fechapago3)));
    }

    public static VerificarDetallesPantallasF prestamo() {
        return Instrumented.instanceOf(VerificarDetallesPantallasF.class).withProperties();
    }

}
