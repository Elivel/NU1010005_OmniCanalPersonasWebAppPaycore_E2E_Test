package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.annotations.Step;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;
import org.openqa.selenium.JavascriptExecutor;

import java.util.logging.Logger;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.CMB_COMPAÑIA;
import static junit.framework.TestCase.assertEquals;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SeleccionarCompania implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(SeleccionarCompania.class.getName());

    private String compa;

    public SeleccionarCompania(String compa) {
        this.compa = compa;
    }

    @Step("{0} clicks on '#compa''")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LOGGER.info(compa);
        int seleccionar1 = 0;
        for (WebElementFacade compania : CMB_COMPAÑIA.resolveAllFor(theActorInTheSpotlight())) {
            if (compania.getAttribute("innerText").equals(compa)) {
                JavascriptExecutor je = (JavascriptExecutor) ThucydidesWebDriverSupport.getProxiedDriver();
                je.executeScript("arguments[0].scrollIntoView(true);", compania);
                compania.click();
                seleccionar1 = 1;
                break;
            }
        }
        assertEquals("No se muestra la compañia: " + compa,1,seleccionar1);
        LeerArchivoProperties.esperar(1);
    }

    public static SeleccionarCompania datosCA(String compa) {
        return Instrumented.instanceOf(SeleccionarCompania.class).withProperties(compa);
    }
}
