package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DetallesCuentaAhorro implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(LINK_IMPRIMIR, isVisible()).forNoMoreThan(20).seconds(),
                WaitUntil.the(LINK_EXPORTAR, isVisible()).forNoMoreThan(20).seconds());
        actor.remember(VariablesSesion.SALDO_INICIAL.toString(), OBTENER_SALDO_INICIAL.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
        actor.remember(VariablesSesion.SALDO_DISPONIBLE.toString(), OBTENER_SALDO_DISPONIBLE.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
        actor.remember(VariablesSesion.SALDO_RETENIDO.toString(), OBTENER_SALDO_RETENIDO.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
        actor.remember(VariablesSesion.SALDO_CONTABLE.toString(), OBTENER_SALDO_CONTABLE.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
        actor.remember(VariablesSesion.PROMEDIO_CONTABLE.toString(), OBTENER_PROMEDIO_CONTABLE.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
        actor.remember(VariablesSesion.TOTAL_CARGOS.toString(), OBTENER_TOTAL_CARGOS.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
        actor.remember(VariablesSesion.TOTAL_ABONOS.toString(), OBTENER_TOTAL_ABONOS.resolveFor(actor).getText().replace("$", "").replace(" ","" ));
    }
}