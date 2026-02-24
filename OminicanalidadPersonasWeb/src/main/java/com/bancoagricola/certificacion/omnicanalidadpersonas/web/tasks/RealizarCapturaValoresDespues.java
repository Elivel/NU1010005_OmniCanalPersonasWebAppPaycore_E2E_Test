package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuADSMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroOrigenMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;

public class RealizarCapturaValoresDespues implements Task {

    private List<Transferencias> datostransferencias;

    public RealizarCapturaValoresDespues(List<Transferencias> datostransferencias) {
        this.datostransferencias = datostransferencias;
    }
    @Step("{0} realiza captura de montos de ambas cuentas")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datostransferencias.get(0);

        actor.attemptsTo(
                IngresoMenuADSMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(
                VariablesSesion.MONTO_CUENTA_ORIGEN_FINAL.toString(),
                OBTENER_SALDO.resolveFor(actor).getText());
        actor.attemptsTo(
                IngresoMenuCtaAhorroDestinoMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(
                VariablesSesion.MONTO_CUENTA_DESTINO_FINAL.toString(),
                OBTENER_SALDO.resolveFor(actor).getText());
    }

    public static RealizarCapturaValoresDespues cuentas(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarCapturaValoresDespues.class).withProperties(datostransferencias);
    }
}