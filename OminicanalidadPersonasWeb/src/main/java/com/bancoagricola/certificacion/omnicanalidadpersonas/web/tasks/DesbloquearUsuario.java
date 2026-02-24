package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class DesbloquearUsuario implements Task {

    @Step("{0} 'realiza proceso para desbloquear usuario'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LABEL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_OLVIDASTE_USUARIO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_OLVIDASTE_USUARIO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_OLVIDASTE_USUARIO),
                WaitUntil.the(TXT_USUARIO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TXT_USUARIO, isClickable()).forNoMoreThan(60).seconds(),
                SendKeys.of(USUARIO).into(TXT_USUARIO),
                WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_CONTINUAR_RECORDAR_USU),
                WaitUntil.the(BTN_DESBLOQUEAR_USUARIO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_DESBLOQUEAR_USUARIO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_DESBLOQUEAR_USUARIO));
        actor.attemptsTo(
                WaitUntil.the(LBL_OBTENER_CODIGO_TELEBANCA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LBL_OBTENER_CODIGO_TELEBANCA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LBL_OBTENER_CODIGO_TELEBANCA),
                WaitUntil.the(TXT_CODIGO_CONFIRMACION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TXT_CODIGO_CONFIRMACION, isClickable()).forNoMoreThan(60).seconds(),
                SendKeys.of(CONTR_TELEBANCA).into(TXT_CODIGO_CONFIRMACION),
                WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_CONTINUAR_RECORDAR_USU),
                WaitUntil.the(BTN_FINALIZAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR, isClickable()).forNoMoreThan(60).seconds());
        WaitUntil.the(LBL_USUARIO_DESBLOQUEADO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
    }

    public static DesbloquearUsuario cliente() {

        return Instrumented.instanceOf(DesbloquearUsuario.class).withProperties();
    }
}
