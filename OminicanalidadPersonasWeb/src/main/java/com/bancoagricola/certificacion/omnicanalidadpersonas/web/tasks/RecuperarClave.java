package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Cliente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.InicioPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RecuperarClave implements Task {

    private static final Logger LOGGER = Logger.getLogger(RecuperarClave.class.getName());

    private final List<Cliente> datosCliente;

    public RecuperarClave(List<Cliente> datosCliente) {
        this.datosCliente = datosCliente;
    }

    @Step("{0} 'realiza proceso para recuperar clave'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        for (Cliente cliente : datosCliente) {
            LOGGER.info(cliente.getPassword());
            actor.attemptsTo(
                    WaitUntil.the(BUTTON_RECOVER, isVisible()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(BUTTON_RECOVER, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BUTTON_RECOVER),
                    WaitUntil.the(TLT_RECUPERACION_USUARIO_CLAVE, isVisible()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(TLT_RECUPERACION_USUARIO_CLAVE, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(TXT_USUARIO, isVisible()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(TXT_USUARIO, isEnabled()).forNoMoreThan(60).seconds(),
                    SendKeys.of("Automatizada04").into(TXT_USUARIO),
                    WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BOTON_CONTINUAR_RECORDAR_USU),
                    WaitUntil.the(BTN_RECUPERAR_CLAVE, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BTN_RECUPERAR_CLAVE, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_RECUPERAR_CLAVE),
                    WaitUntil.the(TXT_CODIGO_CONFIRMACION, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(TXT_CODIGO_CONFIRMACION, isClickable()).forNoMoreThan(60).seconds(),
                    SendKeys.of(CONTR_TELEBANCA).into(TXT_CODIGO_CONFIRMACION),
                    WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BOTON_CONTINUAR_RECORDAR_USU),
                    WaitUntil.the(LABEL_NUEVA_CLAVE, isVisible()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(LABEL_NUEVA_CLAVE, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(TXT_NUEVACLAVE, isEnabled()).forNoMoreThan(60).seconds(),
                    SendKeys.of(cliente.getPassword()).into(TXT_NUEVACLAVE),
                    Scroll.to(TXT_CONFIRMAR_NUEVACLAVE),
                    SendKeys.of(cliente.getPassword()).into(TXT_CONFIRMAR_NUEVACLAVE),
                    WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BOTON_CONTINUAR_RECORDAR_USU, isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(BOTON_CONTINUAR_RECORDAR_USU));
            LeerArchivoProperties.esperar(1);
            WaitUntil.the(LABEL_CLAVE_MODIFICADA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
            actor.attemptsTo(
                    WaitUntil.the(BTN_ACEPTAR, isEnabled()).forNoMoreThan(120).seconds(),
                    WaitUntil.the(BTN_ACEPTAR, isClickable()).forNoMoreThan(60).seconds());
            LeerArchivoProperties.esperar(1);
            actor.attemptsTo(
                    Click.on(BTN_ACEPTAR));
            WaitUntil.the(LABEL, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        }
    }

    public static RecuperarClave cliente(List<Cliente> datosCliente) {
        return Instrumented.instanceOf(RecuperarClave.class).withProperties(datosCliente);
    }
}
