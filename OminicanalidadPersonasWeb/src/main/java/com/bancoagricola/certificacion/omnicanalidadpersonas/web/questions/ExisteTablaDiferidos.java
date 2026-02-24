package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.TABLA_DIF_TC;

public class ExisteTablaDiferidos implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return TABLA_DIF_TC.resolveFor(actor).isPresent();
    }

    public static ExisteTablaDiferidos quelatabla(){
        return new ExisteTablaDiferidos();
    }
}
