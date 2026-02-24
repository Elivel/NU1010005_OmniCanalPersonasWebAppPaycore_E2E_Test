package com.bancoagricola.certificacion.omnicanalidadpersonas.web.userinterface;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class AhorrosPage {

    //Localizadores  Gestión Meta
    public static final Target MENU_AHORROS = Target.the("menú 'Ahorros'")
            .locatedBy("//a[@class='icon-savings']/span[.='Metas']");
    public static final Target MENU_PRINC = Target.the("'Menú principal'")
            .locatedBy("//div/nav/ul[@class='vertical-navigation']");
    public static final Target LBL_TOTAL_AHORROS_ACUM = Target.the("'Total ahorros acumulados'")
            .locatedBy("//span[.='Total Ahorros Acumulados']");
    public static final Target BTN_ANADE_META = Target.the("botón 'Añade Meta'")
          .locatedBy("//span[contains(text(),'Añade meta')]");

    public static final Target BTN_CONTINUAR_META = Target.the("botón 'Añade Meta'")
            .locatedBy("//button[@type='button']");

    public static final Target LBL_CREA_TU_META = Target.the("titulo 'Crea tu meta'")
            .locatedBy("//span[contains(text(),'Crea tu meta')]");
    public static final Target TXT_NOMBRE_META = Target.the("'nombre de la meta'")
            .locatedBy("(//*/div[@class='field-container'])[1]//input");
    public static final Target TXT_MONTO_META = Target.the("'monto de la meta'")
            .locatedBy("(//*/div[@class='field-container'])[2]//input");
    public static final Target TXT_PLAZO_DE_META = Target.the("'plazo de la meta'")
            .locatedBy("(//*/div[@class='field-container'])[3]//input");

    public static final Target DPD_DIA_RETENCION = Target.the("'Dia de retención'")
    .locatedBy("//span[contains(text(),'Día del mes de retención de cuota')]//following::div[1]");


    public static final Target DPD_DIA_RETENCION2 = Target.the("'Dia de retención'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[1]/div");
    public static final Target DPD_DIA_RETENCION3 = Target.the("'Dia de retención'")
            .locatedBy("//span[contains(text(),'Día del mes de retención de cuota')]//following::div[1]");
    public static final Target DPD_DIA_RETENCION4 = Target.the("'Dia de retención'")
            .locatedBy("(//div[@class='selectize-dropdown-content'])[1]/div");
    public static final Target DPD_CUENTA_A_RELACIONAR = Target.the("'Cuenta a relacionar'")
            .locatedBy("/html//div[@id='root']//div[@class='transition-fade']/div[@class='transition-wrapper']/div[@class='app-wrapper background-1']//article/form[@class='regular-form web-selector']//div[@class='form-section-wrapper selectize-item']//div[@class='field-select field-wrapper']/div[@class='selectize-control single']/div[1]");
    public static final Target DPD_CUENTA_A_RELACIONAR2 = Target.the("'Cuenta a relacionar'")
            .locatedBy("//span[contains(text(),'Cuenta para retención de cuota')]//following::div[@class='select-content']");
    public static final Target BTN_CREAR = Target.the("botón 'Crear'")
            .locatedBy("//div[@class='button-row']/button/span/span[.='Crear']");
    public static final Target BTN_ACEPTAR = Target.the("botón 'Aceptar'")
            .locatedBy("//span[contains(text(),'Continuar')]");
    public static final Target BTN_ACEPTAR2 = Target.the("botón 'Aceptar'")
     .locatedBy("//span[contains(text(),'Aceptar')]");



    public static final Target BTN_FINALIZAR = Target.the("botón 'Finalizar'")
            .locatedBy("//div//*[@class='button-cheq']//span[contains(text(),'Finalizar')]");
    public static final Target LBL_META_CREADA = Target.the("'Tu meta ha sido creada con éxito'")
            .locatedBy("//span[contains(text(),'¡Tu meta se creó exitosamente!')]");
    public static final Target LBL_META_ELIMINADA = Target.the("'Tu meta ha sido eliminada con éxito'")
            .locatedBy("//span[contains(text(),'Tu meta ha sido eliminada con éxito')]");
    public static final Target NOMBRE_META = Target.the("'{0}'")
            .locatedBy("//h3[contains(text(),'{0}')]");
    public static final Target LNK_VER_MAS = Target.the("link 'Ver mas'")
          .locatedBy("//h3[contains(text(),'{0}')]/../../../div/ul/li/a/span[contains(text(),'Ver más')]");

    public static final Target LNK_VER_MAS_METAS = Target.the("link 'Ver mas'")
            .locatedBy("//span[contains(text(),'{0}')]/../../../div/ul/li/a/span[contains(text(),'Ver más')]");

    public static final Target LINK_VER_MAS_METAS2 = Target.the("link ver más metas")
            .locatedBy("//*/p[@class=\"card-date\"]/span[contains(text(),\"{0}\")]/following::span[contains(text(),\"Ver más\")][1]");


    public static final Target LNK_APORTAR = Target.the("link 'Aportar'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../../div/ul/li/a/span[contains(text(),'{1}')]");
    public static final Target LNK_RETIRAR = Target.the("link 'Retirar'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../../div/ul/li/a/span[contains(text(),'{1}')]");
    public static final Target LNK_MODIFICAR_M = Target.the("link 'Modificar'")
            .locatedBy("//span[contains(text(),'Modificar')]");
    public static final Target TITLE_RES_META = Target.the("'Resumen de meta'")
            .locatedBy("//span[contains(text(),'Resumen de meta')]");
    public static final Target TITLE_MOD_META = Target.the("'Modificar meta'")
            .locatedBy("//span[contains(text(),'Modificar meta')]");
    public static final Target BTN_MODIFICAR = Target.the("botón 'Modificar-Guardar'")
            .locatedBy("//span[contains(text(),'Guardar')]");

    public static final Target LBL_META_MODIFICADA = Target.the("'Tu meta ha sido modificada con éxito'")
            .locatedBy("//span[contains(text(),'Tu meta ha sido modificada con éxito')]");
    public static final Target LBL_MONTO = Target.the("'Monto'")
            .locatedBy("//dl/dt/span[contains(text(),'Monto acumulado')]//following::span[@class='currency-amount'][1]");
    public static final Target MONTO_GUARDAR = Target.the("'Monto a guardar'")
            .locatedBy("//*[@id='formContent']/div/div[5]/div/div/input");
    public static final Target LBL_APORTE_META = Target.the("'Aporte de meta'")
            .locatedBy("//span[contains(text(),'Aporte a meta')]");
    public static final Target BTN_GUARDAR = Target.the("botón 'Guardar'")
            .locatedBy("//span[contains(text(),'Guardar')]");
    public static final Target LBL_ADICION_EXITOSA = Target.the("'Tu adición se realizó con éxito'")
            .locatedBy("//span[contains(text(),'Tu adición se realizó con éxito')]");
    public static final Target LBL_MONTO_ACUM = Target.the("'Monto'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../..//dl[contains(@class,'ahorro-acumulado')]//span[@class='currency-amount']");
    public static final Target LBL_RETIRO_META = Target.the("'Retiro de meta'")
            .locatedBy("//span[contains(text(),'Retiro a meta')]");
    public static final Target MONTO_RETIRAR = Target.the("'Monto a retirar'")
            .locatedBy("//*[@id='formContent']/div/div[5]/div/div/input");
    public static final Target BTN_RETIRAR = Target.the("botón 'Retirar'")
            .locatedBy("//span[contains(text(),'Retirar')]");
    public static final Target LBL_RETIRO_EXITOSO = Target.the("'Tu retiro se realizó con éxito'")
            .locatedBy("//span[contains(text(),'Tu retiro se realizó con éxito')]");
    public static final Target LNK_ELIMINAR_M = Target.the("link 'Eliminar'")
            .locatedBy("//span[contains(text(),'Eliminar')]");
    public static final Target LBL_IDTRANSACCION = Target.the("'ID transacción'")
            .locatedBy("//label[@class='label-read']/span[.='ID transacción']");
    public static final Target LBL_MONTOACU = Target.the("'Monto acumulado'")
            .locatedBy("//div[@class='card-amount'][1]/span/span[2]");
    public static final Target LBL_MONTOACU2 = Target.the("'Monto acumulado'")
            .locatedBy("//dl[@class='information-item information-order-reversed font ahorro-acumulado']/dd/span");
    //Localizadores Movimientos meta
    public static final Target LNK_MOVIMIENTOS = Target.the("link 'Movimientos'")
            .locatedBy("//span[contains(text(),'Movimientos')]");
    public static final Target STL_MOVIMIENTOS_META = Target.the("'Movimientos meta'")
            .locatedBy("//span[contains(text(),'Movimientos de meta')]");
    public static final Target OPCION_FILTRAR = Target.the("opción 'Filtrar'")
            .locatedBy("//span[contains(text(),'Filtrar')]");
    public static final Target BTN_BUSCAR_MOV = Target.the("botón 'Buscar Movimientos'")
            .locatedBy("//span[contains(text(),'Buscar movimientos')]");
    public static final Target MONTO_RET = Target.the("'Monto retiro'")
            .locatedBy("//tbody/tr[1]/td[4]//*[@class='currency-amount']");
    public static final Target MONTO_APO = Target.the("'Monto aporte'")
            .locatedBy("//tbody/tr[2]/td[4]//*[@class='currency-amount']");

    //Localizadores Consulta detalle de meta
    public static final Target DATO_META1 = Target.the("'Meta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../*[@class='product-secondary-information'][1]/dl[1]/dd/span/span[2]");
    public static final Target DATO_MONTO_ACUM1 = Target.the("'Monto acumulado'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../*[@class='product-secondary-information'][1]/dl[2]/dd/span/span[2]");
    public static final Target DATO_CUOTA1 = Target.the("'Cuota'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../*[@class='product-secondary-information'][2]/dl[1]/dd/span/span[2]");
    public static final Target DATO_PLAZO1 = Target.the("'Plazo'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../div[4]/dl[2]/dd");
    public static final Target DATO_CUENTA1 = Target.the("'Cuenta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../../p/span[2]");
    public static final Target DATO_META2 = Target.the("'Meta'")
            .locatedBy("//div//*[@class='card-amount'][2]//*[@class='currency-amount']");
    public static final Target DATO_MONTO_ACUM2 = Target.the("'Monto acumulado'")
            .locatedBy("//div//*[@class='card-amount'][1]//*[@class='currency-amount']");
    public static final Target DATO_CUOTA2 = Target.the("'Cuota'")
            .locatedBy("//div//*[@class='product-secondary-information']/dl[1]/dd//*[@class='currency-amount']");
    public static final Target DATO_PLAZO2 = Target.the("'Plazo'")
            .locatedBy("//div//*[@class='product-secondary-information']/dl[3]/dd");
    public static final Target DATO_CUENTA2 = Target.the("'Cuenta'")
            .locatedBy("//div//*[@class='product-secondary-information']/dl[6]/dd");
    public static final Target DATO_PR_CUMPL = Target.the("'% cumplimiento'")
            .locatedBy("//div//*[@class='product-secondary-information']/dl[2]/dd");
    public static final Target PLAZO_TRANSC = Target.the("'Plazo transcurrido'")
            .locatedBy("//div//*[@class='product-secondary-information']/dl[4]/dd");
    public static final Target DIA_RETENCION = Target.the("'Dia retención'")
            .locatedBy("//div//*[@class='product-secondary-information']/dl[5]/dd");
    public static final Target TITULO_META2 = Target.the("'Nombre de meta'")
            .locatedBy("//h3[@class='card-title']");
    //Ajuste en pantallas de metas
    public static final Target COUTA_MENSUAL_FORM=Target.the("Couta mensual calculada en formulario")
            .locatedBy("//span[contains(text(),'Cuota mensual')]//following::span[1]");
    public static final Target NUM_COMPROBANTE=Target.the("Numero de comprobante meta")
            .locatedBy("//p[@class='detail-font']");
    public static final Target FECHA_CREACION_META=Target.the("Fecha de creación de meta")
            .locatedBy("//span[@class='detail-font']");
    public static final Target NOMBRE_META2 =Target.the("Leyenda en ticket con nombre de meta")
            .locatedBy("//span[contains(text(),'¡Tu meta se creó exitosamente!')]/following::span[3]");
    public static final Target MONTO_TOTAL_META=Target.the("Monto total de la meta en ticket")
            .locatedBy("//span[contains(text(),'Monto total:')]//following::span[5]");
    public static final Target CUOTA_META_TICKET=Target.the("Cuota de la meta en ticket")
            .locatedBy("//span[contains(text(),'Cuota mensual:')]//following::span[5]");
    public static final Target TXT_FONDOS_RETENIDOS= Target.the("Texto fondos retenidos de la meta")
            .locatedBy("//span[contains(text(),'Podrás ver los fondos retenidos de tu meta en la o')]");
    public static final Target TXT_LIBERAR_FONDOS=Target.the("Texto de liberar fondos de meta")
            .locatedBy("//span[contains(text(),'Recuerda que puedes liberar tus fondos de forma pa')]");
    public static final Target BTN_FINALIZAR_META=Target.the("Botón finalizar meta")
            .locatedBy("//button[@type='button']");
    public static final Target DETALLE_MSG_CONFIRMACION = Target.the("Detalle en pantalla de confirmación creación de meta")
            .locatedBy("//span[contains(text(),'Confirmación')]//following::span[1]");






    //Localizadores Ahorro Programado
    public static final Target TOTAL_AHORROS_ACUMULADOS = Target.the("'Total Ahorros Acumulados'")
            .locatedBy("//span[contains(text(),'Total Ahorros Acumulados')]");
    public static final Target TTL_RESUMEN_AP = Target.the("'Resumen de ahorro programado'")
            .locatedBy("//span[contains(text(),'Resumen de ahorro programado')]");
    public static final Target TTL_RESUMEN_META = Target.the("Resumen de meta")
            .locatedBy("//div/h2[@class='page-subtitle']");
    public static final Target PRODUCTO1 = Target.the("'Tipo de producto'")
            .locatedBy("//h3[contains(text(),'{0}')]/../..//p[@class='card-type']");
    public static final Target ALIAS1 = Target.the("'Alias de la cuenta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../..//h3[@class='product-title']");
    public static final Target META1 = Target.the("'Meta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../..//dl[@class='information-item information-order-reversed highlighted-item']/dd/span");
    public static final Target AHORRO_ACUM1 = Target.the("'Ahorro Acumulado'")
            .locatedBy("//h3[contains(text(),'{0}')]/../..//dl[@class='information-item information-order-reversed ahorro-acumulado']//dd/span");
    public static final Target NUMERO_AP1 = Target.the("'Número de cuenta'")
            .locatedBy("//h3[contains(text(),'{0}')]/../..//p[@class='card-date'][1]//span[2]");
    public static final Target ESTADO_AP1 = Target.the("'Estado'")
            .locatedBy("//h3[contains(text(),'{0}')]/../..//p[@class='card-date'][2]//span[2]");
    public static final Target PRODUCTO2 = Target.the("'Tipo de cuenta'")
            .locatedBy("//p[@class='card-type']");
    public static final Target ALIAS2 = Target.the("'Alias de la cuenta'")
            .locatedBy("//h3[@class='card-title']");
    public static final Target META2 = Target.the("'Meta'")
            .locatedBy("(//div[@class='card-amount']/span)[2]");
    public static final Target AHORRO_ACUM2 = Target.the("'Ahorro Acumulado'")
            .locatedBy("(//div[@class='card-amount']/span)[1]");
    public static final Target NUMERO_AP2 = Target.the("'Número de cuenta'")
            .locatedBy("//dl[@class='information-item information-order-reversed'][1]/dd");
    public static final Target FECHA_VEN_AP1 = Target.the("'Fecha de vencimiento'")
            .locatedBy("//dl[@class='information-item information-order-reversed'][2]/dd");
    public static final Target TTL_MAS_DETALLE_AP = Target.the("'Más detalle de ahorro programado'")
            .locatedBy("//span[contains(text(),'Más detalle de ahorro programado')]");
    public static final Target ALIAS3 = Target.the("'Alias de la cuenta'")
            .locatedBy("//dl[@class='product-detail-list title-ahorro-programado']/dd");
    public static final Target PRODUCTO3 = Target.the("'Tipo de cuenta'")
            .locatedBy("//dl[@class='product-detail-list']/dd");
    public static final Target NUMERO_AP3 = Target.the("'Número de cuenta'")
            .locatedBy("//dl[@class='product-detail-list aligned-product-list'][1]/dd");
    public static final Target CUOTA_MENSUAL1 = Target.the("'Cuota mensual'")
            .locatedBy("//dl[@class='product-detail-list aligned-product-list'][2]/dd/span");
    public static final Target ESTADO_AP2 = Target.the("'Estado'")
            .locatedBy("//dl[@class='product-detail-list aligned-product-list'][3]/dd");
    public static final Target SECC_SALDOS = Target.the("Subtitulo 'Saldos'")
            .locatedBy("//span[contains(text(),'Saldos')]");
    public static final Target CONTABLE1 = Target.the("'Contable'")
            .locatedBy("//dl[@class='product-detail-list'][2]//dd/span");
    public static final Target SALDO1 = Target.the("'Saldo'")
            .locatedBy("//dl[@class='product-detail-list'][3]//dd/span");
    public static final Target DISPONIBLE1 = Target.the("'Disponible'")
            .locatedBy("//dl[@class='product-detail-list'][4]//dd/span");
    public static final Target SECC_FECHAS = Target.the("Subtitulo 'Fechas'")
            .locatedBy("//span[contains(text(),'Fechas')]");
    public static final Target FECHA_CONTRA1 = Target.the("'Contratación'")
            .locatedBy("//dl[@class='product-detail-list'][5]/dd");
    public static final Target DIA_CARGO1 = Target.the("'Día de cargo'")
            .locatedBy("//dl[@class='product-detail-list'][6]/dd");
    public static final Target FECHA_VEN_AP2 = Target.the("'Fecha de vencimiento'")
            .locatedBy("//dl[@class='product-detail-list'][7]/dd");
    public static final Target LBL_PAGO_TRANSF_EXITO = Target.the("'La transferencia se realizó exitosamente'")
            .locatedBy("//span[contains(text(),'La transferencia se realizó exitosamente')]");
    public static final Target BTN_TRANSF_TERC = Target.the("botón 'Transferir a tercero'")
            .locatedBy("//span[contains(text(),'Transferir a tercero')]");
    public static final Target TTL_TRANSF_TERC = Target.the("Titulo 'Transferencia a terceros'")
            .locatedBy("//span[contains(text(),'Transferencia a terceros')]");
    public static final Target NUM_CUENTA = Target.the("'Número de cuenta'")
            .locatedBy("//div[@class='form-line-wrapper'][1]//div[@class='field-container']//input");
    public static final Target CORR_ELECTRO = Target.the("'Correo electrónico'")
            .locatedBy("//div[@class='form-line-wrapper'][2]//div[@class='field-container']//input");
    public static final Target MONTO_TERC = Target.the("'Monto'")
            .locatedBy("//div[@class='field-input field-wrapper field-top']//input");
    public static final Target CONCEPTO_TERC = Target.the("'Concepto'")
            .located(By.name("concept"));
    public static final Target BTN_CONTINUAR = Target.the("botón 'Continuar'")
            .locatedBy("//*/button");
    public static final Target RADIO_CELULAR = Target.the("opción 'Celular'")
            .locatedBy("//div[@class='radio']");
    public static final Target LNK_MOVIMIENTOS_AP = Target.the("link 'Movimientos'")
            .locatedBy("//a[@class='round-button icon-movements']/span");
    public static final Target SALDO_DISP_AP = Target.the("'Disponible'")
            .locatedBy("//dl[@class='product-detail-list'][2]/dd//span[@class='currency-amount']");
    public static final Target FECHA_APLICADA = Target.the("'Fecha aplicada'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[3]");
    public static final Target ACTIVAR_FECHA_EJECUCION = Target.the("'Fecha de ejecución'")
            .located(By.id("txt_date_transaction"));

    //Ahorro navideno
    public static final Target TABLA_AHORRO_NAVIDENO = Target.the("'Ahorro navideño'")
            .locatedBy("//div[@class='table-wrapper']/table");
    public static final Target TABLA_AHORRO_NAVIDENO1 = Target.the("'Ahorro navideño'")
            .locatedBy("//div/table[@class='selectable']/thead/tr/th/span[.='Contrato']");
    public static final Target REFERENCIA_AN1 = Target.the("'Referencia'")
            .locatedBy("//div[@class='table-wrapper']//table//tbody//tr//td[1]");
    public static final Target CONTRATO_AN1 = Target.the("'Contrato'")
            .locatedBy("//div[@class='table-wrapper']//table//tbody//tr//td[2]");
    public static final Target FECHA_CONTRAT_AN1 = Target.the("'Fecha de contratación'")
            .locatedBy("//div[@class='table-wrapper']//table//tbody//tr//td[3]");
    public static final Target ESTADO_AN1 = Target.the("'Estado'")
            .locatedBy("//div[@class='table-wrapper']//table//tbody//tr//td[4]");
    public static final Target RES_AHO_NAV = Target.the("'Resumen de Ahorro Navideño'")
            .locatedBy("//span[contains(text(),'Resumen de Ahorro Navideño')]");
    public static final Target REGISTRO = Target.the("contrato '{0}'")
            .locatedBy("//table/tbody/tr/td[(.='{0}')]");
    public static final Target REGISTRO_MOV = Target.the("referencia '{0}'")
            .locatedBy("//table/tbody/tr/td[.='{0}']");
    public static final Target DETALLE_MOV_CTA_CORRIENTE = Target.the("Detalle Movimiento")
            .locatedBy("//div[@class='popup scrollable popup-left']");
    public static final Target VER_DOCUMENTO = Target.the("Opción Ver Documento")
            .locatedBy("//span[.='Ver documento']");
    public static final Target CERRAR = Target.the("Botón Cerrar")
            .locatedBy("//span[.='Cerrar']");
    public static final Target CONTENEDOR_CHEQUE=Target.the("'Imagen de cheque'")
            .locatedBy("//div[@class='popup scrollable popup-image']");
    public static final Target SERV_AHO_NAV = Target.the("'Servicio'")
            .locatedBy("(//dl/dd)[1]");
    public static final Target ESTADO_AN1_2 = Target.the("'Estado'")
            .locatedBy("(//dl/dd)[2]");
    public static final Target CONTRATO_AN1_2 = Target.the("'Contrato'")
            .locatedBy("(//dl/dd)[3]");
    public static final Target SALDO_AHO_NAV = Target.the("'Saldo'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[4]");
    public static final Target FECHA_CONTRAT_AN1_2 = Target.the("'Fecha de contratación'")
            .locatedBy("(//dl/dd)[5]");
    public static final Target FECHA_ULT_REN_AN = Target.the("'Fecha de última renovación'")
            .locatedBy("(//dl/dd)[6]");
    public static final Target FECHA_PRO_CUO_AN = Target.the("'Fecha de próxima cuota'")
            .locatedBy("(//dl/dd)[7]");
    public static final Target FECHA_PRO_LIBFON_AN = Target.the("'Fecha de próxima liberación de fondos'")
            .locatedBy("(//dl/dd)[8]");
    public static final Target CUOTA_MENS_AHO_NAV = Target.the("'Cuota mensual'")
            .locatedBy("(//dl[@class='product-detail-list']/dd)[9]");
    public static final Target DIA_RETENCION_AN = Target.the("'Día retención'")
            .locatedBy("(//dl/dd)[10]");
    public static final Target CUENTA_AN = Target.the("'Cuenta'")
            .locatedBy("(//dl/dd)[11]");
    public static final Target AGEN_CONT_AN = Target.the("'Agencia de contratación'")
            .locatedBy("(//dl/dd)[12]");
    public static final Target FECHA_CANC_AN = Target.the("'Fecha de cancelación'")
            .locatedBy("(//dl/dd)[13]");

    //Movimientos Ahorro Navideño
    public static final Target MES_ACTUAL = Target.the("'Mes actual'")
            .locatedBy("//span[contains(text(),'Mes actual')]");
    public static final Target TABLA__MOV_AHORRO_NAVIDENO = Target.the("Tabla de movimientos de ahorro navideño")
            .locatedBy("//div[@class='table-wrapper']");

    //Consulta fondos reservados
    public static final Target MOVIMIENTOS = Target.the("'Movimientos de cuentas'")
            .locatedBy("//span[contains(text(),'Movimientos de cuentas')]");
    public static final Target MOVIMIENTOS_AP = Target.the("'Movimientos de cuentas'")
            .locatedBy("//span[contains(text(),'Movimientos de ahorro programado')]");
    public static final Target OTROS = Target.the("'Otros'")
            .locatedBy("//span[contains(text(),'Otros')]");
    public static final Target TABLA_MOVI_COLUMNA_REFERENCIA = Target.the("'Referencia'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[3]");

    public static final Target TABLA_MOVIMIENTOS_REFERENCIA = Target.the("'Referencia'")
            .locatedBy("//table[@class='selectable']/tbody/tr/td[4]");
    public static final Target TABLA_MOVIMIENTOS_REFERENCIA_AP = Target.the("'Referencia'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[4]");

    public static final Target TABLA_MOVIMIENTOS_REFERENCIA_FON_RES = Target.the("'Referencia'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[3]");

    public static final Target TABLA_MOVIMIENTOS_REFERENCIA_FON_RES_TARJ = Target.the("'Referencia'")
            .locatedBy("//div[@class='table-wrapper']/table/tbody/tr/td[3]");
    public static final Target LBL_FONDOS_RESERVADOS = Target.the("'Fondos reservados'")
            .locatedBy("//h2/span[.='Fondos reservados']");
    public static final Target LBL_MOVIMIENTOS_TARJETA = Target.the("'Movimientos de tarjeta'")
            .locatedBy("//h2/span[.='Movimientos de tarjeta']");

    public static final Target REFERENCIA_TRX = Target.the("'Referencia pago tarjeta UNI'")
            .locatedBy("//p[@class='transfer-code operacion-cheq']");

    //Cobros pendientes
    public static final Target COBROS_PENDIENTES = Target.the("'Cobros pendientes'")
            .locatedBy("//span[contains(text(),'Cobros pendientes')]");

    private AhorrosPage() {
    }
}