package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.TABLA_RES;

public class ExisteTablaResultadosAuditoria implements Question <Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
        return TABLA_RES.resolveFor(actor).isPresent();
    }
    public static ExisteTablaResultadosAuditoria quelatabla(){
        return new ExisteTablaResultadosAuditoria();
    }
}
