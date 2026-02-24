package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminarSolictudEnvio implements Task {

    private List<Transferencias> tarjeta;
    public EliminarSolictudEnvio(List<Transferencias> tarjeta) {
        this.tarjeta = tarjeta;
    }

    @Step("{0} 'ingresa al menú y realiza la eliminación de envio de estado de cuenta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = tarjeta.get(0);
        actor.attemptsTo(
                WaitUntil.the(RESULTADOS.of("Realizar otra solicitud"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RESULTADOS.of("Realizar otra solicitud"), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(RESULTADOS.of("Realizar otra solicitud")),
                WaitUntil.the(SELECCIONAR_TARJETA_ENVIO.of(ca.getTarjetaCreditoLista()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_TARJETA_ENVIO.of(ca.getTarjetaCreditoLista()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_TARJETA_ENVIO.of(ca.getTarjetaCreditoLista())),
                Scroll.to(ACEPTO_TERMINOS_CONDICIONES),
                WaitUntil.the(ACEPTO_TERMINOS_CONDICIONES, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACEPTO_TERMINOS_CONDICIONES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACEPTO_TERMINOS_CONDICIONES),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        WaitUntil.the(RESULTADO1, isVisible()).forNoMoreThan(45).seconds().performAs(theActorInTheSpotlight());
        WaitUntil.the(NOPERACION, isVisible()).forNoMoreThan(45).seconds().performAs(theActorInTheSpotlight());
        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
    }

    public static EliminarSolictudEnvio tarjeta(List<Transferencias> tarjeta) {
        return Instrumented.instanceOf(EliminarSolictudEnvio.class).withProperties(tarjeta);
    }
}
