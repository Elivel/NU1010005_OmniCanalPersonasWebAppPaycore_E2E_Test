#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar los movimientos de tarjeta de credito

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9

  @ExportarMovimientosTarjeta @excel @QA
  Escenario: El cliente podra exportar movimientos de Tarjeta
    Cuando valida los movimientos de tarjeta de crédito para una fecha especifica y captura encabezados
      | tarjetaCredito          | fechaDesde    | fechaHasta    |
      | **** 8716 VISA Platinum | 1 Enero, 2025 | 1 Enero, 2026 |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de movimientos de tarjeta en la carpeta y compara saldos

  @ImprimirMovimientosTarjeta @QA
  Escenario: El cliente podra imprimir movimientos de Tarjeta
    Cuando valida los movimientos de tarjeta de crédito para una fecha especifica
      | tarjetaCredito          | fechaDesde    | fechaHasta    |
      | **** 8716 VISA Platinum | 1 Enero, 2025 | 1 Enero, 2026 |
    Y realiza la accion de imprimir
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha