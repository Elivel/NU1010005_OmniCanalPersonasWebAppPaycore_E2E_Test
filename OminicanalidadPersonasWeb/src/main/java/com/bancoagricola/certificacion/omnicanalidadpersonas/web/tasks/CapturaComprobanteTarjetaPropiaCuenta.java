package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteTarjetaPropiaCuenta implements Task {

    private List<Transferencias> transferencias;
    public CapturaComprobanteTarjetaPropiaCuenta(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }
    @Step("{0} 'captura y valida el comprobante de tarjeta a cuenta propia'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        List comprobante = new ArrayList();
        String cuentaOrigen  = t.getCuentaOrigen();
        String tarjeta = t.getTarjetaCredito();
        String monto = t.getMonto();
        String concepto = t.getConcepto();

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(LABEL_COMPROBANTE_NUN_TDC.of("1").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(tarjeta),
                //Scroll.to(VLD_DATA_TRX.of("Concepto")),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(concepto),
                //Scroll.to(VLD_DATA_TRX.of("5")),
                Ensure.that(VLD_DATA_TRX.of("Desde").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen)
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


    public static CapturaComprobanteTarjetaPropiaCuenta datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteTarjetaPropiaCuenta.class).withProperties(datosCAP);
    }
}
