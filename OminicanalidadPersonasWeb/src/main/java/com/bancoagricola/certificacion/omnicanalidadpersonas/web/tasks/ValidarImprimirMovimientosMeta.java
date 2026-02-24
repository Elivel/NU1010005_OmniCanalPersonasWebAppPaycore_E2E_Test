package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.CambiarVentana;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.LNK_MOVIMIENTOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.TABLA_MOV_CA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class ValidarImprimirMovimientosMeta implements Task {

    private String nombreMeta;
    private String opcion;

    public ValidarImprimirMovimientosMeta(String nombreMeta, String opcion) {
        this.nombreMeta = nombreMeta;
        this.opcion = opcion;
    }

    @Step("{0} Validar que se generen movimientos")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS),
                Scroll.to(NOMBRE_META.of(nombreMeta)),
                WaitUntil.the(LNK_VER_MAS.of(nombreMeta), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(nombreMeta), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(nombreMeta)),
                WaitUntil.the(TITLE_RES_META, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Scroll.to(LNK_MOVIMIENTOS),
                WaitUntil.the(LNK_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(TABLA_MOV_CA, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(3);
        actor.should(
                seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de movimientos"),
                seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
        actor.attemptsTo(
                Imprimir.datos(),
                CambiarVentana.nueva());
        LeerArchivoProperties.esperar(3);
    }

    public static ValidarImprimirMovimientosMeta deMeta(String nombreMeta, String opcion) {
        return Instrumented.instanceOf(ValidarImprimirMovimientosMeta.class).withProperties(nombreMeta, opcion);
    }
}