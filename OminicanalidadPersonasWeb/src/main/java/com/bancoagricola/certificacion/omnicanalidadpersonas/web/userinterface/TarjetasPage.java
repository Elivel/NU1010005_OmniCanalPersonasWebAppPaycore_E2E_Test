package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;


import org.openqa.selenium.By;

public class TarjetasPage {

    public static final Target VER_MAS_CUENTA_TC = Target.the("link 'Ver más'")
            .locatedBy("//span[contains(text(),'{0}')]/../../../div[2]/ul/li[.='Ver más']/a");
    public static final Target MÁS_DETALLES = Target.the("btn más detalles")
            .locatedBy("//*[@class=\"icon-see-more\"][.=\"Más detalle\"]");
    public static final Target DISPONIBILIDAD_TARJETA = Target.the("ver disponibilidad tarjetas de credito")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[8]");
    public static final Target NUMERO_RESERVA = Target.the("'Número Reserva'")
            .locatedBy("(//*/div[5])[1]/div/span");
    public static final Target P_LIMITE_CREDITO = Target.the("'Limite de credito'")
            .locatedBy("(//dl[@class='product-detail-list']/dd/span)[1]");
    public static final Target OPCION_PAGO_TARJETA1 = Target.the("'Opción Pagar Tarjeta'")
            .locatedBy("(//div[1]/ul/li[2]/a/span)[1]");
    public static final Target SELECCIONAR_CUENTA_ORIGEN1 = Target.the("'Lista de cuentas propias'")
            .locatedBy("(//*[@class='select-content'])[1]");
    public static final Target SELECCIONAR_CUENTA_ORIGEN = Target.the("'{0}'")
            .locatedBy("(//div[contains(text(),'{0}')])[1]");


    //Consulta Puntos BA
    public static final Target PRODUCTOS_PP = Target.the("'Productos'")
            .locatedBy("//ul[@class='product-list']");
    public static final Target MENU_VERTICAL = Target.the("'Menu Vertical'")
            .locatedBy("//ul[@class='vertical-navigation']/li/a[@class='icon-wallet']");
    public static final Target MENU_TARJETAS = Target.the("menú 'Tarjetas'")
            .locatedBy("//a[@class='icon-wallet']/span[.='Tarjetas']");
    public static final Target TOTAL_TDC = Target.the("Total Disponible TDC'")
            .locatedBy("//span[contains(text(),'Total Disponible TDC')]");
    public static final Target LNK_VER_MAS_PUNTOS = Target.the("link 'Ver más'")
            .locatedBy("//h3[@class='card-title']/../../div/ul/li/a/span[text()='Ver más']");
    public static final Target TTL_RES_PUNTOS = Target.the("'Resumen de detalle de Puntos y CashBac'")
            .locatedBy("//span[contains(text(),'Resumen de detalle de Puntos y CashBac')]");
    public static final Target TTL_MAS_DETALLE = Target.the("'Más detalle'")
            .locatedBy("//span[contains(text(),'Más detalle')]");
    public static final Target PUNTOS_ACUMULADOS = Target.the("'Puntos acumulados'")
            .locatedBy("//dl[@class='product-detail-list pba-puntos-acumulados']/dd/span");

    /*Redencion y Donacion de CashBac*/
    public static final Target LINK_REDENCION_DONACION = Target.the("'Link Redención y donación de CashBac'")
            .locatedBy("//a[@class='round-button icon-redencioncashbac']/span");
    public static final Target OBTENER_CASHBAC = Target.the("'Saldo Disponible CashBac'")
            .locatedBy("(//*/div/div/div/span)[1]");
    public static final Target ACTIVAR_LISTA_TIPO_OPERACION = Target.the("'Activa las opciones para Tipo de Operacion'")
            .locatedBy("(//*[@class='selectize-control single'])[1]");
    public static final Target ACTIVAR_LISTA_INSTITUCION = Target.the("'Activa las opciones para Institucion'")
            .locatedBy("(//*[@class='selectize-control single'])[2]");
    public static final Target ACTIVAR_LISTA_PRODUCTO_ABONAR = Target.the("'Activa las opciones para el producto a abonar'")
            .locatedBy("(//*[@class='selectize-control single'])[2]");
    public static final Target ACTIVAR_LISTA_TIPO_COBRO = Target.the("'Activa las opciones para Tipo de Cobro'")
            .locatedBy("(//*[@class='selectize-control single'])[3]");
    public static final Target SELECCIONAR_TIPO_OPERACION = Target.the("'Ingresa opcion Tipo Operacion'")
            .locatedBy("//div[contains(text(),'{0}')]");
    public static final Target SELECCIONAR_INSTITUCION = Target.the("'Ingresa opcion Institucion ONG'")
            .locatedBy("//div[contains(text(),'{0}')]");
    public static final Target SELECCIONAR_PRODUCTO_ABONAR = Target.the("'Ingresa opcion del Producto a Abonar'")
            .locatedBy("//div[contains(text(),'{0}')]");
    public static final Target SELECCIONAR_TIPO_COBRO = Target.the("'Ingresa opcion Tipo Cobro'")
            .locatedBy("//div[contains(text(),'{0}')]");
    public static final Target LBL_RESULTADO_DONACION = Target.the("'Mensaje de Resultado al Donar'")
            .locatedBy("//span[contains(text(),'Donación de CashBac - Resultado')]");
    public static final Target LBL_RESULTADO_REDENCION = Target.the("'Mensaje de Resultado al Donar'")
            .locatedBy("//span[contains(text(),'Redención de CashBac - Resultado')]");
    public static final Target BTN_ACEPTAR_DON = Target.the("'Botón Aceptar'")
            .locatedBy("(//*/button)[2]/span[1]");

