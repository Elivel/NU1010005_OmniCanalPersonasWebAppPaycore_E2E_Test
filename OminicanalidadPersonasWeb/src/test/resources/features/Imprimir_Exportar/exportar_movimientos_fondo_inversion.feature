#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá exportar los movimientos generados en su fondo de inversion

  @ExportarFondos @excel @QA
  Escenario: El cliente podrá exportar movimientos generados en el fondo de inversión desde e-banca
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente mavelar2
    Cuando consulta los movimientos del fondo de inversion para una fecha especifica
      | fondoInversion  | fechaDesde    | fechaHasta          |
      | 1-000835-000634 | 1 Enero, 2018 | 12 Septiembre, 2025 |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta