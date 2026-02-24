package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.REFERENCIA_TRX;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PAGO_TARJETA_ENTRE_BANCOS_EXITOSA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagoTarjetaUNIsinFavorito implements Task {
    private List<Transferencias> transferencias;

    public PagoTarjetaUNIsinFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza proceso pago de tarjeta UNI'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);
        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(transferencias),
                WaitUntil.the(LINK_PAGO_TARJETA_UNI, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_TARJETA_UNI, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_TARJETA_UNI),
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta UNI: Operaciones entre bancos"), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_PAGAR_OTRA_TARJETA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_PAGAR_OTRA_TARJETA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_PAGAR_OTRA_TARJETA),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isClickable()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_BANCOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_BANCOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DESPLEGAR_LISTA_BANCOS),
                WaitUntil.the(SELECCIONAR_BANCO.of(t.getBanco()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_BANCO.of(t.getBanco()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_BANCO.of(t.getBanco())),
                SendKeys.of(t.getTarjetaOtroBanco()).into(TXT_NUMERO_CUENTA),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_DOC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_DOC, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DESPLEGAR_LISTA_TIPO_DOC),
                WaitUntil.the(SELECCIONAR_TIPO_DOC.of(t.getTipoIdentificacion()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_DOC.of(t.getTipoIdentificacion()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_TIPO_DOC.of(t.getTipoIdentificacion())),
                SendKeys.of(t.getNumeroIdentificacion()).into(TXT_NUMERO_DOCUMENTO),
                SendKeys.of(t.getNombreRecibidor()).into(TXT_NOMBRE),
                SendKeys.of(t.getCorreo()).into(TXT_CORREO),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_DESCRIPCION),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C),
                //new IngresarClaveDinamica(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(RESULTADOS.of(PAGO_TARJETA_ENTRE_BANCOS_EXITOSA), isVisible()).forNoMoreThan(60).seconds());
        actor.remember(VariablesSesion.REFERENCIA.toString(), REFERENCIA_TRX.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(13, 20).trim());
        System.out.println("Referencia: " + actor.recall(VariablesSesion.REFERENCIA.toString()));
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(30).seconds());
    }

    public static PagoTarjetaUNIsinFavorito con(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(PagoTarjetaUNIsinFavorito.class).withProperties(transferencias);
    }
}
