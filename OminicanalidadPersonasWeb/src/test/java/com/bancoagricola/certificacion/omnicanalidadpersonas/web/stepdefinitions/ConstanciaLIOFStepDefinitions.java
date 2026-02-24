package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Servicios;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.questions.ValidaArchivoDescargadoEnLaRuta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConstanciaLIOF;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ConstanciaRenta;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.ServiciosPage.*;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.Constantes.PATH_CONSTANCIA_LIOF;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static org.hamcrest.Matchers.is;

public class ConstanciaLIOFStepDefinitions {

    @Cuando("^haga click en la opción 'Emisión de Constancia LIOF'$")
    public void hagaClickEnLaOpciónEmisiónDeConstanciaLIOF() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(BTN_CONS_LIOF),
                WaitUntil.the(TITLE_CONS_LIOF, isVisible()).forNoMoreThan(30).seconds()

        );

    }


    @Entonces("^Selecciona el año y mes de emisión y hace click en el boton de emitir verá el archivo 'ConstanciaLIOF\\.pdf'\\.$")
    public void seleccionaElAñoYMesDeEmisiónYHaceClickEnElBotonDeEmitirVeráElArchivoConstanciaLIOFPdf(DataTable dataTable) {
        List<Servicios> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Servicios.class);

        theActorInTheSpotlight().attemptsTo(ConstanciaLIOF.datosECL(amortiTabla));
        LeerArchivoProperties.esperar(5);

        // Usamos Ensure para validar que el archivo fue descargado
        Ensure.that(ValidaArchivoDescargadoEnLaRuta.enLaRuta(PATH_CONSTANCIA_LIOF)).isEqualTo(true);
    }


}


