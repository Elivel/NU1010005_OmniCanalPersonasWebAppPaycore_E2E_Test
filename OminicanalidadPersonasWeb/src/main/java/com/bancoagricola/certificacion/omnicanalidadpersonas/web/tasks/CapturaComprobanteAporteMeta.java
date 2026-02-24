package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;

public class CapturaComprobanteAporteMeta implements Task {

    private List<Meta> datosMeta;

    public CapturaComprobanteAporteMeta(List<Meta> datosMeta) {
        this.datosMeta = datosMeta;
    }

    @Step("{0} 'Capturar y validacion el comprobante de Gestion de Meta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta t = datosMeta.get(0);

        String aporteMeta = t.getAporteRetiroMeta();
        String nombreMeta = t.getNombreMeta();
        String montoMeta = t.getMontoMeta();

        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom());

        actor.attemptsTo(
                //Ensure.that(VLD_DATA_TRX.of("Monto a guardar").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(aporteMeta),
                Ensure.that(VLD_DATA_TRX.of("Nombre").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nombreMeta),
                Ensure.that(VLD_DATA_TRX.of("Monto meta").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(montoMeta)

        );

        actor.attemptsTo(
                Scroll.to(LABEL_COMPROBANTE.of(LBL_ESTADO)).andAlignToBottom(),
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


    public static CapturaComprobanteAporteMeta datosC(List<Meta> datosMeta) {
        return Instrumented.instanceOf(CapturaComprobanteAporteMeta.class).withProperties(datosMeta);
    }
}
