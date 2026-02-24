#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar la donacion de Cash Bac a una ONG y redencion de Cash Bac a CA y CC

  @DonacionCashBac @QA
  Escenario: El cliente podrá realizar la donacion de Cash Bac a una institucion ONG
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando valida saldo y realiza la donacion para una ONG
      | tipoOperacion       | institucionOng | tipoCobro     | monto | concepto             |
      | Donación de CashBac | LIBRAS DE AMOR | Cobro parcial | 10    | Donacion CashBac ONG |
    Entonces debe visualizar una disminucion en el saldo CashBac por el monto de 10

  @RedencionCashBac @QA
  Escenario: El cliente podrá realizar la redencion de Cash Bac transfiriendo a CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta a transferir
      | cuentaDestino |
      | 3001329786     |
    Y valida saldo y realiza la transferencia de cashbac a una cuenta propia
      | tipoOperacion        | productoAbonar | tipoCobro     | monto | concepto                    | cuentaDestino |
      | Redención de CashBac | 3001329786      | Cobro parcial | 10    | RedencionCashBac Automatico | 3001329786     |
    Entonces debe visualizar una disminucion en el saldo CashBac por el monto de 10
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 10

  @RedencionCashBac @QA
  Escenario: El cliente podrá realizar la redencion de Cash Bac transfiriendo a CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta a transferir para CC
      | cuentaDestino |
      | 1210039767    |
    Y valida saldo y realiza la transferencia de cashbac a una cuenta propia para CC
      | tipoOperacion        | productoAbonar              | tipoCobro     | monto | concepto                    | cuentaDestino               |
      | Redención de CashBac | 1210039767 Cuenta corriente | Cobro parcial | 10    | RedencionCashBac Automatico | 1210039767 Cuenta corriente |
    Entonces debe visualizar una disminucion en el saldo CashBac por el monto de 10
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 10