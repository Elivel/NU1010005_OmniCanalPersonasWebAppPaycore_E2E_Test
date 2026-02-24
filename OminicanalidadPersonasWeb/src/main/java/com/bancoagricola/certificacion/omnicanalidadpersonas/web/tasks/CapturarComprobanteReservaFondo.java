package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturarComprobanteReservaFondo implements Task {
    private List<Transferencias> transferencias;
    public CapturarComprobanteReservaFondo(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        String monto = t.getMonto();
        String vigencia = t.getVigencia();
        String concepto = t.getConcepto();
        String cuentaOrigen = t.getCuentaCorta();


        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Vigencia en días hábiles").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(vigencia),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(concepto),
                Click.on(VLD_DATA_TRX.of("Número de reserva")),
                Ensure.that(VLD_DATA_TRX.of("Desde").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen));

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());
    }

    public static CapturarComprobanteReservaFondo datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturarComprobanteReservaFondo.class).withProperties(datosCAP);
    }
}
