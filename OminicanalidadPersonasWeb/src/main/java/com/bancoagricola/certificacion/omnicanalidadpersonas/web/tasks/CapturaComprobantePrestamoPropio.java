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

public class CapturaComprobantePrestamoPropio implements Task {
    private List<Transferencias> transferencias;

    public CapturaComprobantePrestamoPropio(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'Capturar y validacion el comprobante de Prestamo propio'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        List comprobante = new ArrayList();
        String cuentaOrigen = t.getCuentaCorta();
        String numeroPrestamo = t.getNumeroPrestamo();
        String monto = t.getMonto();
        String concepto = t.getConcepto();


        comprobante.add(cuentaOrigen);
        comprobante.add(numeroPrestamo);
        comprobante.add(monto);
        comprobante.add(concepto);

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto del pago").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Préstamo").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numeroPrestamo),
                Scroll.to(VLD_DATA_TRX.of("Fecha de último pago")),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(concepto),
                Scroll.to(VLD_DATA_TRX.of("Cuenta débito")),
                Ensure.that(VLD_DATA_TRX.of("Cuenta débito").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen)
                //Scroll.to(VLD_DATA_TRX.of("Fecha de ordenanza"))
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


    public static CapturaComprobantePrestamoPropio datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobantePrestamoPropio.class).withProperties(datosCAP);
    }
}
