#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias de tipo ayuda Teleton a través de CA y CC

  @TransferenciaCuentaTeleton @QA
  Escenario: El cliente podrá realizar una transferencia a cuenta Teleton desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta 3111466124 antes de transferir
    Y realiza la transferencia desde su cuenta 3111466124 a una cuenta teleton por un monto de 0.01 dolares
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen

  @TransferenciaCuentaTeleton @QA
  Escenario: El cliente podrá realizar una transferencia a cuenta Teleton desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta 1210039767 antes de transferir para CC
    Y realiza la transferencia desde su cuenta 1210039767 a una cuenta teleton por un monto de 0.01 dolares desde CC
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen
