package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REG_TAB_CHEQ;

public class CantidadCheques implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return REG_TAB_CHEQ.resolveAllFor(actor).size();
    }

    public static CantidadCheques tiene(){
        return new CantidadCheques();
    }
}
