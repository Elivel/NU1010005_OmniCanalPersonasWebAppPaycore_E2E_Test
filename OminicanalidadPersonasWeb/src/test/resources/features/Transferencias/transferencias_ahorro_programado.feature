#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias desde la cuenta de ahorro programado

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @TransferenciaCuentasPropiasAP @QA
  Escenario: El cliente podrá realizar tranferencias desde la cuenta de ahorro programado a CA
    Y valida los saldos antes de realizar la transacción para ambas cuentas
      | cuentaOrigen | cuentaDestino |
      | 3009267649   | 3001329786    |
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen | cuentaDestino | monto | concepto                         |
      | 3009267649   | 3001329786    | 1     | transferencia cuentas propias AP |
    Entonces valida los saldos posterior a realizar la transacción para ambas cuentas validando la referencia en movimientos
      | cuentaOrigen | cuentaDestino | monto |
      | 3009267649   | 3001329786    | 1     |

  @TransferenciaCuentasPropiasAP @QA
  Escenario: El cliente podrá realizar tranferencias desde la cuenta de ahorro programado a CC
    Y valida los saldos antes de realizar la transacción para ambas cuentas CC
      | cuentaOrigen | cuentaDestino |
      | 3009267649   | 1210039767    |
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino
      | cuentaOrigen | cuentaDestino | monto | concepto                         |
      | 3009267649   | 1210039767    | 1     | transferencia cuentas propias AP |
    Entonces valida los saldos posterior a realizar la transacción para ambas cuentas validando la referencia en movimientos CC
      | cuentaOrigen | cuentaDestino | monto |
      | 3009267649   | 1210039767    | 1     |

  @TransferenciaCuentasTercerosAPCuenta @QA
  Escenario: El cliente podrá realizar tranferencias desde la cuenta de ahorro programado a cuenta tercero seleccionando cuenta
    Y el cliente verifica el saldo de AP al inicio de la transferencia
      | cuentaOrigen |
      | 3009267649   |
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino tercero seleccionando cuenta
      | cuentaOrigen | cuentaDestino | correo                        | monto | concepto                          |
      | 3009267649   | 3111963027    | lmenjiva@bancoagricola.com.sv | 1     | transferencia cuentas terceros AP |
    Entonces debe visualizar una disminucion en el saldo de AP
      | cuentaOrigen | monto |
      | 3009267649   | 1     |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket para ahorro programado

  @TransferenciaCuentasTercerosAPCelular @QA
  Escenario: El cliente podrá realizar tranferencias desde la cuenta de ahorro programado a cuenta tercero seleccionando celular
    Y el cliente verifica el saldo de AP al inicio de la transferencia
      | cuentaOrigen |
      | 3009267649   |
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino tercero seleccionando celular
      | cuentaOrigen | celular  | correo                        | monto | concepto                          |
      | 3009267649   | 60231191 | lmenjiva@bancoagricola.com.sv | 1     | transferencia cuentas terceros AP |
    Entonces debe visualizar una disminucion en el saldo de AP
      | cuentaOrigen | monto |
      | 3009267649   | 1     |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket para ahorro programado
