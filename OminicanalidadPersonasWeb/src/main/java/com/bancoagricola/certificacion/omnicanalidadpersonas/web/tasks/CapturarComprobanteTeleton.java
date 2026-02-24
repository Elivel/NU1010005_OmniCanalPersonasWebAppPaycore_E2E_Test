package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.VLD_DATA_TRX;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturarComprobanteTeleton implements Task {

    private String cuenta;
    private String monto;

    public CapturarComprobanteTeleton(String cuenta,String monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());


        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto total debitado").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Cuenta a abonar").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("5002100000"),
                Ensure.that(VLD_DATA_TRX.of("Nombre del destinatario").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("ASOCIACION TELETON PRO REHABIL ITACION FUNTER"),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(AYUDA_TELETON),
                Ensure.that(VLD_DATA_TRX.of("Cuenta a cargar").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuenta)
        );

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );
    }

    public static CapturarComprobanteTeleton datosC(String cuenta,String monto) {
        return Instrumented.instanceOf(CapturarComprobanteTeleton.class).withProperties(cuenta,monto);
    }
}
