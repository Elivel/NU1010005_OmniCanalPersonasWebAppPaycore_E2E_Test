package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;


import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OBTENER_SALDO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoDestinoInicio;

public class CapturarSaldoCtaDestinoCC implements Task {
    private List<Transferencias> datostransferencias;

    public CapturarSaldoCtaDestinoCC(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                IngresoMenuCtaCorrienteDestinoMovimientos.inicio(datostransferencias));
        actor.remember(VariablesSesion.MONTO_CUENTA_DESTINO.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta Destino Inicio").andContents(obtenerMontoDestinoInicio().toString());
    }

    public static CapturarSaldoCtaDestinoCC inicio(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(CapturarSaldoCtaDestinoCC.class).withProperties(datostransferencias);
    }
}
