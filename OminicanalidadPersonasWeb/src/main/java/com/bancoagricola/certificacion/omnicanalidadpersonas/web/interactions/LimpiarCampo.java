package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.markers.IsSilent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.Keys;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LimpiarCampo implements Interaction, IsSilent {
    private Target elementoALimpiar;
    private String nombreDelElemento;

    public LimpiarCampo(Target elementoALimpiar) {
        this.elementoALimpiar = elementoALimpiar;
        this.nombreDelElemento = elementoALimpiar.getName();
    }

    @Step("{0} limpia el campo #nombreDelElemento")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Keys[] accionesBorrado = new Keys[elementoALimpiar.resolveFor(actor).getTextValue().length()];

        for (int i = 0; i < accionesBorrado.length; i++) {
            accionesBorrado[i] = Keys.BACK_SPACE;
        }

        elementoALimpiar.resolveFor(actor).sendKeys(accionesBorrado);
    }
    public static Performable elCampo(Target elementoALimpiar) {
        return instrumented(LimpiarCampo.class, elementoALimpiar);
    }
}
