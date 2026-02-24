package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteTdcCtaPropia implements Task {
    private List<Transferencias> transferencias;
    public CapturaComprobanteTdcCtaPropia(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Override
    @Step("{0} 'Capturar y validacion el comprobante de tdc a cuenta propia'")
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);

        List comprobante = new ArrayList();
        String tarjetaCredito  = t.getTarjetaCredito();
        String cuentaDestino = t.getCuentaDestino();
        String concepto = t.getConcepto();

        comprobante.add(cuentaDestino);
        comprobante.add(concepto);
        comprobante.add(tarjetaCredito);


        for (int i = 0; i < comprobante.size(); i++) {
            if (LABEL_COMPROBANTE.of(comprobante.get(i).toString()).resolveFor(actor).isVisible()) {
                System.out.println(comprobante.get(i));
                actor.attemptsTo(Click.on(LABEL_COMPROBANTE.of(comprobante.get(i).toString())));
            } else {
                System.out.println("Comprobante capturado con error");
                break;
            }
        }
        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );

    }


    public static CapturaComprobanteTdcCtaPropia datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteTdcCtaPropia.class).withProperties(datosCAP);
    }
}
