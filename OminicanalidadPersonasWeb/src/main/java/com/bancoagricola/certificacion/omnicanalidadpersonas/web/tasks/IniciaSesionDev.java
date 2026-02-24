package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresaDatosTelebanca;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PASSWORD_DEV;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IniciaSesionDev implements Task {
    private String usuario;

    public IniciaSesionDev(String usuario) {
        this.usuario = usuario;
    }

    @Step("{0} 'Inicia sesión'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                SendKeys.of(usuario).into(TXT_USUARIO),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CONTINUAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LBL_OBTENER_CODIGO_TELEBANCA2, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LBL_OBTENER_CODIGO_TELEBANCA2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LBL_OBTENER_CODIGO_TELEBANCA2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LBL_OBTENER_CODIGO_TELEBANCA2),
                IngresaDatosTelebanca.nueva());
                LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LBL_CLAVE, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TXT_PASSWORD, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TXT_PASSWORD, isClickable()).forNoMoreThan(60).seconds(),
                    SendKeys.of(PASSWORD_DEV).into(TXT_PASSWORD),
                    WaitUntil.the(BTN_CONTINUAR, isVisible()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_CONTINUAR)
                    //Click.on(BOTON_REINTENTAR)
        );

            WaitUntil.the(MENU_PRINC, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        }


    public static IniciaSesionDev bancoagricola(String usuario) {
        return Instrumented.instanceOf(IniciaSesionDev.class).withProperties(usuario);
    }
}
