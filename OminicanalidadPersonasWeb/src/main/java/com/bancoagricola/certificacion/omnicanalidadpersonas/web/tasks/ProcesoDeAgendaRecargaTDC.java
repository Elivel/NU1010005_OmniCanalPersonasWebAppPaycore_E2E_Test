package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccionaMontoPaqueteSinFav;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccionarCompania;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
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
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ProcesoDeAgendaRecargaTDC implements Task {
    private List<Transferencias> datosTDC;

    public ProcesoDeAgendaRecargaTDC(List<Transferencias> datosTDC) {
        this.datosTDC = datosTDC;
    }

    public static ProcesoDeAgendaRecargaTDC datosT(List<Transferencias> datosTDC) {
        return Instrumented.instanceOf(ProcesoDeAgendaRecargaTDC.class).withProperties(datosTDC);
    }
    @Step("{0} 'realiza proceso de agenda de recarga/compra de paquete de celular'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(TTL_RECARGA_CELULAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_RECARGA_OTRO_NUM, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_RECARGA_OTRO_NUM, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_RECARGA_OTRO_NUM),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                SendKeys.of(datosTDC.get(0).getCelular()).into(TXT_CELULAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(OPC_COMPAÑIA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_COMPAÑIA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_COMPAÑIA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_COMPAÑIA));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                SeleccionarCompania.datosCA(datosTDC.get(0).getCompania()));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(OPC_PAQ_MONTO, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAQ_MONTO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAQ_MONTO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PAQ_MONTO));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                SeleccionaMontoPaqueteSinFav.datosCA(datosTDC.get(0).getMontopaquete()),
                Scroll.to(TXT_CONCEPTO).andAlignToTop(),
                SendKeys.of(datosTDC.get(0).getConcepto()).into(TXT_CONCEPTO),
                Scroll.to(LNK_AGENDADA).andAlignToTop(),
                WaitUntil.the(LNK_AGENDADA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_AGENDADA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_AGENDADA),
                Scroll.to(LNK_UNAFECHAFUTURA).andAlignToTop(),
                WaitUntil.the(LNK_UNAFECHAFUTURA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_UNAFECHAFUTURA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_UNAFECHAFUTURA),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VTN_EMERG_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(TTL_AGENDADA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        LeerArchivoProperties.esperar(1);


    }
}
