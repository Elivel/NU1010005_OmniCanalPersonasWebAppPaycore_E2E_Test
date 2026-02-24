package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.EsperarVisibilidad;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.DetallesFondos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.OPCION_MENU;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class CapturarDetallesFondo implements Task {
    private String fondo;

    public CapturarDetallesFondo(String fondo) {
        this.fondo = fondo;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_MENU.of("Cuentas"), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_MENU.of("Cuentas")));
        actor.remember(VariablesSesion.CUENTA_P1.toString(), OBTENER_CUENTAP1.of(fondo).resolveFor(actor).getText());
        actor.remember(VariablesSesion.SALDO_DISP1.toString(), OBTENER_SALDO_DISPONIBLE_FONDO.of(fondo).resolveFor(actor).getText().replace(" ","."));
        actor.remember(VariablesSesion.ESTADO_P1.toString(), OBTENER_ESTADOP1_FONDO.of(fondo).resolveFor(actor).getText());
        actor.remember(VariablesSesion.TIPO1.toString(), OBTENER_TIPO_FONDOP1.of(fondo).resolveFor(actor).getText());
        actor.remember(VariablesSesion.NUMEROCC1.toString(), OBTENER_NUMERO_FONDOP1.of(fondo).resolveFor(actor).getText());
        actor.attemptsTo(
                WaitUntil.the(VER_MAS_FONDO.of(fondo), isVisible()).forNoMoreThan(60).seconds(),
                Click.on(VER_MAS_FONDO.of(fondo)),
                EsperarVisibilidad.elElementoConTexto("Resumen de fondo de inversión"));
        LeerArchivoProperties.esperar2();
        actor.remember(VariablesSesion.CUENTA_P2.toString(), OBTENER_CUENTAP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.SALDO_DISP2.toString(), OBTENER_SALDOP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.ESTADO_P2.toString(), OBTENER_ESTADOP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.TIPO2.toString(), OBTENER_TIPOFONDOP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.NUMEROCC2.toString(), OBTENER_NUMERO_FONDOP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.CUOTA2.toString(), OBTENER_CUOTAP2.resolveFor(actor).getText());
        actor.remember(VariablesSesion.MONTO_RETIRO2.toString(), OBTENER_MONTO_RETIROP2.resolveFor(actor).getText());
        actor.attemptsTo(
                WaitUntil.the(MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MAS_DETALLE),
                EsperarVisibilidad.elElementoConTexto("Más detalle de fondo de inversión"));
        LeerArchivoProperties.esperar2();
        actor.remember(VariablesSesion.CUENTA_P3.toString(), OBTENER_CUENTAP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.SALDO_DISP3.toString(), OBTENER_SALDO_DISP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.ESTADO_P3.toString(), OBTENER_ESTADOP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.TIPO3.toString(), OBTENER_TIPOFONDOP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.NUMEROCC3.toString(), OBTENER_NUMERO_FONDOP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.CUOTA3.toString(), OBTENER_CUOTAP3.resolveFor(actor).getText());
        actor.remember(VariablesSesion.MONTO_RETIRO3.toString(), OBTENER_MONTO_RETIROP3.resolveFor(actor).getText());

        Serenity.recordReportData().withTitle("Información Capturada Pantalla Inicial").andContents(String.valueOf(new DetallesFondos().retornoPaginaInicial()));
        Serenity.recordReportData().withTitle("Información Capturada Pantalla Intermedia").andContents(String.valueOf(new DetallesFondos().retornoPaginaIntermedia()));
        Serenity.recordReportData().withTitle("Información Capturada Pantalla Final").andContents(String.valueOf(new DetallesFondos().retornoPaginaFinal()));

    }

    public static CapturarDetallesFondo inversion(String fondo) {
        return Instrumented.instanceOf(CapturarDetallesFondo.class).withProperties(fondo);
    }
}
