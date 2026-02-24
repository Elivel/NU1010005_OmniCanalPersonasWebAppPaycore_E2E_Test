package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_TARJ365;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresarFavoritoPagoTarjetaTransfer365CC implements Task {
    private List<Transferencias> datosTransferencias;

    public IngresarFavoritoPagoTarjetaTransfer365CC(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }

    @Step("{0} 'realiza proceso de pago de tarjeta (con favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                Scroll.to(BTN_REALIZAR_OTRA).andAlignToTop(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_REALIZAR_OTRA));
                LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta Transfer365: Operaciones entre bancos"), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(RESULTADOS.of("Pago de tarjeta Transfer365: Operaciones entre bancos"), isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_FAVORITO_TRANSFERENCIA.of(t.getNombreFavorito())),
                WaitUntil.the(TXT_MONTO_PAGO.of(t.getMonto()), isEnabled()).forNoMoreThan(30).seconds(),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                WaitUntil.the(TXT_CONCEPT2.of(t.getConcepto()), isEnabled()).forNoMoreThan(30).seconds(),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPT2));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(BTN_ACEPTAR_C, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        //new IngresarClaveDinamica(),
        LeerArchivoProperties.esperar(15);
        WaitUntil.the(RESULTADOS_TARJ365, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(datosTransferencias));
        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());

    }

    public static IngresarFavoritoPagoTarjetaTransfer365CC inicio(List<Transferencias> datosTransferencias) {
        return Instrumented.instanceOf(IngresarFavoritoPagoTarjetaTransfer365CC.class).withProperties(datosTransferencias);
    }
}