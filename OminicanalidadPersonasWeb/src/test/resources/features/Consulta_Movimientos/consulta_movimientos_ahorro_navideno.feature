#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de Ahorro Navideño

  @ValidaMovimientosFechaEspecificaAhNav @QA
  Escenario: El cliente podrá consultar movimientos de ahorro navideno para una fecha especifica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando ingresa a los movimientos de la sección de ahorro navideño 3007040110 y contrato 000000035082
    Entonces valida los movimientos del ahorro por la fecha
      | fechaDesde          | fechaHasta         |
      | 15 Enero, 2020      | 15 Mayo, 2020      |