package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Comprobante365 {

    public static final Target LABEL_COMPROBANTE = Target.the("'{0}'")
            .locatedBy("//span[contains(text(),'{0}')]");

    public static final Target LABEL_COMPROBANTE2 = Target.the("'{0}'")
            .locatedBy("//label[contains(text(),'{0}')]");

    public static final Target TABLA_FR = Target.the("'Fondos Reservados no favoritos'")
            .located(By.xpath("//tbody/tr[1]/td[3]"));

    public static final Target TABLA_FR_2 = Target.the("'Fondos Reservados favoritos'")
            .located(By.xpath("//tbody/tr[2]/td[3]"));

    public static final Target TABLA_PG = Target.the("'Fondos Reservados PAGOES'")
            .located(By.xpath("//tbody/tr[2]/td[4]"));

    public static final Target TABLA_PG2 = Target.the("'Fondos Reservados PAGOES Tarjeta'")
            .located(By.xpath("//div[@class='table-wrapper']/table/tbody/tr/td[3]"));

    public static final Target REFERENCIA_365 = Target.the("'Referencia'")
            .locatedBy("//*[@class='transfer-code operacion-cheq']");

    public static final Target TABLA_CA = Target.the("'Movimientos de la cuenta de la que se debito/acredito'")
            .located(By.xpath("//tbody/tr[1]/td[4]"));
    public static final Target TABLA_CA2 = Target.the("'Movimientos de la cuenta de la que se debito'")
            .located(By.xpath("//tbody/tr[2]/td[4]"));
    public static final Target TABLA_CA3 = Target.the("'Movimientos de la cuenta de la que se debito/acredito'")
            .located(By.xpath("//tbody/tr[1]/td[6]"));
    public static final Target LABEL_COMPROBANTE3 = Target.the("'LABEL'")
            .locatedBy("(//div[@class='field-wrapper field-input']/span)[{0}]");
    public static final Target VLD_DATA_TRX = Target.the("{0}")
            .locatedBy("//div/div/label[contains(text(),'{0}')]/following::span[1]");
    public static final Target VLD_DATA_COMPROBANTE = Target.the("{0}")
            .locatedBy("//div/label/span[.=\"{0}\"]//following::span[1]");
    public static final Target VLD_DATA_META = Target.the("{0}")
            .locatedBy("//div/label/span[contains(text(),'{0}')]//following::span[1]");
    public static final Target LABEL_COMPROBANTE_NUN_TDC=Target.the("Numero de tarjeta de credito en comprobante")
            .locatedBy("(//label[contains(text(),'Tarjeta')]//following::span)[{0}]");
    public static final Target VLD_365 = Target.the("{0}")
            .locatedBy("//div/label[contains(text(), '{0}')]");

    public static final Target LABEL_COMPROBANTE_MONTO=Target.the("Label de monto en comprobante pago de tdc propia")
            .locatedBy("//label[contains(text(),'Monto del pago')]//following::span[1]");
    public static final Target LABEL_COMPROBANTE_ADS= Target.the("Comprobante ADS monto a debitar")
            .locatedBy("//label[contains(text(),'Monto total debitado')]//following::span[{0}]");
    public static final Target LABEL_COMPROBANTE_ADS_CTA_DES=Target.the("cuenta destino")
            .locatedBy("//label[contains(text(),'Número de cuenta')]//following::span[{0}]");
    public static final Target LABEL_COMPROBANTE_ADS_EMAIL=Target.the("Email")
            .locatedBy("//label[contains(text(),'Correo electrónico')]//following::span[{0}]");
    public static final Target LABEL_COMPROBANTE_ADS_CONCEPTO=Target.the("concepto")
            .locatedBy("//label[contains(text(),'Concepto')]//following::span[{0}]");
    public static final Target LABEL_COMPROBANTE_ADS_CTA_ORIG=Target.the("Cuenta origen")
            .locatedBy("//label[contains(text(),'Cuenta débito')]//following::span[{0}]");



}
