package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REG_TABLA_MOV_CA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;

public class    CantidadRegistrosTablaMovimientos implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return REG_TABLA_MOV_CA.resolveAllFor(actor).size();
    }

    public static CantidadRegistrosTablaMovimientos tiene(){
        return new CantidadRegistrosTablaMovimientos();
    }
}
