package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class InicioPage extends PageObject {

    /*Localizadores: Recordar Usuario*/
    public static final Target OPCION_OLVIDASTE_USUARIO = Target.the("link '¿Olvidaste o bloqueaste tu usuario o clave?'")
            .located(By.xpath("//a[@class=\"field-link\"]"));
    public static final Target OPCION_OLVIDE_USUARIO = Target.the("opción 'Olvidé mi usuario'")
            .located(By.xpath("//a/span[.='Olvidé mi usuario']"));
    public static final Target SELECCIONAR_TIPO_DOCUMENTO = Target.the("'Lista tipo documento'")
            .located(By.xpath("//div[@class='selectize-input items not-full has-options']"));
    public static final Target CAMPO_IDENTIFICACION = Target.the("campo 'Identificación'")
            .located(By.name("documentNumber"));
    public static final Target BOTON_INGRESAR = Target.the("botón 'Continuar'")
            .located(By.xpath("(//*/div[2]/button/span[1]/span)[2]"));
    public static final Target BTN_CONTINUAR1 = Target.the("Boton Continar")
            .locatedBy("(//*/div[2]/button/span[1]/span)");
    public static final Target BOTON_CONTINUAR_RECORDAR_USU = Target.the("botón 'Continuar'")
            .located(By.xpath("//*/div[2]/button/span[1]/span"));
    public static final Target LABEL_NUEVA_CLAVE = Target.the("label 'Vuelve a escribir la clave'")
            .located(By.xpath("//span[contains(text(),'Nueva clave')]"));
    public static final Target SELECCIONAR_TIPO_DOCUMENTO_2 = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown single']/div/div[contains(text(), '{0}')]");
    public static final Target LBL_USUARIO_RECUPERADO = Target.the("'¡Tu usuario ha sido recuperado con éxito!'")
            .located(By.xpath("//div/span[.='¡Tu usuario ha sido recuperado con éxito!']"));
    public static final Target BTN_FINALIZAR = Target.the("Botón 'Finalizar'")
            .located(By.xpath("//button[@type='button']"));
    public static final Target BTN_ACEPTAR=Target.the("Botón Aceptar cambio clave")
            .located(By.xpath("//div/button/span[.=\"Aceptar\"]"));
    public static final Target LABEL = Target.the("'Bienvenido a e-banca Personas'")
            .located(By.xpath("//span[contains(text(),'Bienvenido a e-banca Personas')]"));
    public static final Target TLT_RECUPERACION_USUARIO_CLAVE = Target.the("'Recuperación de usuario o clave'")
            .located(By.xpath("//span[contains(text(),'Recuperación de usuario o clave')]"));
    public static final Target BUTTON_RECOVER = Target.the("Boton para recuperar contra y usuario").
            locatedBy("//a/span[1][.=\"¿No puedes ingresar?\"]");

    /*Localizadores: Desbloquear Usuario*/
    public static final Target BTN_DESBLOQUEAR_USUARIO = Target.the("Botón 'Desbloquear Usuario'")
            .located(By.xpath("//*[@class = \"recover-user-title\"]/span[.=\"Desbloquear usuario\"]"));
    public static final Target BTN_RECUPERAR_CLAVE = Target.the("botón 'Recuperar Clave'")
            .located(By.xpath("//*[@class=\"recover-user-title\"]/span[.= \"Recuperar clave\"]"));
    public static final Target LBL_USUARIO_DESBLOQUEADO = Target.the("'Usuario desbloqueado con éxito'")
            .located(By.xpath("//span[.='Usuario desbloqueado con éxito']"));

    /*Localizadores: Recuperar clave*/
    public static final Target TXT_NUEVACLAVE = Target.the("'Clave nueva'")
            .located(By.xpath("//input[@id='_newPassword']"));
    public static final Target TXT_CONFIRMAR_NUEVACLAVE = Target.the("'Confirmacion de clave nueva'")
            .located(By.xpath("//input[@id='_newPasswordConfirmation']"));
    public static final Target LABEL_CLAVE_MODIFICADA = Target.the("'Clave modificada con exito'")
            .located(By.xpath("//h2"));

    public static final Target BOTON_REINTENTAR = Target.the("'Clave modificada con exito'")
            .located(By.xpath("//*[@id='root']/div/div/article/div/div[2]/button"));

    private InicioPage() {
    }
}
