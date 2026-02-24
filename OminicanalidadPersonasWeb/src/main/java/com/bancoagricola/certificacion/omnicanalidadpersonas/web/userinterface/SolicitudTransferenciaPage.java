package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SolicitudTransferenciaPage {
    public static final Target CUENTA_BENEFICIARIO = Target.the("'Cuenta beneficiario'")
            .located(By.name("beneficiaryAccount"));
    public static final Target NOMBRE_BENEFICIARIO = Target.the("'Nombre beneficiario'")
            .located(By.name("beneficiaryName"));
    public static final Target DIRECCION_BENEFICIARIO = Target.the("'Dirección beneficiario'")
            .located(By.name("beneficiaryAddress"));
    public static final Target ACTIVAR_FILTRO_PAIS = Target.the("'Filtro País'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target ACTIVAR_FILTRO_TIPO_RED = Target.the("'Filtro Tipo Red'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target SELECCIONAR_OPCION_FILTRO = Target.the("'{0}'")
            .locatedBy("(//div[.='{0}'])[1]");
    public static final Target ICONO_LUPA = Target.the("icono 'Lupa'")
            .locatedBy("//*[@class='field-postfix icon-search']");
    public static final Target ICONO_BORRAR = Target.the("icono 'Borrar'")
            .locatedBy("//*/div/ul/li/div/a");

    public static final Target LNK_CARGAR_P = Target.the("link 'Cargar plantilla'")
            .locatedBy("//div[@class='load-template']/a/span[.='Cargar plantilla']");

    public static final Target BOTTON_REALIZAR_OTRA_SOL = Target.the("botón 'Realizar otra solicitud'")
            .locatedBy("//button[@type='button']/span[.='Realizar otra solicitud']");
    public static final Target NO_HAY_PLANTILLA = Target.the("'No hay plantillas para listar'")
            .locatedBy("//span[contains(text(),'No hay plantillas para listar')]");
    public static final Target BTN_CERRAR=Target.the("botón 'Cerrar'")
            .located(By.xpath("//span[contains(text(),'Cerrar')]"));
        public static final Target TXT_CODIGO_BANCO = Target.the("'Código del banco'")
            .locatedBy("//*[@class='popup popup-banks scrollable']/div/div[2]/div/input");
    public static final Target ACTIVAR_FILTRO_MONEDA = Target.the("'Filtro Moneda'")
            .locatedBy("(//div[@class='selectize-control single'])[5]");
    public static final Target ACTIVAR_FILTRO_NIVEL1 = Target.the("'Filtro Nivel1'")
            .locatedBy("(//div[@class='selectize-control single'])[6]");
    public static final Target ACTIVAR_FILTRO_NIVEL2 = Target.the("'Filtro Nivel2'")
            .locatedBy("(//div[@class='selectize-control single'])[7]");
    public static final Target TXT_DETALLE = Target.the("'Detalle regulatorio'")
            .located(By.name("details"));
    public static final Target NOMBRE_PLANTILLA = Target.the("'Filtro Nivel1'")
            .locatedBy("//span[contains(text(),'Escriba un nombre para la plantilla')]//following::input");

}
