package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickEn implements Interaction {

    private String textoDelElemento;

    public ClickEn(String textoDelElemento) {
        this.textoDelElemento = textoDelElemento;
    }

    @Step("{0} click en '#textoDelElemento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        BrowseTheWeb.as(actor).find(String.format("//span[.='%s']", textoDelElemento)).click();
    }

    public static ClickEn elElementoConTexto(String textoDelElemento) {
        return instrumented(ClickEn.class, textoDelElemento);
    }
}
