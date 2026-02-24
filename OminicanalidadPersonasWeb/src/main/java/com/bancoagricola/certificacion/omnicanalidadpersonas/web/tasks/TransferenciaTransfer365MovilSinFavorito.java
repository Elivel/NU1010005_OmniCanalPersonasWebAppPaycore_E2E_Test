package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.AgregaFavorito;
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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferenciaTransfer365MovilSinFavorito implements Task {
    private List<Transferencias> transferencias;

    public TransferenciaTransfer365MovilSinFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza proceso de transferencia (sin favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(
                WaitUntil.the(LINK_TRANSFERENCIAS_TRANSFER365_MOVIL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_TRANSFERENCIAS_TRANSFER365_MOVIL, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_TRANSFERENCIAS_TRANSFER365_MOVIL),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_MOVIL, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_MOVIL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_NUMERO_CELULAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_NUMERO_CELULAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_TRANSFERIR_NUMERO_CELULAR),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_MOVIL, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_MOVIL, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LISTA_INSTITUCION_DESTINO, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LISTA_INSTITUCION_DESTINO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LISTA_INSTITUCION_DESTINO),
                WaitUntil.the(SELECCIONAR_INSTITUCION_DESTINO.of(t.getBanco()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_INSTITUCION_DESTINO.of(t.getBanco()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_TIPO_CUENTA.of(t.getBanco())),
                SendKeys.of(t.getCelular()).into(CELULAR_T365M),
                SendKeys.of(t.getNombreRecibidor()).into(NOMBRE_RECIBIDOR_T365M),
                SendKeys.of(t.getMonto()).into(MONTO_T365M),
                SendKeys.of(t.getCorreo()).into(EMAIL_T365M),
                SendKeys.of(t.getConcepto()).into(CONCEPTO_T365M),
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
        WaitUntil.the(CONFIRMACION_T365M, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.attemptsTo(
                AgregaFavorito.datosCA(t.getNombreFavorito()),
                ValidaTicketTransfer365Movil.datosCorrectos(transferencias));
    }

    public static TransferenciaTransfer365MovilSinFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(TransferenciaTransfer365MovilSinFavorito.class).withProperties(transferencias);
    }
}
