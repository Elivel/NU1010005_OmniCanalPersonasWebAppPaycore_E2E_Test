#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de cuentas de ahorro, validando las 3 capas de información

  @ValidaciónDetalleCuentaAhorro @QA
  Escenario: El cliente validará que se muestre el detalle de cuentas de ahorro
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Entonces valida que se muestren de forma correcta los datos de la cuenta de ahorro
      | cuentaOrigen                |
      | 3110481891 Cuenta de ahorro |