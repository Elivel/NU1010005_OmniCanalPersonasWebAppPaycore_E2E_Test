package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class EliminaFavorito implements Interaction {

    private String nombrefav;

    public EliminaFavorito(String nombrefav) {
        this.nombrefav = nombrefav;
    }

    @Step("{0} elimina favorito '#nombrefav'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        LeerArchivoProperties.esperar(1);
        actor.attemptsTo(
                WaitUntil.the(LNK_ELIMINAR_FAVO, isVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LNK_ELIMINAR_FAVO, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LNK_ELIMINAR_FAVO, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LNK_ELIMINAR_FAVO));
        if (SELECT_ELIM_FAV.of(nombrefav).resolveFor(actor).isVisible()) {
            actor.attemptsTo(
                    WaitUntil.the(SELECT_ELIM_FAV.of(nombrefav), isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(SELECT_ELIM_FAV.of(nombrefav), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(SELECT_ELIM_FAV.of(nombrefav)),
                    WaitUntil.the(BTN_ELIMINAR, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(BTN_ELIMINAR, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_ELIMINAR),
                    WaitUntil.the(VTN_EMERG_PP, isVisible()).forNoMoreThan(60).seconds(),
                    WaitUntil.the(BOTON_ACEPTAR_PP, isEnabled()).forNoMoreThan(30).seconds(),
                    WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BOTON_ACEPTAR_PP));
            LeerArchivoProperties.esperar(5);
            WaitUntil.the(MSG_CONFIRMA2, isVisible()).forNoMoreThan(60).seconds().performAs(actor);
            LeerArchivoProperties.esperar(2);

        } else {
            actor.attemptsTo(
                    WaitUntil.the(MENU_CUENTAS, isEnabled()).forNoMoreThan(80).seconds(),
                    WaitUntil.the(MENU_CUENTAS, isClickable()).forNoMoreThan(80).seconds());
        }
    }

    public static EliminaFavorito datosCA(String nombrefav) {
        return Instrumented.instanceOf(EliminaFavorito.class).withProperties(nombrefav);
    }
}
