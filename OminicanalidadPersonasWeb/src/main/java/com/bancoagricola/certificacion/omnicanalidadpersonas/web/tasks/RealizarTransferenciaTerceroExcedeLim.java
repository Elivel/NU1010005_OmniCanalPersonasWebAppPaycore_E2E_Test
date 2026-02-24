package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCIONES_TRANSFERENCIAS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Limites.MSG_EX_LM_TRX;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizarTransferenciaTerceroExcedeLim implements Task {

    private List<Transferencias> datosCAP;

    public RealizarTransferenciaTerceroExcedeLim(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} 'realiza proceso de transferencia'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosCAP.get(0);

        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(datosCAP),
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERENCIAS.of(TRANSFERIR)),
                WaitUntil.the(BTN_TRANSF_TERC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TRANSF_TERC, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TRANSF_TERC),
                WaitUntil.the(TTL_TRANSF_TERC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_TRANSF_TERC, isEnabled()).forNoMoreThan(60).seconds(),
                SendKeys.of(ca.getCuentaTercero()).into(TXT_CUENTA_TERCERO),
                SendKeys.of(ca.getCorreo()).into(TXT_CORREO),
                Scroll.to(TXT_MONTO_TERCERO).andAlignToTop(),
                SendKeys.of(ca.getMonto()).into(TXT_MONTO_TERCERO),
                SendKeys.of(ca.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(BOTON_ACEPTAR_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP)
                //new IngresarClaveDinamica(),
        );
    }

    public static RealizarTransferenciaTerceroExcedeLim con(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(RealizarTransferenciaTerceroExcedeLim.class).withProperties(datosCAP);
    }
}
