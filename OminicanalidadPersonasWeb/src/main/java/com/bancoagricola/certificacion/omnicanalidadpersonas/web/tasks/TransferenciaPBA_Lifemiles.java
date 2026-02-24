package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasPuntosBA;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.LimpiarCampo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MSG_CONFIRMACION;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class TransferenciaPBA_Lifemiles implements Task {
    private List<Transferencias> datosCAP;

    public TransferenciaPBA_Lifemiles(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} 'realiza proceso de transferencia de puntos BA a Lifemiles'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias cap = datosCAP.get(0);

        actor.attemptsTo(
                IngresoVerMasPuntosBA.inicio(),
                WaitUntil.the(TRANSF_PAL, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TRANSF_PAL, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(TRANSF_PAL),
                WaitUntil.the(STTL_SELTAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TOC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_TOC, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_TOC),
                WaitUntil.the(LNK_CARGPLAN, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CARGPLAN, isClickable()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_CUENTA, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_CUENTA, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SEL_CUENTA),
                WaitUntil.the(CUENTA.of(cap.getCuentaCorta()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(CUENTA.of(cap.getCuentaCorta()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(CUENTA.of(cap.getCuentaCorta())),
                SendKeys.of(cap.getPrimerNombre()).into(PRIM_NOM),
                SendKeys.of(cap.getSegundoNombre()).into(SEGUN_NOM),
                SendKeys.of(cap.getPrimerApellido()).into(PRIM_APE),
                SendKeys.of(cap.getSegundoApellido()).into(SEGUN_APE),
                SendKeys.of(cap.getNumeroLifemiles()).into(LIFEMILES_NUM),
                SendKeys.of(cap.getPuntos()).into(PUNTOS_TRANF),
                WaitUntil.the(SEL_CODPAIS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SEL_CODPAIS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SEL_CODPAIS),
                WaitUntil.the(OPC_PAIS.of(cap.getCodigoPais()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAIS.of(cap.getCodigoPais()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PAIS.of(cap.getCodigoPais())),
                LimpiarCampo.elCampo(NUM_TELEF),
                SendKeys.of(cap.getNumeroTelefono()).into(NUM_TELEF),
                Scroll.to(BTN_CONTINUAR).andAlignToTop());
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VTN_EMERG_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP));
        WaitUntil.the(MSG_CONFIRMACION, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: "+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
        actor.attemptsTo(
                ValidaTicketTransferenciaPuntosBALifemiles.datosCorrectos(datosCAP));

    }

    public static TransferenciaPBA_Lifemiles datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(TransferenciaPBA_Lifemiles.class).withProperties(datosCAP);
    }
}