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

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.TEXT_CONTENT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidaTicketTransferenciaPuntosBALifemiles implements Task {

    private List<Transferencias> transferencias;

    public ValidaTicketTransferenciaPuntosBALifemiles(List<Transferencias> transferencias) {
        this.transferencias = transferencias;
    }

    @Step("{0} 'realiza validacion de ticket'")
    @Override
    public <T extends Actor> void performAs(T actor) {

        Transferencias t = transferencias.get(0);

        Task.where(actor+" valida que 'No operación' sea igual a "+"'"+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString()+"'",  Ensure.that(REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim()).isEqualTo(actor.recall(REFERENCIA_TICKET_VAR.toString()).toString())).performAs(actor);
        Task.where(actor+" valida que 'Primer nombre' sea igual a "+"'"+t.getPrimerNombre()+"'",  Ensure.that(PRIMER_NOMBRE_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getPrimerNombre())).performAs(actor);
        Task.where(actor+" valida que 'Segundo nombre' sea igual a "+"'"+t.getSegundoNombre()+"'",  Ensure.that(SEGUNDO_NOMBRE_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getSegundoNombre())).performAs(actor);
        Task.where(actor+" valida que 'Primer apellido' sea igual a "+"'"+t.getPrimerApellido()+"'",  Ensure.that(PRIMER_APELLIDO_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getPrimerApellido())).performAs(actor);
        Task.where(actor+" valida que 'Segundo apellido' sea igual a "+"'"+t.getSegundoApellido()+"'",  Ensure.that(SEGUNDO_APELLIDO_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getSegundoApellido())).performAs(actor);
        Scroll.to(SEGUNDO_APELLIDO_TPL).andAlignToTop().performAs(actor);
        LeerArchivoProperties.esperar2();
        Task.where(actor+" valida que 'No. tarjeta LifeMiles' sea igual a "+"'"+t.getNumeroLifemiles()+"'",  Ensure.that(NUMERO_TARJETA_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNumeroLifemiles())).performAs(actor);
        Task.where(actor+" valida que 'Total de puntos' se muestre", WaitUntil.the(TOTAL_PUNTOS_TPL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Puntos a transferir' sea igual a "+"'"+t.getPuntos()+"'",  Ensure.that(PUNTOS_TRANSFERIR_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT).replace(",", "")).isEqualTo(t.getPuntos())).performAs(actor);
        Task.where(actor+" valida que 'Código de país' sea igual a "+"'"+t.getCodigoPais()+"'",  Ensure.that(CODIGO_PAIS_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getCodigoPais())).performAs(actor);
        Task.where(actor+" valida que 'Número telefónico' sea igual a "+"'"+t.getNumeroTelefono()+"'",  Ensure.that(NUMERO_TEL_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).isEqualTo(t.getNumeroTelefono())).performAs(actor);
        Task.where(actor+" valida que 'Cuenta a cargar' sea igual a "+"'"+t.getCuentaCorta()+"'",  Ensure.that(CUENTA_CARGAR_TPL.resolveFor(actor).getAttribute(TEXT_CONTENT)).contains(t.getCuentaCorta())).performAs(actor);
        Task.where(actor+" valida que 'Estado' se muestre", WaitUntil.the(ESTADO_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha de ordenanza' se muestre", WaitUntil.the(FECHAORDENANZA_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'Fecha aplicada' se muestre", WaitUntil.the(FECHA_APLICADA_TICKET_TPL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);
        Task.where(actor+" valida que 'ID transacción' se muestre", WaitUntil.the(IDTRANSACCION_TICKET_CEL, isVisible()).forNoMoreThan(1).seconds()).performAs(actor);

    }

    public static ValidaTicketTransferenciaPuntosBALifemiles datosCorrectos(List<Transferencias> transferencias) {
        return Instrumented.instanceOf(ValidaTicketTransferenciaPuntosBALifemiles.class).withProperties(transferencias);
    }
}
