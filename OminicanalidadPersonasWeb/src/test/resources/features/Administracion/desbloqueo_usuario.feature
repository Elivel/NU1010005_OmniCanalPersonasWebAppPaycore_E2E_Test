#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá desbloquear usuario

  @DesbloquearUsuario @QA

  Escenario: El cliente podrá desbloquear su usuario desde la pagina de Ebanca Personas de acuerdo a su usuario
    Dado que el cliente ingresa a e-banca Personas
    Cuando ingresa a desbloquear usuario e ingresa los datos de telebanca
    Entonces para el desbloqueo se debe visualizar el resultado de Usuario desbloqueado con éxito
