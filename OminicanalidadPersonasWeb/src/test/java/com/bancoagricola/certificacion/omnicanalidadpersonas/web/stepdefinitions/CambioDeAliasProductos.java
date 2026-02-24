package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.CambioAliasProducto;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.SelecciónProducto;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actions.Click;

import javax.xml.crypto.Data;
import java.util.List;


import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.MAS_DETALLE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class CambioDeAliasProductos {
    @Dado("^El cliente Selecciona el producto$")
    public void elClienteSeleccionaElProducto(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                SelecciónProducto.datosP(amortiTabla)
        );

    }

    @Cuando("^Se dirige a la opción de 'Más detalle'$")
    public void seDirigeALaOpciónDeMásDetalle() {
        theActorInTheSpotlight().attemptsTo(
                Click.on(MAS_DETALLE)
        );
    }


    @Entonces("^Cambia el Alias del producto y se regresa a su nombre original (.*)$")
    public void cambiaElAliasDelProductoYSeRegresaASuNombreOriginal(String CuentaOrigen) {
        theActorInTheSpotlight().attemptsTo(
                CambioAliasProducto.datos(CuentaOrigen)
        );
    }


}
