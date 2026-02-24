package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;


public class ExisteTablaMovimientos implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {

        return TABLA_MOV_CA.resolveFor(actor).isPresent();
    }
    public static ExisteTablaMovimientos quelatabla(){

        return new ExisteTablaMovimientos();
    }
}
