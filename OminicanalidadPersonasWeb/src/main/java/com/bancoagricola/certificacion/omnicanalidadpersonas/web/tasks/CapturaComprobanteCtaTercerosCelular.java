package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CapturaComprobanteCtaTercerosCelular implements Task {
    private List<Transferencias> transferencias;

    public CapturaComprobanteCtaTercerosCelular(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'Capturar y validacion el comprobante de transferencia a cta terceros'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        //actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        String celular = t.getCelular();
        String cuentaOrigen = t.getCuentaCorta();
        String concepto = t.getConcepto();
        String monto = t.getMonto();
        String correo = t.getCorreo();


        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto total debitado").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Celular").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(celular),
                Ensure.that(VLD_DATA_TRX.of("Correo electrónico").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(correo),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(concepto),
                Ensure.that(VLD_DATA_TRX.of("Cuenta débito").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen)
        );

        actor.attemptsTo(
                Scroll.to(LABEL_COMPROBANTE2.of("Concepto")).andAlignToTop());

        WaitUntil.the(LABEL_COMPROBANTE2.of(LBL_IMPUEST0), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        WaitUntil.the(LABEL_COMPROBANTE.of(LBL_ESTADO), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        WaitUntil.the(LABEL_COMPROBANTE.of(LBL_FO), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        WaitUntil.the(LABEL_COMPROBANTE.of(LBL_FA), isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        WaitUntil.the(LABEL_COMPROBANTE.of(LBL_ID), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.attemptsTo(
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );

    }


    public static CapturaComprobanteCtaTercerosCelular datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteCtaTercerosCelular.class).withProperties(datosCAP);
    }
}
