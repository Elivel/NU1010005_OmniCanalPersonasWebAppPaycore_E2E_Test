#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar movimientos de extrafinanciamiento

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Auto04

  @ExportarMovimientosPrestamo @excel @QA
  Escenario: El cliente podra exportar movimientos de extrafinanciamiento
    Cuando valida los movimientos del extrafinanciamiento para la fecha
      | extrafinanciamiento                        | fechaDesde    | fechaHasta         |
      | 2130032594 Préstamo de Extrafinanciamiento | 1 Enero, 2023 | 1 Septiembre, 2025 |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta

  @ImprimirMovimientosPrestamo @QA
  Escenario: El cliente podra imprimir movimientos de extrafinanciamiento
    Cuando valida los movimientos del extrafinanciamiento para la fecha
      | extrafinanciamiento                        | fechaDesde    | fechaHasta         |
      | 2130032594 Préstamo de Extrafinanciamiento | 1 Enero, 2023 | 1 Septiembre, 2025 |
    Y realiza la accion de imprimir
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha