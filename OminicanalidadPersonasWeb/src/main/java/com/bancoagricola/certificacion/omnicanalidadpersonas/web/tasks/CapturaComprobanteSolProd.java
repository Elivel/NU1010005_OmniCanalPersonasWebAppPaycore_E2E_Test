package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.ProductosDisponibles;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteSolProd implements Task {

    private List<ProductosDisponibles> datos;
    public CapturaComprobanteSolProd(List<ProductosDisponibles> datos) {
        this.datos = datos;
    }
    @Step("{0} 'Capturar y validacion el comprobante de solicitud de producto'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        ProductosDisponibles dd = datos.get(0);
        String pais  = dd.getPais();
        String telefono = dd.getTelefono();

        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Código de país/región").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(pais),
                Ensure.that(VLD_DATA_TRX.of("Número telefónico").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(telefono)
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


    public static CapturaComprobanteSolProd datosC(List<ProductosDisponibles> datosCAP) {
        return Instrumented.instanceOf(CapturaComprobanteSolProd.class).withProperties(datosCAP);
    }
}
