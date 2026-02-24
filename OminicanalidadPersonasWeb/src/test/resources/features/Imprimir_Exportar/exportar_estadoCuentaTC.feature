#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá validar que se genere y se descargue estado de cuenta de tarjeta de crédito

  @GenerarDescargarEstadoCuentaTC @pdf @QA
  Escenario: El cliente podrá validar que se genere y descargue el estado de cuenta de tarjeta de crédito
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Y realiza proceso para generación y descarga de estado de cuenta de tarjeta de crédito
      | tarjetaCredito          | periodo |
      | **** 4623 VISA Platinum | 3/2025  |
    Entonces el cliente valida que se muestre el archivo de 'EstadoDeCuenta.pdf' en la carpeta