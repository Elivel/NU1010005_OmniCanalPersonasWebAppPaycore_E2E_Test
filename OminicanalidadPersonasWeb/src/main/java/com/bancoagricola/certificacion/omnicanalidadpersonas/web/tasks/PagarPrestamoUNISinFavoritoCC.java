package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.AgregaFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaCorriente;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagarPrestamoUNISinFavoritoCC implements Task {
    private List<Transferencias> datosCAP;

    public PagarPrestamoUNISinFavoritoCC(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} 'realiza pago préstamo UNI (sin favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);
        actor.attemptsTo(
                ValidadorEliminarFavoritos.datosCA(datosCAP),
                IngresoVerMasCtaCorriente.inicio(datosCAP.get(0).getCuentaOrigen()));
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(LINK_PAGO_PRESTAMO_UNI, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_PRESTAMO_UNI, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_PRESTAMO_UNI),
                WaitUntil.the(SUB_PA_PREST_UNI, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR_OTRO_PRESTAMO, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_PAGAR_OTRO_PRESTAMO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_PAGAR_OTRO_PRESTAMO),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar2();
        actor.attemptsTo(
                WaitUntil.the(DESPLEGAR_LISTA_BANCOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_BANCOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DESPLEGAR_LISTA_BANCOS),
                WaitUntil.the(SELECCIONAR_BANCO.of(cap.getBanco()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_BANCO.of(cap.getBanco()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_BANCO.of(cap.getBanco())),
                SendKeys.of(cap.getNumeroPrestamo()).into(TXT_PRESTAMO_A_ABONAR),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_DOC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_DOC, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(DESPLEGAR_LISTA_TIPO_DOC),
                WaitUntil.the(SELECCIONAR_TIPO_DOC.of(cap.getTipoIdentificacion()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_DOC.of(cap.getTipoIdentificacion()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_TIPO_DOC.of(cap.getTipoIdentificacion())),
                SendKeys.of(cap.getNumeroIdentificacion()).into(TXT_NUMERO_DOCUMENTO),
                SendKeys.of(cap.getNombreRecibidor()).into(TXT_NOMBRE),
                SendKeys.of(cap.getCorreo()).into(TXT_CORREO),
                SendKeys.of(cap.getMonto()).into(TXT_MONTO_PR),
                SendKeys.of(cap.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP),
                //new IngresarClaveDinamica(),
                WaitUntil.the(PAGO_PENDIENTE_APL, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(PAGO_PENDIENTE_APL).isDisplayed());
        actor.attemptsTo(
                AgregaFavorito.datosCA(cap.getNombreFavorito()));
        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
        actor.attemptsTo(
                ValidaTicketPagoPrestamosUNI.datosCorrectos(datosCAP));

    }

    public static PagarPrestamoUNISinFavoritoCC datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(PagarPrestamoUNISinFavoritoCC.class).withProperties(datosCAP);
    }
}
