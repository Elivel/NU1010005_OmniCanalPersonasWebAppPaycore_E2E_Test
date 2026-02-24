package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
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

public class CapturarComprobanteReservaFondoTDC implements Task {
    private List<Transferencias> transferencias;
    public CapturarComprobanteReservaFondoTDC(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'Capturar y validacion el comprobante de reserva de fondo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        String monto = t.getMonto();
        String vigencia = t.getVigencia();
        String concepto = t.getConcepto();
        String tarjetaCredito = t.getTarjetaCredito();


        actor.attemptsTo(
                Ensure.that(LABEL_COMPROBANTE3.of("2").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(LABEL_COMPROBANTE3.of("3").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(vigencia),
                Ensure.that(LABEL_COMPROBANTE3.of("4").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(concepto),
                //Click.on(LABEL_COMPROBANTE3.of("5")),
                Ensure.that(LABEL_COMPROBANTE3.of("1").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(tarjetaCredito));

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());
    }

    public static CapturarComprobanteReservaFondoTDC datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturarComprobanteReservaFondoTDC.class).withProperties(datosCAP);
    }
}
