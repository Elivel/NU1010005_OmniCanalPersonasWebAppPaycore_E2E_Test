package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Administrar.CIEX;

public class SeMuestraOpcion implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return CIEX.resolveFor(actor).isPresent();
    }
    public static SeMuestraOpcion en(){
        return new SeMuestraOpcion();
    }
}
