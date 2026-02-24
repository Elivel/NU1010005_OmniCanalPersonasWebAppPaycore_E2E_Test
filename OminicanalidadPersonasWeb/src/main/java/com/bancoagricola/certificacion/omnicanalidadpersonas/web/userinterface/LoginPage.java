package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {

    /*Localizadores utilidad Obtener código telebanca*/
    public static final Target TXT_USUARIO=Target.the("campo 'Usuario'")
            .located(By.xpath("//span[contains(text(),'Usuario')]//following::input[1]"));
    public static final Target BTN_CONTINUAR=Target.the("botón 'Continuar'")
            .located(By.xpath("//*[@type='submit']"));
    public static final Target TXT_PASSWORD =Target.the("campo 'Clave'")
            .located(By.xpath("//input[@type='password']"));
    public static final Target LBL_CLAVE =Target.the("label 'Clave'")
            .located(By.xpath("//span[contains(text(),'Clave')]"));

    /*Localizadores utilidad Obtener código telebanca*/
    public static final Target LBL_OBTENER_CODIGO_TELEBANCA=Target.the("link 'Obtener mi código por Telebanca'")
            .located(By.xpath("//div[@class='field-wrapper undefined']/p"));
    public static final Target LBL_OBTENER_CODIGO_TELEBANCA2=Target.the("link 'Obtener mi código por Telebanca'")
            .located(By.xpath("//div[@class='field-link-wrapper']/a/span[.='Obtener mi código por Telebanca']"));
    public static final Target TXT_CODIGO_CONFIRMACION=Target.the("campo 'Código confirmación'")
            .located(By.xpath("//input[@type='password']"));
    public static final Target TTL_PARACONTINUAR=Target.the("'Para continuar con el proceso llama al 2210-0055. Si resides en el exterior llama al 1-877-824-6772, opción 3-2.'")
         //  .located(By.xpath("//div[@class='field-wrapper intro-code']/span/span[contains(text(),'Para continuar con el proceso llama al 2210-0000 opción 4-1-7. ')]"));
            .locatedBy("//span[@class='token-intro']");

    //Actualizacion de password para usuario ya logueado
    public static final Target ICONO_CLAVE_DE_ACCESO=Target.the("opción 'Clave de acceso'")
            .located(By.xpath("//li[@class='icon-password']"));
    public static final Target TTL_CAMBIO_CLAVE=Target.the("titulo 'Cambio de clave'")
            .located(By.xpath("//h2/span[.='Cambio de clave']"));
    public static final Target CLAVE_ACTUAL=Target.the("'Clave actual'")
            .located(By.xpath("//input[@id='_currentPassword']"));
    public static final Target NUEVA_CLAVE=Target.the("'Nueva clave'")
            .located(By.xpath("//input[@id='_newPassword']"));
    public static final Target REPETIR_NUEVA_CLAVE=Target.the("'Repetir nueva clave'")
            .located(By.xpath("//input[@id='_newPasswordConfirmation']"));

    public static final Target BOTON_GUARDAR=Target.the("botón 'Guardar'")
            .located(By.xpath("//button/span[.='Guardar']"));
    public static final Target MSG_CONFIRMACION=Target.the("'La clave se cambió exitosamente'")
            .locatedBy("//p[@class=\"icon-\"][.=\"La clave se cambió exitosamente\"]");
    public static final Target OPCION_SALIR=Target.the("opción 'Salir'")
            .located(By.xpath("//li[@class='icon-logout']/a/span"));
    public static final Target CERRAR_SESION=Target.the("titulo 'Cerrar sesión'")
            .located(By.xpath("//h2/span"));
    public static final Target BOTON_CERRAR_SESION=Target.the("botón 'Cerrar sesión'")
            .located(By.xpath("//button[@type='button']"));
    public static final Target TTL_BIENVENIDO=Target.the("'Bienvenido a e-banca Personas'")
            .located(By.xpath("//span[.='Bienvenido a e-banca Personas']"));
    public static final Target VERSION_APP=Target.the("'Versión de la aplicación'")
            .located(By.xpath("//p[@class='app-version']"));




    private LoginPage() {
    }
}
