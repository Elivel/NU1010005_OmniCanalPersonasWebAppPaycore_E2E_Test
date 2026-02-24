package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientosBasico;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OBTENER_SALDO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoOrigenInicio;

public class CapturarSaldoCtaOrigenCC implements Task {

    private String cuenta;
    public CapturarSaldoCtaOrigenCC(String cuenta) {
        this.cuenta = cuenta;
    }

    @Step("{0} Valida 'Saldo disponible' antes de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(IngresoMenuCtaCorrienteOrigenMovimientosBasico.inicio(cuenta));
        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta al Inicio").andContents(obtenerMontoOrigenInicio().toString());
    }

    public static CapturarSaldoCtaOrigenCC transferencia(String cuenta) {
        return Instrumented.instanceOf(CapturarSaldoCtaOrigenCC.class).withProperties(cuenta);
    }
}
