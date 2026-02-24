package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientosBasico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_SOLC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_PAGOES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class LiberarFondoCuenta implements Task {
    private List<Transferencias> informacion;

    public LiberarFondoCuenta(List<Transferencias> informacion) {
        this.informacion = informacion;
    }

    @Step("{0} 'realiza proceso para liberar fondos'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(LINK_PAGOES, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_PAGOES, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_PAGOES, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(LINK_PAGOES),
                WaitUntil.the(RESULTADOS.of("P@GOES"), isVisible()).forNoMoreThan(10).seconds(),
                WaitUntil.the(RESULTADOS.of("P@GOES"), isEnabled()).forNoMoreThan(10).seconds());

        LeerArchivoProperties.esperar(3);
        String numeroReserva = actor.recall(REFERENCIA_TICKET_VAR2.toString());
        System.out.println("Numero reserva: " + numeroReserva);
        actor.attemptsTo(
                WaitUntil.the(RESERVA.of(numeroReserva), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESERVA.of(numeroReserva), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(RESERVA.of(numeroReserva)),
                WaitUntil.the(RESULTADOS.of("Liberarás los fondos reservados"), isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(RESULTADOS.of("Liberarás los fondos reservados"), isEnabled()).forNoMoreThan(5).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(10).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(10).seconds(),
                Click.on(BTN_ACEPTAR_C));
        WaitUntil.the(RESULTADOS_SOLC, isVisible()).forNoMoreThan(90).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR3.toString(), RESERVA_CA2.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(1).trim());
        System.out.println("Número de reserva: " + actor.recall(REFERENCIA_TICKET_VAR3.toString()).toString());

        /* Comprobante */
        actor.attemptsTo(
                CapturarComprobanteLiberarFondo.datosC(informacion.get(0).getCuentaCorta()),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* ----------- */

    }

    public static LiberarFondoCuenta pagoes(List<Transferencias> informacion) {
        return Instrumented.instanceOf(LiberarFondoCuenta.class).withProperties(informacion);
    }
}
