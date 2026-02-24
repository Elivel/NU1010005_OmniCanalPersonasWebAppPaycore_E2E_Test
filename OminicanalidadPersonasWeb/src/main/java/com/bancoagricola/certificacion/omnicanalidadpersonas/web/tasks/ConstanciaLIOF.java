package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.actions.selectactions.SelectByValueFromBy;
import net.serenitybdd.screenplay.actions.selectactions.SelectByValueFromElement;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.PDF_ESTADO_CUENTA;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConstanciaLIOF implements Task {
    List<Servicios> datosECL;

    public ConstanciaLIOF(List<Servicios> datosECL) {
        this.datosECL = datosECL;
    }

    @Step("{0} 'Emisión Constancia de LIOF'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Servicios ECL = datosECL.get(0);
        String año = ECL.getAño();
        String mes = ECL.getMes();

        actor.attemptsTo(
                Click.on(SELECTOR_AÑO),
                Click.on(AÑO_SELECT.of(año)),
                Click.on(SELECTOR_MES),
                Click.on(MES_SELECT.of(mes)),
                Click.on(BTN_EMITIR),
                WaitUntil.the(PDF_ESTADO_CUENTA, isClickable()).forNoMoreThan(60).seconds(),
                Ensure.that(PDF_ESTADO_CUENTA).isDisplayed(),
                Scroll.to(BTN_IMPRIMIR).andAlignToTop(),
                WaitUntil.the(BTN_IMPRIMIR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_IMPRIMIR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_IMPRIMIR)
                );


    }

    public static ConstanciaLIOF datosECL(List<Servicios> datosECL) {
        return Instrumented.instanceOf(ConstanciaLIOF.class).withProperties(datosECL);
    }
}
