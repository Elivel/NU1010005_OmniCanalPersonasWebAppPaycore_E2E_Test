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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferenciaTransfer365SinFavorito implements Task {
    private List<Transferencias> transferencias;

    public TransferenciaTransfer365SinFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza proceso de transferencia (sin favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(
                WaitUntil.the(LINK_TRANSFERENCIAS_TRANSFER365, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_TRANSFERENCIAS_TRANSFER365, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_TRANSFERENCIAS_TRANSFER365),
                WaitUntil.the(RESULTADOS.of("Transferencias Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_OTRA_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_OTRA_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_TRANSFERIR_OTRA_CUENTA),
                WaitUntil.the(TTL_SOLIC_TRANSF_365, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TIPO_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TIPO_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TIPO_CUENTA),
                WaitUntil.the(SELECCIONAR_TIPO_CUENTA.of(t.getTipoCuenta()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_CUENTA.of(t.getTipoCuenta()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_TIPO_CUENTA.of(t.getTipoCuenta())),
                WaitUntil.the(DESPLEGAR_LISTA_BANCO_INSTITUCIONES, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_BANCO_INSTITUCIONES, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_BANCO_INSTITUCIONES),
                Click.on(SELECCIONAR_BANCO.of(t.getBanco())),
                SendKeys.of(t.getCuentaDestino()).into(TXT_NUMERO_CUENTA),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_CLIENTE, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_CLIENTE, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_TIPO_CLIENTE),
                Click.on(SELECCIONAR_TIPO_CLIENTE.of(t.getTipoCliente())),
                SendKeys.of(t.getNombreRecibidor()).into(TXT_NOMBRE),
                SendKeys.of(t.getApellidoRecibidor()).into(TXT_APELLIDO),
                SendKeys.of(t.getCorreo()).into(TXT_CORREO),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_TRANSFER1, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_TRANSFER1, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_TRANSFER1),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
                //new IngresarClaveDinamica(),
        WaitUntil.the(RESULTADOS_TRANSF365, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /* Captura comprobante */
        actor.attemptsTo(
                CapturarComprobante.datosC(transferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());
        /* *****************   */

        actor.attemptsTo(
                AgregaFavorito.datosCA(t.getNombreFavorito()));
    }

    public static TransferenciaTransfer365SinFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(TransferenciaTransfer365SinFavorito.class).withProperties(transferencias);
    }
}
