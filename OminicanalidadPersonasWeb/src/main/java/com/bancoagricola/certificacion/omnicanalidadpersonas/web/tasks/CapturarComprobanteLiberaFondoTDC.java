package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE3;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.*;

public class CapturarComprobanteLiberaFondoTDC implements Task {
    private String numeroTarjeta;
    public CapturarComprobanteLiberaFondoTDC(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    @Step("{0} 'Capturar y validacion el comprobante de liberacion de fondo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String numeroReserva = actor.recall(REFERENCIA_TICKET_VAR3.toString());
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        actor.attemptsTo(
                Ensure.that(LABEL_COMPROBANTE3.of("1").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numeroReserva),
                Ensure.that(LABEL_COMPROBANTE3.of("2").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numeroTarjeta.substring(0,9)));

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());
    }

    public static CapturarComprobanteLiberaFondoTDC datosC(String datosCAP) {
        return Instrumented.instanceOf(CapturarComprobanteLiberaFondoTDC.class).withProperties(datosCAP);
    }
}
