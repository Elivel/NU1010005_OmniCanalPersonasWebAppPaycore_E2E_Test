package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.SeleccionarEnCalendarioFechaLista;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.CantidadRegistrosTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ExisteTablaMovimientos;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.TABLA__MOV_AHORRO_NAVIDENO;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BTN_BUSCAR_MOVIMIENTOS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

public class FiltrarMovimientosAhorroNav implements Task {
    private List<Transferencias> fechas;

    public FiltrarMovimientosAhorroNav(List<Transferencias> fechas) {
        this.fechas = fechas;
    }

    @Step("{0} 'realiza el procedimiento para validar los movimientos de Ahorro Navideño'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(OPC_FILTRAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_FILTRAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_FILTRAR),
                WaitUntil.the(PERIODO_TIEMPO, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                SeleccionarEnCalendarioFechaLista.laFecha(fechas));
        LeerArchivoProperties.esperar2();
        theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(BTN_BUSCAR_MOVIMIENTOS, isClickable()).forNoMoreThan(15).seconds(),
                Click.on(BTN_BUSCAR_MOVIMIENTOS),
                WaitUntil.the(TABLA__MOV_AHORRO_NAVIDENO, isCurrentlyVisible()).forNoMoreThan(60).seconds());
        LeerArchivoProperties.esperar2();
        theActorInTheSpotlight().should(seeThat(ExisteTablaMovimientos.quelatabla(), is(true)).because("Valida que se muestre la tabla de 'Movimientos de ahorro navideño'"));
        theActorInTheSpotlight().should(seeThat(CantidadRegistrosTablaMovimientos.tiene(), greaterThanOrEqualTo(1)).because("La cantidad de registros sea 'mayor o igual a 1'"));
    }

    public static Performable navideno(List<Transferencias> fechas) {
        return Instrumented.instanceOf(FiltrarMovimientosAhorroNav.class).withProperties(fechas);
    }


}
