package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class IngrsoMenAhorrosAPMovmts implements Interaction {

    private List<Transferencias> datosTransferencias;
    public IngrsoMenAhorrosAPMovmts(List<Transferencias> datosDCA) { this.datosTransferencias = datosDCA;}

    @Step("{0} 'ingresa al menú'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosTransferencias.get(0);
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL,isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS),
                WaitUntil.the(TOTAL_AHORROS_ACUMULADOS, isVisible()).forNoMoreThan(80).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(t.getCuentaOrigen()),isVisible()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(t.getCuentaOrigen())),
                WaitUntil.the(TTL_RESUMEN_AP, isCurrentlyVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LNK_MOVIMIENTOS_AP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS_AP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS_AP, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS_AP),
                WaitUntil.the(TTL_MOVIMIENTOS, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(TTL_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds());
    }

    public static IngrsoMenAhorrosAPMovmts inicio(List<Transferencias> datosDCA){
        return Instrumented.instanceOf(IngrsoMenAhorrosAPMovmts.class).withProperties(datosDCA);
    }
}
