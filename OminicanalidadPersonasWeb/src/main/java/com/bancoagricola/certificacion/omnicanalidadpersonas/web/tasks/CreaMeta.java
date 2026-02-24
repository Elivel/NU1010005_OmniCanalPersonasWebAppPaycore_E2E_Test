package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.CUOTA_MENSUAL;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static junit.framework.TestCase.assertTrue;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CreaMeta implements Task {

    private static final Logger LOGGER = Logger.getLogger(CreaMeta.class.getName());

    private final List<Meta> datosMeta;

    public CreaMeta(List<Meta> datosMeta) {
        this.datosMeta = datosMeta;
    }
    @Step("{0} Realiza el proceso de creación de meta")
    @Override
    public <T extends Actor> void performAs(T actor) {


        Meta meta = datosMeta.get(0);
        String montoMeta = meta.getMontoMeta();
        String nombreMeta = meta.getNombreMeta();
        String plazoMeta = meta.getPlazoMeta();

        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_AHORROS));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isEnabled()).forNoMoreThan(80).seconds(),
                Scroll.to(BTN_ANADE_META),
                WaitUntil.the(BTN_ANADE_META, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ANADE_META, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ANADE_META),
                WaitUntil.the(BTN_CONTINUAR_META,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_META),
                WaitUntil.the(LBL_CREA_TU_META, isVisible()).forNoMoreThan(60).seconds(),
                SendKeys.of(meta.getNombreMeta()).into(TXT_NOMBRE_META),
                SendKeys.of(meta.getMontoMeta()).into(TXT_MONTO_META),
                SendKeys.of(meta.getPlazoMeta()).into(TXT_PLAZO_DE_META));

        actor.attemptsTo(
                WaitUntil.the(DPD_DIA_RETENCION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DPD_DIA_RETENCION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DPD_DIA_RETENCION));

        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(Scroll.to(COUTA_MENSUAL_FORM).andAlignToTop());
        actor.remember(CUOTA_MENSUAL.toString(), COUTA_MENSUAL_FORM.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(1).trim());
        String logMessage = "Couta mensual calculada ".concat(actor.recall(CUOTA_MENSUAL.toString()));
        LOGGER.log(Level.INFO, logMessage);

        //Seleccionar dia de retencion
        int seleccionar = 0;
        for (WebElementFacade producto : DPD_DIA_RETENCION2.resolveAllFor(theActorInTheSpotlight())) {
            if (producto.getText().contains(meta.getDiaRetencion())) {
                producto.click();
                seleccionar = 1;
                break;
            }
        }
        assertTrue("No se muestra el dia: " + meta.getDiaRetencion(),seleccionar==1);
        actor.attemptsTo(
                Scroll.to(DPD_CUENTA_A_RELACIONAR),
                WaitUntil.the(DPD_CUENTA_A_RELACIONAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DPD_CUENTA_A_RELACIONAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DPD_CUENTA_A_RELACIONAR));
        //Seleccionar cuenta
        int seleccionar2 = 0;
        for (WebElementFacade producto : DPD_CUENTA_A_RELACIONAR2.resolveAllFor(theActorInTheSpotlight())) {
            if (producto.getText().contains(meta.getCuentaARelacionar())) {
                producto.click();
                seleccionar2 = 1;
                break;
            }
        }
        assertTrue("No se muestra la cuenta: " + meta.getCuentaARelacionar(), seleccionar2 == 1);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(BTN_CREAR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CREAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CREAR, isClickable()).forNoMoreThan(30).seconds());
                Click.on(BTN_CREAR).performAs(actor);
        actor.attemptsTo(
                WaitUntil.the(DETALLE_MSG_CONFIRMACION,isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DETALLE_MSG_CONFIRMACION,isEnabled()).forNoMoreThan(30).seconds(),
                Ensure.that(DETALLE_MSG_CONFIRMACION.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nombreMeta),
                Ensure.that(DETALLE_MSG_CONFIRMACION.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(montoMeta),
                Ensure.that(DETALLE_MSG_CONFIRMACION.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(plazoMeta),
                WaitUntil.the(BTN_ACEPTAR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(LBL_META_CREADA, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), NUM_COMPROBANTE.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(16).trim());
        LOGGER.log(Level.INFO, "Referencia ticket meta: {0}", String.valueOf(actor.recall(REFERENCIA_TICKET_VAR.toString())));

        /*Capturar comprobante*/
        actor.attemptsTo(
                CapturaComprobanteAhorroMeta.datosC(datosMeta)
        );


        actor.attemptsTo(

                Scroll.to(BTN_FINALIZAR_META),
                WaitUntil.the(BTN_FINALIZAR_META, isEnabled()).forNoMoreThan(20).seconds(),
                WaitUntil.the(BTN_FINALIZAR_META, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BTN_FINALIZAR_META),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isEnabled()).forNoMoreThan(20).seconds());
    }

    public static CreaMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(CreaMeta.class).withProperties(datosmeta);
    }
}