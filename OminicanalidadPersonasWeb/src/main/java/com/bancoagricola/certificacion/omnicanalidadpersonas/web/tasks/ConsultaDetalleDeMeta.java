package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.MENU_VERTICAL;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ConsultaDetalleDeMeta implements Task {
    private List<Meta> datosmeta;
    public ConsultaDetalleDeMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta arm = datosmeta.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_VERTICAL, isEnabled()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_VERTICAL, isClickable()).forNoMoreThan(15).seconds(),
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(80).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(80).seconds(),
                Click.on(MENU_AHORROS));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Scroll.to(NOMBRE_META.of(arm.getNombreMeta())).andAlignToTop(),
                WaitUntil.the(NOMBRE_META.of(arm.getNombreMeta()), isVisible()).forNoMoreThan(60).seconds(),
                Scroll.to(LNK_APORTAR.of(arm.getNombreMeta(), ("Aportar"))).andAlignToBottom(),
                Ensure.that(NOMBRE_META.of(arm.getNombreMeta())).isDisplayed());
        String nombreMetaA = NOMBRE_META.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute(TEXT_CONTENT);
        String montoAcumuladoA = DATO_MONTO_ACUM1.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute(TEXT_CONTENT);
        String metaA = DATO_META1.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute(TEXT_CONTENT);
        String cuotaA = DATO_CUOTA1.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute(TEXT_CONTENT);
        String plazoA = DATO_PLAZO1.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute(TEXT_CONTENT).trim();
        String cuentaA = DATO_CUENTA1.of(arm.getNombreMeta()).resolveFor(theActorInTheSpotlight()).getAttribute(TEXT_CONTENT);
        actor.attemptsTo(
                WaitUntil.the(LNK_VER_MAS.of(arm.getNombreMeta()), isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(arm.getNombreMeta()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(arm.getNombreMeta()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(arm.getNombreMeta())),
                WaitUntil.the(TITLE_RES_META, isVisible()).forNoMoreThan(60).seconds());
                LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                Ensure.that(TITULO_META2).attribute(TEXT_CONTENT).isEqualTo(nombreMetaA),
                Ensure.that(DATO_MONTO_ACUM2).attribute(TEXT_CONTENT).isEqualTo(montoAcumuladoA),
                Ensure.that(DATO_META2).attribute(TEXT_CONTENT).isEqualTo(metaA),
                Ensure.that(DATO_CUOTA2).attribute(TEXT_CONTENT).isEqualTo(cuotaA),
                Ensure.that(DATO_PLAZO2).attribute(TEXT_CONTENT).isEqualTo(plazoA),
                Ensure.that(DATO_CUENTA2).attribute(TEXT_CONTENT).isEqualTo(cuentaA),
                Ensure.that(DATO_PR_CUMPL).isDisplayed(),
                Ensure.that(PLAZO_TRANSC).isDisplayed(),
                Ensure.that(DIA_RETENCION).isDisplayed(),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isVisible()).forNoMoreThan(60).seconds());
    }

    public static ConsultaDetalleDeMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(ConsultaDetalleDeMeta.class).withProperties(datosmeta);
    }
}
