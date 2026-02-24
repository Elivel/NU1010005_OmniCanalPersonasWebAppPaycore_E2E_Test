package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Meta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.*;

public class ValidaMovimientosDeMeta implements Task {
    static double montoAdicRetir = 0;

    private List<Meta> datosmeta;
    public ValidaMovimientosDeMeta(List<Meta> datosmeta) {
        this.datosmeta = datosmeta;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Meta arm = datosmeta.get(0);
        montoAdicRetir = Double.parseDouble(arm.getAporteRetiroMeta());
        actor.attemptsTo(
                Scroll.to(NOMBRE_META.of(arm.getNombreMeta())),
                WaitUntil.the(LNK_VER_MAS.of(arm.getNombreMeta()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_VER_MAS.of(arm.getNombreMeta()), isEnabled()).forNoMoreThan(60).seconds(),
                Click.on(LNK_VER_MAS.of(arm.getNombreMeta())),
                WaitUntil.the(TITLE_RES_META, isEnabled()).forNoMoreThan(60).seconds(),
                Scroll.to(LNK_MOVIMIENTOS),
                WaitUntil.the(LNK_MOVIMIENTOS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_MOVIMIENTOS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LNK_MOVIMIENTOS));
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                WaitUntil.the(OPCION_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPCION_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPCION_FILTRAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(BTN_BUSCAR_MOV, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_BUSCAR_MOV, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_BUSCAR_MOV),
                WaitUntil.the(STL_MOVIMIENTOS_META, isEnabled()).forNoMoreThan(60).seconds());
                LeerArchivoProperties.esperar2();
        double montoRetiA = Double.parseDouble(MONTO_RET.resolveFor(theActorInTheSpotlight()).getAttribute("innerText"));
        double montoAporA = Double.parseDouble(MONTO_APO.resolveFor(theActorInTheSpotlight()).getAttribute("innerText"));
        actor.should(seeThat(ExisteTablaMovimientos.quelatabla(),is(true)).because("Valida que se muestre la tabla de movimientos"));
        actor.should(seeThat(CantidadRegistrosTablaMovimientos.tiene(),greaterThanOrEqualTo(1)).because("La cantidad de registros sea mayor o igual a 1"));
        actor.attemptsTo(
                Ensure.that(montoRetiA).isEqualTo(montoAdicRetir),
                Ensure.that(montoAporA).isEqualTo(montoAdicRetir),
                WaitUntil.the(MENU_AHORROS, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(MENU_AHORROS, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(MENU_AHORROS),
                WaitUntil.the(LBL_TOTAL_AHORROS_ACUM, isVisible()).forNoMoreThan(60).seconds());
    }
    public static ValidaMovimientosDeMeta datosMet(List<Meta> datosmeta) {
        return Instrumented.instanceOf(ValidaMovimientosDeMeta.class).withProperties(datosmeta);
    }
}
