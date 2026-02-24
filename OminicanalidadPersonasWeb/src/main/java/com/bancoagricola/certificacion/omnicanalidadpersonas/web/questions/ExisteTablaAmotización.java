package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TABLA_AMORTIZ;

public class ExisteTablaAmotización implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return TABLA_AMORTIZ.resolveFor(actor).isPresent();
    }
    public static ExisteTablaAmotización quelatabla(){
        return new ExisteTablaAmotización();
    }
}
