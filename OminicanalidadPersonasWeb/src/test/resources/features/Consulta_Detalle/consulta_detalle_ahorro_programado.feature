#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de ahorro programado, validando las 3 capas de información

  @ValidaciónDetalleAhorroProgramado @QA
  Escenario: El cliente validará que se muestre el detalle de ahorro Programado
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Entonces valida que se muestren de forma correcta los datos del Ahorro Programado
      |cuentaCorta                                      | cuentaOrigen               |
      | 3009267649 Sueño Realizado Programado           |Sueño Realizado Programado |
