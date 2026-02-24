package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.VENTANA_CLAVE_DINAMICA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.TXT_CODIGO_CONFIRMACION;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_OBTENER_CODIGO_TELEBANCA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresarClaveDinamica implements Interaction {

    @Step("{0} 'ingresa información clave dinamica'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(VENTANA_CLAVE_DINAMICA,isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_OBTENER_CODIGO_TELEBANCA,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_OBTENER_CODIGO_TELEBANCA),
                SendKeys.of(LeerArchivoProperties.obtenerPropiedad("contrasena_telebanca")).into(TXT_CODIGO_CONFIRMACION),
                Click.on(BTN_ACEPTAR)
        );
    }
}
