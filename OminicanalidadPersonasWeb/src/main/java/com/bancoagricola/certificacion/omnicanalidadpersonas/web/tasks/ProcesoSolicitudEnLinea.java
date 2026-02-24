package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.LimpiarCampo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.ProductosDisponibles;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ProductosDisponiblesPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ProcesoSolicitudEnLinea implements Task {
    private List<ProductosDisponibles> datos;

    public ProcesoSolicitudEnLinea(List<ProductosDisponibles> datos) {
        this.datos = datos;
    }

    @Step("{0} 'realiza proceso de solicitud en linea'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        ProductosDisponibles dd = datos.get(0);
        actor.attemptsTo(
                WaitUntil.the(LNK_SOLIC_OP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_SOLIC_OP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_SOLIC_OP),
                WaitUntil.the(TTL_OFERTAS, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CREDICASH, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CREDICASH, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_CREDICASH),
                WaitUntil.the(TTL_SOLC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_SOLC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(COD_PAIS_REGION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(COD_PAIS_REGION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(COD_PAIS_REGION),
                WaitUntil.the(OPC_COD_PAIS_REGION.of(dd.getPais()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_COD_PAIS_REGION.of(dd.getPais()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_COD_PAIS_REGION.of(dd.getPais())),
                LimpiarCampo.elCampo(NUM_TELEF),
                SendKeys.of(dd.getTelefono()).into(NUM_TELEF),
                WaitUntil.the(BTN_CONTINUAR_PD, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PD, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PD),
                WaitUntil.the(VENTANA_CONF, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_PD, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_PD, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_PD));
        WaitUntil.the(PGN_RESULTADO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        /*Comprobante*/
        actor.attemptsTo(
                CapturaComprobanteSolProd.datosC(datos),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /*          */
    }

    public static ProcesoSolicitudEnLinea con(List<ProductosDisponibles> datos) {
        return Instrumented.instanceOf(ProcesoSolicitudEnLinea.class).withProperties(datos);
    }
}