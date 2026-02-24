package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.VER_MAS_CUENTA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCION_MENU;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_OTROS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.CUENTAS;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class FondosReservadosAporteMeta implements Task {
    private List<Meta> datosmeta;

    public FondosReservadosAporteMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Step("{0} 'Ver Fondos Reservados'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta t = datosmeta.get(0);
        String cuentaARelacionar  = t.getCuentaARelacionar();
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of(CUENTAS), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of(CUENTAS)),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaARelacionar()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA.of(t.getCuentaARelacionar()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA.of(t.getCuentaARelacionar())),
                WaitUntil.the(LABEL_COMPROBANTE.of(BOTON_OTROS), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LABEL_COMPROBANTE.of(BOTON_OTROS), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LABEL_COMPROBANTE.of(BOTON_OTROS))
        );
        System.out.println("Referencia: " + actor.recall(VariablesSesion.REFERENCIA.toString()));
        actor.attemptsTo(
        //Ensure.that(TABLA_FR.resolveFor(actor).getAttribute("textContent").substring(0,3)).contains("Meta")
                Click.on(TABLA_PG),
                Ensure.that(TABLA_PG.resolveFor(actor).getAttribute("textContent")).isEqualTo(actor.recall(VariablesSesion.REFERENCIA.toString()))
                       );
    }
    public static FondosReservadosAporteMeta datosFR(List<Transferencias> datosFR) {
        return Instrumented.instanceOf(FondosReservadosAporteMeta.class).withProperties(datosFR);
    }
}
