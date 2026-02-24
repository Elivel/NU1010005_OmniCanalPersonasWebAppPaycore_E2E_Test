package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.REG_TABLA_DIF_TC;

public class CantidadRegistrosTablaDiferidosTC implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return REG_TABLA_DIF_TC.resolveAllFor(actor).size();
    }

    public static CantidadRegistrosTablaDiferidosTC tiene(){
        return new CantidadRegistrosTablaDiferidosTC();
    }
}
