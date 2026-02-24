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

public class CapturarComprobanteTarjeta365 implements Task {
    private List<Transferencias> transferencias;
    public CapturarComprobanteTarjeta365(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'valida comprobante'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);

        String monto = t.getMonto();
        String instituciónDestino = t.getBanco();
        String cuentaTransferir = t.getCuentaDestino();
        String tipoDeClienteRecibidor = t.getTipoCliente();
        String nombreDelRecibidor = t.getNombreRecibidor();
        String apellidoDelRecibidor = t.getApellidoRecibidor();
        String correo = t.getCorreo();
        String concepto = t.getConcepto();
        String cuentaOrigen = t.getCuentaOrigen();

        actor.attemptsTo(
                Ensure.that(LABEL_COMPROBANTE3.of("7").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(LABEL_COMPROBANTE3.of("1").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(instituciónDestino),
                Ensure.that(LABEL_COMPROBANTE3.of("2").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaTransferir),
                Ensure.that(LABEL_COMPROBANTE3.of("3").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(tipoDeClienteRecibidor),
                Ensure.that(LABEL_COMPROBANTE3.of("4").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nombreDelRecibidor),
                Ensure.that(LABEL_COMPROBANTE3.of("5").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(apellidoDelRecibidor),
                Ensure.that(LABEL_COMPROBANTE3.of("6").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(correo),
                Ensure.that(LABEL_COMPROBANTE3.of("8").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(concepto),
                Ensure.that(LABEL_COMPROBANTE3.of("9").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen)
        );

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );
    }

    public static CapturarComprobanteTarjeta365 datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturarComprobanteTarjeta365.class).withProperties(datosCAP);
    }
}
