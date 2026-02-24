#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar los movimientos de cuenta de ahorro

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @ExportarMovimientosCuenta @excel @QA
  Escenario: El cliente podra exportar movimientos de Cuenta de ahorro
    Cuando consulta los movimientos de la cuenta de ahorro para una fecha especifica y captura encabezados de saldos
      | cuentaOrigen                | fechaDesde          | fechaHasta     |
      | 3001329786 Cuenta de ahorro | 20 Septiembre, 2025 | 12 Enero, 2026 |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo Movimientos.xlsx en la carpeta y valida los saldos del encabezado


  @ImprimirMovimientosCuenta @QA
  Escenario: El cliente podra imprimir movimientos de Cuenta de ahorro
    Y valida los movimientos de la cuenta de ahorro para una fecha especifica
      | tituloCuenta                | cuentaOrigen                | fechaDesde          | fechaHasta          |
      | Resumen de cuenta ahorro CA | 3001329786 Cuenta de ahorro | 20 Septiembre, 2025 | 12 Enero, 2026 |
    Y realiza la accion de imprimir
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha