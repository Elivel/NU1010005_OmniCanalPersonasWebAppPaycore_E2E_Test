#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias entre cuentas propias

  @TransferenciaCuentasPropiasCAaCA @QA
  Escenario: El cliente podrá realizar transferencias entre sus propias cuentas de CA a CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica los saldos al inicio de la transferencia de CA a CA
      | cuentaOrigen | cuentaDestino | tituloCuenta                |
      | 3001329786   | 3111466124    | Resumen de cuenta ahorro CA |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino de CA a CA
      | cuentaOrigen | cuentaCorta                 | cuentaDestino | monto | concepto                                   | tituloCuenta                |
      | 3001329786   | 3001329786 Cuenta de ahorro | 3111466124    | 0.01  | transferencia cuentas propias automatizada | Resumen de cuenta ahorro CA |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 0.01

  @TransferenciaCuentasPropiasCCaCC @QA
  Escenario: El cliente podrá realizar transferencias entre sus propias cuentas de CC a CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica los saldos al inicio de la transferencia de CC a CC
      | cuentaOrigen | cuentaDestino | tituloCuenta                |
      | 1210025438   | 1210063795    | Resumen de cuenta corriente |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino de CC a CC
      | cuentaOrigen | cuentaCorta   | cuentaDestino | monto | concepto                                   | tituloCuenta                |
      | 1210025438   | 1210025438 CC | 1210063795    | 0.01  | transferencia cuentas propias automatizada | Resumen de cuenta corriente |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 0.01

  @TransferenciaCuentasPropiasCAaCC @QA
  Escenario: El cliente podrá realizar transferencias entre sus propias cuentas de CA a CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica los saldos al inicio de la transferencia de CA a CC
      | cuentaOrigen | cuentaDestino | tituloCuenta                |
      | 3110481891   | 1210025438    | Resumen de cuenta ahorro CA |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino de CA a CC
      | cuentaOrigen | cuentaCorta   | cuentaDestino | monto | concepto                                   | tituloCuenta                |
      | 3110481891   | 3110481891 CA | 1210025438    | 0.01  | transferencia cuentas propias automatizada | Resumen de cuenta ahorro CA |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 0.01

  @TransferenciaCuentasPropiasCCaCA @QA
  Escenario: El cliente podrá realizar transferencias entre sus propias cuentas de CC a CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica los saldos al inicio de la transferencia de CC a CA
      | cuentaOrigen | cuentaDestino | tituloCuenta                |
      | 1210025438   | 3110481891    | Resumen de cuenta corriente |
    Y realiza el traslado de saldo de la cuenta origen a la cuenta destino de CC a CA
      | cuentaOrigen | cuentaCorta   | cuentaDestino | monto | concepto                                   | tituloCuenta                |
      | 1210025438   | 1210025438 CC | 3110481891    | 0.01  | transferencia cuentas propias automatizada | Resumen de cuenta corriente |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 0.01