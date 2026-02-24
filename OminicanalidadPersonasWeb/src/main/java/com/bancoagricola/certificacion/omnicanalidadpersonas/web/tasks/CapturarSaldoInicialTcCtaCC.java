package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuTarjetasMovimentos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OBTENER_SALDO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.DISPONIBILIDAD_TARJETA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoDestinoInicio;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoTarjetaAlInicio;

public class CapturarSaldoInicialTcCtaCC implements Task {

    private List<Transferencias> datostransferencias;

    public CapturarSaldoInicialTcCtaCC(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} 'valida saldo inicial'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresoMenuTarjetasMovimentos.inicio(datostransferencias));
        LeerArchivoProperties.esperar(2);
        actor.remember(VariablesSesion.MONTO_INICIAL_TC.toString(), DISPONIBILIDAD_TARJETA.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Tarjeta al Inicio").andContents(obtenerMontoTarjetaAlInicio().toString());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                IngresoMenuCtaCorrienteDestinoMovimientos.inicio(datostransferencias));
        LeerArchivoProperties.esperar(2);
        actor.remember(VariablesSesion.MONTO_CUENTA_DESTINO.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta destino al Inicio").andContents(obtenerMontoDestinoInicio().toString());

    }

    public static CapturarSaldoInicialTcCtaCC transferenciaTarjeta(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(CapturarSaldoInicialTcCtaCC.class).withProperties(datostransferencias);
    }
}
