package com.bancoagricola.certificacion.omnicanalidadpersonas.web.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/Imprimir_Exportar/exportar_estadoCuentaTC.feature",
        glue = {"com.bancoagricola.certificacion.omnicanalidadpersonas.web.stepdefinitions", "com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils"},
        snippets = CAMELCASE
)
public class ExportarEstadoCuentaTC {
}
