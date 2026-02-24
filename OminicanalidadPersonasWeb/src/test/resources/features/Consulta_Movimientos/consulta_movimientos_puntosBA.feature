#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de puntosBA (Egresos) para una fecha especifica

  @ValidaMovimientosFechaEspecifica @QA
  Escenario: El cliente podrá consultar movimientos de puntosBA (Egresos) para una fecha especifica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y valida los movimientos de puntos BA para una fecha especifica
      | fechaDesde     | fechaHasta     |
      | 1 Junio, 2023  | 6 Junio, 2023  |
    Entonces debe visualizar el listado de movimientos