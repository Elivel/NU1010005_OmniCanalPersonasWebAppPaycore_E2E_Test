#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de extrafinanciamiento, validando las 3 capas de información

  @ValidaciónDetalleEF @QA
  Escenario: El cliente validará que se muestre el detalle de extrafinanciamiento
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Auto04
    Entonces valida que se muestren de forma correcta los datos del extrafinanciamiento
      | extrafinanciamiento                        |
      | 2130032594 Préstamo de Extrafinanciamiento |