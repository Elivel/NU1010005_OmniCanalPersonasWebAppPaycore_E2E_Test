package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class ProductosDisponiblesPage {

    public static final Target MENU_PRODUCTOS = Target.the("menú 'Productos disponibles para ti'")
            .locatedBy("//a[@class='icon-new-products']/span[.='Productos disponibles para ti']");
    public static final Target TTL_PRD_DISP = Target.the("titulo 'Productos disponibles para ti'")
            .locatedBy("//h2/span");
    public static final Target LNK_SOLIC_OP = Target.the("link 'Solicitar otros productos'")
            .locatedBy("//span[contains(text(),'Solicitar otros productos')]");
    public static final Target TTL_OFERTAS = Target.the("titulo 'Ofertas ideales para ti'")
            .locatedBy("//span[contains(text(),'Ofertas ideales para ti')]");
    public static final Target LNK_CREDICASH = Target.the("opción 'CrediCash'")
            .locatedBy("//span[contains(text(),'CrediCash')]");
    public static final Target TTL_SOLC = Target.the("'Solicitud de productos en línea'")
            .locatedBy("//span[contains(text(),'Solicitud de productos en línea')]");
    public static final Target COD_PAIS_REGION = Target.the("'Código de país/región'")
            .locatedBy("//div[@class='selectize-control single']");
    public static final Target OPC_COD_PAIS_REGION = Target.the("'{0}'")
            .locatedBy("//div[@class='optgroup']//div[.='{0}']");
    public static final Target NUM_TELEF = Target.the("'Número telefónico'")
            .locatedBy("//div[@class='field-container field-with-prefix']/input");
    public static final Target BTN_CONTINUAR_PD = Target.the("'Continuar'")
            .locatedBy("//span[contains(text(),'Continuar')]");
    public static final Target VENTANA_CONF = Target.the("'Ventana de confirmación'")
            .locatedBy("//div[contains(@class,'popup scrollable new-popup-confirmation')]");
    public static final Target BTN_ACEPTAR_PD = Target.the("'Aceptar'")
            .locatedBy("//span[contains(text(),'Aceptar')]");
    public static final Target PGN_RESULTADO = Target.the("'Solicitud de productos en línea - Resultado'")
            .locatedBy("//span[contains(text(),'Solicitud de productos en línea - Resultado')]");
    public static final Target NUMERO_SOLIC = Target.the("'Número de solicitud'")
            .locatedBy("(//div[@class='form-line-wrapper']//span[@class='field-read-only'])[1]");

    private ProductosDisponiblesPage() {
    }
}
