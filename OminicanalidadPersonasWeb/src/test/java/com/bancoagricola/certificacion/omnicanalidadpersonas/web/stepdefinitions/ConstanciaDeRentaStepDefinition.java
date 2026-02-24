package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions.CambiarVentana;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConstanciaRenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.TarjetasPage.PDF_ESTADO_CUENTA;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_CONSTANCIA_RENTA;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.Matchers.is;

public class ConstanciaDeRentaStepDefinition {

    @Cuando("^ingrese en el submenu en el apartado de servicios$")
    public void ingreseEnElSubmenuEnElApartadoDeServicios() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MENU_SERVICIOS),
                WaitUntil.the(TTL_SERVICIOS, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Y("^haga click en la opcion 'Constancia de renta'$")
    public void hagaClickEnLaOpcionConstanciaDeRenta() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CONSTANCIA_RENTA),
                WaitUntil.the(TTL_CONSTANCIA_RENTA, isVisible()).forNoMoreThan(10).seconds()
        );
    }

    @Y("^ingrese el año a emitir de su constancia de renta$")
    public void ingreseElAñoAEmitirDeSuConstanciaDeRenta(DataTable dataTable) {
        List<Servicios> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Servicios.class);
        theActorInTheSpotlight().attemptsTo(ConstanciaRenta.datosECR(amortiTabla));
    }

    @Y("^da click en el boton emitir$")
    public void DarClickEnElBotonEmitir() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_EMITIR),
                WaitUntil.the(PDF_ESTADO_CUENTA, isClickable()).forNoMoreThan(60).seconds(),
                Ensure.that(PDF_ESTADO_CUENTA).isDisplayed(),
                Scroll.to(BTN_IMPRIMIR).andAlignToTop(),
                WaitUntil.the(BTN_IMPRIMIR, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(BTN_IMPRIMIR, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(BTN_IMPRIMIR)
        );
    }

    @Entonces("^el cliente valida que se muestre el archivo de 'ConstanciaRenta\\.pdf' en la carpeta$")
    public void elClienteValidaQueSeMuestreElArchivoDeConstanciaRentaPdfEnLaCarpeta() {
        LeerArchivoProperties.esperar(5);
        Ensure.that(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_CONSTANCIA_RENTA)).isEqualTo(true);
    }

}