    //Localicadores detalle de TDD
    public static final Target ESTADO_TDD1 = Target.the("'Estado'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[4]/p[1]");
    public static final Target NUM_TDD1 = Target.the("'Número de tarjeta de débito'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[2]/p[1]");
    public static final Target TTL_RES_DETALLE_TDD = Target.the("'Resumen de tarjeta de débito'")
            .locatedBy("//span[contains(text(),'Resumen de tarjeta de débito')]");
    public static final Target CUENTA_PRIMARIA_TDD2 = Target.the("'Cuenta primaria'")
            .locatedBy("//dl[@class='information-item'][3]/dd");
    public static final Target SALDO_RETENIDO_TDD2 = Target.the("'Saldo Retenido'")
            .locatedBy("//dl[@class='information-item'][4]/dd");
    public static final Target ESTADO_TDD2 = Target.the("'Estado'")
            .locatedBy("//dl[@class='information-item'][5]/dd");
    public static final Target TTL_MAS_DETALLE_TDD = Target.the("'Más detalle de tarjeta de débito'")
            .locatedBy("//span[contains(text(),'Más detalle de tarjeta de débito')]");
    public static final Target SALDODISPO_TDD3 = Target.the("'Saldo disponible'")
            .locatedBy("//dl[@class='product-detail-list'][4]/dd/span");
    public static final Target SALDORET_TDD3 = Target.the("'Saldo Retenido'")
            .locatedBy("//dl[@class='product-detail-list'][5]/dd/span");
    public static final Target PUNTOSBA_TDD3 = Target.the("'PuntosBA'")
            .locatedBy("//dl[@class='product-detail-list'][6]/dd/span");
    public static final Target CUENPRIM_TDD3 = Target.the("'Cuenta primaria'")
            .locatedBy("//table/tr[1]/dl/dd[1]");


    //Localicadores detalle de TDC
    public static final Target LOGO_TDC1 = Target.the("'Franquicia'")
            .locatedBy("//span[contains(text(),'{0}')]/../..//h3");
    public static final Target ALIASTDC1 = Target.the("'Alias de la tarjeta'")
            .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target SALDO_TDC1 = Target.the("'Saldo disponible'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[3]/span");
    public static final Target FECHA_PAGO_TDC1 = Target.the("'Fecha de pago'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[4]/p[1]");
    public static final Target ESTADO_TDC1 = Target.the("'Estado'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[5]/p[1]");
    public static final Target NUM_TDC1 = Target.the("'Número de tarjeta de crédito'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[2]/p[1]");
    public static final Target TIPO_TDC1 = Target.the("'Tipo'")
            .locatedBy("//span[contains(text(),'{0}')]/../../div[2]/p[3]/span");
    public static final Target ALIASTDC2 = Target.the("'Alias de la tarjeta'")
            .locatedBy("//div[@class='creditcards-alias']");
    public static final Target NUM_TDC2 = Target.the("'Número de tarjeta de crédito'")
            .locatedBy("//div[@class='card-number']");
    public static final Target TIPO_TDC2 = Target.the("'Tipo'")
            .locatedBy("//dl[@class='information-item'][1]/dd");
    public static final Target SALDO_TDC2 = Target.the("'Saldo disponible'")
            .locatedBy("//div[@class='product-secondary-information']/dl[2]/dd/span");
    public static final Target FECHA_PAGO_TDC2 = Target.the("'Fecha de pago'")
            .locatedBy("//dl[@class='information-item'][3]/dd");
    public static final Target PAGO_CONTADO_TDC1 = Target.the("'Pago de contado'")
            .locatedBy("//div[@class='product-secondary-information']/dl[4]/dd/span");
    public static final Target SALDO_PAGAR_TDC1 = Target.the("'Saldo a pagar'")
            .locatedBy("//div[@class='product-secondary-information']/dl[5]/dd/span");
    public static final Target SALDO_RETENIDO_TDC1 = Target.the("'Saldo retenido'")
            .locatedBy("//div[@class='product-secondary-information']/dl[6]/dd/span");
    public static final Target ESTADO_TDC2 = Target.the("'Estado'")
            .locatedBy("//dl[@class='information-item'][7]/dd");
    public static final Target TARJ_CRED1 = Target.the("'Tipo de tarjeta'")
            .locatedBy("//div[@class='card-type']");
    public static final Target TTL_MAS_DETALLE_TDC = Target.the("'Más detalle de tarjeta de crédito'")
            .locatedBy("//span[contains(text(),'Más detalle de tarjeta de crédito')]");

