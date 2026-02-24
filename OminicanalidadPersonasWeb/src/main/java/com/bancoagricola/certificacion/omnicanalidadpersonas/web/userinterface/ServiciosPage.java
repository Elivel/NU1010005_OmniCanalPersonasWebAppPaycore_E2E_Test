package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class ServiciosPage {

    public static final Target MENU_SERVICIOS = Target.the("menú 'Servicios'")
            .locatedBy("//a[@class='icon-services']/span[.='Servicios']");
    public static final Target TTL_SERVICIOS = Target.the("titulo 'Servicios'")
            .locatedBy("//h2[@class='form-title']/span");
    public static final Target NOTIF_VIAJEROS = Target.the("opción 'Notificación de viajeros'")
            .locatedBy("//a[@class='round-button icon-traveler']/span");
    public static final Target SUBTTL_SELECC_TARJ = Target.the("'Selecciona las tarjetas a notificar'")
            .locatedBy("//span[contains(text(),'Selecciona las tarjetas a notificar')]");
    public static final Target SELECC_TARJ_VIAJEROS = Target.the("selecciona tarjeta '{0}'")
            .locatedBy("//li[@class='travelerNotification-list']//span[contains(text(),'{0}')]");
    public static final Target SUBTTL_TARJETAS = Target.the("'Selecciona las tarjetas a notificar'")
            .locatedBy("//label[contains(text(),'Tarjetas')]");
    public static final Target LABEL_FECHA_SALIDA = Target.the("'Fecha de salida'")
            .locatedBy("//label[contains(text(),'Fecha de salida')]");
    public static final Target FECHA_SALIDA = Target.the("'Fecha de salida'")
            .located(By.id("outDateWrapper"));
    public static final Target FECHA_REGRESO = Target.the("'Fecha de regreso'")
            .located(By.id("returnDateWrapper"));
    public static final Target PAISES_DESTINO = Target.the("'Países destino'")
            .locatedBy("//div[@class='form-line-wrapper'][2]//div[@class='field-container']//input");
    public static final Target COMENTARIOS = Target.the("'Comentarios'")
            .locatedBy("//div[@class='form-line-wrapper'][3]//div[@class='field-container']//input");
    public static final Target VENT_EMERG_NV = Target.the("'Ventana emergente de confirmación'")
            .locatedBy("//div[@class='popup scrollable new-popup-confirmation']");
    public static final Target TTL_SOLICITUD_EXITOSA = Target.the("'La solicitud se realizó exitosamente'")
            .locatedBy("//span[contains(text(),'La solicitud se realizó exitosamente')]");
    public static final Target FLECHA_ADELANTE_S= Target.the("'Fecha adeltante'")
            .locatedBy("//*[@id='outDateWrapper']/div/table[1]/tbody/tr/td[3]");
    public static final Target FECHA_HOY_NV_SALIDA= Target.the("'Fecha de salida'")
            .locatedBy("//*[@id='outDateWrapper']/div/table[1]/tbody/tr/td[2]");
    public static final Target CAL_DIA1_NV_S= Target.the("'Dia'")
            .locatedBy("//*[@id='outDateWrapper']/div/table[2]/tr/td");
    public static final Target FECHA_HOY_NV_REGRESO= Target.the("'Fecha de regreso'")
            .locatedBy("//*[@id='returnDateWrapper']/div/table[1]/tbody/tr/td[2]");
    public static final Target CAL_DIA1_NV_R= Target.the("'Dia'")
            .locatedBy("//*[@id='returnDateWrapper']/div/table[2]/tr/td");
    public static final Target FLECHA_ADELANTE_R= Target.the("'Fecha adeltante'")
            .locatedBy("//*[@id='returnDateWrapper']/div/table[1]/tbody/tr/td[3]");
    public static final Target SELECC_TODAS= Target.the("link 'Seleccionar todas'")
            .locatedBy("//span[contains(text(),'Seleccionar todas')]");
    public static final Target AUDITORIATRX= Target.the("link 'Auditoría de transacciones'")
           .locatedBy("//span[contains(text(),'Auditoría de transacciones')]");
    public static final Target TTL_AUDITORIATRX= Target.the("'Auditoría de transacciones'")
            .locatedBy("//h2[@class='page-subtitle export']/span");
    public static final Target BTN_FILTRAR= Target.the("opción 'Filtrar'")
            .locatedBy("//a[@class='pull-right']/span[.='Filtrar']");
    public static final Target OPC_HOY= Target.the("opción 'Hoy'")
            .locatedBy("//span[contains(text(),'Hoy')]");
    public static final Target BTN_BUSCAR= Target.the("botón 'Buscar'")
            .locatedBy("(//*/button)[3]");
    public static final Target REG_TABLA_MONTO= Target.the("botón 'Buscar'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[3]");
    public static final Target ACTIVA_LISTA_CTAPRINCIPAL =Target.the("Activa lista de opciones de cuentas principales")
            .locatedBy("(//*[@class='selectize-control single'])[2]");
    public static final Target SELECCIONAR_CTA_PRINCIPAL =Target.the("Selecciona opción de lista cuentas principales")
            .locatedBy("(//*/div[@class='selectize-dropdown-content'])[2]/div[contains(text(),'{0}')]");
    public static final Target SELECCIONAR_CTA_ASOCIAR =Target.the("Selecciona opción de lista cuentas principales")
            .locatedBy("//li[@class='check-elements without-padding-left']/div/span/span[contains(text(),'{0}')]/../../../span");
    public static final Target CAPTURA_CTA_PRINCIPAL =Target.the("Captura Cta Principal Actual")
            .locatedBy("(//div[@class='item'])[2]");
    public static final Target BTN_FINALIZAR_SEV =Target.the("Botón 'Finalizar'")
            .locatedBy("//div[@class='button-row confirmation-component']/a[.='Finalizar']");
    public static final Target VENT_EMERG =Target.the("'Ventana emergente de confirmación'")
            .locatedBy("//div[@class='popup popup-text-center scrollable preview new-popup-confirmation']");

    //Auditoria filtros
    public static final Target FILTROS_ADICIONALES =Target.the("link 'Ver filtros adicionales'")
            .locatedBy("//span[normalize-space()='Ver filtros adicionales']");
    public static final Target PERIODO_TIEMPO =Target.the("'Período de tiempo'")
            .locatedBy("//h2/span[.='Período de tiempo']");

    public static final Target TIPO_TRX =Target.the("'Tipo de transacción'")
            .locatedBy("//div[@class='field-wrapper field-select']//span[contains(text(),'Tipo de transacción')]");
    public static final Target OPC_TIPO_CMB =Target.the("'Tipo de transacción'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target OPC_ESTADO_CMB =Target.the("'Estado'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target OP_CANAL_CMB =Target.the("'Canal'")
            .locatedBy("(//div[@class='selectize-control single'])[3]");
    public static final Target SELECCIONA_OPC =Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']/div[contains(text(),'{0}')]");
    public static final Target TABLA_RES = Target.the("'Tabla de resultados'")
            //.locatedBy("//div[@class='table-wrapper']/table");
            .locatedBy("//table[@class='selectable']");
    public static final Target OP_TIPO_TRX_TRANS_PROP=Target.the("Opción transferencias propias")
            .locatedBy("//div[contains(text(),'Transferencia cuentas propias')]");
    public static final Target CM_TIPO_TRX_AUDI= Target.the("Combo tipo de transacción")
            .locatedBy("//span[contains(text(),'Ocultar filtros adicionales')]//following::div[4]");

    public static final Target REG_TABLA_RES = Target.the("'Registros en tabla resultados'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr");
    public static final Target DESDE_AUDTRX = Target.the("'Desde'")
            .locatedBy("(//div[@class='field-container'])[3]/input");
    public static final Target HASTA_AUDTRX = Target.the("'Desde'")
            .locatedBy("(//div[@class='field-container'])[4]/input");
    public static final Target TIPO_TRX_COLUMNA = Target.the("'Tipo de transacción'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[1]");
    public static final Target MONTO_COLUMNA = Target.the("'Monto'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[3]//span[@class='currency-amount']");
    public static final Target ESTADO_COLUMNA = Target.the("'Tipo de transacción'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[8]");

    //Solicitudes de estado de créditos
    public static final Target SOLIC_ESTCRED = Target.the("link 'Consulta solicitudes de créditos'")
            .locatedBy("//a[@class='round-button']/span[.='Consulta solicitudes de créditos']");
    public static final Target TTL_SOLIC_ESTCRED = Target.the("'Consulta solicitudes de créditos'")
            .locatedBy("//h2/span");
    public static final Target SOLICITUD = Target.the("'{0}'")
            .locatedBy("//tbody//tr/td[contains(text(),'{0}')]/../td[1]");
    public static final Target PRODUCTO = Target.the("'{0}'")
            .locatedBy("//tbody//tr/td[contains(text(),'{0}')]/../td[2]");
    public static final Target TTL_CONSUL_SOLIC_ESTCRED = Target.the("'Consulta de gestión de solicitudes de créditos en Banco Agrícola.'")
            .locatedBy("//h2[@class='page-title centered']/span");
    public static final Target SOLICITUD2 = Target.the("'Número de solicitud'")
            .locatedBy("(//div[@class='form-section-wrapper']/div/div/span)[2]");
    public static final Target PRODUCTO2 = Target.the("'Nombre del producto'")
            .locatedBy("(//div[@class='form-section-wrapper']/div/div/span)[3]");
    public static final Target NO_HAY_SOLICTUDES = Target.the("'No se encontraron solicitudes'")
            .locatedBy("//span[contains(text(),'No se encontraron solicitudes')]");

    //Cálculo de Cuota y Tabla de Amortización
    public static final Target LNK_CCTA = Target.the("link 'Cálculo de Cuota y Tabla de Amortización'")
            .locatedBy("//a[@class='round-button']/span[.='Cálculo de Cuota y Tabla de Amortización']");
    public static final Target TTL_CCTA = Target.the("'Cálculo de Cuota y Tabla de Amortización'")
            .locatedBy("//h2/span");
    public static final Target MONTO = Target.the("'Monto'")
            .locatedBy("(//div[@class='field-container']//input)[1]");
    public static final Target TASA_INTERES = Target.the("'Tasa de interés'")
            .locatedBy("(//div[@class='field-container']//input)[2]");
    public static final Target PLAZO = Target.the("'Plazo'")
            .locatedBy("(//div[@class='field-container']//input)[4]");
    public static final Target SELECTOR_PLAZO = Target.the("'Selector de plazo'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target SELECTOR_PLAZO_OPCION = Target.the("'{0}'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[1]/div[contains(text(),'{0}')]");
    public static final Target SELECTOR_FRECUENCIA_PAGO = Target.the("'Frecuencia de Pago'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target SELECTOR_FRECUENCIA_PAGO_OPCION = Target.the("'{0}'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[2]/div[contains(text(),'{0}')]");
    public static final Target BTN_CALCULAR = Target.the("'Calcular'")
            .locatedBy("//span[contains(text(),'Calcular')]");
    public static final Target TABLA_AMORTIZ = Target.the("'Tabla de amortización'")
            .locatedBy("//div[@class='table-wrapper table-scroll']/table");
    public static final Target REG_TA = Target.the("'Registros tabla de amortización'")
            .locatedBy("//div[@class='table-wrapper table-scroll']/table/tbody/tr/td[1]");

    //Consulta puntos sorteo
    public static final Target LNK_CONSULTA_PUNTOS_SORTEO = Target.the("link 'Consulta puntos de sorteo'")
            .locatedBy("//a[@class='round-button']/span[.='Consulta puntos de sorteo']");
    public static final Target TTL_CONSULTA_PUNTOS_SORTEO = Target.the("titulo 'Consulta puntos de sorteo'")
            .locatedBy("//h2/span");
    public static final Target TABLA_PROMOCIONES = Target.the("tabla 'Promociones'")
            .locatedBy("//div[@class='table-wrapper movements']/table");
    public static final Target PROMOCION_SELECCIONADO = Target.the("'{0}'")
            .locatedBy("//div[@class='table-wrapper movements']/table/tbody/tr/td[contains(text(),'{0}')]");
    public static final Target DETALLE_PUNTOS_SORTEO = Target.the("'Detalle de puntos de sorteo'")
            .locatedBy("//span[contains(text(),'Detalle de puntos de sorteo')]");
    public static final Target NOMBRE_PROMOCION1 = Target.the("'Nombre de la promoción'")
            .locatedBy("//table/tbody/tr/td[contains(text(),'{0}')]/../td[1]");
    public static final Target PUNTOS_ACUMULADOS1 = Target.the("'Puntos acumulados'")
            .locatedBy("//table/tbody/tr/td[contains(text(),'{0}')]/../td[2]");
    public static final Target FECHA_INIC_PROM1 = Target.the("'Fecha inicio de la promoción'")
            .locatedBy("//table/tbody/tr/td[contains(text(),'{0}')]/../td[3]");
    public static final Target FECHA_FIN_PROM1 = Target.the("'Fecha fin de la promoción'")
            .locatedBy("//table/tbody/tr/td[contains(text(),'{0}')]/../td[4]");
    public static final Target NOMBRE_PROMOCION2 = Target.the("'Nombre de la promoción'")
            .locatedBy("//dl[@class='product-detail-list'][1]/dd");
    public static final Target PUNTOS_ACUMULADOS2 = Target.the("'Puntos acumulados'")
            .locatedBy("//dl[@class='product-detail-list'][4]/dd");
    public static final Target FECHA_INIC_PROM2 = Target.the("'Fecha inicio de la promoción'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dd");
    public static final Target FECHA_FIN_PROM2 = Target.the("'Fecha fin de la promoción'")
            .locatedBy("//dl[@class='product-detail-list'][3]/dd");
    public static final Target TABLA_FECHA_ASIGNACION_PUNTOS = Target.the("tabla 'Fecha de asignación de puntos'")
            .locatedBy("//div[@class='table-wrapper']/table");


    // Emisión de Constancia Renta
    public static final Target BTN_CONSTANCIA_RENTA = Target.the("botón de Constancia Renta")
            .locatedBy("//span[contains(text(),'Constancia de renta')]");
    public static final Target SELECTOR_AÑO_RENTA = Target.the("Selector de año de constancia de renta")
            .locatedBy("*//div[@class=\"field-container\"]");
    public static final Target AÑO_RENTA = Target.the("Año a emitir Constancia")
            .locatedBy("//div[@class='selectize-dropdown-content']/div[@data-value='{0}']");
    public static final Target BTN_EMITIR = Target.the("Botón Emitir")
            .locatedBy("*//button[@class= \"button    undefined\"]");

    public static final Target TTL_CONSTANCIA_RENTA = Target.the("Titulo Constancia Renta")
            .locatedBy("//span[contains(text(),'Constancia de renta')]");

    public static final Target BTN_IMPRIMIR = Target.the("Bototn Imprimir")
            .locatedBy("*//div[@class=\"button-row\"]/button/span[.=\"Imprimir\"]");

    //Emisión Constancia LIOF
    public static final Target BTN_CONS_LIOF = Target.the("Botón Constancia LIOF")
                .locatedBy("[href^=\"/services/liofTestimony\"]");
    public static final Target TITLE_CONS_LIOF = Target.the("Titulo de Constancia LIOF")
            .locatedBy("//h2[@class=\"page-subtitle\"]");
    public static final Target SELECTOR_AÑO = Target.the("Selector dropdown")
            .locatedBy("(*//div[@class=\"selectize-control single\"])[1]");
    public static final Target SELECTOR_MES = Target.the("Selector de mes dropdown")
            .locatedBy("(*//div[@class=\"selectize-control single\"])[2]");
    public static final Target AÑO_SELECT = Target.the("Selector Año")
            .locatedBy("//div[@class=\"selectize-dropdown-content\"]/div[.='{0}']");
    public static final Target MES_SELECT = Target.the("Selector Mes")
            .locatedBy("//div[@class=\"selectize-dropdown-content\"]/div[.='{0}']");

    //PAGINA INICIO
    public static final Target TITLE_INICIO = Target.the("Titulo Inicial").locatedBy("//span[contains(text(),'Bienvenido/a Erick Renderos')]");
    //boton cerrar Sesión:
    public static final Target FNL_SESION = Target.the("BNT Finalizar Sesión").locatedBy("//span[contains(text(),'Salir')]");
    public static final Target CONFIRMAR_FNLSESION = Target.the("Botón Finalizar Sesión").locatedBy("//*[@class=\"button    undefined\"]");
    private ServiciosPage() {
    }
}
