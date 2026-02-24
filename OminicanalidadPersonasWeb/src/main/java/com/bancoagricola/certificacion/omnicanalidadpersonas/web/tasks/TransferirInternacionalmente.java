package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.TransferenciaInternacional;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_TRANSFINT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.SolicitudTransferenciaPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferirInternacionalmente implements Task {

    private List<TransferenciaInternacional> datos;

    public TransferirInternacionalmente(List<TransferenciaInternacional> datos) {
        this.datos = datos;
    }

    @Step("{0} 'realiza proceso para transferencia internacional, con plantilla'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LNK_CARGAR_P, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(LNK_CARGAR_P, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(LNK_CARGAR_P),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C),
                WaitUntil.the(BTN_ACEPTAR_C, isNotVisible()).forNoMoreThan(30).seconds());
        actor.attemptsTo(
                Scroll.to(BTN_CONTINUAR_PAGAR2).andAlignToTop(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR2, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR2, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR2));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
        //new IngresarClaveDinamica(),
        WaitUntil.the(RESULTADOS_TRANSFINT, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
        actor.attemptsTo(
                ValidaTicketTransferenciaInternacional.datosCorrectos(datos),
                EliminarPlantilla.para(datos));
    }

    public static TransferirInternacionalmente usandoPlantilla(List<TransferenciaInternacional> datos) {
        return Instrumented.instanceOf(TransferirInternacionalmente.class).withProperties(datos);
    }
}
