#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá validar que se muestren los registros de diferidos de tarjeta de crédito

  @ConsultaDiferidosTDC @QA
  Escenario: El cliente podrá validar que se muestren los registros de diferidos de tarjeta de crédito
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Entonces valida que se muestre la tabla y registros de diferidos de tarjeta de crédito
      | tarjetaCredito              |
      | **** 0442 VISA Selectos Oro |




