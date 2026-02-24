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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferenciaUniFavorito implements Task {
    private List<Transferencias> transferencias;

    public TransferenciaUniFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza proceso de transferencia UNI (con favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Scroll.to(BTN_REALIZAR_OTRA).andAlignToTop(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_REALIZAR_OTRA),
                WaitUntil.the(RESULTADOS.of("Transferencias UNI: Operaciones entre bancos"), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RESULTADOS.of("Transferencias UNI: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito())));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(TTL_SOLIC_TRANSF_UNI, isVisible()).forNoMoreThan(30).seconds(),
                Scroll.to(TXT_CONCEPTO),
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
    }

    public static TransferenciaUniFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(TransferenciaUniFavorito.class).withProperties(transferencias);
    }
}
