package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasCtaAhorro;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OBTENER_SALDO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class PagarTarjetaUniFavorito implements Task {
    private List<Transferencias> transferencias;

    public PagarTarjetaUniFavorito(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza pago tarjeta UNI (con favorito)'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = transferencias.get(0);

        actor.attemptsTo(
                IngresoVerMasCtaAhorro.inicio(transferencias),
                WaitUntil.the(LINK_PAGO_TARJETA_UNI, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LINK_PAGO_TARJETA_UNI, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LINK_PAGO_TARJETA_UNI),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getNombreFavorito()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCIONES_TRANSFERIR_CTA_DES.of(t.getNombreFavorito()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCIONES_TRANSFERIR_CTA_DES.of(t.getNombreFavorito())),
                WaitUntil.the(TTL_PAGO_TARJ_UNI,isVisible()).forNoMoreThan(30).seconds(),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_DESCRIPCION),
                Scroll.to(BTN_CONTINUAR_PAGAR).andAlignToTop(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR),
                WaitUntil.the(BTN_ACEPTAR_C, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C),
                //new IngresarClaveDinamica(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds());
                WaitUntil.the(RESULTADOS.of(PAGO_TARJETA_ENTRE_BANCOS_EXITOSA), isVisible()).forNoMoreThan(60).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: " + actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

      /*  actor.attemptsTo(
                IngresoMenuCtaAhorroOrigenMovimientos.inicio(transferencias),
                ValidaReferenciaTicketCAFondosReservados.conLaReferencia());

        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());*/
    }

    public static PagarTarjetaUniFavorito datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(PagarTarjetaUniFavorito.class).withProperties(transferencias);
    }
}
