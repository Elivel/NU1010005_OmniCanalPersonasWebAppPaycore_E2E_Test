package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.LimpiarCampo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.REFERENCIA_TICKET;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static junit.framework.TestCase.assertEquals;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ModificaMeta implements Task {

    private static final Logger LOGGER = Logger.getLogger(ModificaMeta.class.getName());
    private final List<Meta> datosmeta;

    public ModificaMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta meta = datosmeta.get(0);

        double montoMetaMod = Double.parseDouble(meta.getMontoMeta());
        actor.attemptsTo(
                WaitUntil.the(LNK_VER_MAS.of(meta.getNombreMeta()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(meta.getNombreMeta()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(meta.getNombreMeta())),
                WaitUntil.the(TITLE_RES_META, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TITLE_RES_META, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        /*validar monto acumulado*/
        String montoAcumu = LBL_MONTOACU.resolveFor(actor).getAttribute("innerText");
        actor.attemptsTo(
                Ensure.that(montoAcumu).isEqualTo("0.00"));

        actor.attemptsTo(
                WaitUntil.the(LNK_MODIFICAR_M, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MODIFICAR_M, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MODIFICAR_M),
                WaitUntil.the(TITLE_MOD_META, isVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                LimpiarCampo.elCampo(TXT_MONTO_META),
                SendKeys.of(meta.getMontoMeta()).into(TXT_MONTO_META),
                Clear.field(TXT_PLAZO_DE_META),
                SendKeys.of(meta.getPlazoMeta()).into(TXT_PLAZO_DE_META),
                WaitUntil.the(DPD_DIA_RETENCION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DPD_DIA_RETENCION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DPD_DIA_RETENCION));
        //Seleccionar dia de retencion
        int seleccionar = 0;
        for (WebElementFacade producto : DPD_DIA_RETENCION4.resolveAllFor(theActorInTheSpotlight())) {
            if (producto.getText().contains(meta.getDiaRetencion())) {
                producto.click();
                seleccionar = 1;
                break;
            }
        }
        assertEquals("No se muestra el dia: " + meta.getDiaRetencion(), 1, seleccionar);
        actor.attemptsTo(
                Scroll.to(BTN_MODIFICAR));
        LeerArchivoProperties.esperar(4);
        actor.attemptsTo(
                WaitUntil.the(BTN_MODIFICAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_MODIFICAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_MODIFICAR),
                WaitUntil.the(BTN_ACEPTAR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(LBL_META_MODIFICADA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        String logMessage = "Referencia: ".concat(actor.recall(REFERENCIA_TICKET_VAR.toString()));
        LOGGER.log(Level.INFO, logMessage);

        /*Capturar comprobante*/
        actor.attemptsTo(
                CapturaComprobanteModificarMeta.datosC(datosmeta),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        actor.attemptsTo(
                Scroll.to(LBL_IDTRANSACCION).andAlignToTop(),
                WaitUntil.the(LBL_IDTRANSACCION, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(BTN_FINALIZAR),
                WaitUntil.the(BTN_FINALIZAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_FINALIZAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_FINALIZAR),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(NOMBRE_META.of(meta.getNombreMeta())),
                WaitUntil.the(NOMBRE_META.of(meta.getNombreMeta()), isVisible()).forNoMoreThan(60).seconds());

        String metaDespues0 = LBL_MONTO.resolveFor(theActorInTheSpotlight()).getAttribute("innerText");
        double metaDespues = Double.parseDouble(metaDespues0);
        Ensure.that(montoMetaMod).isEqualTo(metaDespues);
    }

    public static ModificaMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(ModificaMeta.class).withProperties(datosmeta);
    }
}