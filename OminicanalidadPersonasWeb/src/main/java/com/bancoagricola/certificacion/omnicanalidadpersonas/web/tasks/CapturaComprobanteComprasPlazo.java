package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE3;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteComprasPlazo implements Task {

    private List<Transferencias> transferencias;
    public CapturaComprobanteComprasPlazo(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }
    @Step("{0} 'captura y valida el comprobante de Compras a plazo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        String cuentaOrigen  = t.getCuentaOrigen();
        String tarjeta = t.getTarjetaCredito();
        String monto = t.getMonto();
        String concepto = t.getConcepto();


        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        actor.attemptsTo(
                Scroll.to(LABEL_COMPROBANTE3.of("6")).andAlignToBottom(),
                Ensure.that(LABEL_COMPROBANTE3.of("5").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(LABEL_COMPROBANTE3.of("2").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(tarjeta),
                Ensure.that(LABEL_COMPROBANTE3.of("6").resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(concepto),
                Ensure.that(LABEL_COMPROBANTE3.of("7").resolveFor(actor).getAttribute(TEXT_CONTENT).substring(0,9)).contains(cuentaOrigen.substring(0,9))
        );

        actor.attemptsTo(
                Ensure.that(LABEL_COMPROBANTE.of(LBL_ESTADO)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(LBL_FO)),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_FO)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(LBL_FA)),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_FA)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(LBL_ID)),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_ID)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );

    }


    public static CapturaComprobanteComprasPlazo datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteComprasPlazo.class).withProperties(datosCAP);
    }
}