    public static final Target TTL_MAS_DETALLE_ECARD = Target.the("'Más detalle de e-card'")
            .locatedBy("//span[contains(text(),'Más detalle de e-card')]");

    public static final Target ALIASTDC3 = Target.the("'Alias de la tarjeta'")
            .locatedBy("//dl[@class='product-detail-list detail-first-list'][1]//dd");
    public static final Target TIPO_TDC3 = Target.the("'Tipo'")
            .locatedBy("//dl[@class='product-detail-list aligned-selectos'][1]//dd");
    public static final Target NUM_TDC3 = Target.the("'Número de tarjeta de crédito'")
            .locatedBy("//dl[@class='product-detail-list'][1]//dd");
    public static final Target ESTADO_TDC3 = Target.the("'Estado'")
            .locatedBy("//dl[@class='product-detail-list'][2]//dd");
    public static final Target FRANQUICIA_TDC = Target.the("'Franquicia'")
            .locatedBy("//dl[@class='product-detail-list'][3]/dd");
    public static final Target LIMITE_OTORGADO = Target.the("'Límite otorgado'")
            .locatedBy("//dl[@class='product-detail-list'][4]/dd/span");
    public static final Target SALDO_UTILIZADO = Target.the("'Saldo utilizado'")
            .locatedBy("//dl[@class='product-detail-list'][5]/dd/span");
    public static final Target DISPONIBILIDAD = Target.the("'Disponibilidad'")
            .locatedBy("//dl[@class='product-detail-list'][6]/dd/span");
    public static final Target SALDO_RETENIDO_TDC2 = Target.the("'Saldo Retenido'")
            .locatedBy("//dl[@class='product-detail-list'][7]/dd/span");
    public static final Target PAGO_MINIMO = Target.the("'Mínimo'")
            .locatedBy("//dl[@class='product-detail-list'][8]/dd/span");
    public static final Target PAGO_CONTADO = Target.the("'Contado'")
            .locatedBy("//dl[@class='product-detail-list'][9]/dd/span");
    public static final Target FECHA_PAGO_TDC3 = Target.the("'Fecha de pago'")
            .locatedBy("//dl[@class='product-detail-list'][10]//dd");
    public static final Target DIA_CORTE = Target.the("'Día de corte'")
            .locatedBy("//dl[@class='product-detail-list'][11]//dd");
    public static final Target MORA_ = Target.the("'Mora'")
            .locatedBy("//span[normalize-space()='Mora']");
    public static final Target DIAS30 = Target.the("'30 días'")
            .locatedBy("//dl[@class='product-detail-list'][12]/dd/span");
    public static final Target DIAS60 = Target.the("'60 días'")
            .locatedBy("//dl[@class='product-detail-list'][13]/dd/span");
    public static final Target DIAS90 = Target.the("'90 días'")
            .locatedBy("//dl[@class='product-detail-list'][14]/dd/span");
    public static final Target MORA_TOTAL = Target.the("'Mora total'")
            .locatedBy("//dl[@class='product-detail-list'][15]/dd/span");
    public static final Target HONO_COBR_EXT = Target.the("'Honorarios cobro externo'")
            .locatedBy("//dl[@class='product-detail-list honorarios-cobro'][1]/dd/span");
    public static final Target TOTAL_PAGO = Target.the("'Total de pago'")
            .locatedBy("//dl[@class='product-detail-list'][16]/dd/span");
    public static final Target TTL_MOV_TARJ = Target.the("'Movimientos de tarjeta'")
            .locatedBy("//span[contains(text(),'Movimientos de tarjeta')]");
    public static final Target REGISTRO_MOV_TC = Target.the("registro '{0}'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td//span[text()='{0}']");
    public static final Target VENT_EMER_DETA_MOV = Target.the("ventana emergente de 'Detalle de movimiento'")
            .locatedBy("//div[@class='popup scrollable popup-left']");
    public static final Target TTL_VENT_EMER_DETA_MOV = Target.the("titulo 'Detalle de movimiento'")
            .locatedBy("//span[contains(text(),'Detalle de movimiento')]");
    public static final Target TARJETAS_ADICIONALES = Target.the("opción tarjetas adicionales")
            .locatedBy("//span[contains(text(),'Consulta de tarjetas adicionales')]");
    public static final Target TTL_CONSUL_TDC_ADICIONALES = Target.the("Titulo 'Consulta de tarjetas adicionales'")
            .locatedBy("//span[contains(text(),'Consulta de tarjetas adicionales')]");
    public static final Target TABLA_TDC_ADICONALES = Target.the("Tabla tarjetas adiconales")
            .locatedBy("//table[@class='selectable']");
    public static final Target NUM_TDC_ADIC = Target.the("Numero de TDC adcional")
            .locatedBy("//span[contains(text(),'Número de tarjeta adicional')]//following::td[1]");
    public static final Target NUM_TDC_ADIC2 = Target.the("Número de Tarjeta e-card")
            .locatedBy("//td[contains(text(),'**** 6279')]");
    public static final Target NOMBRE_TDC_ADICIONAL = Target.the("Nombre de la TDC adicional")
            .locatedBy("//span[contains(text(),'Número de tarjeta adicional')]//following::td[5]//following::td[2]");
    public static final Target ESTADO_TDC_ADIC = Target.the("estado de la TDC adicional")
            .locatedBy("//span[contains(text(),'Número de tarjeta adicional')]//following::td[5]//following::td[3]");
    public static final Target LIMITE_CREDI_TDC_ADIC = Target.the("Limite de credito TDC adicional")
            .locatedBy("//span[contains(text(),'Número de tarjeta adicional')]//following::td[5]//following::td[4]/span/span[2]");
    public static final Target SALDO_DISPO_TDC_ADIC = Target.the("Saldo disponible TDC Adicional")
            .locatedBy("//span[contains(text(),'Número de tarjeta adicional')]//following::td[5]//following::td[5]/span/span[2]");
    public static final Target TTL_NUM_ECARD_ADICIONAL = Target.the("Titulo numero de tarjeta Ecard adicional")
            .locatedBy("//span[contains(text(),'Número de tarjeta e-card')]");

