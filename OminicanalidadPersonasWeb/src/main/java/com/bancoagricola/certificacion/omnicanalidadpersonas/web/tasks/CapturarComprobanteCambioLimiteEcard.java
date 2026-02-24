package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import java.util.List;

public class CapturarComprobanteCambioLimiteEcard implements Task {
    private List<Transferencias> datosEcard;

    public CapturarComprobanteCambioLimiteEcard(List<Transferencias> datosEcard) {
        this.datosEcard = datosEcard;
    }

    public static CapturarComprobanteCambioLimiteEcard inicio(List<Transferencias> datosEcard) {
        return Instrumented.instanceOf(CapturarComprobanteCambioLimiteEcard.class).withProperties(datosEcard);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t = datosEcard.get(0);
        String numEcard = t.getNumTarjetaEcard();
        String nuevoLimiteEcard = t.getNuevoLimiteEcard();


        LeerArchivoProperties.esperar(4);
        actor.attemptsTo(
                WaitUntil.the(LBL_MSG_EXITO_CAMB_LIMITE_ECARD, isVisible()).forNoMoreThan(60).seconds()

        );
        actor.attemptsTo(
                Ensure.that(VLD_DATA_COMPROBANTE.of("Tarjeta e-card").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numEcard),
                Ensure.that(VLD_DATA_COMPROBANTE.of("Límite de tu e-card").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nuevoLimiteEcard)


        );
        actor.attemptsTo(
                Ensure.that(LABEL_COMPROBANTE.of(LBL_ESTADO)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(LBL_FO)),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_FO)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(LBL_FA)),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_FA)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(LBL_ID)),
                Ensure.that(LABEL_COMPROBANTE.of(LBL_ID)).isDisplayed(),
                Scroll.to(LABEL_COMPROBANTE.of(BOTON_FINALIZAR)).andAlignToBottom()
        );


    }
}
