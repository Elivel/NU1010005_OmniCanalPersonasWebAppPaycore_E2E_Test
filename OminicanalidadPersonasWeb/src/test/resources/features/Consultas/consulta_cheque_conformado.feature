#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá consultar sus cheques conformados

  @ChequesConformado @DEV
  Escenario: El cliente podrá visualizar sus cheques conformados al consultar en los movimientos de cuenta corriente
  los pagos realizados con cheque
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD chequeconformado1
    Cuando valida los movimientos de la cuenta corriente para una fecha especifica
      | cuentaOrigen | fechaDesde    | fechaHasta      |
      | 5416262221   | 1 Enero, 2023 | 1 Febrero, 2023 |
    Y realiza el proceso para consultar los pagos realizados con referencia de cheque 3966
    Entonces debe visualizar el cheque con el cual se realizo el pago