    public static final Target NUM_ECARD_ADICIONAL = Target.the("Numero de tarjeta e-card adicional")
            .locatedBy("//span[contains(text(),'Número de tarjeta e-card')]//following::td[1]");
    public static final Target NOMB_ECARD = Target.the("nombre de ecard")
            .locatedBy("//span[contains(text(),'Número de tarjeta e-card')]//following::td[2]");
    public static final Target ESTADO_ECARD_ADIC = Target.the("Estado de ecard en la consulta de tarjetas adicionales")
            .locatedBy("//span[contains(text(),'Número de tarjeta e-card')]//following::td[3]");
    public static final Target SALDO_DISP_ECARD = Target.the("Saldo disponible ecard")
            .locatedBy("//span[contains(text(),'Número de tarjeta e-card')]//following::td[5]/span/span[2]");

    public static final Target LIMITE_CRED_ECARD = Target.the("Valor limite de ecard TDC adiconal")
            .locatedBy("//span[contains(text(),'Número de tarjeta e-card')]//following::td[4]/span/span[2]");


    /*Consulta detalle compras a plazo*/
    public static final Target OPCION_OTROS = Target.the("opción 'Otros'")
            .locatedBy("//span[.='Otros']");
    public static final Target OPCION_MOVTARJE = Target.the("'Movimientos de tarjeta'")
            .locatedBy("//span[.='Movimientos de tarjeta']");
    public static final Target OPCION_COMPRPLAZ = Target.the("'Compras a plazo'")
            .locatedBy("//span[.='Compras a plazo']");


    public static final Target TABLA_COMPRAS_PLAZO = Target.the("'Tabla con los registros de compras a plazo'")
            .locatedBy("//table[@class='selectable']");
    public static final Target NUMERO_AUTORIZACION = Target.the("Nº autorización: '{0}'")
            .locatedBy("//tr/td[contains(text(),'{0}')]");
    public static final Target LABEL_DETALLE_COMPRA_PLAZO = Target.the("'Detalle de compras a plazo'")
            .locatedBy("//span[.='Detalle de compras a plazo']");
    public static final Target TABLA_DETALLE_COMPRA_PLAZO = Target.the("Tabla 'Detalle de compras a plazo'")
            .locatedBy("//div[@class='table-wrapper scrollable']/table");

