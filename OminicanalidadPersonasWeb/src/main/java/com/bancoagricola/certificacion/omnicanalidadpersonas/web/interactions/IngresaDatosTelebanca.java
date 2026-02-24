package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CONTR_TELEBANCA_DEV;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresaDatosTelebanca implements Interaction {

    @Step("{0} 'ingresa datos Telebanca '")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(TTL_PARACONTINUAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_PARACONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TXT_CODIGO_CONFIRMACION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TXT_CODIGO_CONFIRMACION, isClickable()).forNoMoreThan(60).seconds(),
                SendKeys.of(CONTR_TELEBANCA_DEV).into(TXT_CODIGO_CONFIRMACION),
                WaitUntil.the(BOTON_INGRESAR, isCurrentlyEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_INGRESAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_INGRESAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_INGRESAR));
    }

    public static IngresaDatosTelebanca nueva(){
        return Instrumented.instanceOf(IngresaDatosTelebanca.class).withProperties();
    }
}