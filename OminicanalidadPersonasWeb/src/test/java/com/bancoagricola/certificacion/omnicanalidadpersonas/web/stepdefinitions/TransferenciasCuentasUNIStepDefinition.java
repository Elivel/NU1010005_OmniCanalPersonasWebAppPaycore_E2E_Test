package com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.TransferenciaUniFavorito;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.TransferenciaUniNuevo;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.TransferenciaUniNuevoCC;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks.ValidaTicketTransferenciaUNI;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.TransformacionALista;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferenciasCuentasUNIStepDefinition {
    @Cuando("^realiza la transferencia a una ctaahorro o corriente de otro banco desde cero$")
    public void realizaLaTransferenciaAUnaCtaahorroOCorrienteDeOtroBancoDesdeCero(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                TransferenciaUniNuevo.datosCorrectos(amortiTabla),
                ValidaTicketTransferenciaUNI.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza la transferencia a una ctaahorro o corriente de otro banco desde cero CC$")
    public void realizaLaTransferenciaAUnaCtaahorroOCorrienteDeOtroBancoDesdeCeroCC(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                TransferenciaUniNuevoCC.datosCorrectos(amortiTabla),
                ValidaTicketTransferenciaUNI.datosCorrectos(amortiTabla));
    }

    @Cuando("^realiza la transferencia a una ctaahorro o corriente de otro banco desde un favorito$")
    public void realizaLaTransferenciaAUnaCtaahorroOCorrienteDeOtroBancoDesdeUnFavorito(DataTable dataTable) {
        List<Transferencias> amortiTabla = TransformacionALista.convertirDataTableALista(dataTable, Transferencias.class);
        theActorInTheSpotlight().attemptsTo(
                TransferenciaUniFavorito.datosCorrectos(amortiTabla));
    }
}