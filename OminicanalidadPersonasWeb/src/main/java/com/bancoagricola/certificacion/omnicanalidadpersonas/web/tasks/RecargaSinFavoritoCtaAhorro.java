package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RecargaSinFavoritoCtaAhorro implements Task {
    private List<Transferencias> datosDCA;

    public RecargaSinFavoritoCtaAhorro(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Realiza recarga/compra de paquete de celular'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                ValidadorEliminarFavoritos.datosCA(datosDCA),
                IngresoVerMasCtaAhorro.inicio(datosDCA),
                WaitUntil.the(LNK_RECARGA_CEL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_RECARGA_CEL, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_RECARGA_CEL),
                WaitUntil.the(TTL_RECARGA_CELULAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_RECARGA_OTRO_NUM, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_RECARGA_OTRO_NUM, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_RECARGA_OTRO_NUM),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                SendKeys.of(datosDCA.get(0).getCelular()).into(TXT_CELULAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(OPC_COMPAÑIA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_COMPAÑIA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_COMPAÑIA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_COMPAÑIA));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                SeleccionarCompania.datosCA(datosDCA.get(0).getCompania()));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(OPC_PAQ_MONTO, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAQ_MONTO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAQ_MONTO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PAQ_MONTO));
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                SeleccionaMontoPaqueteSinFav.datosCA(datosDCA.get(0).getMontopaquete()),
                Scroll.to(TXT_CONCEPTO).andAlignToTop(),
                SendKeys.of(datosDCA.get(0).getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VTN_EMERG_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(RESULTADOS_RECARGA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: "+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
        actor.attemptsTo(
                AgregaFavorito.datosCA(datosDCA.get(0).getNombreFavorito()),
                ValidaTicketRecargasCA.datosCorrectos(datosDCA));
    }

    public static RecargaSinFavoritoCtaAhorro datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(RecargaSinFavoritoCtaAhorro.class).withProperties(datosDCA);
    }
}