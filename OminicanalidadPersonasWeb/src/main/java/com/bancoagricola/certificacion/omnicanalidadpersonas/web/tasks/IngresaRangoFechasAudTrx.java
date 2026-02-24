package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;

public class IngresaRangoFechasAudTrx implements Task {
    private List<Transferencias> datosAud;
    public IngresaRangoFechasAudTrx(List<Transferencias> datosAud) {
        this.datosAud = datosAud;
    }

    @Step("{0} 'ingresa rango de fechas'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias aud = datosAud.get(0);
        actor.attemptsTo(
                SendKeys.of(aud.getMontoDesde()).into(DESDE_AUDTRX),
                SendKeys.of(aud.getMontoHasta()).into(HASTA_AUDTRX));
    }

    public static IngresaRangoFechasAudTrx datosAud(List<Transferencias> datosAud) {
        return Instrumented.instanceOf(IngresaRangoFechasAudTrx.class).withProperties(datosAud);
    }
}