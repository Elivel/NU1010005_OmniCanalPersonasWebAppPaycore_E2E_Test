package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngrsoMenCADstnoMovim;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoRedencionDonacion;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasPuntosBA;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_CONTINUAR;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.OBTENER_CASHBAC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RedencionCashBac implements Task {
    private List<Transferencias> datosDonacion;

    public RedencionCashBac(List<Transferencias> datosDonacion) {
        this.datosDonacion = datosDonacion;
    }

    @Step("{0} 'realiza proceso de redención CashBac'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosDonacion.get(0);

        actor.attemptsTo(
                IngresoVerMasPuntosBA.inicio(),
                IngresoRedencionDonacion.nuevo());
        actor.remember(VariablesSesion.CASHBAC_DISPONIBLE.toString(), OBTENER_CASHBAC.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("CashBac Inical").andContents(obtenerMontoCashBacInicio().toString());
        actor.attemptsTo(
                WaitUntil.the(OBTENER_CASHBAC, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ACTIVAR_LISTA_TIPO_OPERACION, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ACTIVAR_LISTA_TIPO_OPERACION, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ACTIVAR_LISTA_TIPO_OPERACION),
                WaitUntil.the(SELECCIONAR_TIPO_OPERACION.of(t.getTipoOperacion()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_TIPO_OPERACION.of(t.getTipoOperacion()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_TIPO_OPERACION.of(t.getTipoOperacion())),
                WaitUntil.the(ACTIVAR_LISTA_PRODUCTO_ABONAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ACTIVAR_LISTA_PRODUCTO_ABONAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ACTIVAR_LISTA_PRODUCTO_ABONAR),
                WaitUntil.the(SELECCIONAR_PRODUCTO_ABONAR.of(t.getProductoAbonar()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECCIONAR_PRODUCTO_ABONAR.of(t.getProductoAbonar()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECCIONAR_PRODUCTO_ABONAR.of(t.getProductoAbonar())),
                WaitUntil.the(ACTIVAR_LISTA_TIPO_COBRO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(ACTIVAR_LISTA_TIPO_COBRO, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(ACTIVAR_LISTA_TIPO_COBRO),
                Click.on(SELECCIONAR_TIPO_COBRO.of(t.getTipoCobro())),
                SendKeys.of(t.getMonto()).into(TXT_MONTO_PAGO),
                SendKeys.of(t.getConcepto()).into(TXT_CONCEPTO),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(BTN_ACEPTAR_DON, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_DON, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_DON));
        WaitUntil.the(LBL_RESULTADO_REDENCION, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: "+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
        actor.attemptsTo(
                ValidaTicketRedencionCashBac.datosCorrectos(datosDonacion),
                IngresoVerMasPuntosBA.inicio(),
                IngresoRedencionDonacion.nuevo());
        actor.remember(VariablesSesion.CASHBAC_FINAL.toString(), OBTENER_CASHBAC.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("CashBac Final").andContents(obtenerMontoCashBacFinal().toString());
        actor.attemptsTo(
                IngresoMenuCtaAhorroDestinoMovimientos.inicio(datosDonacion),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(VariablesSesion.MONTO_CUENTA_DESTINO_FINAL.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta Destino Final").andContents(obtenerMontoDestinoFinal().toString());
    }

    public static RedencionCashBac datosCorrectos(List<Transferencias> datosDonacion) {
        return Instrumented.instanceOf(RedencionCashBac.class).withProperties(datosDonacion);
    }
}