    //Cambio de limite Tarjetas adicionales y ecard
    public static final Target LINK_CAMB_LIMITE_ECARD = Target.the("Link de cambio de limite ecard")
            .locatedBy("//span[contains(text(),'Cambio de límite e-card')]");
    public static final Target TLL_CAMB_LIMITE_ECARD = Target.the("Titulo cambio de limite ecard")
            .locatedBy("//span[contains(text(),'Cambio de límite e-card')]");
    public static final Target CMB_ECARD = Target.the("ComboBox selecciona tu tarjeta ecard")
            .locatedBy("//span[contains(text(),'Selecciona tu tarjeta e-card')]//following::div[1]/div/div[1]");
    public static final Target CMBX_LIMITE_ECARD = Target.the("Seleccionar el limite de tarjeta ecard")
            .locatedBy("//span[contains(text(),'Selecciona el límite de tu e-card')]//following::div[1]/div");
    public static final Target PORCENTAJE_LIM_ECARD = Target.the("Porcentaje de ecard")
            .locatedBy("//div[contains(text(),'45%')]");
    public static final Target LIMITE_ACTUAL_ECARD = Target.the("Limite actual de ecard")
            .locatedBy("//span[contains(text(),'Límite actual de tu e-card')]//following::span[2]/span[2]");
    public static final Target BTN_CONTIUAR_ECARD = Target.the("Botón continuar en pantalla cambio de limite ecard")
            .locatedBy("//button[@type='button']");
    public static final Target TARJETA_TITULAR = Target.the("numero de tarjeta titular")
            .locatedBy("//span[contains(text(),'Tarjeta titular')]//following::span[1]");
    public static final Target LIMITE_TDC_TITULAR = Target.the("Limite tarjeta titular")
            .locatedBy("//span[contains(text(),'Límite tarjeta titular')]//following::span[2]/span[2]");

    //Cambio de limite tarjeta adicional
    public static final Target LNK_CAMB_LIMT_TDC_ADIC = Target.the("Link cambio de limite de tarjeta adicional")
            .locatedBy("//span[contains(text(),'Cambio de límite Tarjeta de crédito Adicional')]");
    public static final Target LBL_CAMB_LIMITE_TDC_ADIC = Target.the("Titulo cambio de limite tarjeta adicional")
            .locatedBy("//span[contains(text(),'Cambio de límite Tarjeta de crédito Adicional')]");
    public static final Target TTL_TIPO_TARJETA = Target.the("Tipo de tarjeta")
            .locatedBy("//table[@class='selectable']/tbody/tr[1]/td[1]");
    public static final Target TLL_NUM_TARJETA = Target.the("Numero de tarjeta adicional")
            .locatedBy("//table[@class='selectable']/tbody/tr[1]/td[2]");
    public static final Target TLL_NOMBRE_TARJETA = Target.the("Nombre de tarjeta adicional")
            .locatedBy("//table[@class='selectable']/tbody/tr[1]/td[3]");
    public static final Target TLL_ESTADO_TARJETA = Target.the("Estado de tarjeta adicional")
            .locatedBy("//table[@class='selectable']/tbody/tr[1]/td[4]");
    public static final Target LIMIT_CREDITO = Target.the("Limite del credito TDC")
            .locatedBy("//table[@class='selectable']/tbody/tr[1]/td[5]/span[1]/span[2]");
    public static final Target SALDO_DISPO_TDC = Target.the("Saldo disponible TDC")
            .locatedBy("//table[@class='selectable']/tbody/tr[1]/td[6]/span[1]/span[2]");
    public static final Target MSG_CAMB_TDC_ADIC = Target.the("Mensaje de exito cambio de limite tdc adicional")
            .locatedBy("//span[contains(text(),'Cambio de límite tarjeta adicional - Resultado')]");


    public static final Target NUM_TDC_PRINC = Target.the("Numero de TDC principal")
            .locatedBy("//span[contains(text(),'Cambio de límite Tarjeta de crédito Adicional')]//following::span[1]");
    public static final Target CMB_TARJETA_ADIC = Target.the("Numero de tarjeta adicional en pantalla cambio de limite")
            .locatedBy("//span[contains(text(),'Tarjeta adicional')]//following::div[1]");
    public static final Target TXT_LIMITE_TARJETA_ADIC = Target.the("Campo para ingresar el nuevo limite de la tarjeta adicional")
            .locatedBy("//input[@type='tel']");
    public static final Target TXT_NUEVO_LIMITE_ECARD = Target.the("Nuevo limite ecard")
            .locatedBy("//span[contains(text(),'Ingresa el límite de tu e-card')]//following::input");
    public static final Target BTN_CONFIR_CAMB = Target.the("Botón Continuar en pop up de confirmación Cambio de limite tdc adicional")
            .locatedBy("//span[contains(text(),'¿Deseas continuar?')]//following::span[2]");
    public static final Target NUM_TDC_TITULAR_ECARD = Target.the("Capturar numero de tdc titular")
            .locatedBy("//span[contains(text(),'Tarjeta titular')]//following::span[1]");
    public static final Target LIM_TDC_TITULAR_ECARD = Target.the("Capturar limite de tdc titular")
            .locatedBy("//span[contains(text(),'Límite tarjeta titular')]/following::span[1]");
    public static final Target LIM_ACTUAL_ECARD = Target.the("Capturar limite actual ecard")
            .locatedBy("//span[contains(text(),'Límite actual de tu e-card')]/following::span[1]");
    public static final Target ACEPTAR_TERMI_CONDI_ECARD = Target.the("Aceptar terminos y condiciones cambio de limite ecard")
            .locatedBy("//div[@class='field-checkbox field-small']");
    public static final Target BTN_ACEP_CAMB_LIMITE_ECARD = Target.the("Botón Aceptar pantalla de confirmación cambio de limite limite ecard")
            .locatedBy("//span[contains(text(),'Aceptar')]");
    public static final Target LBL_MSG_EXITO_CAMB_LIMITE_ECARD = Target.the("Mensaje de exito para cambio de limite limite ecard")
            .locatedBy("//span[contains(text(),'Cambio límite e-card - Resultado')]");
    public static final Target TICKET_NUM_ECARD = Target.the("Numero de ecard en ticket")
            .locatedBy("//span[contains(text(),'Tarjeta e-card')]//following::span[1]");
    public static final Target TICKET_NUM_TDC_TITULAR = Target.the("Numero de ecard en ticket")
            .locatedBy("//span[contains(text(),'Tarjeta titular')]//following::span[1]");
    public static final Target TICKET_LIM_TDC_TITULAR = Target.the("Limite tdc titular en ticket")
            .locatedBy("//span[contains(text(),'Límite tarjeta titular')]//following::span[1]");
    public static final Target TICKET_LIM_ACTUAL_ECARD = Target.the("Limite actual de ecard en ticket")
            .locatedBy("//span[contains(text(),'Límite actual de tu e-card')]//following::span[1]");
    public static final Target TICKET_NUEVO_LIM_ECARD = Target.the("Nuevo limite de ecard en ticket")
            .locatedBy("//span[contains(text(),'Límite de tu e-card')]//following::span[1]");
    public static final Target TICKET_ESTADO_CAM_LIM_ECARD = Target.the("Estado de cambio limite de ecard en ticket")
            .locatedBy("//span[contains(text(),'Estado')]//following::span[1]");


