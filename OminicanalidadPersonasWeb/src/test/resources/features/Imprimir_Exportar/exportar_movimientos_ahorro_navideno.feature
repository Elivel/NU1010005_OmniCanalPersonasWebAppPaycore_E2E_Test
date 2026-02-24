#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá exportar de ahorro navideño

  @ExportarMovimientosNavideño @excel @QA
  Escenario: El cliente podrá exportar movimientos Ahorro Navideño, el cliente podrá visualizar los movimientos de su cuenta en un archivo de excel
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando ingresa a los movimientos de la sección de ahorro navideño 3007040110 y contrato 000000035082
    Y valida los movimientos del ahorro por la fecha
      | fechaDesde          | fechaHasta         |
      | 15 Enero, 2020      | 15 Mayo, 2020      |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta