package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ValidadorEliminarMeta implements Task {
    private List<Meta> datosmeta;

    public ValidadorEliminarMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Step("{0} 'Valida si existe meta y la elimina'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta em = datosmeta.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isEnabled()).forNoMoreThan(80).seconds());
        if (LNK_VER_MAS.of(em.getNombreMeta()).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    EliminaMeta.datosMet(datosmeta));
        } else {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(80).seconds(),
                    WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(80).seconds());
        }
    }

    public static ValidadorEliminarMeta datosCA(List<Meta> datosDCA) {
        return Instrumented.instanceOf(ValidadorEliminarMeta.class).withProperties(datosDCA);
    }
}