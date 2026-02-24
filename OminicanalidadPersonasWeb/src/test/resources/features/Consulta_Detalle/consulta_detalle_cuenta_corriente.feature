#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de cuentas corriente, validando las 3 capas de información

  @ValidaciónDetalleCuentaCorriente @QA
  Escenario: El cliente validará que se muestre el detalle de cuenta corriente
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Entonces valida que se muestren de forma correcta los datos de la cuenta corriente
      | cuentaOrigen |
      | 1210039767   |