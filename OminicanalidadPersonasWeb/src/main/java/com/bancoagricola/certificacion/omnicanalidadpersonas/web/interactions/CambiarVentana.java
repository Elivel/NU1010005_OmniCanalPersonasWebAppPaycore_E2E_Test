package com.bancoagricola.certificacion.omnicanalidadpersonas.web.interactions;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.annotations.Screenshots;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


import net.serenitybdd.annotations.Step;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import static junit.framework.TestCase.assertEquals;

public class CambiarVentana implements Interaction {

    private static final Logger LOGGER = Logger.getLogger(CambiarVentana.class.getName());

    @Step("{0} 'cambia de pestaña y se muestra el documento'")
    @Override
    @Screenshots(forEachAction = true)
    public <T extends Actor> void performAs(T actor) {

        LeerArchivoProperties.esperar(45);
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        LOGGER.log(Level.INFO, "Tabs: \"{0}\"", tabs.size());
        int numTabs = tabs.size();
        assertEquals("No se muestra la pestaña con el documento, favor validar", 2, numTabs);
        driver.switchTo().window(tabs.get(1));
        driver.manage().window();
        LeerArchivoProperties.esperar(5);

    }

    public static CambiarVentana nueva() {

        return Instrumented.instanceOf(CambiarVentana.class).withProperties();
    }

}
