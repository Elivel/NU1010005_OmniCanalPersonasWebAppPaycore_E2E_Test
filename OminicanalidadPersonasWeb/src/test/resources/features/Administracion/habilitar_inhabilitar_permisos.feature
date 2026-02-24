#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá habilitar e inhabilitar permisos a funcionalidades

  @HabilitarInhabilitar @QA
  Escenario: El cliente podrá habilitar e inhabilitar permisos
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y realiza el proceso inhabilitación de opcion y valida que no se muestre la opcion "CIEX"
      | usuario                  | opcion | permisos  | cuentaOrigen                |
      | SANDRA YANIRA PEÑA AMAYA | Pagar  | Pago CIEX | 3001329786 Cuenta de Ahorro |
    Entonces realiza el proceso de habilitación y valida que se muestre la opcion "CIEX"
      | usuario                  | opcion | permisos  | cuentaOrigen                |
      | SANDRA YANIRA PEÑA AMAYA | Pagar  | Pago CIEX | 3001329786 Cuenta de Ahorro |