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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.VLD_365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturarComprobanteFavorito implements Task {
    private List<Transferencias> transferencias;
    public CapturarComprobanteFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'valida comprobante'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());


        String monto = t.getMonto();
        String tipoDeCuenta = t.getTipoCuenta();
        String instituciónDestino = t.getBanco();
        String cuentaTransferir = t.getCuentaDestino();
        String tipoDeClienteRecibidor = t.getTipoCliente();
        String nombreDelRecibidor = t.getNombreRecibidor();
        String apellidoDelRecibidor = t.getApellidoRecibidor();
        String correo = t.getCorreo();
        String concepto = t.getConcepto();
        String cuentaOrigen = t.getCuentaOrigen();


        actor.attemptsTo(
                Ensure.that(VLD_365.of("Monto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Monto"),
                Ensure.that(VLD_365.of("Tipo de cuenta").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Tipo de cuenta"),
                Ensure.that(VLD_365.of("Institución destino").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Institución destino"),
                Ensure.that(VLD_365.of("Tipo de cliente recibidor").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Tipo de cliente recibidor"),
                Ensure.that(VLD_365.of("Cuenta a transferir").resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo("Cuenta a transferir"),
                Ensure.that(VLD_365.of("Nombre del recibidor").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Nombre del recibidor"),
                Ensure.that(VLD_365.of("Apellido del recibidor").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Apellido del recibidor"),
                Ensure.that(VLD_365.of("Correo electrónico").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Correo electrónico"),
                Ensure.that(VLD_365.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Concepto"),
                Ensure.that(VLD_365.of("Cuenta").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains("Cuenta")
        );

        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID)),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );
    }

    public static CapturarComprobanteFavorito datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturarComprobanteFavorito.class).withProperties(datosCAP);
    }
}
