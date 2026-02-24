package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Comprobante365.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import java.util.List;

public class CapturarComprobanteCambioLimiteTdcAd implements Task {
    private List<Transferencias> datosTDCAd;

    public CapturarComprobanteCambioLimiteTdcAd(List<Transferencias> datosTDCAd) {
        this.datosTDCAd = datosTDCAd;
    }

    public static CapturarComprobanteCambioLimiteTdcAd inicio(List<Transferencias> datosTDCAd) {
        return Instrumented.instanceOf(CapturarComprobanteCambioLimiteTdcAd.class).withProperties(datosTDCAd);
    }
    @Step("{0} 'Capturar y validacion del comprobante de cambio de limite TDC adicional'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t=datosTDCAd.get(0);
        String numTdcPrincipal = t.getTarjetaCredito();
        String numTdcAdic= t.getTarjetaAdicional();
        String nuevoLimTdcAd= t.getNuevoLimiteTarjetaAdicional();

        LeerArchivoProperties.esperar(4);
        actor.attemptsTo(
                WaitUntil.the(MSG_CAMB_TDC_ADIC,isVisible()).forNoMoreThan(60).seconds(),
                Ensure.that(MSG_CAMB_TDC_ADIC).text().isEqualTo("Cambio de límite tarjeta adicional - Resultado")
        );
        actor.attemptsTo(
                Ensure.that(VLD_DATA_TRX.of("Tarjeta de crédito").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numTdcPrincipal),
                Ensure.that(VLD_DATA_TRX.of("Tarjeta adicional").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(numTdcAdic),
                Ensure.that(VLD_DATA_TRX.of("Límite de tu tarjeta adicional").resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(nuevoLimTdcAd)
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
