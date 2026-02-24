package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.VLD_DATA_TRX;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturarComprobantePrestamo365 implements Task {
    private List<Transferencias> transferencias;

    public CapturarComprobantePrestamo365(List<Transferencias> transferencias) {
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
        String cuentaOrigen = t.getCuentaCorta();

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Monto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(monto),
                Ensure.that(VLD_DATA_TRX.of("Institución destino").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(instituciónDestino),
                Ensure.that(VLD_DATA_TRX.of("a abonar").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaTransferir),
                Ensure.that(VLD_DATA_TRX.of("Tipo de cliente recibidor").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(tipoDeClienteRecibidor),
                Ensure.that(VLD_DATA_TRX.of("Nombre del recibidor").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nombreDelRecibidor),
                Ensure.that(VLD_DATA_TRX.of("Apellido del recibidor").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(apellidoDelRecibidor),
                Ensure.that(VLD_DATA_TRX.of("Correo electrónico").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(correo),
                Ensure.that(VLD_DATA_TRX.of("Concepto").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(concepto),
                Ensure.that(VLD_DATA_TRX.of("Cuenta").resolveFor(actor).getAttribute(TEXT_CONTENT).substring(0, 10).trim()).contains(cuentaOrigen)
        );
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Click.on(LABEL_COMPROBANTE.of(LBL_ESTADO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FO)),
                Click.on(LABEL_COMPROBANTE.of(LBL_FA)),
                Click.on(LABEL_COMPROBANTE.of(LBL_ID))
                //Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );
    }

    public static CapturarComprobantePrestamo365 datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturarComprobantePrestamo365.class).withProperties(datosCAP);
    }
}
