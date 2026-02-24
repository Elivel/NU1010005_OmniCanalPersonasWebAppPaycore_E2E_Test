package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
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
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_FAV;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagarPrestamoUNIConFavorito implements Task {
    private List<Transferencias> datosCAP;

    public PagarPrestamoUNIConFavorito(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} 'realiza pago préstamo UNI (con favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);

        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                Scroll.to(BTN_OTRO_PAGO).andAlignToTop(),
                WaitUntil.the(BTN_OTRO_PAGO, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_OTRO_PAGO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_OTRO_PAGO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_OTRO_PAGO),
                WaitUntil.the(SUB_PA_PREST_UNI, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR_OTRO_PRESTAMO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR_OTRO_PRESTAMO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONA_FAV_PRESTAMO.of(cap.getNombreFavorito())));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(60).seconds(),
                SendKeys.of(cap.getMonto()).into(TXT_MONTO_PR),
                SendKeys.of(cap.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP));
        //new IngresarClaveDinamica(),
        WaitUntil.the(PAGO_PENDIENTE_APL, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.remember(REFERENCIA_FAV.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia fav: " + actor.recall(REFERENCIA_FAV.toString()).toString());

    }

    public static PagarPrestamoUNIConFavorito datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(PagarPrestamoUNIConFavorito.class).withProperties(datosCAP);
    }
}
