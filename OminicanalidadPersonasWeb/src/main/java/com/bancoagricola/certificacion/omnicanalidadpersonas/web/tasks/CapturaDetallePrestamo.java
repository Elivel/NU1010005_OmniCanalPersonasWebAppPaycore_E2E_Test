package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.DetallesPrestamos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCION_MENU;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class CapturaDetallePrestamo implements Task {
    private List<Transferencias> datostransferencias;

    public CapturaDetallePrestamo(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of("Cuentas"), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of("Cuentas"), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of("Cuentas")));

        actor.remember(VariablesSesion.CUENTA_P1.toString(), OBTENER_CUENTAP1.of(t.getCuentaOrigen()).resolveFor(actor).getText());
        actor.remember(VariablesSesion.DEUDA_P1.toString(), OBTENER_DEUDAP1.of(t.getCuentaOrigen()).resolveFor(actor).getText().replace(" ", "."));
        actor.remember(VariablesSesion.ESTADO_P1.toString(), OBTENER_ESTADOP1.of(t.getCuentaOrigen()).resolveFor(actor).getText());
        actor.remember(VariablesSesion.FECHA_PAGO_P1.toString(), OBTENER_FECHAPAGOP1.of(t.getCuentaOrigen()).resolveFor(actor).getText());

        actor.attemptsTo(
                WaitUntil.the(VER_MAS_DETALLE.of(t.getCuentaOrigen()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VER_MAS_DETALLE.of(t.getCuentaOrigen()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_DETALLE.of(t.getCuentaOrigen())),
                WaitUntil.the(LBL_VER_MAS, isEnabled()).forNoMoreThan(30).seconds());
        LeerArchivoProperties.esperar2();
        actor.remember(VariablesSesion.CUENTA_P2.toString(), OBTENER_CUENTAP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.DEUDA_P2.toString(), OBTENER_SALDOP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.ESTADO_P2.toString(), OBTENER_ESTADOP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.FECHA_PAGO_P2.toString(), OBTENER_FECHAPAGOP2.resolveFor(actor).getText());

        actor.attemptsTo(
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MAS_DETALLE),
                WaitUntil.the(LBL_MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar2();
        actor.remember(VariablesSesion.CUENTA_P3.toString(), OBTENER_CUENTAP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.DEUDA_P3.toString(), OBTENER_DEUDAP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.ESTADO_P3.toString(), OBTENER_ESTADOP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.FECHA_PAGO_P3.toString(), OBTENER_FECHAPAGOP3.resolveFor(actor).getText());

        Serenity.recordReportData().withTitle("Información Capturada Pantalla Inicial").andContents(String.valueOf(new DetallesPrestamos().retornoPaginaInicial()));
        Serenity.recordReportData().withTitle("Información Capturada Pantalla Intermedia").andContents(String.valueOf(new DetallesPrestamos().retornoPaginaIntermedia()));
        Serenity.recordReportData().withTitle("Información Capturada Pantalla Final").andContents(String.valueOf(new DetallesPrestamos().retornoPaginaFinal()));

    }


    public static CapturaDetallePrestamo pantallas(List<Transferencias> listTranferencia) {
        return Instrumented.instanceOf(CapturaDetallePrestamo.class).withProperties(listTranferencia);
    }
}
