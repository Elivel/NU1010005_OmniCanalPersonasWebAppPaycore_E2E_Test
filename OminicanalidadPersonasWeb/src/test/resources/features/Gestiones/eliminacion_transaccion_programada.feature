#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá eliminar transferencias programadas

  @EliminarTransferenciaProgramada @QA
  Escenario: El cliente podrá realizar la eliminacion de una tranferencia programada desde el modulo de servicios
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando programa una transferencia entre cuentas para el dia siguiente
      | cuentaOrigen | cuentaDestino | monto | concepto                 |
      | 3001329786   | 3111466124    | 1     | transferencia programada |
    Entonces debe eliminar la transferencia programada segun el concepto transferencia programada y estado AGENDADA