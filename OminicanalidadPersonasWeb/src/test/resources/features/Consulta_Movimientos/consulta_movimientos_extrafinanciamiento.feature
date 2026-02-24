#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar los movimientos de Préstamo De Extrafinanciamiento

  @ConsultaMovimientosExtrafinanciamiento @QA
  Escenario: El cliente validará que se muestren los movimientos del extrafinanciamiento
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Auto04
    Entonces valida que se muestren de forma correcta los movimientos del extrafinanciamiento
      | extrafinanciamiento                        | fechaDesde    | fechaHasta          |
      | 2130032594 Préstamo de Extrafinanciamiento | 1 Enero, 2023 | 31 Septiembre, 2024 |