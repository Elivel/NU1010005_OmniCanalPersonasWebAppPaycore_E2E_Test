package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.*;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.TransferenciaInternacional;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.GeneralPage.RESULTADOS_TRANSFINT;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.VariablesSesion.REFERENCIA_TICKET_VAR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.SolicitudTransferenciaPage.*;

public class RealizarTranferenciaInternacionalSin implements Task {

    private List<TransferenciaInternacional> datos;

    public RealizarTranferenciaInternacionalSin(List<TransferenciaInternacional> datos) {
        this.datos = datos;
    }

    @Step("{0} 'realiza proceso para transferencia internacional, sin plantilla'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CUENTA_BENEFICIARIO, isEnabled()).forNoMoreThan(5).seconds(),
                SendKeys.of(datos.get(0).getNroCuenta()).into(CUENTA_BENEFICIARIO),
                SendKeys.of(datos.get(0).getNombreBeneficiario()).into(NOMBRE_BENEFICIARIO),
                SendKeys.of(datos.get(0).getDireccionBeneficiario()).into(DIRECCION_BENEFICIARIO),
                WaitUntil.the(ACTIVAR_FILTRO_PAIS, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACTIVAR_FILTRO_PAIS, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACTIVAR_FILTRO_PAIS),
                ClickEn.elElementoConTexto(datos.get(0).getPais()),
                WaitUntil.the(ACTIVAR_FILTRO_TIPO_RED, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACTIVAR_FILTRO_TIPO_RED, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACTIVAR_FILTRO_TIPO_RED),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getTipoRed()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getTipoRed()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getTipoRed())),
                WaitUntil.the(ICONO_LUPA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ICONO_LUPA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ICONO_LUPA),
                SendKeys.of(datos.get(0).getCodigoBan1()).into(TXT_CODIGO_BANCO),
                ClickEn.elElementoConTexto(BUSCAR),
                ClickEn.elElementoConTexto(datos.get(0).getCodigoBan2()),
                WaitUntil.the(ACTIVAR_FILTRO_MONEDA, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACTIVAR_FILTRO_MONEDA, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACTIVAR_FILTRO_MONEDA),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getMoneda()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getMoneda()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getMoneda())),
                SendKeys.of(datos.get(0).getMonto()).into(TXT_MONTO_PAGO),
                WaitUntil.the(ACTIVAR_FILTRO_NIVEL1, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACTIVAR_FILTRO_NIVEL1, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACTIVAR_FILTRO_NIVEL1),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getNivel1()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getNivel1()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getNivel1())),
                WaitUntil.the(ACTIVAR_FILTRO_NIVEL2, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(ACTIVAR_FILTRO_NIVEL2, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(ACTIVAR_FILTRO_NIVEL2),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getNivel2()), isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getNivel2()), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(SELECCIONAR_OPCION_FILTRO.of(datos.get(0).getNivel2())),
                SendKeys.of(datos.get(0).getDetalle()).into(TXT_DETALLE),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_CONTINUAR_PAGAR, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_CONTINUAR_PAGAR));
        LeerArchivoProperties.esperar(2);
        actor.attemptsTo(
                WaitUntil.the(BTN_ACEPTAR_C, isEnabled()).forNoMoreThan(30).seconds(),
                WaitUntil.the(BTN_ACEPTAR_C, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_ACEPTAR_C));
        LeerArchivoProperties.esperar(15);
                //new IngresarClaveDinamica(),
        WaitUntil.the(RESULTADOS_TRANSFINT, isVisible()).forNoMoreThan(30).seconds().performAs(actor);

        actor.remember(REFERENCIA_TICKET_VAR.toString(), REFERENCIA_TICKET.resolveFor(actor).getAttribute(TEXT_CONTENT).substring(12).trim());
        System.out.println("Referencia: "+actor.recall(REFERENCIA_TICKET_VAR.toString()).toString());

        actor.attemptsTo(
                ValidaTicketTransferenciaInternacional.datosCorrectos(datos));
    }

    public static RealizarTranferenciaInternacionalSin plantilla(List<TransferenciaInternacional> datos) {
        return Instrumented.instanceOf(RealizarTranferenciaInternacionalSin.class).withProperties(datos);
    }
}
