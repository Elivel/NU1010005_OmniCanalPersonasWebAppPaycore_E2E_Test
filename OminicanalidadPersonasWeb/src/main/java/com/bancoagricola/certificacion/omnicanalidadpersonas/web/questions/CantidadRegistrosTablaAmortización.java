package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.REG_TA;

public class CantidadRegistrosTablaAmortización implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return REG_TA.resolveAllFor(actor).size();
    }
    public static CantidadRegistrosTablaAmortización tiene(){
        return new CantidadRegistrosTablaAmortización();
    }
}
