package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class EsperarAClick implements Interaction {

    private String textoDelElemento;

    public EsperarAClick(String textoDelElemento) {
        this.textoDelElemento = textoDelElemento;
    }

    @Step("{0} valida que '#textoDelElemento' sea clickable")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).find(String.format("//span[.='%s']", textoDelElemento)).isClickable();
    }

    public static EsperarAClick elElementoConTexto(String textoDelElemento) {
        return instrumented(EsperarAClick.class, textoDelElemento);
    }

}
