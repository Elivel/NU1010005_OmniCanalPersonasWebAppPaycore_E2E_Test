package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuADSMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaAhorroDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoMenuCtaCorrienteDestinoMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.OBTENER_SALDO;

public class RealizarCapturaValoresDespuesCC implements Task {

    private List<Transferencias> datostransferencias;

    public RealizarCapturaValoresDespuesCC(List<Transferencias> datostransferencias) {
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
                IngresoMenuCtaCorrienteDestinoMovimientos.inicio(datostransferencias),
                ValidaReferenciaTicketCuentaAhorro.conLaReferencia());
        actor.remember(
                VariablesSesion.MONTO_CUENTA_DESTINO_FINAL.toString(),
                OBTENER_SALDO.resolveFor(actor).getText());
    }

    public static RealizarCapturaValoresDespuesCC cuentas(List<Transferencias> datostransferencias) {
        return Instrumented.instanceOf(RealizarCapturaValoresDespuesCC.class).withProperties(datostransferencias);
    }
}