package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Administrar.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BOTON_ACEPTAR_PP;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.VTN_EMERG_PP;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.NO_SELECCIONADO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.SELECCIONADO;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RealizaProcesoInactivacion implements Interaction {

    private List<Transferencias> datosTransferencias;
    public RealizaProcesoInactivacion(List<Transferencias> datosDCA) { this.datosTransferencias = datosDCA;}

    @Step("{0} 'realiza proceso de inhabilitación de permisos'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);

        actor.attemptsTo(
                WaitUntil.the(SELCC_USUARIOS.of(t.getUsuario()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELCC_USUARIOS.of(t.getUsuario()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELCC_USUARIOS.of(t.getUsuario())));
                WaitUntil.the(TTL_SELCC_USUARIO, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.attemptsTo(
                Scroll.to(PERMISOS).andAlignToTop(),
                WaitUntil.the(OPC_PERM.of(t.getOpcion()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PERM.of(t.getOpcion()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PERM.of(t.getOpcion())),
                RealizaValidaPermiso.inicio(datosTransferencias));
        LeerArchivoProperties.esperar(1);
        String estadoAntes = OPC_PERM_PAG.of(t.getPermisos()).resolveFor(theActorInTheSpotlight()).getAttribute("className");
        System.out.println("estadoAntes: "+estadoAntes);

        actor.attemptsTo(
                Click.on(OPC_PERM_PAG.of(t.getPermisos())));

        String estadoDespues = OPC_PERM_PAG.of(t.getPermisos()).resolveFor(theActorInTheSpotlight()).getAttribute("className");
        System.out.println("estadoDespues: "+estadoDespues);
        actor.attemptsTo(
                Ensure.that(OPC_PERM_PAG.of(t.getPermisos()).resolveFor(theActorInTheSpotlight()).getAttribute("className")).isEqualTo(NO_SELECCIONADO));
        actor.attemptsTo(
                Scroll.to(BTN_CONTINUAR),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR),
                WaitUntil.the(VTN_EMERG_PP, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BOTON_ACEPTAR_PP),
                //WaitUntil.the(MSG_CONF.of(t.getUsuario()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VOLVER_ESCRITORIO, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VOLVER_ESCRITORIO, isClickable()).forNoMoreThan(60).seconds()
                //Ensure.that(MSG_CONF.of(t.getUsuario())).isDisplayed());
        );
    }

    public static RealizaProcesoInactivacion inicio(List<Transferencias> datosTransferencias){
        return Instrumented.instanceOf(RealizaProcesoInactivacion.class).withProperties(datosTransferencias);
    }
}
