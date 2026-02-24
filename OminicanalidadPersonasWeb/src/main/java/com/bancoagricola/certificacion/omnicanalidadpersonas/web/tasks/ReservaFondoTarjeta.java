package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.LABEL_COMPROBANTE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_SOLC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.LINK_PAGOES;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TransferenciasLinksPage.TTL_PAGOS;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.BOTON_IMPRIMIR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR2;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ReservaFondoTarjeta implements Task {
    private List<Transferencias> informacion;

    public ReservaFondoTarjeta(List<Transferencias> informacion) {
        this.informacion = informacion;
    }

    @Step("{0} 'realiza proceso para reserva de fondos'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(TTL_PAGOS).andAlignToTop(),
                WaitUntil.the(LINK_PAGOES, isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(LINK_PAGOES, isClickable()).forNoMoreThan(5).seconds(),
                Click.on(LINK_PAGOES),
                WaitUntil.the(RESULTADOS.of("P@GOES"), isEnabled()).forNoMoreThan(5).seconds(),
                Scroll.to(BTN_NUEVA_RESERVA).andAlignToTop(),
                WaitUntil.the(BTN_NUEVA_RESERVA, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_NUEVA_RESERVA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_NUEVA_RESERVA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_NUEVA_RESERVA),
                WaitUntil.the(RESULTADOS.of("Reserva de fondos P@GOES"), isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(RESULTADOS.of("Reserva de fondos P@GOES"), isEnabled()).forNoMoreThan(5).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_CUENTA_ORIGEN1, isClickable()).forNoMoreThan(30).seconds(),
                SendKeys.of(informacion.get(0).getMonto()).into(TXT_MONTO),
                WaitUntil.the(ACTIVA_LISTA_VIGENCIA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACTIVA_LISTA_VIGENCIA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACTIVA_LISTA_VIGENCIA),
                WaitUntil.the(SELECCIONAR_LISTA_VIGENCIA.of(informacion.get(0).getVigencia()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_LISTA_VIGENCIA.of(informacion.get(0).getVigencia()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_LISTA_VIGENCIA.of(informacion.get(0).getVigencia())),
                SendKeys.of(informacion.get(0).getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(RESULTADOS.of("Reservarás fondos P@GOES"), isVisible()).forNoMoreThan(5).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        WaitUntil.the(RESULTADOS_SOLC, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR2.toString(), RESERVA_CA.resolveFor(actor).getAttribute(TEXT_CONTENT).trim());
        System.out.println("Número de reserva: " + actor.recall(REFERENCIA_TICKET_VAR2.toString()).toString());

        /* Comprobante */
        actor.attemptsTo(
                CapturarComprobanteReservaFondoTDC.datosC(informacion),
                Scroll.to(BTN_FINALIZAR2).andAlignToTop(),
                Click.on(BTN_FINALIZAR2));
        /* ----------- */
        LeerArchivoProperties.esperar(3);

    }

    public static ReservaFondoTarjeta pagoes(List<Transferencias> informacion) {
        return Instrumented.instanceOf(ReservaFondoTarjeta.class).withProperties(informacion);
    }

}
