package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CuentasPage {

    public static final Target OPCION_PAGO_PRESTAMO = Target.the("opción 'Pago de Préstamo'")
            .locatedBy("//ul/li[3]/a/span[.='Pago de préstamo']");
    public static final Target OPCION_PAGO_TARJETA = Target.the("opción 'Pago de tarjeta'")
            .locatedBy("//ul/li[6]/a/span[.='Pago de tarjeta']");
    public static final Target OPCION_TIPO_PAGO = Target.the("opción 'Tipo Pago'")
            .locatedBy(" (//*[@class='selectize-control single'])[1]");
    public static final Target OPCION_OTRO_MONTO = Target.the("opción 'otro monto'")
            .locatedBy("(//*[@class='option'])[1]");
    public static final Target TXT_MONTO = Target.the("'Monto'")
            .locatedBy("//*[@class='field-container']/input");
    public static final Target TXT_MONTO_TERCERO = Target.the("'Monto'")
            .locatedBy("//*[@type='tel']");
    public static final Target TXT_MONTO_PAGO = Target.the("Ingresar monto")
            .locatedBy("//*[@type='tel']");
    public static final Target SELECCIONA_MONTOPAQ = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']/div[.='{0}']");
    public static final Target TXT_CONCEPT2 = Target.the("concepto fav guardado").
            locatedBy("//input[@name='concept']");
    public static final Target TXT_CONCEPTO = Target.the("'Concepto'")
            .located(By.name("concept"));
    public static final Target TXT_CUENTA_TERCERO = Target.the("'Cuenta tercero'")
            .located(By.name("creditProductAccount"));
    public static final Target TXT_CELULAR_TERCERO = Target.the("'Cuenta tercero'")
            .locatedBy("//input[@name='creditProductMobile']");
    public static final Target TXT_NUMERO_CUENTA = Target.the("'Cuenta'")
            .located(By.name("creditProductNumber"));
    public static final Target TXT_CORREO = Target.the("'Correo electrónico'")
            .located(By.name("creditProductEmail"));
    public static final Target BTN_TRANSFERIR = Target.the("botón 'Transferir'")
            .locatedBy("//div[@class='button-row confirmation-component']/button/span");
    public static final Target BTN_TRANSFERIR1 = Target.the("botón 'Transferir'")
            .locatedBy("(//span[.='Transferir'])[1]");
    public static final Target CONFIRMACION_AGENDADA = Target.the("'Confirmación de transferencia programada'")
            .locatedBy("//div[@class='page-information']/h2");
    public static final Target GUARDAR_COMO_PLANTILLA_FOR = Target.the("link 'Guardar como plantilla'")
            .locatedBy("//span[.='Guardar como plantilla']");

    public static final Target BTN_TRANSFER1 = Target.the("botón 'Transferir'")
            .locatedBy("//*/button/span[1]");
    public static final Target BTN_CONTINUAR_PAGAR = Target.the("botón 'Pagar'")
            .locatedBy("//*/button/span[1]");
    public static final Target BTN_CONTINUAR_PAGAR2 = Target.the("botón 'Continuar'")
            .locatedBy("//div/button/span[.='Continuar']");

    public static final Target BTN_ACEPTAR_C = Target.the("botón 'Aceptar'")
            .locatedBy("//*/button/span[.='Aceptar']");
    public static final Target BTN_FINALIZAR2 = Target.the("botón 'Finalizar'")
            .locatedBy("//a[@class='button-cheq']/span[.='Finalizar']");
    public static final Target VER_MAS_CUENTA = Target.the("link 'Ver más'")
            .locatedBy("//*[@class=\"product-information\"]/h3[contains(text(), '{0}')]/following::span[contains(text(), \"Ver más\")][1]");
    public static final Target TXT_NOMBRE_FAVORITO = Target.the("'Nombre de favorito'")
            .locatedBy("//*/div[@class='field-container']//input");

    public static final Target TTL_SOLIC_TRANSF_INT = Target.the("'Solicitud de transferencia internacional'")
            .locatedBy("//span[contains(text(),'Solicitud de transferencia internacional')]");
    public static final Target TTL_SOLIC_TRANSF_365 = Target.the("titulo 'Transferencias Transfer365: Operaciones entre bancos'")
            .locatedBy("//span[.='Transferencias Transfer365: Operaciones entre bancos']");
    public static final Target TTL_SOLIC_TRANSF_UNI = Target.the("titulo 'Transferencias UNI: Operaciones entre bancos'")
            .locatedBy("//span[.='Transferencias UNI: Operaciones entre bancos']");
    public static final Target TTL_SOLIC_TRANSF_TER = Target.the("titulo 'Transferencia a terceros'")
            .locatedBy("//span[.='Transferencia a terceros']");
    public static final Target TTL_SOLIC_TRANSF_TELETON = Target.the("titulo 'Ayuda Teletón'")
            .locatedBy("//span[.='Ayuda Teletón']");
    public static final Target TTL_SOLIC_TRANSF_CP = Target.the("titulo 'Transferencia Cuentas Propias'")
            .locatedBy("//span[.='Transferencia Cuentas Propias']");
    public static final Target TTL_PAGO_TARJ_UNI = Target.the("titulo 'Pago de tarjeta UNI: Operaciones entre bancos'")
            .locatedBy("//span[.='Pago de tarjeta UNI: Operaciones entre bancos']");
    public static final Target TTL_PAGO_TARJ_TER = Target.the("titulo 'Pago de tarjeta de crédito de terceros'")
            .locatedBy("//span[.='Pago de tarjeta de crédito de terceros']");
    public static final Target TTL_PAGO_TARJ_PROP = Target.the("titulo 'Pago de tarjeta de crédito propia'")
            .locatedBy("//span[.='Pago de tarjeta de crédito propia']");


    /*Localizadores Detalle Prestamos*/
    public static final Target OBTENER_CUENTAP1 = Target.the("'Detalle Cuenta Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]");
    public static final Target OBTENER_DEUDAP1 = Target.the("'Detalle Deuda Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/div/span/span[2]");
    public static final Target OBTENER_ESTADOP1 = Target.the("'Detalle Estado Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/div[4]/p[1]");
    public static final Target OBTENER_ESTADOP1_FONDO = Target.the("'Detalle Estado Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/div[3]/p[1]");
    public static final Target OBTENER_SALDO_DISPONIBLE_FONDO = Target.the("'Detalle Estado Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/div[2]/span");
    public static final Target TTL_RESUMEN_PRESTAMO = Target.the("Titulo 'Resumen de préstamo'")
            .locatedBy("//span[contains(text(),'Resumen de préstamo')]");
    public static final Target TTL_MAS_DETALLE_PRESTAMO = Target.the("Titulo 'Más detalle de préstamo'")
            .locatedBy("//span[contains(text(),'Más detalle de préstamo')]");
    public static final Target TTL_SECC_DAT_GEN = Target.the("Titulo 'Sección datos general'")
            .locatedBy("//span[contains(text(),'Sección datos general')]");
    public static final Target TTL_SECC_CUO_MES = Target.the("Sección cuota del mes'")
            .locatedBy("//span[contains(text(),'Sección cuota del mes')]");
    public static final Target TTL_SECC_CAN_TOT = Target.the("Sección cancelación total'")
            .locatedBy("//span[contains(text(),'Sección cancelación total')]");
    public static final Target TTL_SECC_DET_MOR = Target.the("Sección detalle de mora'")
            .locatedBy("//span[contains(text(),'Sección detalle de mora')]");
    public static final Target OBTENER_TIPO_FONDOP1 = Target.the("'Detalle Tipo Fondo Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/h3[2]");
    public static final Target OBTENER_NUMERO_FONDOP1 = Target.the("'Detalle Número Fondo Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/div[1]/p[1]");
    public static final Target OBTENER_NUMERO_FONDOP2 = Target.the("'Detalle Número Fondo Pantalla 2'")
            .locatedBy("//div/dl[1]/dd");
    public static final Target OBTENER_NUMERO_FONDOP3 = Target.the("'Detalle Número Fondo Pantalla 3'")
            .locatedBy("//div/dl[2]/dd");
    public static final Target OBTENER_CUOTAP2 = Target.the("Obtener Cuota Pantalla 2'")
            .locatedBy("//div[@class='product-secondary-information']/dl[3]/dd/span");
    public static final Target OBTENER_CUOTAP3 = Target.the("Obtener Cuota Pantalla 3'")
            .locatedBy("//dl[@class='product-detail-list'][12]/dd/span");
    public static final Target OBTENER_MONTO_RETIROP2 = Target.the("Obtener Cuota Pantalla 2'")
            .locatedBy("//div[@class='product-secondary-information']/dl[4]/dd/span");
    public static final Target OBTENER_MONTO_RETIROP3 = Target.the("Obtener Cuota Pantalla 3'")
            .locatedBy("//dl[@class='product-detail-list'][10]/dd/span");
    public static final Target OBTENER_FECHAPAGOP1 = Target.the("'Detalle Fecha Pago Pantalla 1'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/div[3]/p[1]");
    public static final Target OBTENER_CUENTAP2 = Target.the("'Detalle Cuenta Pantalla 2'")
            .located(By.xpath("//h3"));
    public static final Target OBTENER_SALDOP2 = Target.the("'Detalle Saldo Pantalla 2'")
            .located(By.xpath("//div[@class='card-amount']/span"));
    public static final Target OBTENER_ESTADOP2 = Target.the("'Detalle Estado Pantalla 2'")
            .located(By.xpath("//div/dl[5]/dd"));
    public static final Target OBTENER_FECHAPAGOP2 = Target.the("'Detalle Fecha Pago Pantalla 2'")
            .located(By.xpath("//div/dl[2]/dd"));
    public static final Target OBTENER_TIPOFONDOP2 = Target.the("'Detalle Tipo Fondo Pantalla 2'")
            .located(By.xpath("//div/dl[2]/dd"));
    public static final Target OBTENER_TIPOFONDOP3 = Target.the("'Detalle Tipo Fondo Pantalla 3'")
            .located(By.xpath("//div/dl[3]/dd"));
    public static final Target OBTENER_CUENTAP3 = Target.the("'Detalle Cuenta Pantalla 3'")
            .located(By.xpath("//div/div/dl[1]/dd"));
    public static final Target OBTENER_DEUDAP3 = Target.the("'Detalle Deuda Pantalla 3'")
            .located(By.xpath("//dl[28]/dd/span/span[2]"));
    public static final Target OBTENER_SALDO_DISP3 = Target.the("'Detalle Saldo disponible Pantalla 3'")
            .located(By.xpath("//dl[@class='product-detail-list'][6]/dd/span"));
    public static final Target OBTENER_ESTADOP3 = Target.the("'Detalle Estado Pantalla 3'")
            .located(By.xpath("//div/div/dl[4]/dd"));
    public static final Target OBTENER_FECHAPAGOP3 = Target.the("'Detalle Fecha Pago Pantalla 3'")
            .located(By.xpath("//div/div/dl[11]/dd"));
    public static final Target LBL_VER_MAS = Target.the("'Pantalla Resumen Prestamo'")
            .located(By.xpath("//h2/span[contains(text(),'Resumen de préstamo')]"));
    public static final Target LBL_MAS_DETALLE = Target.the("'Pantalla Resumen Prestamo'")
            .located(By.xpath("//h2/span[contains(text(),'Más detalle de préstamo')]"));
    public static final Target MAS_DETALLE = Target.the("Opción 'Más Detalle'")
            .located(By.xpath("//*[@class='information-link']/a/span[contains(text(), 'Más detalle')]"));
    public static final Target VER_MAS_DETALLE = Target.the("Opción 'Ver Más'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/ul/li[3]/a");
    public static final Target CAMBIO_ALIAS = Target.the("Cambio Alias")
            .locatedBy("//a[@class=\"icon-edit\"]");
    public static final Target INPUT_NOMB_ALIAS = Target.the("Input Alias")
            .locatedBy("//div/input");
    public static final Target BTN_CAMBIAR = Target.the("botón Cambiar alias")
            .locatedBy("//div/button/span[.=\"Cambiar\"]");
    public static final Target NOMBRE_ALIAS_PRODUCTO = Target.the("NOMBRE DE PRODUCTO")
            .locatedBy("//dd[.='{0}']");
    //Localizadores consulta detalle cuenta ahorros
    public static final Target MENU_CUENTAS = Target.the("menú 'Cuentas'")
            .locatedBy("//a[@class='icon-accounts']/span[.='Cuentas']");
    public static final Target MOVIMIENTOS_FONDOS_INVERSION = Target.the("link 'Movimientos'")
            .locatedBy("(//span[contains(text(),'Movimientos')])[1]");
    public static final Target TTL_MOVIMIENTOS_FONDOS_INVERSION = Target.the("'Movimientos de fondo de inversión'")
            .locatedBy("//span[.='Movimientos de fondo de inversión']");
    public static final Target OPCIONES_MENU = Target.the("'Opciones'")
            .locatedBy("//div[@class='flex-row']/div/h2/div");
    public static final Target VER_MAS_FONDO = Target.the("link 'Ver más'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/ul/li/a[@class='round-button icon-menu']");
    public static final Target TOTAL_CUENTAS = Target.the("'Total cuentas'")
            .locatedBy("//span[contains(text(),'Total cuentas')]");
    public static final Target LBL_ALIAS_PRD = Target.the("'Alias de la cuenta'")
            .locatedBy("//h3[contains(text(),'{0}')]");
    public static final Target SALDO_DISPONIBLE_CA = Target.the("'Saldo Disponible'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div[1]/span");
    public static final Target TIPO_CA = Target.the("'Tipo de producto'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/p");
    public static final Target NUMERO_CA = Target.the("'Número de cuenta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div[2]/p/span[1]");
    public static final Target ESTADO_CA = Target.the("'Estado'")
            .locatedBy("//h3[contains(text(),'{0}')]/following-sibling::div[@class='card-information-item']/p");
    public static final Target TTL_RESUMEN_CA = Target.the("titulo 'Resumen CA'")
            .locatedBy("//span[contains(text(),'Resumen CA')]");
    public static final Target TTL_RESUMEN_CA2 = Target.the("Titulo 'Resumen de cuenta de Ahorro'")
            .locatedBy("//div/h2/span[@class='span-res-account']");
    public static final Target TTL_RS_CAyCC = Target.the("{0}")
            .locatedBy("//div/h2/span[.=\"{0}\"]");
    public static final Target TRNSF_DINERO = Target.the("titulo 'Transferencias de dinero'")
            .locatedBy("//span[contains(text(),'Transferencias de dinero')]");
    public static final Target TRNSF_INTERNACIONAL = Target.the("opción 'Solicitud de transferencia internacional'")
            .locatedBy("//a[@class='round-button icon-transfer']/span[.='Solicitud de transferencia internacional']");
    public static final Target TTL_RESUMEN_TC = Target.the("titulo 'Resumen de tarjeta de crédito'")
            .locatedBy("//h2[@class='page-subtitle']/span[.='Resumen de tarjeta de crédito']");

    public static final Target TTL_RESUMEN_ECARD = Target.the("titulo 'Resumen de tarjeta e-card'")
            .locatedBy("//h2[@class='page-subtitle']/span[.='Resumen de tarjeta e-card']");
    public static final Target LBL_ALIAS_PRD2 = Target.the("'Alias de la cuenta'")
            .locatedBy("//div[@class='card-title']/strong");
    public static final Target SALDO_DISPONIBLE_CA2 = Target.the("'Saldo Disponible'")
            .locatedBy("//div[@class='card-amount'][1]/span");
    public static final Target TIPO_CA2 = Target.the("'Tipo de cuenta'")
            .locatedBy("//div[@class='product-information']//div[@class='card-type']");
    public static final Target NUMERO_CA2 = Target.the("'Número de cuenta'")
            .locatedBy("//div[@class='product-secondary-information']/dl[2]/dd");
    public static final Target ESTADO_CA2 = Target.the("'Estado'")
            .locatedBy("//div[@class='product-secondary-information']/dl[1]/dd");
    public static final Target SALDO_RETENIDO_CA = Target.the("subtitulo 'Saldo Retenido'")
            .locatedBy("//div[@class='card-amount'][2]/span");
    public static final Target OPC_MAS_DETALLE = Target.the("opción 'Más detalle'")
            .locatedBy("//a[@class='icon-see-more']/span");
    public static final Target TTL_MAS_DETALLE_CA = Target.the("subtitulo 'Más detalle de cuenta de ahorro'")
            .locatedBy("//span[contains(text(),'Más detalle de cuenta de ahorro')]");
    public static final Target LBL_ALIAS_PRD3 = Target.the("'Alias de la cuenta'")
            .locatedBy("//div[@class='product-more-detail-card information-card CA-card-information']/dl[1]/dd");
    public static final Target TIPO_CA3 = Target.the("'Tipo de cuenta'")
            .locatedBy("//div[@class='product-more-detail-card information-card CA-card-information']/dl[2]/dd");
    public static final Target NUMERO_CA3 = Target.the("'Número de cuenta'")
            .locatedBy("//div[@class='product-more-detail-card information-card CA-card-information']/dl[3]/dd");
    public static final Target ESTADO_CA3 = Target.the("'Estado'")
            .locatedBy("//div[@class='product-more-detail-card information-card CA-card-information']/dl[4]/dd");
    public static final Target SECC_SALDOS = Target.the("subtitulo 'Saldos'")
            .locatedBy("//span[contains(text(),'Saldos')]");
    public static final Target SALDO_CONTABLE_CA = Target.the("'Saldo Contable'")
            .locatedBy("//dl[@class='product-detail-list'][1]/dd/span");
    public static final Target SALDO_DISPONIBLE_CA3 = Target.the("'Saldo Disponible'")
            .locatedBy("//dl[@class='product-detail-list aligned-detail-saldo'][1]/dd");
    public static final Target SALDO_RETENIDO_CA2 = Target.the("'Saldo Retenido'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dd/span");
    public static final Target SECC_PROMEDIOS = Target.the("subtitulo 'Promedios'")
            .locatedBy("//span[contains(text(),'Promedios')]");
    public static final Target PROM_MES_ACT = Target.the("'Promedio del mes actual'")
            .locatedBy("//dl[@class='product-detail-list'][3]/dd/span");
    public static final Target PROM_ULT_TRM = Target.the("'Promedio del último trimestre'")
            .locatedBy("//dl[@class='product-detail-list'][4]/dd/span");

    //Localizadores detalle de fondo de inversion
    public static final Target TIPO_FONDO_INVERSION = Target.the("'Tipo de fondo de inversión'")
            .locatedBy("//h3[contains(text(),'FIDEICOMISO_1')]");
//.locatedBy("//p[contains(text(),'{0}')]/../h3[2]");


    public static final Target NUMERO_FONDO = Target.the("'Nº'")
            .locatedBy("(//h3[contains(text(),'{0}')]/../div/p[@class='information-detail'])[1]");
    ///.locatedBy("(//h3[contains(text(),'{0}')]");

    public static final Target SALDO_DISPONIBLE_FONDO = Target.the("'Saldo Disponible'")
            .locatedBy("//h3[contains(text(),'{0}')]/../div[@class='card-amount']/span");
    public static final Target ESTADO_FONDO = Target.the("'Estado'")
            .locatedBy("(//h3[contains(text(),'{0}')]/../div/p[@class='information-detail'])[2]");
    public static final Target TTL_RESUMEN_FI = Target.the("Titulo 'Resumen de fondo de inversión'")
            .locatedBy("//span[contains(text(),'Resumen de fondo de inversión')]");
    public static final Target VER_MAS_FI = Target.the("Titulo 'Resumen de fondo de inversión'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/ul/li[2]/a/span");
    public static final Target LBL_ALIAS_PRD_2 = Target.the("'Alias de la cuenta'")
            .locatedBy("//div[@class='product-information']/h3/strong");
    public static final Target SALDO_DISPONIBLE_FONDO2 = Target.the("'Saldo Disponible'")
            .locatedBy("//div[@class='product-information']/div/span");
    public static final Target NUMERO_FONDO2 = Target.the("'Número de cuenta'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd)[1]");
    public static final Target TIPO_FONDO_INVERSION2 = Target.the("'Tipo de fondo de inversión'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd)[2]");
    public static final Target VALOR_CUOTA = Target.the("'Valor cuota'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd)[3]/span");
    public static final Target MONTO_MAX_RETIRO = Target.the("'Monto máximo de retiro'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd)[4]/span");
    public static final Target ESTADO_FONDO2 = Target.the("'Estado'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd)[5]");
    public static final Target TTL_MAS_DETALLE_FI = Target.the("Titulo 'Resumen de fondo de inversión'")
            .locatedBy("//span[contains(text(),'Más detalle de fondo de inversión')]");
    public static final Target LBL_ALIAS_PRD_3 = Target.the("'Alias de la cuenta'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[1]");
    public static final Target NUMERO_FONDO3 = Target.the("'Número de referencia'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[2]");
    public static final Target TIPO_FONDO_INVERSION3 = Target.the("'Tipo de fondo de inversión'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[3]");
    public static final Target ESTADO_FONDO3 = Target.the("'Estado'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[4]");
    public static final Target SECC_RESUM = Target.the("Sección 'resumen'")
            .locatedBy("//span[contains(text(),'Sección resumen')]");
    public static final Target SALDO_FONDO = Target.the("'Saldo'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[5]/span");
    public static final Target SALDO_DISPONIBLE_FONDO3 = Target.the("'Disponible'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[6]/span");
    public static final Target SALDO_EFECTIVIZAR = Target.the("'Saldo por efectivizar'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[7]/span");
    public static final Target SALDO_PROT = Target.the("'Saldo protegido'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[8]/span");
    public static final Target CUOTAS_PARTICIPACION = Target.the("'Cuotas de participación'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[9]");
    public static final Target MONTO_MAX_RETIRO2 = Target.the("'Monto máximo de retiro'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[10]/span");
    public static final Target SECC_FOND = Target.the("Sección 'fondos'")
            .locatedBy("//span[contains(text(),'Sección fondos')]");
    public static final Target FECHA_FI = Target.the("'Fecha'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[11]");
    public static final Target VALOR_CUOTA2 = Target.the("'Valor cuota'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[12]/span");
    public static final Target MONEDA = Target.the("'Moneda'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[13]");
    public static final Target MONTO_MIN = Target.the("'Monto mínimo'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[14]/span");
    public static final Target SECC_FECH = Target.the("Sección 'fecha'")
            .locatedBy("//span[contains(text(),'Sección fecha')]");
    public static final Target ULT_MOV_FI = Target.the("'Último movimiento'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[15]");


    //Localizadores pago prestamos propios desde CA
    public static final Target LINK_PAGO_PRESTAMO = Target.the("link 'Pago de préstamo'")
            .locatedBy("//a[@class='round-button icon-loan']/span");
    public static final Target LBL_PAGO_PRESTAMO = Target.the("'Pago de préstamo'")
            .locatedBy("//span[contains(text(),'Pago de préstamo')]");
    public static final Target SELECC_PRESTAMO = Target.the("'Préstamo {0}'")
            .locatedBy("//div/ul[@class='chooser-element transfer-element']/li//span[contains(text(),'{0}')]");
    public static final Target LBL_PAGO_PRESTAMO_PROP = Target.the("'Pago de préstamo propio'")
            .locatedBy("//span[contains(text(),'Pago de préstamo propio')]");
    public static final Target MONTO_DEL_PAGO_PP = Target.the("'Monto del pago'")
            .locatedBy("//div[@class='field-container']/input");
    public static final Target DESCRIPCIÓN_PAGO_PP = Target.the("'Concepto'")
            .locatedBy("//div[@class='field-textarea field-wrapper field-normal']/textarea");
    public static final Target BOTON_PAGAR_PP = Target.the("botón 'Pagar'")
            .locatedBy("//span[contains(text(),'Pagar')]");
    public static final Target VTN_EMERG_PP = Target.the("'Ventana emergente de confirmación'")
            .locatedBy("//div[@class='popup scrollable new-popup-confirmation']");
    public static final Target VTN_EMERG_PP2 = Target.the("'Ventana emergente de confirmación'")
            .locatedBy("//div[@class='popup scrollable']");

    public static final Target BOTON_ACEPTAR_PP = Target.the("botón 'Aceptar'")
            .locatedBy("//*[@class=\"button    undefined\" ]/span/span[.=\"Aceptar\"]");
    public static final Target LBL_PAGO_PRESTAMO_EXITO = Target.the("'El préstamo se pagó exitosamente'")
            .locatedBy("//span[contains(text(),'El préstamo se pagó exitosamente')]");
    public static final Target BTN_PAGAR = Target.the("Boton Pagar").locatedBy("//button/span[.=\"Pagar\"]");
    public static final Target BTN_ACEPTARNPE = Target.the("Boton de acpetar").locatedBy("//button/span[.=\"Aceptar\"]");
    //Localizadores pago prestamos propios desde PR
    public static final Target TTL_RESUMEN_PR = Target.the("'Resumen de préstamo'")
            .locatedBy("//span[contains(text(),'Resumen de préstamo')]");
    public static final Target VER_MAS_PRODUCTOS = Target.the("link 'Ver más'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/ul/li/a//span[contains(text(),'Ver más')]");
    public static final Target SEL_CUENTAS = Target.the("'Selector de cuentas'")
            .locatedBy("//div[@class='selectize-control single']");
    public static final Target SELECC_CUENTA = Target.the("'Cuenta {0}'")
            .locatedBy("//div[@class='selectize-dropdown single']//div[@class='section-info'][contains(text(),'{0}')]");

    //Consulta movimientos cuenta de ahorro
    public static final Target LNK_MOVIMIENTOS = Target.the("link 'Movimientos'")
            .locatedBy("//a[@class='round-button icon-movements']/span");
    public static final Target TTL_MOVIMIENTOS = Target.the("'Resumen movimientos'")
            .locatedBy("//span[contains(text(),'Resumen movimientos')]");
    public static final Target OPC_FILTRAR = Target.the("opción 'Filtrar'")
            .locatedBy("//a[@class='pull-right']/span[.='Filtrar']");
    public static final Target PDF = Target.the("'PDF'")
            .locatedBy("//body/pdf-viewer");
    public static final Target PERIODO_TIEMPO = Target.the("'Período de tiempo'")
            .locatedBy("//span[contains(text(),'Período de tiempo')]");
    public static final Target RANGO_FECHAS = Target.the("'Rango de fechas'")
            .locatedBy("//span[contains(text(),'Rango de fechas')]");
    public static final Target OPC_PERIODO = Target.the("opción '{0}'")
            .locatedBy("//div[@class='field-radio']//span[contains(text(),'{0}')]");
    public static final Target BTN_BUSCAR_MOVIMIENTOS = Target.the("botón 'Buscar movimientos'")
            .locatedBy("//span[contains(text(),'Buscar movimientos')]");
    public static final Target TTL_MOVIMIENTOS2 = Target.the("'Movimientos de cuentas'")
            .locatedBy("//span[contains(text(),'Movimientos de cuentas')]");
    public static final Target TABLA_MOV_CA = Target.the("'Tabla de movimientos'")
            .locatedBy("//div[@class='table-wrapper']/table");


    public static final Target TABLA_MOV_CA_FONDOS_RESERV = Target.the("'Tabla de movimientos'")
            .locatedBy("//div[@class='table-wrapper']");


    public static final Target MSG_ELIMINACION_TRX = Target.the("'Se ha eliminado exitosamente la transacción agendada'")
            .locatedBy("//p[contains(text(),'Se ha eliminado exitosamente la transacción agendada')]");
    public static final Target CONTROL_PAGINEO = Target.the("'Control de pagineo'")
            .locatedBy("//ul[@class='container-paginator']");
    public static final Target ESTADO_CONCEPTO_TRANSACCION_PROGRAMADA = Target.the("Transaccion programada con estado ,'{1}'")
            .locatedBy("//table/tbody/tr/td[contains(text(),'{0}') and ('{1}')]/../td/a");
    public static final Target REG_TABLA_MOV_CA = Target.the("'Registros en tabla movimientos'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr");
    public static final Target REG_TABLA_ESTADO = Target.the("'Registros con estado'")
            .locatedBy("//table[@class='selectable']/tbody/tr/td[8]");

    public static final Target SEL_DESDE = Target.the("'Selector de fecha Desde'")
            .locatedBy("//*[@id='datesWrapper']/div[1]");
    public static final Target FECHA_ACTUAL1 = Target.the("fecha actual")
            .locatedBy("//*[@id='datesWrapper']/div[4]/table[1]/tbody/tr/td[2]");
    public static final Target CAL_DIA1 = Target.the("'Dia'")
            .locatedBy("//*[@id='datesWrapper']/div[4]/table[2]/tr/td");
    public static final Target FECHA_ACTUAL2 = Target.the("fecha actual")
            .locatedBy("//*[@id='datesWrapper']/div[5]/table[1]/tbody/tr/td[2]");
    public static final Target CAL_DIA2 = Target.the("'Dia'")
            .locatedBy("//*[@id='datesWrapper']/div[5]/table[2]/tr/td");
    public static final Target FLECHA_ATRAS = Target.the("'Fecha atras'")
            .locatedBy("//*[@id='datesWrapper']/div[4]/table[1]/tbody/tr/td[1]");
    public static final Target SEL_HASTA = Target.the("'Selector de fecha Hasta'")
            .locatedBy("//*[@id='datesWrapper']/div[3]");
    public static final Target FLECHA_ATRAS2 = Target.the("'Fecha atras'")
            .locatedBy("//*[@id='datesWrapper']/div[5]/table[1]/tbody/tr/td[1]");
    public static final Target OBTENER_SALDO = Target.the("'Saldo disponible'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dd//span[@class='currency-amount']");

    public static final Target TAB_EGRESOS = Target.the("'Egresos'")
            .locatedBy("//div[@class='chooser-element-wrapper']/div/ul/li/a/span[.='Egresos']");

    //Consulta movimientos prestamo
    public static final Target LBL_MOVIMIENTOS_PR = Target.the("'Movimientos'")
            .locatedBy("//span[contains(text(),'Movimientos')]");
    public static final Target RES_MOV_SALDO_DISP = Target.the("'Saldo disponible'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dd//span[@class='currency-amount']");

    //Recargas
    public static final Target LNK_RECARGA_CEL = Target.the("link 'Recarga de celular'")
            .locatedBy("//a[@class='round-button icon-topup']/span");
    public static final Target BTN_REALIZAR_OTRA = Target.the("boton 'Realizar otra'")
            .locatedBy("//button/span[.='Realizar otra']");
    public static final Target BTN_OTRO_PAGO = Target.the("boton 'Otro pago'")
            .locatedBy("//button/span[.='Otro pago']");
    public static final Target TTL_RECARGA_CELULAR = Target.the("'Recarga de celular'")
            .locatedBy("//span[contains(text(),'Recarga de celular')]");
    public static final Target BTN_RECARGA_OTRO_NUM = Target.the("botón 'Recargar otro número'")
            .locatedBy("//a[@class='icon-add']/span");
    public static final Target TXT_CELULAR = Target.the("campo 'Celular'")
            .locatedBy("//div[@class='field-container']/input");
    public static final Target OPC_COMPAÑIA = Target.the("campo 'Compañia'")
            .locatedBy("//div[@class='selectize-input items not-full has-options']");
    public static final Target CMB_COMPAÑIA = Target.the("campo 'Compañia'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[1]/div");
    public static final Target OPC_PAQ_MONTO = Target.the("campo 'Paquete/Monto'")
            .locatedBy("//div[@class='selectize-input items not-full']");
    public static final Target CMB_PAQ_MONTO = Target.the("campo 'Paquete/Monto'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[2]/div");
    public static final Target LNK_CARGAR_PLANTILLA = Target.the("link 'Cargar plantilla'")
            .locatedBy("//div[@class='load-template']/a/span");
    public static final Target BTN_CONTINUAR = Target.the("botón 'Continuar'")
            .locatedBy("//span[contains(text(),'Continuar')]");
    public static final Target LNK_AGENDADA = Target.the("link 'Agendada para hoy'")
            .locatedBy("//div/span/span[.='Agendada para hoy']");
    public static final Target LNK_UNAFECHAFUTURA = Target.the("link 'En una fecha futura'")
            .locatedBy("//div[@class='radio']/span[.='En una fecha futura']");
    public static final Target TTL_AGENDADA = Target.the("'Agendada para'")
            .locatedBy("//h2[@class='page-subtitle centered']");

    public static final Target RESULTADOS_RECARGA = Target.the("'La recarga de celular ha sido completada exitosame'")
            .locatedBy("//div/h2/span[.='La recarga de celular ha sido completada exitosamente']");
    public static final Target OPC_PAQ_MONTO_FAV = Target.the("campo 'Paquete/Monto'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target CMB_PAQ_MONTO_FAV = Target.the("campo 'Paquete/Monto'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[1]/div");
    public static final Target SELECC_FAVOR = Target.the("'Selecciona número a recargar.'")
            .locatedBy("//span[contains(text(),'Selecciona número a recargar.')]");
    public static final Target SELECT_ELIM_FAV = Target.the("'{0}'")
            .locatedBy("//div[contains(text(),'{0}')]");
    public static final Target BTN_ELIMINAR = Target.the("botón 'Eliminar'")
            .locatedBy("//*/button");
    public static final Target LNK_ELIMINAR_FAVO = Target.the("link 'Eliminar favoritos'")
            .locatedBy("//a[@class='chooser-switch']/span[.='Eliminar favoritos']");
    public static final Target BTN_ANADIR_FAV = Target.the("botón 'Añadir a favoritos'")
            .locatedBy("//span[contains(text(),'Añadir a favoritos')]");
    public static final Target BTN_CONFIRMAR = Target.the("Botón 'Confirmar'")
            .located(By.xpath("//span[contains(text(),'Confirmar')]"));

    public static final Target MSG_CONFIRMA2 = Target.the("'La Eliminacion se ha realizado con exito'")
            .locatedBy("//p[@class=\"icon-\"]");
    public static final Target MSG_CONFIRMACION = Target.the("'La plantilla ha sido guardada correctamente'")
            .locatedBy("//p[@class=\"icon-\"]");
    public static final Target TTL_SOLIC = Target.the("'Solicitud de transferencia internacional'")
            .locatedBy("//h2/span[.='Solicitud de transferencia internacional']");

    public static final Target SELECC_FAVORITO = Target.the("selecciona favorito '{0}'")
            .locatedBy("//strong[contains(text(),'{0}')]");
    public static final Target SIN_FAVORITO = Target.the("'Estimado usuario, no tienes favoritos para la funcionalidad seleccionada'")
            .locatedBy("//p[@class='default-message']/span[.='Estimado usuario, no tienes favoritos para la funcionalidad seleccionada']");

    /*Pago tarjetas entre bancos*/
    public static final Target LINK_PAGO_TARJETA_UNI = Target.the("'Pago de tarjeta UNI: Operaciones entre bancos'")
            .locatedBy("//span[contains(text(),'Pago de tarjeta UNI: Operaciones entre bancos')]");
    public static final Target LINK_TRANSFERENCIAS_UNI = Target.the("'Transferencias UNI: Operaciones entre bancos'")
            .locatedBy("//span[contains(text(),'Transferencias UNI: Operaciones entre bancos')]");
    public static final Target BOTON_PAGAR_OTRA_TARJETA = Target.the("'Pagar otra tarjeta'")
            .locatedBy("//span[contains(text(),'Pagar otra tarjeta')]");
    public static final Target DESPLEGAR_LISTA_BANCOS = Target.the("'Lista de bancos'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target SELECCIONAR_BANCO = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target DESPLEGAR_LISTA_TIPO_DOC = Target.the("'Lista de tipo de documento'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target SELECCIONAR_TIPO_DOC = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target TXT_NUMERO_DOCUMENTO = Target.the("'Número de documento'")
            .located(By.name("creditProductDocumentNumber"));
    public static final Target TXT_NOMBRE = Target.the("'Nombre de recibidor'")
            .located(By.name("creditProductOwnerName"));
    public static final Target TXT_APELLIDO = Target.the("'Apellido de recibidor'")
            .located(By.name("creditProductOwnerLastname"));
    public static final Target TXT_DESCRIPCION = Target.the("'Descripcion'")
            .located(By.name("description"));

    /* transferencias entre bancos*/
    public static final Target BOTON_TRANSFERIR_OTRA_CUENTA = Target.the("'Transferir a otra cuenta'")
            .locatedBy("//span[contains(text(),'Transferir a otra cuenta')]");
    public static final Target BOTON_TRANSFERIR_NUMERO_CELULAR = Target.the("botón 'Transferir a un número de celular'")
            .locatedBy("//div[@class='button-row']/button");
    public static final Target TIPO_CUENTA = Target.the("'Lista de tipos de cuenta'")
            .locatedBy("(//div[@class='selectize-control single']/div)[1]");
    public static final Target SELECCIONAR_TIPO_CUENTA = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target DESPLEGAR_LISTA_BANCO_INSTITUCIONES = Target.the("'Lista de bancos'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target DESPLEGAR_LISTA_TIPO_DOC_UNI = Target.the("'Lista tipo de documento'")
            .locatedBy("(//div[@class='selectize-control single'])[3]");
    public static final Target DESPLEGAR_LISTA_TIPO_CLIENTE = Target.the("'Lista tipo de cliente'")
            .locatedBy("(//div[@class='selectize-control single'])[3]");
    public static final Target SELECCIONAR_TIPO_CLIENTE = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target SELECCIONAR_FAVORITO_TRANSFERENCIA = Target.the("'{0}'")
            .locatedBy("(//span[contains(text(),'{0}')])[1]");

    public static final Target OPC_CUENTAS_OTROS_BANCOS = Target.the("Opción 'Cuentas de otros bancos'")
            .located(By.xpath("//ul[@class='chooser-element list-home-services']/li/a/span[(contains(.,'Cuentas de otros bancos')) and not(contains(.,'Cuentas de otros bancos - transfer365'))]"));
    public static final Target OPCIONES_FAVORITOS = Target.the("Opción '{0}'")
            .locatedBy("//div[@class='chooser-element-wrapper scrollable']/ul/li/a[.='{0}']");
    public static final Target OPCIONES = Target.the("Titulo '{0}'")
            .locatedBy("//span[contains(text(),'{0}')]");

    //Transferencias CP a Celular
    public static final Target OPCION_CELULAR = Target.the("Opcion 'Celular'")
            .locatedBy("//div[@class='field-radio']/span[.='Celular']");


    //Transfer365 Celular
    public static final Target LISTA_INSTITUCION_DESTINO = Target.the("lists 'Institución de destino'")
            .locatedBy("(//div[@class='selectize-control single']/div)[1]");
    public static final Target SELECCIONAR_INSTITUCION_DESTINO = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target CELULAR_T365M = Target.the("'Celular'")
            .locatedBy("//input[@name='creditProductMobileNumber']");
    public static final Target NOMBRE_RECIBIDOR_T365M = Target.the("'Nombre de recibidor'")
            .locatedBy("//input[@name='creditProductOwnerName']");
    public static final Target MONTO_T365M = Target.the("'Monto'")
            .locatedBy("//input[@type='tel']");
    public static final Target EMAIL_T365M = Target.the("'Correo electrónico (opcional)'")
            .locatedBy("//input[@name='creditProductEmail']");
    public static final Target CONCEPTO_T365M = Target.the("'Concepto'")
            .locatedBy("//input[@name='concept']");
    public static final Target BTN_TRANSFERIR_T365M = Target.the("botón 'Transferir'")
            .locatedBy("//button[@type='button']/span[.='Transferir']");
    public static final Target BTN_ACEPTAR_T365M = Target.the("botón 'Aceptar'")
            .locatedBy("//button[@type='button']/span[.='Aceptar']");
    public static final Target CONFIRMACION_T365M = Target.the("'Transfer365 Móvil pendiente de aplicación'")
            .locatedBy("//h2[@class='page-subtitle centered']/span[.='Transfer365 Móvil pendiente de aplicación']");
    //Transfer365 CA-RD

    public static final Target LISTA_TIPO_PAGO_TRANSFER365_CA_RD = Target.the("lists 'Institución de destino'")
            .locatedBy("(//div[@class='selectize-control single']/div)[3]");
    public static final Target SELECCIONAR_TIPO_PAGO_TRANSFER365_CA_RD = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target MONTO_T365_CA_RD = Target.the("'Monto a transfereir'")
            .locatedBy("//input[@type='tel']");
    public static final Target DESCRIPCION_T365_CA_RD = Target.the("'Descripción'")
            .locatedBy("//input[@name='description']");
    public static final Target LISTA_PAIS_BANCO_BENEF_TRANSFER365_CA_RD = Target.the("lists 'Pais banco beneficiario'")
            .locatedBy("(//div[@class='selectize-control single']/div)[5]");
    public static final Target SELECCIONAR_PAIS_BANCO_BENEF_TRANSFER365_CA_RD = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");

    public static final Target LISTA_BANCO_BENEF_TRANSFER365_CA_RD = Target.the("lists 'banco beneficiario'")
            .locatedBy("(//div[@class='selectize-control single']/div)[7]");
    public static final Target SELECCIONAR_BANCO_BENEF_TRANSFER365_CA_RD = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");

    public static final Target CUENTA_IBAN_T365_CA_RD = Target.the("'Cuenta IBAN'")
            .locatedBy("//input[@name='beneficiaryAccount']");
    public static final Target NOMBRE_BENEF_T365_CA_RD = Target.the("'Nombre del beneficiario transfer365 CA-RD'")
            .locatedBy("//input[@name='beneficiaryName']");

    public static final Target DOCUMENTO_BENEF_T365_CA_RD = Target.the("'Documento del beneficiario transfer365 CA-RD'")
            .locatedBy("//input[@name='beneficiarDocumentNumber']");

    public static final Target CIUDAD_BENEF_T365_CA_RD = Target.the("'Ciudad del beneficiario transfer365 CA-RD'")
            .locatedBy("//input[@name='beneficiaryCity']");
    public static final Target DIRECCION_BENEF_T365_CA_RD = Target.the("'Dirección del beneficiario transfer365 CA-RD'")
            .locatedBy("//input[@name='beneficiaryAddress']");

    public static final Target CONFIRMACION_T365_SIPA = Target.the("'Transfer365 CA-RD pendiente de aplicación'")
            .locatedBy("//span[contains(text(),'Transfer365 CA-RD pendiente de aplicación')]");

//ticket SIPA

    public static final Target MONTO_T365_SIPA = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target COMISION_T365_SIPA = Target.the("'Monto de comisión'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target CUENTA_ORIGEN_T365_SIPA = Target.the("'Cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TIPO_PAGO_T365_SIPA = Target.the("'Tipo de pago'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target DESCRIP_T365_SIPA = Target.the("'Descripción'")
            .locatedBy("(//span[@class='field-read-only'])[5]");

    public static final Target PAIS_BANCO_BENEF_T365_SIPA = Target.the("'País del banco beneficiario'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target BANCO_BENEF_T365_SIPA = Target.the("'Banco beneficiario'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target NUM_IBAN_T365_SIPA = Target.the("'Número de Cuenta o IBAN'")
            .locatedBy("(//span[@class='field-read-only'])[8]");
    public static final Target NOMBRE_BENEF_T365_SIPA = Target.the("'Nombre completo de la persona que recibirá la transferencia.'")
            .locatedBy("(//span[@class='field-read-only'])[9]");
    public static final Target NUM_DOCUMENT_BENEF_T365_SIPA = Target.the("'Número de documento de identificación de la persona que recibirá la transferencia.'")
            .locatedBy("(//span[@class='field-read-only'])[10]");
    public static final Target CIUDAD_BENEF_T365_SIPA = Target.the("'Cuidad donde se encuentra la persona que recibirá la transferencia.'")
            .locatedBy("(//span[@class='field-read-only'])[11]");
    public static final Target DIRECCIOPN_BENEF_T365_SIPA = Target.the("'Dirección'")
            .locatedBy("(//span[@class='field-read-only'])[12]");
    public static final Target FECHA_APLICADA_T365_SIPA = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[13]");


    //Pago préstamos
    public static final Target DESPLEGAR_LISTA_TIPO_CLIENTE2 = Target.the("'Lista Tipo cliente'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target LINK_PAGO_PRESTAMO_UNI = Target.the("link 'Pago de Préstamo UNI: Operaciones entre bancos'")
            .locatedBy("//span[contains(text(),'Pago de Préstamo UNI: Operaciones entre bancos')]");
    public static final Target SUB_PA_PREST_UNI = Target.the("'Realiza pagos de préstamos de la red UNI'")
            .locatedBy("//span[contains(text(),'Realiza pagos de préstamos de la red UNI')]");
    public static final Target BTN_PAGAR_OTRO_PRESTAMO = Target.the("botón 'Pagar otro préstamo'")
            .locatedBy("//span[contains(text(),'Pagar otro préstamo')]");
    public static final Target TXT_PRESTAMO_A_ABONAR = Target.the("'Préstamo a abonar'")
            .locatedBy("//input[@name='creditProductNumber']");
    public static final Target TXT_MONTO_PR = Target.the("'Monto'")
            .locatedBy("//input[@type='tel']");
    public static final Target PAGO_PENDIENTE_APL = Target.the("'Pago de Préstamo UNI: Operaciones entre bancos pendiente de aplicación'")
            .locatedBy("//span[contains(text(),'Pago de Préstamo UNI: Operaciones entre bancos pen')]");

    public static final Target FAV_PREST_OTROS = Target.the("'Préstamos de otros bancos'")
            .locatedBy("//span[@class='column stretchable']/span[(contains(.,'Préstamos de otros bancos')) and not(contains(.,'Préstamos de otros bancos - transfer365'))]");
    public static final Target SELECCIONA_FAV_PRESTAMO = Target.the("'{0}'")
            .locatedBy("//ul/li/a/span[1]/span[contains(text(),'{0}')]");
    public static final Target TTL_GESTION_FAVORITOS = Target.the("'Gestión de favoritos'")
            .locatedBy("//h2/span");


    //Resumen cuenta corriente
    public static final Target TTL_RESUMEN_CC = Target.the("Titulo 'Resumen de cuenta corriente'")
            .locatedBy("//span[contains(text(),'Resumen de cuenta corriente')]");
    public static final Target SALDO_CC1 = Target.the("'Saldo'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd/strong)[3]");
    public static final Target FONDOS_RESERVADOS1 = Target.the("'Monto total de fondos reservados'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd/strong)[4]");
    public static final Target SOBREGIRO1 = Target.the("'Sobregiro'")
            .locatedBy("(//div[@class='product-secondary-information']/dl/dd/strong)[5]");
    public static final Target TTL_MAS_DETALLE_CC = Target.the("Titulo 'Más detalle de cuenta corriente'")
            .locatedBy("//span[contains(text(),'Más detalle de cuenta corriente')]");
    public static final Target LBL_ALIAS_PRD3_CC = Target.the("'Alias de la cuenta'")
            .locatedBy("//div[@class='product-more-detail-card information-card']/dl[1]/dd");
    public static final Target TIPO_CA3_CC = Target.the("'Tipo de cuenta'")
            .locatedBy("//div[@class='product-more-detail-card information-card']/dl[2]/dd");
    public static final Target NUMERO_CA3_CC = Target.the("'Número de cuenta'")
            .locatedBy("//div[@class='product-more-detail-card information-card']/dl[3]/dd");
    public static final Target ESTADO_CA3_CC = Target.the("'Estado'")
            .locatedBy("//div[@class='product-more-detail-card information-card']/dl[4]/dd");
    public static final Target SALDO_CONTABLE_CA_CC = Target.the("'Saldo contable'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[1]");
    public static final Target SALDO_DISPONIBLE_CA3_CC = Target.the("'Saldo disponible'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[2]");
    public static final Target SALDO_RETENIDO_CA2_CC = Target.the("'Saldo Retenido'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[3]");
    public static final Target PROM_MES_ACT_CC = Target.the("'Promedio del mes actual'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[18]");
    public static final Target PROM_ULT_TRM_CC = Target.the("'Promedio del último trimestre'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[19]");
    public static final Target SUB_SOBREGIRO = Target.the("Subtitulo 'Sobregiro'")
            .locatedBy("//span[contains(text(),'Sobregiro')]");
    public static final Target REF_SOB_CC = Target.the("'Referencia'")
            .locatedBy("//dl[@class='product-detail-list'][8]/dd");
    public static final Target MONTO_SOB_CC = Target.the("'Monto'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[4]");
    public static final Target DISPON_SOB_CC = Target.the("'Disponibilidad'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[5]");
    public static final Target TASINT_SOB_CC = Target.the("'Tasa de interés'")
            .locatedBy("//dl[@class='product-detail-list'][11]/dd");
    public static final Target FECAPE_SOB_CC = Target.the("'Fecha de apertura'")
            .locatedBy("//dl[@class='product-detail-list'][12]/dd");
    public static final Target VENLIN_SOB_CC = Target.the("'Vencimiento de la línea'")
            .locatedBy("//dl[@class='product-detail-list'][13]/dd");
    public static final Target VENSOB_SOB_CC = Target.the("'Vencimiento del sobregiro'")
            .locatedBy("//dl[@class='product-detail-list'][14]/dd");
    public static final Target INMEAC_SOB_CC = Target.the("'Intereses mes actual'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[10]");
    public static final Target ESTADO_SOB_CC = Target.the("'Estado'")
            .locatedBy("//dl[@class='product-detail-list'][16]/dd");
    public static final Target SALCAP_SOB_CC = Target.the("'Saldo capital'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[12]");
    public static final Target INTTOT_SOB_CC = Target.the("'Interés total'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[13]");
    public static final Target COMPEN_SOB_CC = Target.the("'Comisiones pendientes'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[14]");
    public static final Target COBEXT_SOB_CC = Target.the("'Cobro externo'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[15]");
    public static final Target SATOPA_SOB_CC = Target.the("'Saldo total a pagar'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[16]");
    public static final Target IAMEAN_SOB_CC = Target.the("'Intereses acumulados meses anteriores'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[17]");
    public static final Target SACAPE_SOB_CC = Target.the("'Saldo capital pendientes'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[18]");
    public static final Target DMIAMA_SOB_CC = Target.the("'Días mora intereses acumulados meses anteriores'")
            .locatedBy("//dl[@class='product-detail-list'][24]/dd");
    public static final Target DIMOCA_SOB_CC = Target.the("'Días mora capital'")
            .locatedBy("//dl[@class='product-detail-list'][25]/dd");

    //Pago Extrafinanciamiento
    public static final Target VER_MAS_EXTRAFINANCIAMIENTO = Target.the("link 'Ver más''")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div/ul/li[3]/a/span");
    public static final Target TTL_RESUMEN_EXTRAFINANCIAMIENTO = Target.the("Titulo 'Resumen de extrafinanciamiento'")
            .locatedBy("//span[contains(text(),'Resumen de extrafinanciamiento')]");
    public static final Target OPCION_PAGAR_EXTRAFINANCIAMIENTO = Target.the("opción 'Pagar extrafinanciamiento'")
            .locatedBy("//ul/li/a/span[.='Pagar extrafinanciamiento']");
    public static final Target DESPLEGAR_LISTA_DESDE = Target.the("'Lista cuentas propias'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target DESPLEGAR_LISTA_TIPO_PAGO = Target.the("'Lista tipo pago'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target SELECCIONA_DESDE = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");
    public static final Target SELECCIONA_TIPO_PAGO = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");

    //Imprimir Exportas movimientos Cuentas
    public static final Target LINK_IMPRIMIR = Target.the("link 'Imprimir'")
            .locatedBy("//span[contains(text(),'IMPRIMIR')]");
    public static final Target LINK_EXPORTAR = Target.the("link 'Exportar'")
            .locatedBy("//span[contains(text(),'Exportar')]");
    public static final Target OBTENER_SALDO_INICIAL = Target.the("'Obtener Saldo Inicial'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[1]");
    public static final Target OBTENER_SALDO_DISPONIBLE = Target.the("'Obtener Saldo Disponible'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[2]");
    public static final Target OBTENER_SALDO_RETENIDO = Target.the("'Obtener Saldo Retenido'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[3]");
    public static final Target OBTENER_SALDO_CONTABLE = Target.the("'Obtener Saldo Contable'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[4]");
    public static final Target OBTENER_PROMEDIO_CONTABLE = Target.the("'Obtener Promedio contable'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[5]");
    public static final Target OBTENER_TOTAL_CARGOS = Target.the("'Obtener Total cargos'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[6]");
    public static final Target OBTENER_TOTAL_ABONOS = Target.the("'Obtener Total abonos'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[7]");

    //detalle extrafinanciamiento
    public static final Target TTL_MAS_DETALLE_EF = Target.the("'Más detalle de extrafinanciamiento'")
            .locatedBy("//span[contains(text(),'Más detalle de extrafinanciamiento')]");
    public static final Target ALIAS_EF = Target.the("'Alias de la cuenta'")
            .locatedBy("//h3[@class='card-title'][contains(text(), \"{0}\")]");
    public static final Target DEUDA_TOTAL_EF = Target.the("'Deuda Total'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div/span");
    public static final Target NUM_EF = Target.the("'Número de extrafinanciamiento'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div[2]/p[1]");
    public static final Target FECHA_PAGO_EF = Target.the("'Fecha De Pago'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div[3]/p[1]");
    public static final Target ESTADO_EF = Target.the("'Estado'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div[4]/p[1]");
    public static final Target ALIAS_EF2 = Target.the("'Alias de la cuenta'")
            .locatedBy("//h3[@class='card-title']/strong");
    public static final Target DEUDA_TOTAL_EF2 = Target.the("'Deuda Total'")
            .locatedBy("//div[@class='card-amount'][1]/span");
    public static final Target TIPO_PRD2 = Target.the("'Tipo de producto'")
            .locatedBy("//p[@class='card-type']/span");
    public static final Target NUM_EF2 = Target.the("'Número de extrafinanciamiento'")
            .locatedBy("//div[@class='product-secondary-information']/dl[1]/dd");
    public static final Target FECHA_PAGO_EF2 = Target.the("'Fecha De Pago'")
            .locatedBy("//div[@class='product-secondary-information']/dl[2]/dd");
    public static final Target ULT_PAGO_EF = Target.the("'Último pago'")
            .locatedBy("//div[@class='product-secondary-information']/dl[3]/dd");
    public static final Target CUOTA_EF = Target.the("'Cuota'")
            .locatedBy("//div[@class='product-secondary-information']/dl[4]/dd/span");
    public static final Target ESTADO_EF2 = Target.the("'Estado'")
            .locatedBy("//div[@class='product-secondary-information']/dl[5]/dd");
    public static final Target ALIAS_EF3 = Target.the("'Alias de la cuenta'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[1]");
    public static final Target TIPO_PRD3 = Target.the("'Tipo de producto'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[2]");
    public static final Target NUM_EF3 = Target.the("'Número de extrafinanciamiento'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[3]");
    public static final Target ESTADO_EF3 = Target.the("'Estado'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[4]");
    public static final Target SBTTL_DATOS_GEN_EF = Target.the("Subtitulo 'Datos generales'")
            .locatedBy("//span[contains(text(),'Datos generales')]");
    public static final Target MONTO_EF = Target.the("'Monto'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[5]/span");
    public static final Target SALDO_EF = Target.the("'Saldo'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[6]/span");
    public static final Target TASA_EF = Target.the("'Tasa de interés'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[7]/span");
    public static final Target GARANTIA_EF = Target.the("'Garantía'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[8]");
    public static final Target FECHA_AP_EF = Target.the("'Fecha apertura'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[9]");
    public static final Target ULTMOV_EF = Target.the("'Último movimiento'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[10]");
    public static final Target ULT_PAGO_EF2 = Target.the("'Próximo pago'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[11]");
    public static final Target VENC_EF = Target.the("'Vencimiento'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[12]");
    public static final Target SALDO_AHO_EF = Target.the("'Saldo ahorro'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[13]/span");
    public static final Target ESTADO_ACTUAL_EF = Target.the("'Estado'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[14]");
    public static final Target SBTTL_CM_EF = Target.the("Subtitulo 'Cuota del mes'")
            .locatedBy("//span[contains(text(),'Cuota del mes')]");
    public static final Target CUOTA_NORMAL = Target.the("'Cuota'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[15]/span");
    public static final Target SEGURO_EF = Target.the("'Seguro'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[16]/span");
    public static final Target COMISION_ADM_EF = Target.the("'Comisión por ADM'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[17]/span");
    public static final Target IVA = Target.the("'IVA'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[18]/span");
    public static final Target CUOTA_AHORRO = Target.the("'Cuota ahorro'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[19]/span");
    public static final Target CUOTA_EF2 = Target.the("'Cuota total'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[20]/span");
    public static final Target SEGURO_DIF_COVID = Target.the("'Seguros diferidos COVID'")
            .locatedBy("//dl[@class='product-detail-list'][8]/dd/span");
    public static final Target INT_DIF_COVID = Target.the("'Intereses diferidos COVID'")
            .locatedBy("//dl[@class='product-detail-list'][9]/dd/span");
    public static final Target SBTTL_CT_EF = Target.the("Subtitulo 'Cancelación total'")
            .locatedBy("//span[contains(text(),'Cancelación total')]");
    public static final Target SALD_CAP = Target.the("'Saldo capital'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[21]/span");
    public static final Target SEGURO_EF2 = Target.the("'Seguro'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[22]/span");
    public static final Target COMISION_ADM_EF2 = Target.the("'Comisión por ADM'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[23]/span");
    public static final Target IVA2 = Target.the("'IVA'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[24]/span");
    public static final Target RECARGO_MORA_EF = Target.the("'Recargo por mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[25]/span");
    public static final Target INTERESES_EF = Target.the("'Intereses'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[26]/span");
    public static final Target HONOR_COBEXT_EF = Target.the("'Honorarios cobro externo'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[27]/span");
    public static final Target DEUDA_TOTAL_EF3 = Target.the("'Monto a pagar'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[28]/span");
    public static final Target SBTTL_DETALLEM = Target.the("Subtitulo 'Detalle de mora'")
            .locatedBy("//span[contains(text(),'Detalle de mora')]");
    public static final Target VAL_CUOMORA = Target.the("'Valor cuotas en mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[29]/span");
    public static final Target SEGURO_EF3 = Target.the("'Seguro'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[30]/span");
    public static final Target COMISION_ADM_EF3 = Target.the("'Comisión por ADM'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[31]/span");
    public static final Target IVA3 = Target.the("'IVA'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[32]/span");
    public static final Target RECARGO_MORA_EF2 = Target.the("'Recargo por mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[33]/span");
    public static final Target CUOTA_AHORRO2 = Target.the("'Cuota ahorro'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[34]/span");
    public static final Target MORA_EF = Target.the("'Mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[35]/span");
    public static final Target HONOR_COBEXT_EF2 = Target.the("'Honorarios cobro externo'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[36]/span");
    public static final Target VALPENPAG_EF = Target.the("'Valor pendiente de pago'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[37]/span");
    public static final Target CUOMORA_EF = Target.the("'Cuotas en mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[38]");
    public static final Target DIAMORA_EF = Target.the("'Días de mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[39]");
    public static final Target FECHINIMORA_EF = Target.the("'Fecha inicio de mora'")
            .locatedBy("(//div[@class='product-more-detail-card-wrapper']/div/dl/dd)[40]");

    //Pago servicios NPE
    public static final Target PAGOSERVICIOS = Target.the("link 'Pago de servicios'")
            .locatedBy("//a[@class='round-button icon-ticket']/span[.='Pago de servicios']");
    public static final Target TTL_PAGOSERV = Target.the("titulo 'Pago de servicios'")
            .locatedBy("//span[contains(text(),'Pago de servicios')]");
    public static final Target PAGOCONFACTURA = Target.the("link 'Pago con factura'")
            .locatedBy("//span[contains(text(),'Pago con factura')]");
    public static final Target TTL_PTSMRS = Target.the("titulo 'Paga tus servicios de manera rápida y segura'")
            .locatedBy("//span[contains(text(),'Paga tus servicios de manera rápida y segura')]");
    public static final Target NPE_TXT = Target.the("'Digita el NPE'")
            .locatedBy("//div[@class='field-container InputScannField']/textarea");
    public static final Target MONTO_NPE = Target.the("'Monto'")
            .locatedBy("//div[@class='field-container']/input");
    public static final Target CONFPAGOSERV = Target.the("'El servicio se pagó exitosamente'")
            .locatedBy("//span[contains(text(),'El servicio se pagó exitosamente')]");

    //Resumen de ADS
    public static final Target TTL_RESUMEN_ADS = Target.the("Titulo 'Resumen de ADS'")
            .locatedBy("//span[contains(text(),'Resumen de ADS')]");
    public static final Target ALIAS_ADS2 = Target.the("'Alias de la cuenta'")
            .locatedBy("//div[@class='card-title']/strong");
    public static final Target SALDO_DISP_ADS2 = Target.the("'Saldo Disponible'")
            .locatedBy("//div[@class='card-amount']/span");
    public static final Target TIPO_PROD_ADS2 = Target.the("'Tipo de producto'")
            .locatedBy("//div[@class='card-type']");
    public static final Target NUM_CUENTA_ADS2 = Target.the("'Número de cuenta'")
            .locatedBy("(//dl[@class='information-item']//dd/strong)[1]");
    public static final Target MONTO_APROB_ADS1 = Target.the("'Monto aprobado'")
            .locatedBy("(//dl[@class='information-item']//dd/strong)[2]");
    public static final Target MONTO_UTIL_ADS1 = Target.the("'Monto utilizado'")
            .locatedBy("(//dl[@class='information-item']//dd/strong)[3]");
    public static final Target MONTO_PAGAR_ADS1 = Target.the("'Monto a pagar'")
            .locatedBy("(//dl[@class='information-item']//dd/strong)[4]");
    public static final Target ESTADO_ADS2 = Target.the("'Estado'")
            .locatedBy("(//dd[@class='card-number']/strong)[5]");
    public static final Target TTL_MAS_RESUMEN_ADS = Target.the("Titulo 'Más detalle de ADS'")
            .locatedBy("//span[contains(text(),'Más detalle de ADS')]");
    public static final Target ALIAS_ADS3 = Target.the("'Alias de la cuenta'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[1]");
    public static final Target TIPO_PROD_ADS3 = Target.the("'Tipo de producto'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[2]");
    public static final Target NUM_CUENTA_ADS3 = Target.the("'Número de cuenta'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[3]");
    public static final Target ESTADO_ADS3 = Target.the("'Estado'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[4]");
    public static final Target STTL_SALDOS = Target.the("Sección 'Saldos'")
            .locatedBy("//span[contains(text(),'Saldos')]");
    public static final Target MONTO_APROB_ADS2 = Target.the("'Monto aprobado'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[5]");
    public static final Target MONTO_UTIL_ADS2 = Target.the("'Monto utilizado'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[6]");
    public static final Target MONTO_DISP_ADS1 = Target.the("'Monto disponible'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[7]");
    public static final Target STTL_MONTOPAGAR = Target.the("Sección 'Monto a pagar'")
            .locatedBy("//h3//span[contains(text(),'Monto a pagar')]");
    public static final Target MONTO_PAGAR_ADS2 = Target.the("'Monto a pagar'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[8]");
    public static final Target INTERESES_ADS1 = Target.the("'Intereses'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[9]");
    public static final Target CAPITAL_ADS1 = Target.the("'Capital'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[10]");
    public static final Target COMISION_ADS1 = Target.the("'% comisión'")
            .locatedBy("(//dl[@class='product-detail-list']//span[@class='currency-amount'])[7]");
    public static final Target STTL_INTMORA = Target.the("Sección 'Intereses días mora'")
            .locatedBy("//span[contains(text(),'Intereses días mora')]");
    public static final Target MORA_TOTAL_ADS1 = Target.the("'Mora total'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[12]");
    public static final Target INT_DIARIO_ADS1 = Target.the("'Interés Diario'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[13]");
    public static final Target INT_PENDIENTE_ADS1 = Target.the("'Interés Pendiente'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[14]");
    public static final Target HONO_COB_EXT_ADS1 = Target.the("'Honorarios por cobro externo'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[15]");
    public static final Target MT = Target.the("Sección 'Mora total'")
            .locatedBy("//span[contains(text(),'Mora total')]");

    //Gestión de chequera
    public static final Target GESTION_CHEQUERAS = Target.the("Sección 'Gestión de chequeras'")
            .locatedBy("//span[contains(text(),'Gestión de chequeras')]");
    public static final Target SOLICITUD_CHEQUERAS = Target.the("link 'Solicitud de chequeras'")
            .locatedBy("//span[contains(text(),'Solicitud de chequeras')]");
    public static final Target TT_SOLICITUD_CHEQUERAS = Target.the("'Solicitud de chequeras'")
            .locatedBy("//h2/span");
    public static final Target TIPO_CHEQ = Target.the("'Tipo de chequera'")
            .locatedBy("//*[@id='formContent']/div/div[2]/div/div/div/div");
    public static final Target OPC_TIPO_CHEQ = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'{0}')]");
    public static final Target BTN_FILTRAR_CHEQUES = Target.the("'Filtrar'")
            .locatedBy("//button/span[.='Filtrar']");
    public static final Target CANT_CHEQ = Target.the("'Cantidad de cheques'")
            .locatedBy("(//div[@class='selectize-control single'])[3]");

    public static final Target OPC_CANT_CHEQ = Target.the("'{0}'")
            //  .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'{0}')]");
            .locatedBy("//span[contains(text(),'Cantidad de cheques')]//following::div[contains(text(),'{0}')]");


    public static final Target DEPTO = Target.the("'Departamento'")
            .locatedBy("(//div[@class='selectize-control single'])[4]");
    public static final Target OPC_DEPTO = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'{0}')]");
    public static final Target AGENCIA = Target.the("'Agencia'")
            .locatedBy("(//div[@class='selectize-wrapper'])[4]");
    public static final Target OPC_AGENCIA = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'{0}')]");
    public static final Target RESULT_SOLIC_CHEQ = Target.the("'Solicitud de chequeras - Resultado'")
            .locatedBy("//span[contains(text(),'Solicitud de chequeras - Resultado')]");
    public static final Target CONSULTA_CHEQUERAS = Target.the("link 'Consulta de chequeras'")
            .locatedBy("//span[contains(text(),'Consulta de chequeras')]");
    public static final Target TT_CONSULTA_CHEQUERAS = Target.the("'Consulta de chequeras'")
            .locatedBy("//h2/span");
    public static final Target SELECCIONA_CHEQUERA = Target.the("'{0}'")
            .locatedBy("//table[@class='selectable']/tbody/tr/td[1][.='{0}']");
    public static final Target CONSUL_CHQUES = Target.the("'Consulta de cheques'")
            .locatedBy("//span[contains(text(),'Consulta de cheques')]");
    public static final Target CHEQ_ACTIV = Target.the("'Cheques activos'")
            .locatedBy("//div[@class='form-line-wrapper'][3]/div/div");
    public static final Target TOTAL_CHEQ = Target.the("'Total de cheques'")
            .locatedBy("//div[@class='form-line-wrapper'][4]/div/div");
    public static final Target REFERENCIA_CHEQ = Target.the("referencia '{0}'")
            .locatedBy("//div[@class='table-wrapper movements']/table/tbody/tr/td[text()='{0}'][1]");
    public static final Target MOV_CONS_CHEQ_SUSPENDIDOS = Target.the("'Tabla de registros de cheques suspendidos'")
            .locatedBy("//div[@class='table-wrapper movements']/table");
    public static final Target ESTADO_CHEQ = Target.the("'Estado de cheque'")
            .locatedBy("//div[@class='selectize-input items has-options not-full']");
    public static final Target LBL_ESTADO_CHEQ = Target.the("label 'Estado de cheque'")
            .locatedBy("//div[@class='field-wrapper field-select']/label[.='Estado de cheque']");

    public static final Target ESTADO_LIST = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'{0}')]");
    public static final Target ESTADO_CHEQUE_PAGADO = Target.the("Estado del cheque, 'Pagado'")
            .locatedBy("(//div[@class='selectize-input items has-options full has-items'])[2][.='Pagado']");
    public static final Target N_CHEQUE = Target.the("'Tabla de cheques'")
            .locatedBy("//span[contains(text(),'No. cheque')]");
    public static final Target ESTADO_TABLA_CHEQUES = Target.the("'Estado de cheques'")
            .locatedBy("//div[@class='table-wrapper movements']/table/tbody/tr/td[2]");
    public static final Target REG_TAB_CHEQ = Target.the("'Registros de cheques'")
            .locatedBy("//div[@class='table-wrapper movements']/table/tbody/tr");
    public static final Target DESPLEGAR_LISTA_CUENTA = Target.the("'Despliega lista cuenta'")
            .locatedBy("(//div[@class='selectize-control single'])[1]");
    public static final Target SELECCIONA_CUENTA = Target.the("'Selecciona cuenta'")
            .locatedBy("(//*/div[@class='selectize-dropdown-content'])[1]/div[contains(text(),'{0}')]");

    //Detalle DAP
    public static final Target DAP = Target.the("'Depósito a Plazo'")
            .locatedBy("//span[contains(text(),'Depósito a Plazo')]");
    public static final Target SALDO_PRINCIPAL = Target.the("'Saldo Principal'")
            .locatedBy("//h3[contains(text(),'{0}')]/../div/span");
    public static final Target NUMERCUENTA_DAP = Target.the("'Número de cuenta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[1]/div/p[@class='information-detail']");
    public static final Target TTL_RESUMEN_DEPOSITO = Target.the("'Resumen de depósito'")
            .locatedBy("//span[contains(text(),'Resumen de depósito')]");
    public static final Target SALDO_PRINCIPAL2 = Target.the("'Saldo Principal'")
            .locatedBy("//div[@class='card-amount']/span");
    public static final Target NUMERCUENTA_DAP2 = Target.the("'Número de cuenta'")
            .locatedBy("//div[@class='product-secondary-information']/dl[1]/dd");
    public static final Target ULTPAGO_DAP2 = Target.the("'Último pago'")
            .locatedBy("//div[@class='product-secondary-information']/dl[2]/dd");
    public static final Target MONTINIC_DAP2 = Target.the("'Monto inicial'")
            .locatedBy("//div[@class='product-secondary-information']/dl[3]/dd/strong");
    public static final Target ESTADO_DAP2 = Target.the("'Estado'")
            .locatedBy("(//dd[@class='card-number'])[4]//strong");
    public static final Target TTL_MASDETALLDAP = Target.the("'Más detalle de depósito'")
            .locatedBy("//span[contains(text(),'Más detalle de depósito')]");
    public static final Target ALIAS_DAP3 = Target.the("'Alias de la cuenta'")
            .locatedBy("//dl[@class='product-detail-list'][1]/dd");
    public static final Target TIPO_DAP3 = Target.the("'Tipo de cuenta'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dd");
    public static final Target NUMERCUENTA_DAP3 = Target.the("'Número de cuenta'")
            .locatedBy("//dl[@class='product-detail-list'][3]/dd");
    public static final Target ULTPAGO_DAP3 = Target.the("'Último pago'")
            .locatedBy("//dl[@class='product-detail-list'][4]/dd");
    public static final Target ESTADO_DAP3 = Target.the("'Estado'")
            .locatedBy("//dl[@class='product-detail-list'][5]/dd");
    public static final Target SALD_PIGN_DAP3 = Target.the("'Saldo pignorado'")
            .locatedBy("//dl[@class='product-detail-list'][6]//dd//span[@class='currency-amount']");
    public static final Target MONT_INIC_DAP3 = Target.the("'Monto inicial'")
            .locatedBy("//dl[@class='product-detail-list'][6]/dd/span");
    public static final Target SALDO_PRINCIPAL3 = Target.the("'Saldo principal'")
            .locatedBy("//dl[@class='product-detail-list'][7]/dd/span");
    public static final Target SALD_INT_DAP3 = Target.the("'Saldo intereses'")
            .locatedBy("//dl[@class='product-detail-list'][8]/dd/span");
    public static final Target SALD_AL_DIA_DAP3 = Target.the("'Saldo al día'")
            .locatedBy("//dl[@class='product-detail-list'][9]/dd/span");
    public static final Target TASA_INT_DAP3 = Target.the("'Tasa interés'")
            .locatedBy("//dl[@class='product-detail-list'][10]/dd/span");
    public static final Target TASA_DIF_DAP3 = Target.the("'Tasa diferencial'")
            .locatedBy("//dl[@class='product-detail-list'][11]/dd/span");
    public static final Target PLAZO_DAP3 = Target.the("'Plazo'")
            .locatedBy("//dl[@class='product-detail-list'][12]//dd/span");
    public static final Target PERIO_FP_DAP3 = Target.the("'Período forma de pago'")
            .locatedBy("//dl[@class='product-detail-list'][13]//dd");
    public static final Target CUEN_RECEP_DAP3 = Target.the("'Cuenta receptora'")
            .locatedBy("//dl[@class='product-detail-list'][14]/dd");
    public static final Target TIPO_DEPO_DAP3 = Target.the("'Tipo de depósito'")
            .locatedBy("//dl[@class='product-detail-list'][15]/dd");
    public static final Target TTL_FECHAS_DAP3 = Target.the("Subtitulo  'Fechas'")
            .locatedBy("//span[contains(text(),'Fechas')]");
    public static final Target APERTURA_DAP3 = Target.the("'Apertura'")
            .locatedBy("//dl[@class='product-detail-list'][16]//dd");
    public static final Target ULT_PAGO_DAP3 = Target.the("'Último pago'")
            .locatedBy("//dl[@class='product-detail-list'][17]//dd");
    public static final Target CALC_INT_DAP3 = Target.the("'Cálculo interés'")
            .locatedBy("//dl[@class='product-detail-list'][18]//dd");
    public static final Target VENC_DAP3 = Target.the("'Vencimiento'")
            .locatedBy("//dl[@class='product-detail-list'][19]//dd");
    public static final Target INICIO_CICL_DAP3 = Target.the("'Inicio de ciclo'")
            .locatedBy("//dl[@class='product-detail-list'][20]//dd");
    public static final Target CANCELACION_DAP3 = Target.the("'Cancelación'")
            .locatedBy("//dl[@class='product-detail-list'][21]//dd");

    //Ticket UNI
    public static final Target MONTO_TICKET_UNI = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[8]");
    public static final Target REFERENCIA_TICKET = Target.the("'No operación'")
            .locatedBy("//p[@class='transfer-code operacion-cheq']");


    public static final Target TIPO_CUENTA_TICKET_UNI = Target.the("'Tipo de cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target BANCO_TICKET_UNI = Target.the("'Banco'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target CUENTA_A_TRANSFERIR_TICKET_UNI = Target.the("'Cuenta a transferir'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TIPO_DOCUMENTO_TICKET_UNI = Target.the("'Tipo de documento'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target NUMERO_DOCUMENTO_TICKET_UNI = Target.the("'Número de documento'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target NOMBRE_RECIBIDOR_TICKET_UNI = Target.the("'Nombre de recibidor'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target CORREO_ELECTRONICO_TICKET_UNI = Target.the("'Correo electrónico'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target COMISION_ACH_TICKET_UNI = Target.the("'Comisión ACH'")
            .locatedBy("(//span[@class='field-read-only'])[10]");
    public static final Target ESTADO_TICKET_UNI = Target.the("'Estado'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[1]");
    public static final Target CUENTA_TICKET_UNI = Target.the("'Cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[11]");
    public static final Target FECHA_ORDENANZA_TICKET_UNI = Target.the("'Fecha de ordenanza'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[2]");
    public static final Target FECHA_APLICADA_TICKET_UNI = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[12]");
    public static final Target ID_TRANSACCION_TICKET_UNI = Target.the("'ID transacción'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[3]");

    //Ticket 365 Movil
    public static final Target MONT_T365M = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target INSTITUC_DEST_T365M = Target.the("'Institución de destino'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target CEL_T365M = Target.the("'Celular'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target NOMBR_RECIB_T365M = Target.the("'Nombre del recibidor'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target CORREO_T365M = Target.the("'Correo electrónico (opcional)'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target CONCEP_T365M = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target CUENT_T365M = Target.the("'Cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target FECHA_APLICADA_T365M = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[8]");


    //Ticket Transferencia Internacional
    public static final Target NUMERO_CUENTA_TICKET_TI = Target.the("'NÚMERO DE CUENTA, IBAN O CLABE'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target NOMBRE_BENEFICIARIO_TICKET_TI = Target.the("'Nombre del beneficiario'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target DIR_BEN_TICKET_TI = Target.the("'Dirección del beneficiario'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target PAIS_REG_TICKET_TI = Target.the("'País/Región'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target SBTTL_INF2_TI = Target.the("'Cuenta A Debitar'")
            .locatedBy("//h3[@class='form-subsection-title'][5]");
    public static final Target SBTTL_INF3_TI = Target.the("'Información Monetaria De La Transacción'")
            .locatedBy("//h3[@class='form-subsection-title'][7]");
    public static final Target SBTTL_INF4_TI = Target.the("'Información Regulatoria BCR'")
            .locatedBy("//h3[@class='form-subsection-title'][8]");
    public static final Target TIP_RED_TICKET_TI = Target.the("'Tipo de red'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target COD_RUTEO_BEN_TICKET_TI = Target.the("'Código de ruteo del banco beneficiario'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target NOM_BAN_BEN_TICKET_TI = Target.the("'Nombre del banco beneficiario (banco pagador)'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target DIR_BAN_BEN_TICKET_TI = Target.the("'Dirección del banco beneficiario'")
            .locatedBy("(//span[@class='field-read-only'])[8]");
    public static final Target PAIS_BAN_BEN_TICKET_TI = Target.the("'País/Región'")
            .locatedBy("(//span[@class='field-read-only'])[9]");
    public static final Target CUENTA_DEBITAR_TICKET_TI = Target.the("'Cuenta a debitar'")
            .locatedBy("(//span[@class='field-read-only'])[10]");
    public static final Target NOMBRE_TICKET_TI = Target.the("'Nombre'")
            .locatedBy("(//span[@class='field-read-only'])[11]");
    public static final Target DIRECCION_TICKET_TI = Target.the("'Dirección'")
            .locatedBy("(//span[@class='field-read-only'])[12]");
    public static final Target TELEFONO1_TICKET_TI = Target.the("'Teléfono 1'")
            .locatedBy("(//span[@class='field-read-only'])[13]");

    public static final Target TELEFONO2_TICKET_TI = Target.the("'Teléfono 2'")
            .locatedBy("(//span[@class='field-read-only'])[14]");
    public static final Target MONEDA_TICKET_TI = Target.the("'Moneda'")
            .locatedBy("(//span[@class='field-read-only'])[15]");
    public static final Target MONTO_TRANSACCION_TICKET_TI = Target.the("'Monto de la transacción'")
            .locatedBy("(//span[@class='field-read-only'])[16]");
    public static final Target EQUIVALENTE_DOL_TICKET_TI = Target.the("'Equivalente en dólares'")
            .locatedBy("(//span[@class='field-read-only'])[17]");
    public static final Target NIVEL1_TICKET_TI = Target.the("'Nivel 1'")
            .locatedBy("(//span[@class='field-read-only'])[18]");
    public static final Target NIVEL2_TICKET_TI = Target.the("'Nivel 2'")
            .locatedBy("(//span[@class='field-read-only'])[19]");
    public static final Target DETALLE_REGULA_TICKET_TI = Target.the("'Detalle regulatorio'")
            .locatedBy("(//span[@class='field-read-only'])[20]");
    public static final Target NUMERO_FORMULARIO_TICKET_TI = Target.the("'Número de formulario'")
            .locatedBy("(//span[@class='field-read-only'])[21]");
    public static final Target FECHA_APLICADA_TICKET_TI = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[22]");


    //Ticket Recargas
    public static final Target CELULAR_TICKET_CEL = Target.the("'Celular'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target COMPANIA_TICKET_CEL = Target.the("'Compañía'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target PAQUETEMONTO_TICKET_CEL = Target.the("'Paquete/Monto'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target CONCEPTO_TICKET_CEL = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target DESDE_TICKET_CEL = Target.the("'Desde'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target DESDE_TICKET_CEL_FAV = Target.the("'Desde'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target ESTADO_TICKET_CEL = Target.the("'Estado'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[1]");
    public static final Target FECHAORDENANZA_TICKET_CEL = Target.the("'Fecha de ordenanza'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[2]");
    public static final Target FECHAAPLICADA_TICKET_CEL = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target FECHAAPLICADA_TICKET_CEL_FAV = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target IDTRANSACCION_TICKET_CEL = Target.the("'ID transacción'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[3]");


    //Ticket Donacion/Redencion
    public static final Target MONTO_TICKET_DON_RED = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TIPOOPERACION_TICKET_DON_RED = Target.the("'Tipo de operación'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target INSTITUCIONONG_TICKET_DON_RED = Target.the("'Institución de ONG'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target PRODUCTOABONAR_TICKET_DON_RED = Target.the("'Producto a abonar'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TIPOCOBRO_TICKET_DON_RED = Target.the("'Tipo de cobro'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target CABC_TICKET_DON_RED = Target.the("'Con abono a cuenta: LIBRAS DE AMOR por un monto'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target CONCEPTO_TICKET_DON_RED = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target CONCEPTO_TICKET_DON_RED2 = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[5]");

    public static final Target ESTADO_TICKET_DON_RED = Target.the("'Estado'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[1]");
    public static final Target FECHA_ORDENANZA_TICKET_DON_RED = Target.the("'Fecha de ordenanza'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[2]");
    public static final Target FECHA_APLICADA_TICKET_DON_RED = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target FECHA_APLICADA_TICKET_DON_RED2 = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target ID_TRANSACCION_TICKET_DON_RED = Target.the("'ID transacción'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[3]");


    //Ticket Transferencia puntosBA a Lifemiles
    public static final Target PRIMER_NOMBRE_TPL = Target.the("'Primer nombre'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target SEGUNDO_NOMBRE_TPL = Target.the("'Segundo nombre'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target PRIMER_APELLIDO_TPL = Target.the("'Primer apellido'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target SEGUNDO_APELLIDO_TPL = Target.the("'Segundo apellido'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target NUMERO_TARJETA_TPL = Target.the("'No. tarjeta LifeMiles'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target TOTAL_PUNTOS_TPL = Target.the("'Total de puntos'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target PUNTOS_TRANSFERIR_TPL = Target.the("'Puntos a transferir'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target CODIGO_PAIS_TPL = Target.the("'Código de país'")
            .locatedBy("(//span[@class='field-read-only'])[9]");
    public static final Target NUMERO_TEL_TPL = Target.the("'Número telefónico'")
            .locatedBy("(//span[@class='field-read-only'])[10]/span/span[3]");
    public static final Target CUENTA_CARGAR_TPL = Target.the("'Cuenta a cargar'")
            .locatedBy("(//span[@class='field-read-only'])[8]");
    public static final Target FECHA_APLICADA_TICKET_TPL = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[11]");


    //Ticket pago prestamos UNI
    public static final Target TICKET_PREST_UNI_MONTO = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target TICKET_PREST_UNI_BANCO = Target.the("'Banco'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TICKET_PREST_UNI_PRESTABO = Target.the("'Préstamo a abonar'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_PREST_UNI_TIPODOC = Target.the("'Tipo de documento'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TICKET_PREST_UNI_NUMDOC = Target.the("'Número de documento'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target TICKET_PREST_UNI_NOMREC = Target.the("'Nombre de recibidor'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target TICKET_PREST_UNI_CORREO = Target.the("'Correo electrónico'")
            .locatedBy("(//span[@class='field-read-only'])[6]");
    public static final Target TICKET_PREST_UNI_CONCEPTO = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[8]");
    public static final Target TICKET_PREST_UNI_COMISIONACH = Target.the("'Comisión ACH'")
            .locatedBy("(//span[@class='field-read-only'])[10]");
    public static final Target TICKET_PREST_UNI_CUENTA = Target.the("'Cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[9]");
    public static final Target TICKET_PREST_UNI_ESTADO = Target.the("'Estado'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[1]");
    public static final Target TICKET_PREST_UNI_FECORDE = Target.the("'Fecha de ordenanza'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[2]");
    public static final Target TICKET_PREST_UNI_FECAPLI = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[11]");
    public static final Target TICKET_PREST_UNI_ID = Target.the("'ID transacción'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[3]");


    //Ticket Solicitud de estado de cuenta por e-mail
    public static final Target TICKET_SOLESTACUEEMAIL1 = Target.the("'Estados de cuenta que empezarás a recibir'")
            //        .locatedBy("(//span[@class='field-read-only'])[1]");
            .locatedBy("//span[contains(text(),'Estados de cuenta que empezarás a recibir')]//following::span[1]");
    public static final Target TICKET_SOLESTACUEEMAIL2 = Target.the("'Estados de cuenta que dejarás de recibir'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TICKET_SOLESTACUEEMAIL_CORREO = Target.the("'Correo electrónico en el cual recibirás los estados de cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_SOLESTACUEEMAIL_CONDICIONES = Target.the("'Condiciones del servicio'")
            .locatedBy("//p[@class='form-auxiliar-text']/span");
    public static final Target TICKET_SOLESTACUEEMAIL_ESTADO = Target.the("'Estado'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[1]");
    public static final Target TICKET_SOLESTACUEEMAIL_FECHORDEN = Target.the("'Fecha de ordenanza'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[2]");
    public static final Target TICKET_SOLESTACUEEMAIL_FECHAAPLICADA = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TICKET_SOLESTACUEEMAIL_IDTRANSACCION = Target.the("'ID transacción'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[3]");

    //Ticket eliminacion transaccion programada
    public static final Target TICKET_CREACION_TRX_PROGRAMADA_MONTO = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_CREACION_TRX_PROGRAMADA_CUENCRED = Target.the("'Cuenta crédito'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TICKET_CREACION_TRX_PROGRAMADA_CONCEPTO = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TICKET_CREACION_TRX_PROGRAMADA_CUENDEB = Target.the("'Cuenta débito'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target TICKET_CREACION_TRX_PROGRAMADA_FECHPROG = Target.the("'Fecha programada'")
            .locatedBy("(//span[@class='field-read-only'])[5]");

    //Ticket pago servicios NPE
    public static final Target TICKET_PAGOSERVICIOSNPE_MONTO = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TICKET_PAGOSERVICIOSNPE_RECIBO = Target.the("'Recibo'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_PAGOSERVICIOSNPE_NPE = Target.the("'NPE'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TICKET_PAGOSERVICIOSNPE_DESDE = Target.the("'Desde'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target TICKET_PAGOSERVICIOSNPE_ESTADO = Target.the("'Estado'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[1]");
    public static final Target TICKET_PAGOSERVICIOSNPE_FECHAORDENANZA = Target.the("'Fecha de ordenanza'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[2]");
    public static final Target TICKET_PAGOSERVICIOSNPE_FECHA_APLICADA = Target.the("'Fecha aplicada'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target TICKET_PAGOSERVICIOSNPE_ID = Target.the("'ID transacción'")
            .locatedBy("(//span[@class='field-read-only field-remesa'])[3]");

    //Ticket pago servicios NPE
    public static final Target TICKET_TRANSFERENCIA_AP_MONTO = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_TRANSFERENCIA_AP_CUENTACRED = Target.the("'Cuenta crédito'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TICKET_TRANSFERENCIA_AP_CONCEPTO = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TICKET_TRANSFERENCIA_AP_CUENTADEB = Target.the("'Cuenta débito'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target TICKET_TRANSFERENCIA_AP_MONTO_TER = Target.the("'Monto'")
            .locatedBy("(//span[@class='field-read-only'])[4]");
    public static final Target TICKET_TRANSFERENCIA_AP_NOMDES_TER = Target.the("'Nombre del destinatario'")
            .locatedBy("(//span[@class='field-read-only'])[1]");
    public static final Target TICKET_TRANSFERENCIA_AP_NUMCUE_TER = Target.the("'Número de cuenta'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_TRANSFERENCIA_AP_CELULAR_TER = Target.the("'Celular'")
            .locatedBy("(//span[@class='field-read-only'])[2]");
    public static final Target TICKET_TRANSFERENCIA_AP_CORREO_TER = Target.the("'Correo electrónico'")
            .locatedBy("(//span[@class='field-read-only'])[3]");
    public static final Target TICKET_TRANSFERENCIA_AP_CONCEPTO_TER = Target.the("'Concepto'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target TICKET_TRANSFERENCIA_AP_IMPOF_TER = Target.the("'Impuesto de Operaciones Financieras'")
            .locatedBy("(//span[@class='field-read-only'])[7]");
    public static final Target TICKET_TRANSFERENCIA_AP_CUEDEB_TER = Target.the("'Cuenta débito'")
            .locatedBy("(//span[@class='field-read-only'])[6]");

    //Numero de reserva
    public static final Target RESERVA_CA = Target.the("'Número de reserva'")
            .locatedBy("(//span[@class='field-read-only'])[5]");
    public static final Target RESERVA_CA2 = Target.the("'Número de reserva'")
            .locatedBy("(//span[@class='field-read-only field-pagoes'])[1]");

    public static final Target BTN_FINALIZAR3 = Target.the("botón 'Finalizar'")
            .locatedBy(" //div/a/span[.='Finalizar']");


    private CuentasPage() {
    }
}