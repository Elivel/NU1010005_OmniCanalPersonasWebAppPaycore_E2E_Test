package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteSolChequera implements Task {

    private List<Transferencias> transferencias;
    public CapturaComprobanteSolChequera(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }
    @Step("{0} 'Capturar y validacion el comprobante de Solicitud de chequera'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        String tipoChequera  = t.getTipoChequera();
        String cuentaOrigen = t.getCuentaOrigen();
        String cantidadCheques = t.getCantidadCheques();
        String departamentoEntrega = t.getDepartamentoEntrega();
        String agenciaEntrega = t.getAgenciaEntrega();


        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Tipo de chequera").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(tipoChequera),
                Ensure.that(VLD_DATA_TRX.of("Cantidad de cheques").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cantidadCheques),
                Ensure.that(VLD_DATA_TRX.of("Departamento").resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(departamentoEntrega),
                Ensure.that(VLD_DATA_TRX.of("Agencia").resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(agenciaEntrega),
                Ensure.that(VLD_DATA_TRX.of("Cuenta").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(cuentaOrigen.substring(0,9))
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


    public static CapturaComprobanteSolChequera datosC(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteSolChequera.class).withProperties(datosCAP);
    }
}
