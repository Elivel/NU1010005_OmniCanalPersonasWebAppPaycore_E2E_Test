package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteCtaPropia implements Task {
    private List<Transferencias> transferencias;

    public CapturaComprobanteCtaPropia(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'Capturar y validacion el comprobante de transferencia a cta propia'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        List comprobante = new ArrayList();
        String cuentaOrigen = t.getCuentaCorta();
        String cuentaDestino = t.getCuentaDestino();
        String concepto = t.getConcepto();
        String monto = t.getMonto();

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto total debitado").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Cuenta crédito").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaDestino),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(concepto),
                Ensure.that(VLD_DATA_TRX.of("Desde").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen)
        );

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );

    }


    public static CapturaComprobanteCtaPropia datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteCtaPropia.class).withProperties(datosCAP);
    }
}
