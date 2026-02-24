#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de tarjeta de crédito, validando las 3 capas de información

  @ValidaciónDetalleTDC @QA
  Escenario: El cliente validará que se muestre el detalle de tarjeta de crédito
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Entonces valida que se muestren de forma correcta los datos de la tarjeta de crédito
      | tarjetaCredito          |
      | **** 5577 VISA Business |