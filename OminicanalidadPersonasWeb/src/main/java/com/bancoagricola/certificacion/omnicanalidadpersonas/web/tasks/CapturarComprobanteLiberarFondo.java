package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR3;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.RESERVA_CAP;

public class CapturarComprobanteLiberarFondo implements Task {
    private String cuentaOrigen;
    public CapturarComprobanteLiberarFondo(String cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    @Step("{0} 'Capturar y validacion el comprobante de liberacion de fondo'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        String numeroReserva = actor.recall(REFERENCIA_TICKET_VAR3.toString());
        System.out.println("Numero reserva: "+numeroReserva);

        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Número de reserva").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numeroReserva),
                Ensure.that(VLD_DATA_TRX.of("Cuenta").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen));

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());
    }

    public static CapturarComprobanteLiberarFondo datosC(String cuentaOrigen) {
        return Instrumented.instanceOf(CapturarComprobanteLiberarFondo.class).withProperties(cuentaOrigen);
    }
}
