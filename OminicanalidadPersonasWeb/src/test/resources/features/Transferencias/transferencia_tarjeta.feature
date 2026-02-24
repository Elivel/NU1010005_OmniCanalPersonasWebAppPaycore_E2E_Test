#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias de TDC a cuentas propias

  @TransferenciaTDCaCuentasPropias @QA
  Escenario: El cliente podrá realizar transferencias de TDC a CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica los saldos al inicio de la transferencia para la tarjeta
      | tarjetaCredito         | cuentaDestino |
      | **** 6603 Preferencial | 3113482653    |
    Y realiza el traslado de saldo de la tarjeta a la cuenta destino
      | tarjetaCredito         | cuentaDestino | monto | concepto              |
      | **** 6603 Preferencial | 3113482653    | 1     | transferencia TC a CP |
    Entonces debe visualizar una disminucion en el saldo cuenta de la TC
      | monto |
      | 1     |
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 1

  @TransferenciaTDCaCuentasPropias @QA
  Escenario: El cliente podrá realizar transferencias de TDC a CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica los saldos al inicio de la transferencia para la tarjeta y CC
      | tarjetaCredito         | cuentaDestino |
      | **** 6603 Preferencial | 1210025438    |
    Y realiza el traslado de saldo de la tarjeta a la cuenta destino CC
      | tarjetaCredito         | cuentaDestino | monto | concepto              |
      | **** 6603 Preferencial | 1210025438    | 1     | transferencia TC a CP |
    Entonces debe visualizar una disminucion en el saldo cuenta de la TC
      | monto |
      | 1     |
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 1