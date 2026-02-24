package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.IngresoVerMasPuntosBA;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.TTL_MAS_DETALLE;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidaPuntosBADespues implements Task {
    private List<Transferencias> datosCAP;
    public ValidaPuntosBADespues(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} Valida 'Puntos BA' despues de realizar la transacción")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                IngresoVerMasPuntosBA.inicio(),
                WaitUntil.the(OPC_MAS_DETALLE, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_MAS_DETALLE, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_MAS_DETALLE),
                WaitUntil.the(TTL_MAS_DETALLE, isCurrentlyVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(1);
        double saldoCuentaDesD = Double.parseDouble(PUNTOS_ACUMULADOS.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",",""));
        double saldoCuentaAntD = Double.parseDouble(actor.recall(VariablesSesion.PUNTOSBA_ANTES_TRX.toString()).toString().replace(",",""));
        double valorAPagar = Double.parseDouble(datosCAP.get(0).getMonto());
        double calculo = saldoCuentaAntD - valorAPagar;
        System.out.println("Puntos BA despues: "+saldoCuentaDesD);
        System.out.println("Valor a pagar: "+valorAPagar);
        System.out.println("Calculo: "+calculo);
        actor.attemptsTo(
                Ensure.that(saldoCuentaDesD).isEqualTo(calculo));
    }
    public static ValidaPuntosBADespues datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ValidaPuntosBADespues.class).withProperties(datosCAP);
    }
}

