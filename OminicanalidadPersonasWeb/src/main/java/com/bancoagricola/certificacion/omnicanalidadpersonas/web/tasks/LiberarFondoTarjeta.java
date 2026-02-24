package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias;
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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_SOLC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_PAGOES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.TTL_PAGOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.*;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class LiberarFondoTarjeta implements Task {
    private String numeroTarjeta;

    public LiberarFondoTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Step("{0} 'realiza proceso de liberación de fondos'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(numeroTarjeta), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(numeroTarjeta), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(numeroTarjeta), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(numeroTarjeta)),
                WaitUntil.the(TTL_RESUMEN_TC, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(TTL_PAGOS).andAlignToTop(),
                WaitUntil.the(LINK_PAGOES, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(LINK_PAGOES, isEnabled()).forNoMoreThan(5).seconds(),
                WaitUntil.the(LINK_PAGOES, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LINK_PAGOES),
                WaitUntil.the(RESULTADOS.of("P@GOES"), isEnabled()).forNoMoreThan(5).seconds());
        String numeroReserva = actor.recall(REFERENCIA_TICKET_VAR2.toString());
        System.out.println("Número de reserva: " + numeroReserva);
        actor.attemptsTo(
                Scroll.to(RESERVA1).andAlignToTop(),
                WaitUntil.the(RESERVA.of(numeroReserva), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESERVA.of(numeroReserva), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(RESERVA.of(numeroReserva)),
                WaitUntil.the(RESULTADOS.of("Liberarás los fondos reservados"), isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BTN_ACEPTAR_C));
        WaitUntil.the(RESULTADOS_SOLC, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR3.toString(), RESERVA_CA2.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(1).trim());
        System.out.println("Número de reserva: " + actor.recall(REFERENCIA_TICKET_VAR3.toString()).toString());

        /* Comprobante */
        actor.attemptsTo(
                CapturarComprobanteLiberaFondoTDC.datosC(numeroTarjeta),
                Scroll.to(BTN_FINALIZAR2).andAlignToTop(),
                Click.on(BTN_FINALIZAR2));
        /* ---------- */
        LeerArchivoProperties.esperar(3);

        actor.attemptsTo(
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(numeroTarjeta), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(numeroTarjeta), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(numeroTarjeta)),
                Scroll.to(LNK_MOVIMIENTOS).andAlignToTop(),
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS),
                WaitUntil.the(TTL_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds());

        actor.remember(VariablesSesion.MONTO_FINAL_TC.toString(), DISPONIBILIDAD_TARJETA.resolveFor(theActorInTheSpotlight()).getText());
        double montoFinalTarjeta = Double.parseDouble(theActorInTheSpotlight().recall(MONTO_FINAL_TC.toString()).toString().replace(",", "").replace("$", "").trim());
        System.out.println("Disponible tarjeta al liberar fondo: " + montoFinalTarjeta);
        Ensure.that(montoFinalTarjeta).isEqualTo(CalculosTranferencias.obtenerMontoTarjetaAlInicio());
    }

    public static LiberarFondoTarjeta pagoes(String numeroTarjeta) {
        return Instrumented.instanceOf(LiberarFondoTarjeta.class).withProperties(numeroTarjeta);
    }
}
