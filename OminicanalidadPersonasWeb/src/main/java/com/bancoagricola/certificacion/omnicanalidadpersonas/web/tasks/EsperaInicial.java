package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.PRODUCTOS_PP;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EsperaInicial implements Task {

    @Step("{0} 'espera que carguen los productos'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Task.where(actor+" 'valida que los productos se muestren'", WaitUntil.the(PRODUCTOS_PP, isVisible()).forNoMoreThan(60).seconds()).performAs(actor);
        Task.where(actor+" 'valida que los productos esten habilitados'", WaitUntil.the(PRODUCTOS_PP, isEnabled()).forNoMoreThan(60).seconds()).performAs(actor);
    }

    public static EsperaInicial inicio() {
        return Instrumented.instanceOf(EsperaInicial.class).withProperties();
    }
}
