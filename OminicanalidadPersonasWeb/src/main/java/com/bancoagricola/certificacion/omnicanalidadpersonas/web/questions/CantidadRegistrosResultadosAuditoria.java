package com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.REG_TABLA_RES;

public class CantidadRegistrosResultadosAuditoria implements Question <Integer> {

    @Override
    public Integer answeredBy(Actor actor) {
        return REG_TABLA_RES.resolveAllFor(actor).size();
    }

    public static CantidadRegistrosResultadosAuditoria tiene(){
        return new CantidadRegistrosResultadosAuditoria();
    }
}
