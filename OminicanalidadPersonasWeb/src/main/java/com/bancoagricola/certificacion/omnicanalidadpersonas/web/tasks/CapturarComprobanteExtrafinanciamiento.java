package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturarComprobanteExtrafinanciamiento implements Task {
    private List<Transferencias> transferencias;
    public CapturarComprobanteExtrafinanciamiento(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }
    @Step("{0} 'Capturar y validacion el comprobante de extrafinanciamiento'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        String monto = t.getMonto();
        String numeroPrestamo = t.getNumeroPrestamo();
        String concepto = t.getConcepto();
        String cuentaOrigen = t.getCuentaOrigen();

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto a pagar").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Extrafinanciamiento").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numeroPrestamo),
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

    public static CapturarComprobanteExtrafinanciamiento datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturarComprobanteExtrafinanciamiento.class).withProperties(datosCAP);
    }
}
