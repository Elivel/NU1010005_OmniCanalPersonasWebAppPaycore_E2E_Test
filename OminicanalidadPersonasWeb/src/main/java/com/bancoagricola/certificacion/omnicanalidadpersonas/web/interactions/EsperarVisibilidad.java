package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EsperarVisibilidad implements Interaction {

    private String textoDelElemento;

    public EsperarVisibilidad(String textoDelElemento) {
        this.textoDelElemento = textoDelElemento;
    }

    @Step("{0} valida que '#textoDelElemento' sea visible")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).find(String.format("//span[.='%s']", textoDelElemento)).isVisible();
    }

    public static EsperarVisibilidad elElementoConTexto(String textoDelElemento) {
        return instrumented(EsperarVisibilidad.class, textoDelElemento);
    }

}
