package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OBTENER_SALDO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoDestinoInicio;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoOrigenInicio;

public class CapturarSaldoCtaOrigenDestinoCCaCA implements Task {

    private List<Transferencias> datostransferencias;

    public CapturarSaldoCtaOrigenDestinoCCaCA(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }

    @Step("{0} 'Usuario captura los valores de saldo disponible en cuenta origen y destino'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(IngresoMenuCtaCorrienteOrigenMovimientos.inicio(datostransferencias));
        actor.remember(VariablesSesion.MONTO_CUENTA_ORIGEN.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta Origen Inicio").andContents(obtenerMontoOrigenInicio().toString());
        actor.attemptsTo(IngresoMenuCtaAhorroDestinoMovimientos.inicio(datostransferencias));
        actor.remember(VariablesSesion.MONTO_CUENTA_DESTINO.toString(), OBTENER_SALDO.resolveFor(actor).getText());
        Serenity.recordReportData().withTitle("Monto Cuenta Destino Inicio").andContents(obtenerMontoDestinoInicio().toString());
    }

    public static CapturarSaldoCtaOrigenDestinoCCaCA inicio(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(CapturarSaldoCtaOrigenDestinoCCaCA.class).withProperties(datostransferencias);
    }


}
