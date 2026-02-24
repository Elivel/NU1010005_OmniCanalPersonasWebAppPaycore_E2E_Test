package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.LoginPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PASSWORD;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoCambioDeClave implements Task {
    private List<String> pass;
    private String oldPass;

    public ProcesoCambioDeClave(List<String> pass) {
        this.pass = pass;
        this.oldPass = PASSWORD;
    }

    @Step("{0} 'realiza proceso para cambio de clave'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ICONO_CLAVE_DE_ACCESO, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(ICONO_CLAVE_DE_ACCESO, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(ICONO_CLAVE_DE_ACCESO),
                WaitUntil.the(TTL_CAMBIO_CLAVE, isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(TTL_CAMBIO_CLAVE, isEnabled()).forNoMoreThan(10).seconds());

        pass.subList(1, pass.size()).forEach(
                passValue -> {
                    System.out.println(passValue);
                    Enter.theValue(oldPass).into(CLAVE_ACTUAL).performAs(actor);
                    LeerArchivoProperties.esperar2();
                    Enter.theValue(passValue).into(NUEVA_CLAVE).performAs(actor);
                    LeerArchivoProperties.esperar2();
                    Enter.theValue(passValue).into(REPETIR_NUEVA_CLAVE).performAs(actor);
                    LeerArchivoProperties.esperar(2);
                    WaitUntil.the(BOTON_GUARDAR, isEnabled()).forNoMoreThan(15).seconds().performAs(actor);
                    WaitUntil.the(BOTON_GUARDAR, isClickable()).forNoMoreThan(15).seconds().performAs(actor);
                    Click.on(BOTON_GUARDAR).performAs(actor);
                    WaitUntil.the(MSG_CONFIRMACION, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
                    oldPass = passValue;
                    WaitUntil.the(ICONO_CLAVE_DE_ACCESO, isEnabled()).forNoMoreThan(15).seconds().performAs(actor);
                    WaitUntil.the(ICONO_CLAVE_DE_ACCESO, isClickable()).forNoMoreThan(15).seconds().performAs(actor);
                    Click.on(ICONO_CLAVE_DE_ACCESO).performAs(actor);
                    WaitUntil.the(TTL_CAMBIO_CLAVE, isVisible()).forNoMoreThan(15).seconds().performAs(actor);
                    WaitUntil.the(TTL_CAMBIO_CLAVE, isEnabled()).forNoMoreThan(15).seconds().performAs(actor);
                    LeerArchivoProperties.esperar2();
                }
        );
        LeerArchivoProperties.esperar2();
    }

    public static ProcesoCambioDeClave alUsuarioConLasClaves(List<String> pass) {
        return Tasks.instrumented(ProcesoCambioDeClave.class, pass);
    }
}