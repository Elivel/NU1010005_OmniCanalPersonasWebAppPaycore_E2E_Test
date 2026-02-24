package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.TTL_TRANSFERENCIAS_TRANSFER365_CA_RD;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.TTL_TRANSFERENCIAS_TRANSFER365_MOVIL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransferenciaTransfer365SIPAConFavorito implements Task {

    private List<Transferencias> transferencias;

    public TransferenciaTransfer365SIPAConFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }


    public static TransferenciaTransfer365SIPAConFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(TransferenciaTransfer365SIPAConFavorito.class).withProperties(transferencias);

    }
    @Step("{0} 'realiza proceso de transferencia (con favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(


                Scroll.to(BTN_REALIZAR_OTRA).andAlignToTop(),
                WaitUntil.the(BTN_REALIZAR_OTRA,isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA,isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_REALIZAR_OTRA),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito())),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                SendKeys.of(t.getMonto()).into(MONTO_T365_CA_RD),
                SendKeys.of(t.getDescripcion()).into(DESCRIPCION_T365_CA_RD),
                Scroll.to(BTN_TRANSFERIR_T365M).andAlignToTop(),
                WaitUntil.the(BTN_TRANSFERIR_T365M, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_TRANSFERIR_T365M, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_TRANSFERIR_T365M),
                WaitUntil.the(VTN_EMERG_PP, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(VTN_EMERG_PP, isClickable()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_T365M, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_T365M, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_T365M));
        LeerArchivoProperties.esperar(15);
        WaitUntil.the(CONFIRMACION_T365_SIPA, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.attemptsTo(
                ValidaTicketTransfer365SIPA.datosCorrectos(transferencias));
    }
}
