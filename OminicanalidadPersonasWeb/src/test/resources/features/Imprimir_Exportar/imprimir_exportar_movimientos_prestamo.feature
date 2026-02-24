#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar los movimientos de prestamo

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @ExportarMovimientosPrestamo @excel @QA
  Escenario: El cliente podra exportar movimientos de Prestamos
    Cuando valida los movimientos del préstamo para la fecha
      | numeroPrestamo                | fechaDesde    | fechaHasta         |
      | 2131947871 Prstamo de Consumo | 1 Enero, 2018 | 1 Septiembre, 2025 |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta

  @ImprimirMovimientosPrestamo @QA
  Escenario: El cliente podra imprimir movimientos de Prestamos
    Cuando valida los movimientos del préstamo para la fecha
      | numeroPrestamo                | fechaDesde    | fechaHasta         |
      | 2131947871 Prstamo de Consumo | 1 Enero, 2018 | 1 Septiembre, 2025 |
    Y realiza la accion de imprimir
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha