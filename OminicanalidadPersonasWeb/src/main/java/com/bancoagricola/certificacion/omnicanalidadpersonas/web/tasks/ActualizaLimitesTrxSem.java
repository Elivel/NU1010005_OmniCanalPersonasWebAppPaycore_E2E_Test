package com.bancoagricola.certificacion.omnicanalidadpersonas.web.tasks;

import com.bancoagricola.certificacion.omnicanalidadpersonas.web.models.Transferencias;
import com.bancoagricola.certificacion.omnicanalidadpersonas.web.utils.LeerArchivoProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.annotations.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import javax.swing.*;
import java.awt.event.FocusListener;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.AhorrosPage.MENU_PRINC;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.CuentasPage.BOTON_ACEPTAR_PP;
import static com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface.Limites.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ActualizaLimitesTrxSem implements Task {
    private List<Transferencias> datosCAP;

    public ActualizaLimitesTrxSem(List<Transferencias> datosCAP) {
        this.datosCAP = datosCAP;
    }

    @Step("{0} actualiza los valores de 'Límite acumulable semanal' y 'Límite por transacción'")
    @Override
    public <T extends Actor> void performAs(T actor) {
        Transferencias ca = datosCAP.get(0);

        actor.attemptsTo(
                WaitUntil.the(MENU_PRINC, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LIMITES, isEnabled()).forNoMoreThan(60).seconds(),
                WaitUntil.the(LIMITES, isClickable()).forNoMoreThan(60).seconds(),
                Click.on(LIMITES),
                WaitUntil.the(TTL_LIMITES, isEnabled()).forNoMoreThan(60).seconds(),
                ValidaMontoAcumulado.datosP());
        LeerArchivoProperties.esperar(10);

        actor.attemptsTo(
                Task.where("{0} limpia los cuatro inputs",
                        a -> {
                            var driver = net.serenitybdd.screenplay.abilities.BrowseTheWeb.as(a).getDriver();
                            var js     = (org.openqa.selenium.JavascriptExecutor) driver;
                            var actions= new org.openqa.selenium.interactions.Actions(driver);
                            java.util.function.Consumer<net.serenitybdd.screenplay.targets.Target> clear = (field) -> {
                                org.openqa.selenium.WebElement el = field.resolveFor(a);
                                // 1) A la vista y centrado
                                js.executeScript("arguments[0].scrollIntoView({block:'center', inline:'center'});", el);
                                // 2) Intentar click "normal" (mouselike). Si lo interceptan -> fallback JS
                                try {
                                    actions.moveToElement(el).pause(java.time.Duration.ofMillis(80)).click().perform();
                                } catch (org.openqa.selenium.ElementClickInterceptedException e) {
                                    // Forzar focus/click sin importar overlays no bloqueantes
                                    js.executeScript("arguments[0].focus();", el);
                                    js.executeScript("try{arguments[0].click();}catch(e){}", el);
                                }
                                // 3) Borrar con teclas
                                el.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.CONTROL, "a"));
                                el.sendKeys(org.openqa.selenium.Keys.DELETE);
                                el.sendKeys(org.openqa.selenium.Keys.chord(org.openqa.selenium.Keys.COMMAND, "a")); // mac
                                el.sendKeys(org.openqa.selenium.Keys.DELETE);
                                el.sendKeys(org.openqa.selenium.Keys.BACK_SPACE);
                                // 4) Fallback final: vaciar por JS + disparar eventos (por si hay máscara)
                                String v = el.getAttribute("value");
                                if (v != null && !v.isEmpty()) {
                                    js.executeScript(
                                            "arguments[0].value='';" +
                                                    "arguments[0].dispatchEvent(new Event('input',{bubbles:true}));" +
                                                    "arguments[0].dispatchEvent(new Event('change',{bubbles:true}));",
                                            el
                                    );
                                }
                            };
                            // Limpiar los 4
                            clear.accept(LIMACUMSEM_BM);
                            clear.accept(LIMPORTRX_BM);
                            net.serenitybdd.screenplay.actions.Scroll.to(LIMACUMSEM_EBP).andAlignToTop().performAs(a);
                            clear.accept(LIMACUMSEM_EBP);
                            clear.accept(LIMPORTRX_EBP);
                })
        );
        actor.attemptsTo(
                WaitUntil.the(LIMACUMSEM_BM, isEmpty()).forNoMoreThan(10).seconds(),
                SendKeys.of(ca.getLimiteSem()).into(LIMACUMSEM_BM),
                WaitUntil.the(LIMPORTRX_BM, isEmpty()).forNoMoreThan(10).seconds(),
                SendKeys.of(ca.getLimitePorTRX()).into(LIMPORTRX_BM),
                Scroll.to(LIMACUMSEM_EBP).andAlignToTop(),
                WaitUntil.the(LIMACUMSEM_EBP, isEmpty()).forNoMoreThan(10).seconds(),
                SendKeys.of(ca.getLimiteSem()).into(LIMACUMSEM_EBP),
                WaitUntil.the(LIMPORTRX_EBP, isEmpty()).forNoMoreThan(10).seconds(),
                SendKeys.of(ca.getLimitePorTRX()).into(LIMPORTRX_EBP),
                WaitUntil.the(BOTON_ACEPTAR_PP, isClickable()).forNoMoreThan(20).seconds(),
                Click.on(BOTON_ACEPTAR_PP),
                WaitUntil.the(CONF_LIM_EXIT, isEnabled()).forNoMoreThan(120).seconds(),
                Ensure.that(CONF_LIM_EXIT).isDisplayed()
        );
    }

    public static ActualizaLimitesTrxSem datosP(List<Transferencias> datosCAP) {
        return Instrumented.instanceOf(ActualizaLimitesTrxSem.class).withProperties(datosCAP);
    }
}

