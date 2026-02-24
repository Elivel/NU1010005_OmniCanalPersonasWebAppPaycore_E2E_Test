package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.AgregaFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_ACEPTAR_C;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_PRES365;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.SELECCIONAR_CUENTA_ORIGEN1;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagarUsandoTransfer365SinFavorito implements Task {

    private List<Transferencias> transferencias;

    public PagarUsandoTransfer365SinFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza proceso de pago de préstamo'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isClickable()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_BANCOS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_BANCOS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_BANCOS),
                WaitUntil.the(SELECCIONAR_BANCO.of(t.getBanco()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_BANCO.of(t.getBanco()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_BANCO.of(t.getBanco())),
                SendKeys.of(t.getCuentaDestino()).into(TXT_NUMERO_CUENTA),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_CLIENTE2, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_CLIENTE2, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_TIPO_CLIENTE2),
                WaitUntil.the(SELECCIONAR_TIPO_CLIENTE.of(t.getTipoCliente()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_CLIENTE.of(t.getTipoCliente()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_TIPO_CLIENTE.of(t.getTipoCliente())),
                SendKeys.of(t.getNombreRecibidor()).into(TXT_NOMBRE),
                SendKeys.of(t.getApellidoRecibidor()).into(TXT_APELLIDO),
                SendKeys.of(t.getCorreo()).into(TXT_CORREO),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
        //new IngresarClaveDinamica(),
        WaitUntil.the(RESULTADOS_PRES365, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.attemptsTo(
                AgregaFavorito.datosCA(t.getNombreFavorito()));
        /* Capturar comprobante */
        actor.attemptsTo(
               // CapturarComprobantePrestamo365.datosC(transferencias));
        /* -------------------- */
        );
    }

    public static PagarUsandoTransfer365SinFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(PagarUsandoTransfer365SinFavorito.class).withProperties(transferencias);
    }
}
