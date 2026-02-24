package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BOTON_ACEPTAR_PP;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Limites.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class ActualizaLimitesPorDefecto implements Task {
    private List<Transferencias> datosCAP;
    public ActualizaLimitesPorDefecto(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} actualiza los valores de 'Límite acumulable semanal' y 'Límite por transacción' por defecto")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosCAP.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LIMITES, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LIMITES, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LIMITES),
                WaitUntil.the(TTL_LIMITES, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Clear.field(LIMACUMSEM_BM),
                SendKeys.of(ca.getLimiteSem()).into(LIMACUMSEM_BM),
                Clear.field(LIMPORTRX_BM),
                SendKeys.of(ca.getLimitePorTRX()).into(LIMPORTRX_BM),
                Scroll.to(LIMACUMSEM_EBP).andAlignToTop(),
                Clear.field(LIMACUMSEM_EBP),
                SendKeys.of(ca.getLimiteSem()).into(LIMACUMSEM_EBP),
                Clear.field(LIMPORTRX_EBP),
                SendKeys.of(ca.getLimitePorTRX()).into(LIMPORTRX_EBP),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BOTON_ACEPTAR_PP),
                WaitUntil.the(CONF_LIM_EXIT, isEnabled()).forNoMoreThan(20).seconds(),
                Ensure.that(CONF_LIM_EXIT).isDisplayed());
    }

    public static ActualizaLimitesPorDefecto datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ActualizaLimitesPorDefecto.class).withProperties(datosCAP);
    }
}

