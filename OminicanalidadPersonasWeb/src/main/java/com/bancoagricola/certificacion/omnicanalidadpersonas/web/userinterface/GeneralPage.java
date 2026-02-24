package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class GeneralPage {
    public static final Target OPCION_MENU = Target.the("menú '{0}'")
            .locatedBy("//ul/li/a/span[contains(text(),'{0}')]");
    public static final Target OPCIONES_TRANSFERENCIAS = Target.the("link '{0}'")
            .locatedBy("//ul[@class='item-toolbar left-aligned']/li/a/span[contains(text(),'{0}')]");

    public static final Target OPCION_TRANSFERIR1 = Target.the("button Transferir")
            .locatedBy("//a[@class=\"round-button icon-transfer\"]");

    public static final Target OPCIONES_TRANSFERENCIA2 = Target.the("Btn Transferir")
            .locatedBy("//*/p[@class=\"card-date\"]/span[contains(text(),\"{0}\")]/following::span[contains(text(),\"Transferir\")][1]");
    public static final Target OPCIONES_TRANSFERIR_CTA_DES = Target.the("'{0}'")
            .locatedBy("//ul/li/a/span[1]/span[contains(text(),'{0}')][1]");
    public static final Target OPCIÓN_TRANSF_C = Target.the("botón TransferirQA")
            .locatedBy("//*/a[@class='round-button icon-transfer']");

    public static final Target VENTANA_EM= Target.the("'Ventana emergente'")
            .locatedBy("//div[@class='popup scrollable popup-idea']");
    public static final Target VENTANA_EM_MSG= Target.the("'Selecciona una plantilla de la lista'")
            .locatedBy("//p[@class='form-auxiliar-text popup-cibTitle']/span[.='Selecciona una plantilla de la lista']");
    public static final Target VENTANA_EM_NO_HAY= Target.the("'No hay plantillas para listar'")
            .locatedBy("//p[@class='default-message']/span[.='No hay plantillas para listar']");

    public static final Target RESULTADOS= Target.the("'{0}'")
            .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target BTN_ACEPTAR1= Target.the("botón 'Aceptar'")
            .locatedBy("//div/button/span[.='Aceptar']");
    public static final Target RESULTADOS_TRANSFINT= Target.the("'Solicitud de transferencia internacional - Resultado'")
            .locatedBy("//h2/span[.='Solicitud de transferencia internacional - Resultado']");
    public static final Target RESULTADOS_TRANSF365= Target.the("'Transferencia Transfer365: Operaciones entre bancos pendiente de aplicación'")
            .locatedBy("//h2/span[.='Transferencia Transfer365: Operaciones entre bancos pendiente de aplicación']");
    public static final Target RESULTADOS_PRES365= Target.the("'Pago de préstamo Transfer365: Operaciones entre bancos pendiente de aplicación'")
            .locatedBy("//h2/span[.='Pago de préstamo Transfer365: Operaciones entre bancos pendiente de aplicación']");
    public static final Target RESULTADOS_TARJ365= Target.the("'Pago de tarjeta Transfer365: Operaciones entre bancos pendiente de aplicación'")
            .locatedBy("//h2/span[.='Pago de tarjeta Transfer365: Operaciones entre bancos pendiente de aplicación']");
    public static final Target RESULTADOS_TRANSFE= Target.the("'La transferencia se realizó exitosamente'")
            .locatedBy("//h2/span[.='La transferencia se realizó exitosamente']");

    public static final Target RESULTADOS_SOLC= Target.the("'La solicitud se realizó exitosamente'")
            .locatedBy("//h2/span[.='La solicitud se realizó exitosamente']");
    public static final Target RESULTADOS_EXTRAF= Target.the("'El extrafinanciamiento se pagó exitosamente'")
            .locatedBy("//h2/span[.='El extrafinanciamiento se pagó exitosamente']");
    public static final Target VENTANA_CLAVE_DINAMICA= Target.the("Ventana flotante para ingresar clave dinamica")
            .locatedBy("//div[@class='popup scrollable new-popup-confirmation']");
    public static final Target FAVORITO= Target.the("opción 'Favoritos'")
            .locatedBy("//*/ul/li[@class='icon-fav']/a");
    public static final Target GESTION_FAV= Target.the("'Gestión de favoritos'")
            .locatedBy("//span[contains(text(),'Gestión de favoritos')]");

    private GeneralPage() {
    }
}
