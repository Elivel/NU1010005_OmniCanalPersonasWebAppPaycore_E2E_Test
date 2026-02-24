package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.CalculosTranferencias.obtenerMontoTarjetaAlInicio;

public class CapturarSaldoSoloTarjeta implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember(VariablesSesion.MONTO_INICIAL_TC.toString(), DISPONIBILIDAD_TARJETA.resolveFor(actor).getText().replace("$", ""));
        actor.remember(VariablesSesion.V_LIMITE_CREDITO.toString(), P_LIMITE_CREDITO.resolveFor(actor).getText().replace("$", ""));
        Serenity.recordReportData().withTitle("Monto Tarjeta al Inicio").andContents(obtenerMontoTarjetaAlInicio().toString());

    }

    public static CapturarSaldoSoloTarjeta alInicio() {
        return Instrumented.instanceOf(CapturarSaldoSoloTarjeta.class).withProperties();
    }
}
