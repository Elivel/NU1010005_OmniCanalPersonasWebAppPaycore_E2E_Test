package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ValidarDetalleTDCAdicionales implements Task {

    private static final Logger LOGGER = Logger.getLogger(ValidarDetalleTDCAdicionales.class.getName());

    private final List<Transferencias>detalleTDC;

    public ValidarDetalleTDCAdicionales(List<Transferencias> detalleTDC) {
        this.detalleTDC = detalleTDC;
    }

    public static ValidarDetalleTDCAdicionales inicio(List<Transferencias> detalleTDC) {
        return Instrumented.instanceOf(ValidarDetalleTDCAdicionales.class).withProperties(detalleTDC);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias t=detalleTDC.get(0);
        actor.attemptsTo(
                WaitUntil.the(TABLA_TDC_ADICONALES,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(NUM_TDC_ADIC.of(t.getTarjetaAdicional()),isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(NOMBRE_TDC_ADICIONAL,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(ESTADO_TDC_ADIC,isVisible()).forNoMoreThan(15).seconds(),
                Ensure.that(ESTADO_TDC_ADIC).text().isEqualTo("ACTIVA"),
                WaitUntil.the(LIMITE_CREDI_TDC_ADIC,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(SALDO_DISPO_TDC_ADIC,isVisible()).forNoMoreThan(15).seconds());

        String limiteCredito= Text.of(LIMITE_CREDI_TDC_ADIC).answeredBy (actor).replace(",", "");
        String saldoDisponible= Text.of(SALDO_DISPO_TDC_ADIC).answeredBy(actor).replace(",", "");

        double limite = Double.parseDouble(limiteCredito);
        double montoLimite = Math.round(limite*100.0)/100.0;
        LOGGER.log(Level.INFO, "Monto limite de TDC adicional: \"{0}\"", montoLimite);

        double saldo = Double.parseDouble(saldoDisponible);
        double montoSaldoDispo = Math.round(saldo*100.0)/100.0;
        LOGGER.log(Level.INFO, "Monto disponible de TDC adicional: \"{0}\"", montoSaldoDispo);

        Ensure.that(montoSaldoDispo).isLessThanOrEqualTo(montoLimite);

        actor.attemptsTo(
                WaitUntil.the(TTL_NUM_ECARD_ADICIONAL,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(NUM_ECARD_ADICIONAL.of(t.getTarjetaAdicionalEcard()),isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(NOMB_ECARD, isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(ESTADO_ECARD_ADIC,isVisible()).forNoMoreThan(15).seconds(),
                Ensure.that(ESTADO_ECARD_ADIC).text().isEqualTo("ACTIVA"),
                WaitUntil.the(SALDO_DISP_ECARD,isVisible()).forNoMoreThan(15).seconds(),
                WaitUntil.the(LIMITE_CRED_ECARD,isVisible()).forNoMoreThan(15).seconds()

        );
        String limiteCreditoEcard= Text.of(LIMITE_CRED_ECARD).answeredBy(actor).replace(",", "");
        String saldoDisponibleEcard= Text.of(SALDO_DISP_ECARD).answeredBy(actor).replace(",", "");

        double limiteE = Double.parseDouble(limiteCreditoEcard);
        double montoLimiteE = Math.round(limiteE*100.0)/100.0;
        LOGGER.log(Level.INFO, "El monto limite de la tarjeta e-card es: \"{0}\"", montoLimiteE);

        double saldoE = Double.parseDouble(saldoDisponibleEcard);
        double montoSaldoDispoE = Math.round(saldoE*100.0)/100.0;
        LOGGER.log(Level.INFO, "El monto disponible la tarjeta e-card es: \"{0}\"", montoSaldoDispoE);

        Ensure.that(montoSaldoDispoE).isLessThanOrEqualTo(montoLimiteE);
    }
}
