package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ImprimirExportar implements Task {
    private String opcion;

    public ImprimirExportar(String opcion) {
        this.opcion = opcion;
    }

    @Step("{0} 'realiza proceso de imprimir/exportar'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        if (opcion.equals("imprimir")) {
            actor.attemptsTo(
                    Scroll.to(LINK_IMPRIMIR).andAlignToBottom(),
                    WaitUntil.the(LINK_IMPRIMIR, isVisible()).forNoMoreThan(20).seconds(),
                    WaitUntil.the(LINK_IMPRIMIR, isEnabled()).forNoMoreThan(20).seconds(),
                    WaitUntil.the(LINK_IMPRIMIR, isClickable()).forNoMoreThan(20).seconds(),
                    Click.on(LINK_IMPRIMIR));
            LeerArchivoProperties.esperar(2);
        } else {
            if (LNK_MOVIMIENTOS.resolveFor(actor).isVisible()) {
                actor.attemptsTo(
                        Scroll.to(LINK_EXPORTAR).andAlignToBottom(),
                        WaitUntil.the(LINK_EXPORTAR, isVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(LINK_EXPORTAR, isClickable()).forNoMoreThan(20).seconds(),
                        Click.on(LINK_EXPORTAR),
                        WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds());
            } else {
                actor.attemptsTo(
                        WaitUntil.the(LINK_EXPORTAR, isVisible()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds(),
                        WaitUntil.the(LINK_EXPORTAR, isClickable()).forNoMoreThan(20).seconds(),
                        Click.on(LINK_EXPORTAR),
                        WaitUntil.the(LINK_EXPORTAR, isEnabled()).forNoMoreThan(20).seconds());
            }
        }
    }

    public static ImprimirExportar movimientos(String opcion) {
        return Instrumented.instanceOf(ImprimirExportar.class).withProperties(opcion);

    }
}
