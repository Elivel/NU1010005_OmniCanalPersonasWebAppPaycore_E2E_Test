package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DetallesFondos {
    ArrayList<String> datosCapturados = new ArrayList();

    public ArrayList<String> retornoPaginaInicial() {

        String cuenta1 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P1.toString());
        String saldo1 = theActorInTheSpotlight().recall(VariablesSesion.SALDO_DISP1.toString().replace(" ", "."));
        String estado1 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P1.toString());
        String tipocuenta1 = theActorInTheSpotlight().recall(VariablesSesion.TIPO1.toString());
        String numerocta1 = theActorInTheSpotlight().recall(VariablesSesion.NUMEROCC1.toString());

        datosCapturados.add(cuenta1);
        datosCapturados.add(saldo1);
        datosCapturados.add(estado1);
        datosCapturados.add(tipocuenta1);
        datosCapturados.add(numerocta1);

        return datosCapturados;
    }

    public ArrayList<String> retornoPaginaIntermedia() {

        String cuenta2 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P2.toString());
        String saldo2 = theActorInTheSpotlight().recall(VariablesSesion.SALDO_DISP2.toString());
        String estado2 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P2.toString());
        String tipocuenta2 = theActorInTheSpotlight().recall(VariablesSesion.TIPO2.toString());
        String numerocta2 = theActorInTheSpotlight().recall(VariablesSesion.NUMEROCC2.toString());
        String cuota2 = theActorInTheSpotlight().recall(VariablesSesion.CUOTA2.toString());
        String monto2 = theActorInTheSpotlight().recall(VariablesSesion.MONTO_RETIRO2.toString());

        datosCapturados.add(cuenta2);
        datosCapturados.add(saldo2);
        datosCapturados.add(estado2);
        datosCapturados.add(tipocuenta2);
        datosCapturados.add(numerocta2);
        datosCapturados.add(cuota2);
        datosCapturados.add(monto2);

        return datosCapturados;
    }

    public ArrayList<String> retornoPaginaFinal() {

        String cuenta3 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P3.toString());
        String saldo3 = theActorInTheSpotlight().recall(VariablesSesion.SALDO_DISP3.toString());
        String estado3 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P3.toString());
        String tipocuenta3 = theActorInTheSpotlight().recall(VariablesSesion.TIPO3.toString());
        String numerocta3 = theActorInTheSpotlight().recall(VariablesSesion.NUMEROCC3.toString());
        String cuota3 = theActorInTheSpotlight().recall(VariablesSesion.CUOTA3.toString());
        String monto3 = theActorInTheSpotlight().recall(VariablesSesion.MONTO_RETIRO3.toString());

        datosCapturados.add(cuenta3);
        datosCapturados.add(saldo3);
        datosCapturados.add(estado3);
        datosCapturados.add(tipocuenta3);
        datosCapturados.add(numerocta3);
        datosCapturados.add(cuota3);
        datosCapturados.add(monto3);

        return datosCapturados;

    }
}