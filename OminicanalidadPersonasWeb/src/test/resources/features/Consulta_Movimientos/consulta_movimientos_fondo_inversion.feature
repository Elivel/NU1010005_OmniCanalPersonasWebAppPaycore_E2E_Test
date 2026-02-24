#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos del fondo de inversión

  @MovimientosFondo @QA
  Escenario: El cliente podrá consultar movimientos de fondo de inversion para una fecha específica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente mavelar2
    Cuando ingresa al fondo de inversion 1-000835-000634 Fondo de inversión
    Y consulta los movimientos del fondo de inversion por fecha
      | fechaDesde    | fechaHasta          |
      | 1 Enero, 2018 | 16 Septiembre, 2025 |
    Entonces debe visualizar el listado de movimientos