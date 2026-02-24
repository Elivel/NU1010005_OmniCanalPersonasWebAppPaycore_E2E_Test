package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

public class Limites {

    public static final Target LIMITES= Target.the("Opción 'Gestión de límites'")
            .locatedBy("//li[@class='icon-limits']//a");
    public static final Target TTL_LIMITES= Target.the("Titulo 'Gestión de límites'")
            .locatedBy("//h2[@class='form-title mb-0']//span[contains(text(),'Gestión de límites')]");
    public static final Target LIMACUMSEM_BM= Target.the("'Límite acumulable semanal' para Banca Móvil")
            .locatedBy("(//div[@class='field-container'])[1]//input");
    public static final Target LIMPORTRX_BM= Target.the("'Límite por transacción' para Banca Móvil")
            .locatedBy("(//div[@class='field-container'])[6]//input");
    public static final Target MONTOACUM_BM= Target.the("'Monto acumulado a la fecha' para Banca Móvil")
            .locatedBy("(//div[@class='field-container'])[3]//input");
    public static final Target LIMACUMSEM_EBP= Target.the("'Límite acumulable semanal' para e-banca Personas")
            .locatedBy("(//div[@class='field-container'])[2]//input");
    public static final Target LIMPORTRX_EBP= Target.the("'Límite por transacción' para e-banca Personas")
            .locatedBy("(//div[@class='field-container'])[3]//input");
    public static final Target MONTOACUM_EBP= Target.the("'Monto acumulado a la fecha' para e-banca Personas")
            .locatedBy("(//div[@class='field-container'])[6]//input");
    public static final Target CONF_LIM_EXIT= Target.the("'Los límites se actualizaron exitosamente'")
            .locatedBy("//span[contains(text(),'Los límites se actualizaron exitosamente')]");
    public static final Target STTL_LIM_EBP= Target.the("'Límites para e-banca Personas'")
            .locatedBy("//span[contains(text(),'Límites para e-banca Personas')]");
    public static final Target MSG_EX_LM_TRX= Target.the("'Esta transacción excede tu límite por transacción autorizado'")
            .locatedBy("//p[contains(text(),'Esta transacción excede tu límite por transacción ')]");
    public static final Target MSG_EX_LM_SEM= Target.the("'Esta transacción excede tu límite por usuario semanal autorizado'")
            .locatedBy("//p[@class='icon-'][.='Esta transacción excede tu límite por usuario semanal autorizado (FLO0009W)']");
    public static final Target MSG_EX_LM_SEM2= Target.the("'Esta transacción excede tu límite por usuario semanal autorizado'")
          //  .locatedBy("//p[contains(text(),'Esta transacción excede tu límite por ambiente sem')]");
            .locatedBy("//p[contains(text(),'Esta transacción excede tu límite por usuario sema')]");





    private Limites() {
    }
}