    //Consultas de diferidos de TDC
    public static final Target TTL_FONDOS_RESERV = Target.the("titulo 'Fondos reservados'")
            .locatedBy("//span[contains(text(),'Fondos reservados')]");
    public static final Target TABLA_DIF_TC = Target.the("Tabla de diferidos'")
            .locatedBy("//div[2][@class='table-wrapper']/table");
    public static final Target REG_TABLA_DIF_TC = Target.the("Registros en tabla de diferidos'")
            .locatedBy("//div[2][@class='table-wrapper']/table/tbody/tr");

    //Pago compras a plazo
    public static final Target PAGO_TAR_PROP = Target.the("link 'Pago de tarjeta'")
            .locatedBy("//a[@class='round-button icon-cards']//span[contains(text(),'Pago de tarjeta')]");
    public static final Target TTL_PAGO_TAR = Target.the("titulo 'Pago de tarjeta'")
            .locatedBy("//span[contains(text(),'Pago de tarjeta')]");
    public static final Target SELECC_TARJ = Target.the("selecciona tarjeta '{0}'")
            .locatedBy("//ul/li/a/span[1]/span[contains(text(),'{0}')]");
    public static final Target TTL_PAGO_TAR_PROP = Target.the("titulo 'Pago de tarjeta'")
            .locatedBy("//span[contains(text(),'Pago de tarjeta de crédito propia')]");
    public static final Target RADIO_CP = Target.the("opción '{0}'")
            .locatedBy("//div[@class='radio']");
    public static final Target SELECTOR_CP = Target.the("'Selector de compras a plazo'")
            .locatedBy("//div[@class='selectize-input items not-full has-options']");
    public static final Target SELEC_CP = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'{0}')]");
    public static final Target SELECTOR_TPAGO = Target.the("'Selector de tipo de pago'")
            .locatedBy("//div[@class='form-line-wrapper selector-wrapper'][3]//div[@class='selectize-wrapper']");
    public static final Target SELEC_TPAGO = Target.the("'{0}'")
            .locatedBy("//div[@class='selectize-dropdown-content']//div[contains(text(),'Otro monto')]");
    public static final Target MSG_PAGO_EXITOSO = Target.the("'La tarjeta de crédito se pagó exitosamente'")
            .locatedBy("//span[contains(text(),'La tarjeta de crédito se pagó exitosamente')]");

    public static final Target MSG_PAGO_EXITOSO1 = Target.the("'La tarjeta de crédito se pagó exitosamente'")
            .locatedBy("//h2/span[.='La tarjeta de crédito se pagó exitosamente']");

    public static final Target MSG_PAGO_EXITOSO_COMPRA_A_PLAZO = Target.the("'La compra a plazo se pagó exitosamente'")
            .locatedBy("//span[contains(text(),'La compra a plazo se pagó exitosamente')]");


    public static final Target LABEL_ULTIMA_FECHA_PAGO = Target.the("'La tarjeta de crédito se pagó exitosamente'")
            .locatedBy("//span[contains(text(),'Última fecha de pago')]");


    //Transferencia puntosBA a Lifemiles
    public static final Target TRANSF_PAL = Target.the("link 'Transferencia de Puntos a LifeMiles'")
            .locatedBy("//a[@class='round-button icon-lifemiles']/span");
    public static final Target STTL_SELTAR = Target.the("'Selecciona la tarjeta LifeMiles a la cual transferir'")
            .locatedBy("//span[contains(text(),'Selecciona la tarjeta LifeMiles a la cual transfer')]");
    public static final Target BTN_TOC = Target.the("'Transferir a otra cuenta'")
            .locatedBy("//span[contains(text(),'Transferir a otra cuenta')]");
    public static final Target LNK_CARGPLAN = Target.the("'Cargar plantilla'")
            .locatedBy("//span[contains(text(),'Cargar plantilla')]");
    public static final Target SEL_CUENTA = Target.the("'Selector de cuenta'")
            .locatedBy("(//div[@class='selectize-input items has-options full has-items']/div)[1]");
    public static final Target CUENTA = Target.the("'{0}'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[1]/div/div[@class='account-name-wrapper']/div[@class='section-info'][contains(text(),'{0}')]");
    public static final Target PRIM_NOM = Target.the("'Primer nombre'")
            .located(By.name("creditProductFirstName"));
    public static final Target SEGUN_NOM = Target.the("'Segundo nombre'")
            .located(By.name("creditProductSecondName"));
    public static final Target PRIM_APE = Target.the("'Primer apellido'")
            .located(By.name("creditProductFirstLastName"));
    public static final Target SEGUN_APE = Target.the("'Segundo apellido'")
            .located(By.name("creditProductSecondLastName"));
    public static final Target LIFEMILES_NUM = Target.the("'No. tarjeta LifeMiles'")
            .located(By.name("creditProductNumber"));
    public static final Target PUNTOS_TRANF = Target.the("'Puntos a transferir'")
            .located(By.name("transferPoints"));
    public static final Target SEL_CODPAIS = Target.the("'Selector de Código de país'")
            .locatedBy("(//div[@class='selectize-input items has-options full has-items'])[2]");
    public static final Target OPC_PAIS = Target.the("'{0}'")
            .locatedBy("//div[@class='optgroup']//span[contains(text(),'{0}')]");
    public static final Target NUM_TELEF = Target.the("'Número telefónico'")
            .located(By.name("phoneNumber"));
    public static final Target MSG_CONFIRMACION = Target.the("'La solicitud se realizó exitosamente'")
            .locatedBy("//span[contains(text(),'La solicitud se realizó exitosamente')]");

    //Consulta detalle puntos BA y CashBac
    public static final Target ALIAS_PUNTOSBA = Target.the("'Alias 'Puntos BA'")
            .locatedBy("//div[@class='product-information']/h3[contains(text(),'{0}')]");
    public static final Target TIPO_PRD = Target.the("'Tipo de producto'")
            .locatedBy("//h3[contains(text(),'{0}')]/../p/span");
    public static final Target PUNTOSACUM = Target.the("'Puntos Acumulados'")
            .locatedBy("//h3[contains(text(),'{0}')]/../div[1]/span");
    public static final Target SALDOENDOL = Target.the("'Saldo En $'")
            .locatedBy("//h3[contains(text(),'{0}')]/../div[2]/span");
    public static final Target ALIAS_PUNTOSBA2 = Target.the("'Alias 'Puntos BA'")
            .locatedBy("//div[@class='creditcards-alias']");
    public static final Target TIPO_PRD2 = Target.the("'Tipo de producto'")
            .locatedBy("//div[@class='card-type']");
    public static final Target PUNTOSACUM2 = Target.the("'Puntos Acumulados'")
            .locatedBy("(//dd//span[@class='currency-amount'])[1]");
    public static final Target SALDOENDOL2 = Target.the("'Saldo En $'")
            .locatedBy("//dl[@class='information-item aligned-saldo-pba']/dd/span");
    public static final Target ALIAS_PUNTOSBA3 = Target.the("'Alias Puntos BA'")
            .locatedBy("//dl[@class='product-detail-list first-title-pba']/dd");
    public static final Target TIP_PRD3 = Target.the("'Tipo de producto'")
            .locatedBy("//dl[@class='product-detail-list'][1]/dd/span");
    public static final Target PUNTOSACUM3 = Target.the("'Puntos Acumulados'")
            .locatedBy("//dl[@class='product-detail-list pba-puntos-acumulados']/dd/span");
    public static final Target SALDOENDOL3 = Target.the("'Saldo En $'")
            .locatedBy("//dl[@class='product-detail-list'][2]//dd/span/span[2]");

    public static final Target PROXVENCER = Target.the("'Próximos a vencer'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dt/span[.=\"Próximos a vencer\"]");
    public static final Target CUERELACION = Target.the("'Cuentas relacionadas'")
            .locatedBy("//span[contains(text(),'Cuentas relacionadas')]");
    public static final Target TABCR = Target.the("tabla 'Cuentas relacionadas'")
            .locatedBy("//div[@class='table-wrapper']");
    public static final Target BTN_NUEVA_RESERVA = Target.the("Botón 'Nueva Reserva'")
            .locatedBy("//button[@type='button']");
    public static final Target ACTIVA_LISTA_VIGENCIA = Target.the("'Lista Vigencia'")
            .locatedBy("(//*[@class='selectize-control single'])[2]");
    public static final Target SELECCIONAR_LISTA_VIGENCIA = Target.the("'{0}'")
            .locatedBy("(//*/div[@class='selectize-dropdown-content'])[2]/div[contains(text(),'{0}')]");
    public static final Target RESERVA = Target.the("'{0}'")
            .locatedBy("//tr/td[contains(text(),'{0}')]");
    public static final Target RESERVA1 = Target.the("'Número de reserva'")
            .locatedBy("//span[.='Número de reserva']");


    //e-card
    public static final Target TTL_RESUMEN_ECARD = Target.the("'Resumen de tarjeta e-card'")
            .locatedBy("//span[contains(text(),'Resumen de tarjeta e-card')]");
    public static final Target OPC_CVV2_FE = Target.the("link 'Consulta CVV2 y fecha de expiración'")
            .locatedBy("//a[@class='round-button icon-CVV2']/span");
    public static final Target TTL_CVV2_FE = Target.the("'Consulta CVV2 y fecha de expiración'")
            .locatedBy("//h2/span");
    public static final Target TARJ_TIT_ECARD = Target.the("'Tarjeta titular'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[1]");
    public static final Target TARJ_ECARD = Target.the("'Tarjeta e-card'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[2]");
    public static final Target CVV2_ECARD = Target.the("'Código de seguridad CVV2'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[3]");
    public static final Target FV_ECARD = Target.the("'Fecha de vencimiento'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[4]");
    public static final Target ESTADO_ECARD = Target.the("'Estado'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[5]");

    //estado de cuenta TC
    public static final Target OPERACIONES = Target.the("'Operaciones'")
            .locatedBy("//span[contains(text(),'Operaciones')]");
    public static final Target ESTA_CUENTA_TC = Target.the("link 'Estado de cuenta de tarjeta de crédito'")
            .locatedBy("//span[contains(text(),'Estado de cuenta de tarjeta de crédito')]");
    public static final Target TTL_ESTA_CUENTA_TC = Target.the("'Estado de cuenta de tarjeta de crédito'")
            .locatedBy("//h2/span");
    public static final Target MES_ANO = Target.the("'Mes y año'")
            .locatedBy("(//div[@class='selectize-control single'])[2]");
    public static final Target OPC_MES_ANO = Target.the("'{0}'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[2]//div[contains(text(),'{0}')]");
    public static final Target BTN_CONSULTAR = Target.the("botón 'Consultar'")
            .locatedBy("//span[contains(text(),'Consultar')]");
    public static final Target PDF_ESTADO_CUENTA = Target.the("'Estado de cuenta PDF'")
            .locatedBy("//div[@class='react-pdf__Page pdf-center']/canvas");
    public static final Target DESCARGAR = Target.the("botón 'Descargar'")
            .locatedBy("//span[contains(text(),'Descargar')]");
    public static final Target OPCIONES_TARJETA_ENVIO = Target.the("Listado de Tarjetas")
            .locatedBy("//*/ul/li/div/span/span[contains(text(),'{0}')]/../../../span[@class='current-add']");
    public static final Target SELECCIONAR_TARJETA_ENVIO = Target.the("'{0}'")
            // .locatedBy("//*/ul/li/div/span/span[contains(text(),'{0}')]");

            .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target TARJETA_ENVIO_ESTADO_CUENTA = Target.the("Label de tarjeta que va a recibir estado")
            .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target ACEPTO_TERMINOS_CONDICIONES = Target.the("checkbox 'Acepto los términos y condiciones'")
            .locatedBy("(//span[.='Acepto los términos y condiciones'])[1]");
    public static final Target NOPERACION = Target.the("'N° de Operación'")
            .locatedBy("//p[@class='transfer-code operacion-cheq']");
    public static final Target RESULTADO1 = Target.the("'Solicitud de estado de cuenta por e-mail - Resultado'")
            .locatedBy("//h2/span[.='Solicitud de estado de cuenta por e-mail - Resultado']");


    //CONSULTA FE y CVV2
    public static final Target BTN_MOSTRAR_CVV = Target.the("Botón Mostrar CVV").locatedBy("(//*[@class= \"icon-visible\"])[2]");
    public static final Target CVV_TDD = Target.the("CVV de TDD").locatedBy("//dd/p/span[contains(text(),'{0}')]");
    public static final Target FE_TDD = Target.the("Fecha de Vencimiento TDD").locatedBy("//dd[contains(text(),'{0}')]");

    //
    public static final Target OPC_INTEGRACIONCUENTA = Target.the("Opción de Integración de cuenta ").locatedBy("//*[@class=\"round-button icon-debit-account-integration\"]");

    private TarjetasPage() {
    }
}
