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

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.CMB_PAQ_MONTO;
import static junit.framework.TestCase.assertEquals;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class SeleccionaMontoPaqueteSinFav implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(SeleccionaMontoPaqueteSinFav.class.getName());

    private final String monto;

    public SeleccionaMontoPaqueteSinFav(String monto) {
        this.monto = monto;
    }

    @Step("{0} clicks on '#monto''")
    @Override
    public <T extends Actor> void performAs(T actor) {

        LOGGER.info(monto);
        int seleccionar1 = 0;
        for (WebElementFacade montos : CMB_PAQ_MONTO.resolveAllFor(theActorInTheSpotlight())) {
            if (montos.getAttribute("innerText").equals(monto)) {
                JavascriptExecutor je = (JavascriptExecutor) ThucydidesWebDriverSupport.getProxiedDriver();
                je.executeScript("arguments[0].scrollIntoView(true);", montos);
                montos.click();
                seleccionar1 = 1;
                break;
            }
        }
        assertEquals("No se muestra el Paquete/Monto:" + monto,1,seleccionar1);
        LeerArchivoProperties.esperar(1);
    }

    public static SeleccionaMontoPaqueteSinFav datosCA(String monto) {
        return Instrumented.instanceOf(SeleccionaMontoPaqueteSinFav.class).withProperties(monto);
    }
}
