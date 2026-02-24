package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_EXTRAF;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagarExtrafinanciciamientoCC implements Task {
    private List<Transferencias> datostransferencias;

    public PagarExtrafinanciciamientoCC(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_CUENTAS),
                WaitUntil.the(VER_MAS_EXTRAFINANCIAMIENTO.of(t.getNumeroPrestamo()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_EXTRAFINANCIAMIENTO.of(t.getNumeroPrestamo()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_EXTRAFINANCIAMIENTO.of(t.getNumeroPrestamo()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_EXTRAFINANCIAMIENTO.of(t.getNumeroPrestamo())),
                WaitUntil.the(TTL_RESUMEN_EXTRAFINANCIAMIENTO, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_PAGAR_EXTRAFINANCIAMIENTO, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(OPCION_PAGAR_EXTRAFINANCIAMIENTO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(OPCION_PAGAR_EXTRAFINANCIAMIENTO),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_DESDE, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_DESDE, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_DESDE),
                WaitUntil.the(SELECCIONA_DESDE.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONA_DESDE.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONA_DESDE.of(t.getCuentaOrigen())),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_PAGO, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(DESPLEGAR_LISTA_TIPO_PAGO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(DESPLEGAR_LISTA_TIPO_PAGO),
                WaitUntil.the(SELECCIONA_TIPO_PAGO.of(t.getTipoCobro()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONA_TIPO_PAGO.of(t.getTipoCobro()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONA_TIPO_PAGO.of(t.getTipoCobro())),
                WaitUntil.the(TXT_MONTO_PAGO, isEnabled()).forNoMoreThan(30).seconds(),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                Scroll.to(BTN_CONTINUAR_PAGAR).andAlignToTop(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
        WaitUntil.the(RESULTADOS_EXTRAF, isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        /*Comprobante*/
        actor.attemptsTo(
                CapturarComprobanteExtrafinanciamiento.datosC(datostransferencias),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_IMPRIMIR)).andAlignToTop());

        /*          */
        actor.attemptsTo(
                IngresoMenuCtaCorrienteOrigenMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());

        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());
    }

    public static PagarExtrafinanciciamientoCC cuentaPropia(List<Transferencias> datostransferencia) {
        return Instrumented.instanceOf(PagarExtrafinanciciamientoCC.class).withProperties(datostransferencia);
    }
}
