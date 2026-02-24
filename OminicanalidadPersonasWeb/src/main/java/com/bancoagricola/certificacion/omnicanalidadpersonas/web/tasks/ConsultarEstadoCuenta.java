package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.ClickEn;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.ESTADO_DE_CUENTA_CORRIENTE;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultarEstadoCuenta implements Task {
    private List<Transferencias> datos;

    public ConsultarEstadoCuenta(List<Transferencias> datos) {
        this.datos = datos;
    }

    @Step("{0} 'realiza proceso para consultar el estado de cuenta corriente'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(OPERACIONES).andAlignToTop(),
                WaitUntil.the(RESULTADOS.of(ESTADO_DE_CUENTA_CORRIENTE), isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of(ESTADO_DE_CUENTA_CORRIENTE), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of(ESTADO_DE_CUENTA_CORRIENTE), isClickable()).forNoMoreThan(60).seconds(),
                ClickEn.elElementoConTexto(ESTADO_DE_CUENTA_CORRIENTE),
                WaitUntil.the(RESULTADOS.of(ESTADO_DE_CUENTA_CORRIENTE), isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_CUENTA),
                WaitUntil.the(SELECCIONA_CUENTA.of(datos.get(0).getCuentaOrigen()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONA_CUENTA.of(datos.get(0).getCuentaOrigen()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONA_CUENTA.of(datos.get(0).getCuentaOrigen())),
                WaitUntil.the(MES_ANO, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MES_ANO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MES_ANO),
                WaitUntil.the(OPC_MES_ANO.of(datos.get(0).getPeriodo()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPC_MES_ANO.of(datos.get(0).getPeriodo()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPC_MES_ANO.of(datos.get(0).getPeriodo())),
                WaitUntil.the(BTN_CONSULTAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONSULTAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONSULTAR),
                WaitUntil.the(PDF_ESTADO_CUENTA, isClickable()).forNoMoreThan(60).seconds(),
                Ensure.that(PDF_ESTADO_CUENTA).isDisplayed(),
                Scroll.to(DESCARGAR).andAlignToTop(),
                WaitUntil.the(DESCARGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESCARGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DESCARGAR));
    }

    public static ConsultarEstadoCuenta corriente(List<Transferencias> datos) {
        return Instrumented.instanceOf(ConsultarEstadoCuenta.class).withProperties(datos);
    }
}
