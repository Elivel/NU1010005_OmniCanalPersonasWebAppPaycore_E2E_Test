package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.BOTON_INGRESAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.TTL_PARACONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.TXT_CODIGO_CONFIRMACION;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CONTR_TELEBANCA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CONTR_TELEBANCA_DEV;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresaDatosTelebancaDev implements Interaction {

    @Step("{0} 'ingresa datos Telebanca '")
    @Override
    public <T extends Actor> void performAs(T actor) {
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

    public static IngresaDatosTelebancaDev nueva(){
        return Instrumented.instanceOf(IngresaDatosTelebancaDev.class).withProperties();
    }
}