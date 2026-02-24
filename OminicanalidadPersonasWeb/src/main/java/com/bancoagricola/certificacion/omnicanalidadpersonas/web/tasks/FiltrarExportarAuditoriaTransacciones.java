package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.BTN_BUSCAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class FiltrarExportarAuditoriaTransacciones implements Task {


    @Step("{0} 'Filtra y Exporta Transacciones'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AUDITORIATRX, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(AUDITORIATRX, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(AUDITORIATRX),
                WaitUntil.the(TTL_AUDITORIATRX, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TABLA_MOV_CA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FILTRAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_FILTRAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_FILTRAR),
                WaitUntil.the(OPC_HOY, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPC_HOY, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPC_HOY),
                WaitUntil.the(BTN_BUSCAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_BUSCAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_BUSCAR),
                WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds());
        actor.should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de 'Auditoría de transacciones'"),
                seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea 'mayor o igual a 1'"));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Scroll.to(LINK_IMPRIMIR).andAlignToBottom(),
                WaitUntil.the(LINK_EXPORTAR, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_EXPORTAR, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LINK_EXPORTAR));
        LeerArchivoProperties.esperar(6);
    }

    public static FiltrarExportarAuditoriaTransacciones hoy() {
        return Instrumented.instanceOf(FiltrarExportarAuditoriaTransacciones.class).withProperties();
    }
}