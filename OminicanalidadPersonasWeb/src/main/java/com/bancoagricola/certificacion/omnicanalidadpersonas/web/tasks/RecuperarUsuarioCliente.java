package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Cliente;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.TXT_CODIGO_CONFIRMACION;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CONTR_TELEBANCA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RecuperarUsuarioCliente implements Task {

    private List<Cliente> datosCliente;

    public RecuperarUsuarioCliente(List<Cliente> datosCliente) {
        this.datosCliente = datosCliente;
    }

    @Step("{0} 'realiza proceso de recuperacion de usuario'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Cliente cli = datosCliente.get(0);
        actor.attemptsTo(
                WaitUntil.the(BUTTON_RECOVER, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BUTTON_RECOVER),
                WaitUntil.the(OPCION_OLVIDASTE_USUARIO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_OLVIDASTE_USUARIO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_OLVIDASTE_USUARIO),
                WaitUntil.the(OPCION_OLVIDE_USUARIO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_OLVIDE_USUARIO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_OLVIDE_USUARIO),
                WaitUntil.the(SELECCIONAR_TIPO_DOCUMENTO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_DOCUMENTO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_TIPO_DOCUMENTO));
        //WaitUntil.the(SELECCIONAR_TIPO_DOCUMENTO_2, isEnabled()).forNoMoreThan(60).seconds(),
        //WaitUntil.the(SELECCIONAR_TIPO_DOCUMENTO_2, isClickable()).forNoMoreThan(60).seconds());
        System.out.println("Dato Esperado: " + cli.getTipoDocumento());
        actor.attemptsTo(
                Click.on(SELECCIONAR_TIPO_DOCUMENTO_2.of(cli.getTipoDocumento())),
                SendKeys.of(cli.getNumeroIdentificacion()).into(CAMPO_IDENTIFICACION),
                WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_CONTINUAR_RECORDAR_USU),
                WaitUntil.the(TXT_CODIGO_CONFIRMACION, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TXT_CODIGO_CONFIRMACION, isEnabled()).forNoMoreThan(30).seconds(),
                SendKeys.of(CONTR_TELEBANCA).into(TXT_CODIGO_CONFIRMACION),
                WaitUntil.the(BTN_CONTINUAR1, isCurrentlyEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR1, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR1, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR1));
    }

    public static RecuperarUsuarioCliente conIdentificacion(List<Cliente> datosCliente) {
        return Instrumented.instanceOf(RecuperarUsuarioCliente.class).withProperties(datosCliente);
    }
}