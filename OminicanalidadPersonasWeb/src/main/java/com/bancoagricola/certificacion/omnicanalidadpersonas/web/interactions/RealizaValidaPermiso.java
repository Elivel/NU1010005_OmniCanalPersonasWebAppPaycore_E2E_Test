package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Administrar.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.NO_SELECCIONADO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.SELECCIONADO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

public class RealizaValidaPermiso implements Interaction {

    private List<Transferencias> datosTransferencias;

    public RealizaValidaPermiso(List<Transferencias> datosDCA) {
        this.datosTransferencias = datosDCA;
    }

    @Step("{0} 'valida que la opcion se encuentre seleccionada'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);

        String valida = OPC_PERM_PAG.of(t.getPermisos()).resolveFor(theActorInTheSpotlight()).getAttribute("className");

        if (valida.equals(NO_SELECCIONADO)) {
            actor.attemptsTo(
                    WaitUntil.the(OPC_PERM_PAG.of(t.getPermisos()), isEnabled()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(OPC_PERM_PAG.of(t.getPermisos()), isClickable()).forNoMoreThan(60).seconds(),
                    Click.on(OPC_PERM_PAG.of(t.getPermisos())));
        }
        actor.attemptsTo(
                Ensure.that(OPC_PERM_PAG.of(t.getPermisos()).resolveFor(theActorInTheSpotlight()).getAttribute("className")).isEqualTo(SELECCIONADO));
    }

    public static RealizaValidaPermiso inicio(List<Transferencias> datosTransferencias) {
        return Instrumented.instanceOf(RealizaValidaPermiso.class).withProperties(datosTransferencias);
    }
}
