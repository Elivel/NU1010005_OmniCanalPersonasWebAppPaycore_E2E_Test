package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.AgregaFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferenciaUniNuevo implements Task {

    private List<Transferencias> transferencias;

    public TransferenciaUniNuevo(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza proceso de transferencia UNI (sin favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(
                ValidadorEliminarFavoritos.datosCA(transferencias),
                IngresoVerMasCtaAhorro.inicio(transferencias),
                WaitUntil.the(LINK_TRANSFERENCIAS_UNI, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_TRANSFERENCIAS_UNI, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_TRANSFERENCIAS_UNI),
                WaitUntil.the(RESULTADOS.of("Transferencias UNI: Operaciones entre bancos"), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RESULTADOS.of("Transferencias UNI: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_OTRA_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BOTON_TRANSFERIR_OTRA_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BOTON_TRANSFERIR_OTRA_CUENTA),
                WaitUntil.the(TTL_SOLIC_TRANSF_UNI, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TIPO_CUENTA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(TIPO_CUENTA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TIPO_CUENTA),
                Click.on(SELECCIONAR_TIPO_CUENTA.of(t.getTipoCuenta())),
                Click.on(DESPLEGAR_LISTA_BANCO_INSTITUCIONES),
                Click.on(SELECCIONAR_BANCO.of(t.getBanco())),
                SendKeys.of(t.getCuentaDestino()).into(TXT_NUMERO_CUENTA),
                Click.on(DESPLEGAR_LISTA_TIPO_DOC_UNI),
                Click.on(SELECCIONAR_TIPO_DOC.of(t.getTipoIdentificacion())),
                SendKeys.of(t.getNumeroIdentificacion()).into(TXT_NUMERO_DOCUMENTO),
                SendKeys.of(t.getNombreRecibidor()).into(TXT_NOMBRE),
                SendKeys.of(t.getCorreo()).into(TXT_CORREO),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
        WaitUntil.the(RESULTADOS.of(TRANSFERENCIA_ENTRE_BANCOS_EXITOSA), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: "+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        actor.attemptsTo(
                AgregaFavorito.datosCA(t.getNombreFavorito()));
    }

    public static TransferenciaUniNuevo datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(TransferenciaUniNuevo.class).withProperties(transferencias);
    }
}
