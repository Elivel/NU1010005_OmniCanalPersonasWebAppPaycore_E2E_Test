package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class TransferenciasLinksPage {
    public static final Target lINK_APOYO_TELETON =Target.the("lnk 'Ayuda Teleton'")
            .locatedBy("//a[@class='round-button icon-teleton']/span");
    public static final Target LINK_TRANSFERENCIAS_TRANSFER365 =Target.the("link 'Transferencias Transfer365: Operaciones entre bancos'")
            .locatedBy("//a[@class='round-button icon-local-transfer']/span[.='Transferencias Transfer365: Operaciones entre bancos']");

    public static final Target LINK_TRANSFERENCIAS_TRANSFER365_MOVIL =Target.the("link 'Transfer365 Móvil'")
            .locatedBy("//a[@class='round-button icon-phone-money']/span[.='Transfer365 Móvil']");
    public static final Target TTL_TRANSFERENCIAS_TRANSFER365_MOVIL =Target.the("titulo 'Transfer365 Móvil'")
            .locatedBy("//h2/span[.='Transfer365 Móvil']");
    public static final Target LINK_PAGO_PRESTAMO_TRANSFER365 =Target.the("link 'Pago de préstamo Transfer365: Operaciones entre bancos'")
            .locatedBy("//span[.='Pago de préstamo Transfer365: Operaciones entre bancos']");
    public static final Target LINK_OBTENER_CODIGO_TELEBANCA =Target.the("link 'Obtener mi código por Telebanca'")
            .locatedBy("//span[.='Obtener mi código por Telebanca']");
    public static final Target LINK_PAGO_TARJETA_TRANSFER365 =Target.the("link 'Pago de tarjeta Transfer365: Operaciones entre bancos'")
            .locatedBy("//span[.='Pago de tarjeta Transfer365: Operaciones entre bancos']");
    public static final Target LINK_PAGOES =Target.the("'P@goes'")
            .locatedBy("//a[@class='round-button icon-reservefund']/span");
    public static final Target TTL_PAGOS =Target.the("'Pagos'")
            .locatedBy("//span[contains(text(),'Pagos')]");
    public static final Target LINK_TRANSFERENCIA_TRANSFER365_CA_RD =Target.the("link 'Transferencia Transfer365 CA-RD'")
            .locatedBy("//span[contains(text(),'Transfer365 CA-RD')]");
    public static final Target TTL_TRANSFERENCIAS_TRANSFER365_CA_RD =Target.the("titulo 'Transfer365 CA-RD'")
            .locatedBy("//h2/span[.='Transfer365 CA-RD']");





}
