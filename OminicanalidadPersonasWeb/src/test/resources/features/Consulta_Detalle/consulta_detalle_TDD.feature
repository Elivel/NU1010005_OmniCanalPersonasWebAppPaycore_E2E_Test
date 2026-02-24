#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de tarjeta de débito, validando las 3 capas de información

  @ValidaciónDetalleECARD @QA
  Escenario: El cliente validará que se muestre el detalle de tarjeta de débito Digital
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Entonces valida que se muestren de forma correcta los datos de la tarjeta de debito
      | tarjetaDebito     |
      | **** 6279 ECARD   |

  @ValidaciónDetalleTDDFisica @QA
  Escenario: El cliente validará que se muestre el detalle de tarjeta de débito Fisica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Entonces valida que se muestren de forma correcta los datos de la tarjeta de debito
      | tarjetaDebito     |
      | **** 7912 Clásica |