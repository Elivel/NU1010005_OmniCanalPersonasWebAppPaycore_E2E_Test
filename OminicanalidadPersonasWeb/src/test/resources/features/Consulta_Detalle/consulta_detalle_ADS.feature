#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de adelanto de salario, validando las 3 capas de información

  @ValidaciónDetalleADS @QA
  Escenario: El cliente validará que se muestre el detalle de ADS
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Entonces valida que se muestren de forma correcta los datos de ADS
      | ads                         |
      | 5167582534 Cuenta corriente |