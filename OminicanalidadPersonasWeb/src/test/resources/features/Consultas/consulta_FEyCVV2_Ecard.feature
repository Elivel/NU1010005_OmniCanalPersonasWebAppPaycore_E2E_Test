#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar CVV2 y fecha de expiración de e-card

  @CVV2yFE @QA
  Escenario: El cliente podrá consultar CVV2 y fecha de expiración de e-card
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente miguelsabal
    Y realiza validación de  datos de e-card
      | tarjetaCredito  |
      | **** 2513 ECARD |