#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de e-card, validando las 3 capas de información

  @ValidaciónDetalleECARD @QA
  Escenario: El cliente validará que se muestre el detalle de e-card
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Entonces valida que se muestren de forma correcta los datos de la e-card
      | tarjetaCredito  |
      |**** 4708 ECARD  |