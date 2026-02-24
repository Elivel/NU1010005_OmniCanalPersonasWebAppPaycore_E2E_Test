package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuServicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccionarEnCalendarioFechaNV;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class NotifViajeros1Tarj implements Task {
    private List<Transferencias> datosCAP;
    public NotifViajeros1Tarj(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} realiza proceso de registro para una tarjeta")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);

        actor.attemptsTo(
                IngresoMenuServicios.inicio(),
                WaitUntil.the(NOTIF_VIAJEROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(NOTIF_VIAJEROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(NOTIF_VIAJEROS),
                WaitUntil.the(SUBTTL_SELECC_TARJ, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SUBTTL_SELECC_TARJ, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_TARJ_VIAJEROS.of(cap.getTarjetaCredito()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_TARJ_VIAJEROS.of(cap.getTarjetaCredito()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECC_TARJ_VIAJEROS.of(cap.getTarjetaCredito())),
                Scroll.to(BTN_CONTINUAR),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(SUBTTL_TARJETAS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SUBTTL_TARJETAS, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                SeleccionarEnCalendarioFechaNV.laFecha(datosCAP),
                SendKeys.of(cap.getPaisDestino()).into(PAISES_DESTINO),
                SendKeys.of(cap.getComentarios()).into(COMENTARIOS),
                Scroll.to(BTN_CONTINUAR),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(VENT_EMERG_NV, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VENT_EMERG_NV, isEnabled()).forNoMoreThan(60).seconds(),
                Ensure.that(VENT_EMERG_NV).isDisplayed(),
                WaitUntil.the(BTN_ACEPTAR2, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR2, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR2));
    }

    public static NotifViajeros1Tarj datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(NotifViajeros1Tarj.class).withProperties(datosCAP);
    }
}