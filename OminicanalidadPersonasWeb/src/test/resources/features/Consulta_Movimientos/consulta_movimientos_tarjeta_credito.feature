#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de tarjeta de crédito

  @ValidaMovimientosFechaEspecifica @QA
  Escenario: El cliente podrá consultar movimientos de tarjeta de crédito para una fecha especifica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Auto04
    Y valida los movimientos de tarjeta de crédito para una fecha especifica
      | tarjetaCredito           | fechaDesde      | fechaHasta    |
      |**** 3144 VISA Gold       | 1 Febrero, 2024 | 1 Julio, 2024 |
    Entonces valida que se muestre el detalle de movimientos de tarjeta de crédito para un registro
      | cargo |
      | 31.25 |