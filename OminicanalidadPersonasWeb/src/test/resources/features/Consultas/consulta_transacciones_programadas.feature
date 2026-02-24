#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar transacciones programadas

  @ConsultaTransferenciaProgramada @QA
  Escenario: El cliente consultar transacciones programadas para semana actual
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y realiza agenda de recargas para la compañia indicada desde cuenta de ahorro
      | cuentaOrigen | celular  | compania                | montopaquete                                               | concepto | opcion             |
      | 3111466124   | 72491237 | TIGO, PREPAGO (RECARGA) | 2D 1GB+RedesSoc+10minOtraRed/USA/CAN+IlimTigo $1.10 $ 1.10 | paquete  | Recarga de Celular |
    Cuando realizar consulta de transacciones programadas
      | periodo       | tipoTRX | estadoTRX | canal            |
      | Semana actual | Todos   | AGENDADA  | e-banca Personas |
    Entonces debe visualizar el listado de movimientos con el estado AGENDADA


