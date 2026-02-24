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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TransferenciaTransfer365CARDSinFavorito implements Task {
    private List<Transferencias> transferencias;

    public TransferenciaTransfer365CARDSinFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    public static TransferenciaTransfer365CARDSinFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(TransferenciaTransfer365CARDSinFavorito.class).withProperties(transferencias);
    }
    @Step("{0} 'realiza proceso de transferencia (con favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        LeerArchivoProperties.esperar(4);

        actor.attemptsTo(
                WaitUntil.the(LINK_TRANSFERENCIA_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_TRANSFERENCIA_TRANSFER365_CA_RD, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_TRANSFERENCIA_TRANSFER365_CA_RD),
               // WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isVisible()).forNoMoreThan(30).seconds(),
                //WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_OTRA_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_OTRA_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_TRANSFERIR_OTRA_CUENTA),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TTL_TRANSFERENCIAS_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LISTA_TIPO_PAGO_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LISTA_TIPO_PAGO_TRANSFER365_CA_RD, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LISTA_TIPO_PAGO_TRANSFER365_CA_RD),
                WaitUntil.the(SELECCIONAR_TIPO_PAGO_TRANSFER365_CA_RD.of(t.getTipoDePago()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_PAGO_TRANSFER365_CA_RD.of(t.getTipoDePago()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_TIPO_CUENTA.of(t.getTipoDePago())),
                SendKeys.of(t.getMonto()).into(MONTO_T365_CA_RD),
                SendKeys.of(t.getDescripcion()).into(DESCRIPCION_T365_CA_RD),
                WaitUntil.the(LISTA_PAIS_BANCO_BENEF_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LISTA_PAIS_BANCO_BENEF_TRANSFER365_CA_RD, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LISTA_PAIS_BANCO_BENEF_TRANSFER365_CA_RD),
                WaitUntil.the(SELECCIONAR_PAIS_BANCO_BENEF_TRANSFER365_CA_RD.of(t.getPaisBancoBeneficiario()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_PAIS_BANCO_BENEF_TRANSFER365_CA_RD.of(t.getPaisBancoBeneficiario()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_PAIS_BANCO_BENEF_TRANSFER365_CA_RD.of(t.getPaisBancoBeneficiario()))
        );
        LeerArchivoProperties.esperar(5);
        actor.attemptsTo(
                WaitUntil.the(LISTA_BANCO_BENEF_TRANSFER365_CA_RD, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LISTA_BANCO_BENEF_TRANSFER365_CA_RD, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LISTA_BANCO_BENEF_TRANSFER365_CA_RD),
                WaitUntil.the(SELECCIONAR_BANCO_BENEF_TRANSFER365_CA_RD.of(t.getBancoBeneficiario()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_BANCO_BENEF_TRANSFER365_CA_RD.of(t.getBancoBeneficiario()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_BANCO_BENEF_TRANSFER365_CA_RD.of(t.getBancoBeneficiario())),
                SendKeys.of(t.getNumeroCuentaIban()).into(CUENTA_IBAN_T365_CA_RD),
                SendKeys.of(t.getNombreBeneficiario()).into(NOMBRE_BENEF_T365_CA_RD),
                SendKeys.of(t.getNumeroDocumentoBeneficiario()).into(DOCUMENTO_BENEF_T365_CA_RD),
                SendKeys.of(t.getCiudad()).into(CIUDAD_BENEF_T365_CA_RD),
                SendKeys.of(t.getDireccion()).into(DIRECCION_BENEF_T365_CA_RD),
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
                AgregaFavorito.datosCA(t.getNombreFavorito()),
                ValidaTicketTransfer365SIPA.datosCorrectos(transferencias));
    }
    }



