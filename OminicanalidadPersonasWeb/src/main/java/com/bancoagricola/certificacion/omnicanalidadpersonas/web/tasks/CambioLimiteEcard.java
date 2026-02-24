package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;


import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.LINK_CAMB_LIMITE_ECARD;

public class CambioLimiteEcard implements Task {
    private List<Transferencias>datosEcard;

    public CambioLimiteEcard(List<Transferencias> datosEcard) {
        this.datosEcard = datosEcard;
    }

    public static CambioLimiteEcard inicio(List<Transferencias> datosEcard) {
        return Instrumented.instanceOf(CambioLimiteEcard.class).withProperties(datosEcard);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t=datosEcard.get(0);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(30).seconds(),
                WaitUntil.the(MENU_TARJETAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_TARJETAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_TARJETAS),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isVisible()).forNoMoreThan(400).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito()),isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_CUENTA_TC.of(t.getTarjetaCredito())),
                Scroll.to(LINK_CAMB_LIMITE_ECARD).andAlignToBottom(),
                WaitUntil.the(LINK_CAMB_LIMITE_ECARD, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(LINK_CAMB_LIMITE_ECARD),
                WaitUntil.the(TLL_CAMB_LIMITE_ECARD,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(CMB_ECARD,isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(TARJETA_TITULAR,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LIMITE_TDC_TITULAR,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LIMITE_ACTUAL_ECARD,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(TXT_NUEVO_LIMITE_ECARD,isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(TXT_NUEVO_LIMITE_ECARD,isEnabled()).forNoMoreThan(20).seconds(),
                SendKeys.of(t.getNuevoLimiteEcard()).into(TXT_NUEVO_LIMITE_ECARD),
                WaitUntil.the(BTN_CONTIUAR_ECARD,isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_CONTIUAR_ECARD),
                WaitUntil.the(ACEPTAR_TERMI_CONDI_ECARD,isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ACEPTAR_TERMI_CONDI_ECARD,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ACEPTAR_TERMI_CONDI_ECARD),
                WaitUntil.the(BTN_ACEP_CAMB_LIMITE_ECARD,isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEP_CAMB_LIMITE_ECARD,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEP_CAMB_LIMITE_ECARD)

        );


    }
}
