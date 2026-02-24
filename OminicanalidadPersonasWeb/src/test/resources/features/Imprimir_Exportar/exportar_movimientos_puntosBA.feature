#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá exportar los movimientos generados (Egresos) por PuntosBA para una fecha especifica

  @ExportarPuntosBA @excel @QA
  Escenario: El cliente podrá exportar movimientos (Egresos) de PuntosBA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y valida los movimientos de puntos BA para una fecha especifica
      | fechaDesde     | fechaHasta     |
      | 1 Junio, 2023 | 6 Noviembre, 2023  |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta