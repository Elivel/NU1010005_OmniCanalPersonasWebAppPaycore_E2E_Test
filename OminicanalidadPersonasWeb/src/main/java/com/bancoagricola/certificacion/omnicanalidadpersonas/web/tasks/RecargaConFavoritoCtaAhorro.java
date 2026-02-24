package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class RecargaConFavoritoCtaAhorro implements Task {
    private List<Transferencias> datosDCA;

    public RecargaConFavoritoCtaAhorro(List<Transferencias> datosDCA) {
        this.datosDCA = datosDCA;
    }

    @Step("{0} 'Realiza recarga/compra de paquete de celular'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(BTN_REALIZAR_OTRA).andAlignToTop(),
                WaitUntil.the(BTN_REALIZAR_OTRA,isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA,isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_REALIZAR_OTRA,isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_REALIZAR_OTRA),
                WaitUntil.the(TTL_RECARGA_CELULAR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_FAVOR, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_FAVORITO.of(datosDCA.get(0).getNombreFavorito()), isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(SELECC_FAVORITO.of(datosDCA.get(0).getNombreFavorito()), isClickable()).forNoMoreThan(60).seconds(),
                Click.on(SELECC_FAVORITO.of(datosDCA.get(0).getNombreFavorito())));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LNK_CARGAR_PLANTILLA, isEnabled()).forNoMoreThan(60).seconds(),
                Scroll.to(OPC_PAQ_MONTO_FAV));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(OPC_PAQ_MONTO_FAV, isCurrentlyEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAQ_MONTO_FAV, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(OPC_PAQ_MONTO_FAV, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(OPC_PAQ_MONTO_FAV));
        LeerArchivoProperties.esperar(3);
        actor.attemptsTo(
                SeleccionaMontoPaqueteConFav.datosCA(datosDCA.get(0).getMontopaquete()),
                WaitUntil.the(BTN_CONTINUAR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_CONTINUAR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_CONTINUAR));
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                WaitUntil.the(VTN_EMERG_PP, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(5);
        WaitUntil.the(RESULTADOS_RECARGA, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
        actor.remember(REFERENCIA_TICKET_VAR.toString(), CuentasPage.REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: "+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());
        actor.attemptsTo(
                ValidaTicketRecargasCAFavorito.datosCorrectos(datosDCA));
    }

    public static RecargaConFavoritoCtaAhorro datosCA(List<Transferencias> datosDCA) {
        return Instrumented.instanceOf(RecargaConFavoritoCtaAhorro.class).withProperties(datosDCA);
    }
}

