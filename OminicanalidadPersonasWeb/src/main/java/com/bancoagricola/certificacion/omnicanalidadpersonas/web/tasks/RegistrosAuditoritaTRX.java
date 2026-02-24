package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class RegistrosAuditoritaTRX implements Task {
    private List<Transferencias> datosAud;

    public RegistrosAuditoritaTRX(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }

    @Step("{0} 'valida registros en auditoria de transacciones'")
    @Override
    public <T extends Actor> void performAs(T actor) {
              actor.attemptsTo(
                IngresoMenuServicios.inicio(),
                WaitUntil.the(AUDITORIATRX, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(AUDITORIATRX, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(AUDITORIATRX),
                WaitUntil.the(TTL_AUDITORIATRX, isEnabled()).forNoMoreThan(30).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
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
                WaitUntil.the(TABLA_MOV_CA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TABLA_MOV_CA, isEnabled()).forNoMoreThan(60).seconds());
        actor.should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de 'Auditoría de transacciones'"));
        actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea 'mayor o igual a 1'"));
        actor.attemptsTo(ConsultaRegistroAuditoriaTRX.datosAud(datosAud));
    }

    public static RegistrosAuditoritaTRX datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(RegistrosAuditoritaTRX.class).withProperties(datosAud);
    }
}