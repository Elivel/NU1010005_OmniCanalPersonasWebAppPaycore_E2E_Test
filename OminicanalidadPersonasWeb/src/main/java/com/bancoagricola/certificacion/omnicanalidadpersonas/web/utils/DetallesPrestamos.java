package com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils;

import java.util.ArrayList;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DetallesPrestamos {
    ArrayList<String> datosCapturados = new ArrayList();

    public ArrayList<String> retornoPaginaInicial() {

        String cuenta1 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P1.toString());
        String deuda1 = theActorInTheSpotlight().recall(VariablesSesion.DEUDA_P1.toString().replace(" ", "."));
        String fechapago1 = theActorInTheSpotlight().recall(VariablesSesion.FECHA_PAGO_P1.toString());
        String estado1 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P1.toString());

        datosCapturados.add(cuenta1);
        datosCapturados.add(deuda1);
        datosCapturados.add(estado1);
        datosCapturados.add(fechapago1);

        return datosCapturados;
    }

    public ArrayList<String> retornoPaginaIntermedia() {

        String cuenta2 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P2.toString());
        String deuda2 = theActorInTheSpotlight().recall(VariablesSesion.DEUDA_P2.toString());
        String fechapago2 = theActorInTheSpotlight().recall(VariablesSesion.FECHA_PAGO_P2.toString());
        String estado2 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P2.toString());

        datosCapturados.add(cuenta2);
        datosCapturados.add(deuda2);
        datosCapturados.add(estado2);
        datosCapturados.add(fechapago2);

        return datosCapturados;
    }

    public ArrayList<String> retornoPaginaFinal() {

        String cuenta3 = theActorInTheSpotlight().recall(VariablesSesion.CUENTA_P3.toString());
        String deuda3 = theActorInTheSpotlight().recall(VariablesSesion.DEUDA_P3.toString());
        String fechapago3 = theActorInTheSpotlight().recall(VariablesSesion.FECHA_PAGO_P3.toString());
        String estado3 = theActorInTheSpotlight().recall(VariablesSesion.ESTADO_P3.toString());

        datosCapturados.add(cuenta3);
        datosCapturados.add(deuda3);
        datosCapturados.add(fechapago3);
        datosCapturados.add(estado3);

        return datosCapturados;
    }
}