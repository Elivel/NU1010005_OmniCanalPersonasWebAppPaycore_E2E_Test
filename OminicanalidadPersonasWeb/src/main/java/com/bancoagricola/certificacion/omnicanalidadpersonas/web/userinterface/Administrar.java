package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class Administrar {

    public static final Target MENU_ADMINISTRAR = Target.the("menú 'Administrar'")
            .locatedBy("//a[@class='icon-administration']");
    public static final Target TTL_USUARIOS = Target.the("titulo 'Usuarios'")
            .locatedBy("//h2[@class='page-subtitle']");
    public static final Target SELCC_USUARIOS = Target.the("selecciona '{0}'")
            .locatedBy("//td[contains(text(),'{0}')]");
    public static final Target TTL_SELCC_USUARIO = Target.the("'Titulo'")
            .locatedBy("//h2[@class='form-title']");
    public static final Target PERMISOS = Target.the("'Permisos'")
            .locatedBy("//span[contains(text(),'Permisos')]");
    public static final Target OPC_PERM = Target.the("'{0}'")
            .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target OPC_PERM_PAG = Target.the("'{0}'")
            .locatedBy("//span[text()='{0}']/../../div/div");
    public static final Target BTN_CONTINUAR = Target.the("botón 'Continuar'")
            .locatedBy("//span[contains(text(),'Continuar')]");
    public static final Target MSG_CONF = Target.the("'Se modificó exitosamente el usuario {0}'")
            .locatedBy("//p[contains(text(),'Se modificó exitosamente el usuario {0}')]");
    public static final Target VOLVER_ESCRITORIO = Target.the("link 'Banco Agricola'")
            .locatedBy("//h1[@class='internal-app-name']/a");
    public static final Target PAGOS = Target.the("'Pagos'")
            .locatedBy("//span[contains(text(),'Pagos')]");
    public static final Target CIEX = Target.the("'CIEX'")
            .locatedBy("//span[contains(text(),'CIEX')]");

    private Administrar() {
    }
}
