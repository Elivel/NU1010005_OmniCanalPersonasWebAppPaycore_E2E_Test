#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de Préstamos

  @ValidaMovimientosFechaEspecifica @QA
  Escenario: El cliente podrá consultar movimientos de prestamos para una fecha específica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Entonces valida los movimientos del préstamo para la fecha
      | numeroPrestamo                | fechaDesde     | fechaHasta        |
      | 2131947871 Prstamo de Consumo | 1  Enero, 2024 | 4 Diciembre, 2025 |



