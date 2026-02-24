package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.TXT_LIBERAR_FONDOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE3;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.CUOTA_MENSUAL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CapturaComprobanteAhorroMeta implements Task {

    private List<Meta> datosMeta;

    public CapturaComprobanteAhorroMeta(List<Meta> datosMeta) {
        this.datosMeta = datosMeta;
    }

    @Step("{0} 'Capturar y validacion el comprobante de Gestion de Meta'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta t = datosMeta.get(0);
        String montoMeta = t.getMontoMeta();
        String nombreMeta = t.getNombreMeta();
        String plazoMeta = t.getPlazoMeta();
        String diaRetencion = t.getDiaRetencion();


        LeerArchivoProperties.esperar(1);

        actor.attemptsTo(
                Ensure.that(MONTO_TOTAL_META.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(montoMeta),
                Ensure.that(CUOTA_META_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(actor.recall(CUOTA_MENSUAL.toString()).toString()),
                Ensure.that(NOMBRE_META2.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nombreMeta),
                Ensure.that(NOMBRE_META2.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(plazoMeta),
                Ensure.that(NOMBRE_META2.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(diaRetencion)

        );
        WaitUntil.the(FECHA_CREACION_META, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        System.out.println("Fecha de creación de meta " + FECHA_CREACION_META.resolveFor(actor).getAttribute(TEXT_CONTENT));

        actor.attemptsTo(

                Ensure.that(LABEL_COMPROBANTE.of(LBL_NUM_COMPROBANTE)).isDisplayed(),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_MONTO_TOTAL)).isDisplayed(),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_CUOTA_MENSUAL)).isDisplayed(),
                Ensure.that(TXT_FONDOS_RETENIDOS.of(LBL_TXT_FONDOS_RETENIDOS)).isDisplayed(),
                Ensure.that(TXT_LIBERAR_FONDOS.of(LBL_TXT_LIBERAR_FONDOS)).isDisplayed()
        );
    }



    public static CapturaComprobanteAhorroMeta datosC(List<Meta> datosMeta) {
        return Instrumented.instanceOf(CapturaComprobanteAhorroMeta.class).withProperties(datosMeta);
    }
}
