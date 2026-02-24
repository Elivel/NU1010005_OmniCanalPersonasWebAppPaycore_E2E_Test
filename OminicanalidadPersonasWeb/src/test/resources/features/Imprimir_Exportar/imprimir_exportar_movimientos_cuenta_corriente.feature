#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar los movimientos de cuenta corriente

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @ExportarMovimientosCuentaCorriente @excel @QA
  Escenario: El cliente podra exportar movimientos de Cuenta corriente
    Y valida los movimientos de la cuenta corriente para una fecha especifica
      | cuentaOrigen | fechaDesde          | fechaHasta          |
      | 1210039767   | 10 Septiembre, 2024 | 16 Septiembre, 2025 |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta


  @ImprimirMovimientosCuentaCorriente @QA
  Escenario: El cliente podra imprimir movimientos de Cuenta corriente
    Y valida los movimientos de la cuenta corriente para una fecha especifica
      | cuentaOrigen | fechaDesde          | fechaHasta          |
      | 1210039767   | 20 Septiembre, 2023 | 28 Septiembre, 2023 |
    Y realiza la accion de imprimir
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha