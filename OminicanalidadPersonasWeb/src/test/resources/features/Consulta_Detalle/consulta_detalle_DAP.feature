#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de deposito a plazo, validando las 3 capas de información

  @ValidaciónDetalleDAP @QA
  Escenario: El cliente validará que se muestre el detalle de deposito a plazo
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Feldouser7
    Entonces valida que se muestren de forma correcta los datos de Deposito a plazo
      | cuentaOrigen                |
      | 7001151643 Depósito a plazo |