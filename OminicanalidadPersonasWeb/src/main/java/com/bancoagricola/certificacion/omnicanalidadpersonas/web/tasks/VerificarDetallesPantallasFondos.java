package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class VerificarDetallesPantallasFondos implements Task {

        public <T extends Actor> void performAs(T actor) {

        String cuenta1 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P1.toString());
        String saldo1 = theActorInTheSpotlight().recall(VariablesSesion.SALDO_DISP1.toString().replace(" ", "."));
        String estado1 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P1.toString());
        String tipocuenta1 = theActorInTheSpotlight().recall(VariablesSesion.TIPO1.toString());
        String numerocta1 = theActorInTheSpotlight().recall(VariablesSesion.NUMEROCC1.toString());

        String cuenta2 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P2.toString());
        String saldo2 = theActorInTheSpotlight().recall(VariablesSesion.SALDO_DISP2.toString());
        String estado2 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P2.toString());
        String tipocuenta2 = theActorInTheSpotlight().recall(VariablesSesion.TIPO2.toString());
        String numerocta2 = theActorInTheSpotlight().recall(VariablesSesion.NUMEROCC2.toString());
        String cuota2 = theActorInTheSpotlight().recall(VariablesSesion.CUOTA2.toString());
        String monto2 = theActorInTheSpotlight().recall(VariablesSesion.MONTO_RETIRO2.toString());

        String cuenta3 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P3.toString());
        String saldo3 = theActorInTheSpotlight().recall(VariablesSesion.SALDO_DISP3.toString());
        String estado3 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P3.toString());
        String tipocuenta3 = theActorInTheSpotlight().recall(VariablesSesion.TIPO3.toString());
        String numerocta3 = theActorInTheSpotlight().recall(VariablesSesion.NUMEROCC3.toString());
        String cuota3 = theActorInTheSpotlight().recall(VariablesSesion.CUOTA3.toString());
        String monto3 = theActorInTheSpotlight().recall(VariablesSesion.MONTO_RETIRO3.toString());


        actor.attemptsTo(
                Ensure.that(cuenta1).matches("Cuentas",
                        cuenta -> cuenta.equals(cuenta2)
                                & cuenta.equals(cuenta3)),
                Ensure.that(saldo1).matches("Saldos disponibles",
                        saldo -> saldo.equals(saldo2)
                                & saldo.equals(saldo3)),
                Ensure.that(estado1).matches("Estados",
                        estado -> estado.equals(estado2)
                                & estado.equals(estado3)),
                Ensure.that(tipocuenta1).matches("Tipos de fondo",
                        tipo -> tipo.equals(tipocuenta2)
                                & tipo.equals(tipocuenta3)),
                Ensure.that(numerocta1).matches("Números de cuenta",
                        numerocta -> numerocta.equals(numerocta2)
                                & numerocta.equals(numerocta3)),
                Ensure.that(cuota2).matches("Cuotas",
                        cuota -> cuota.equals(cuota3)),
                Ensure.that(monto2).matches("Monto máximo pago",
                        monto -> monto.equals(monto3)));

    }

    public static VerificarDetallesPantallasFondos inversion() {
        return Instrumented.instanceOf(VerificarDetallesPantallasFondos.class).withProperties();
    }

}
