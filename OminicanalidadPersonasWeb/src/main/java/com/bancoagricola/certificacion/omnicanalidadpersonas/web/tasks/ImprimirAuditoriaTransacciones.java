package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.BTN_BUSCAR;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ImprimirAuditoriaTransacciones implements Task {

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
                WaitUntil.the(FILTROS_ADICIONALES,isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(FILTROS_ADICIONALES,isClickable()).forNoMoreThan(30).seconds(),
                Click.on(FILTROS_ADICIONALES),
                WaitUntil.the(CM_TIPO_TRX_AUDI, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(CM_TIPO_TRX_AUDI, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(CM_TIPO_TRX_AUDI),
                WaitUntil.the(OP_TIPO_TRX_TRANS_PROP, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OP_TIPO_TRX_TRANS_PROP, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OP_TIPO_TRX_TRANS_PROP),
                WaitUntil.the(BTN_BUSCAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_BUSCAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_BUSCAR),
                WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds());

        actor.should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de 'Auditoría de transacciones'"),
                seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo( 1)).because("La cantidad de registros sea 'mayor o igual a 1'"));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                ImprimirExportar.movimientos("imprimir"));
    }

    public static ImprimirAuditoriaTransacciones hoy() {
        return Instrumented.instanceOf(ImprimirAuditoriaTransacciones.class).withProperties();
    }
}
