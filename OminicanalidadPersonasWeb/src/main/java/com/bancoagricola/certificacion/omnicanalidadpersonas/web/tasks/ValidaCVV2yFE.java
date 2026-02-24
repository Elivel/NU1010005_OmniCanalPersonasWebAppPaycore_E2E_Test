package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaCVV2yFE implements Task {
    private List<Transferencias> datosDCA;

    public ValidaCVV2yFE(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} valida 'Consulta CVV2 y fecha de expiración'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosDCA.get(0);
        actor.attemptsTo(
                Scroll.to(OPERACIONES).andAlignToTop());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(OPC_CVV2_FE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_CVV2_FE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_CVV2_FE),
                WaitUntil.the(TTL_CVV2_FE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_CVV2_FE, isVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(TARJ_TIT_ECARD).isDisplayed(),
                Ensure.that(TARJ_ECARD).isDisplayed(),
                Ensure.that(CVV2_ECARD).isDisplayed(),
                Ensure.that(FV_ECARD).isDisplayed(),
                Ensure.that(ESTADO_ECARD).isDisplayed());
    }

    public static ValidaCVV2yFE datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(ValidaCVV2yFE.class).withProperties(datosDCA);
    }
}