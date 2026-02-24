package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class CambioLimiteTarjetaAdicional implements Task {

    private List<Transferencias>datosTDCAd;

    public CambioLimiteTarjetaAdicional(List<Transferencias> datosTDCAd) {
        this.datosTDCAd = datosTDCAd;
    }


    public static CambioLimiteTarjetaAdicional inicio(List<Transferencias> datosTDCAd) {
        return Instrumented.instanceOf(CambioLimiteTarjetaAdicional.class).withProperties(datosTDCAd);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t=datosTDCAd.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito())),
                Scroll.to(LNK_CAMB_LIMT_TDC_ADIC).andAlignToBottom(),
                WaitUntil.the(LNK_CAMB_LIMT_TDC_ADIC, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(LNK_CAMB_LIMT_TDC_ADIC),
                WaitUntil.the(LBL_CAMB_LIMITE_TDC_ADIC,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(TTL_TIPO_TARJETA,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(TLL_NUM_TARJETA,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(TLL_NOMBRE_TARJETA,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(TLL_ESTADO_TARJETA,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LIMIT_CREDITO,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(SALDO_DISPO_TDC,isVisible()).forNoMoreThan(20).seconds(),
                Click.on(SALDO_DISPO_TDC),
                WaitUntil.the(NUM_TDC_PRINC.of(t.getTarjetaCredito()),isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CMB_TARJETA_ADIC,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(TXT_LIMITE_TARJETA_ADIC,isEnabled()).forNoMoreThan(15).seconds(),
                SendKeys.of(t.getNuevoLimiteTarjetaAdicional()).into(TXT_LIMITE_TARJETA_ADIC),
                WaitUntil.the(BTN_CONTIUAR_ECARD,isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CONTIUAR_ECARD),
                WaitUntil.the(BTN_CONFIR_CAMB, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONFIR_CAMB)
        );
    }
}
