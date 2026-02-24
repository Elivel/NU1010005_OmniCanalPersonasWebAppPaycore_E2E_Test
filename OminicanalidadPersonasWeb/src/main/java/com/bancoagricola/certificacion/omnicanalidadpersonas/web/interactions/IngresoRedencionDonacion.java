package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.LINK_REDENCION_DONACION;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.OBTENER_CASHBAC;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngresoRedencionDonacion implements Interaction {
    @Step("{0} 'ingresa a la opción 'Redención y donación de CashBac''")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(LINK_REDENCION_DONACION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_REDENCION_DONACION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_REDENCION_DONACION),
                WaitUntil.the(OBTENER_CASHBAC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OBTENER_CASHBAC, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar2();
    }
    public static IngresoRedencionDonacion nuevo() {
        return Instrumented.instanceOf(IngresoRedencionDonacion.class).withProperties();
    }
}
