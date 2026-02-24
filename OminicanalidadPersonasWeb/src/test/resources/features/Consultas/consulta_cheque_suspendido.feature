#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá consultar sus cheques suspendidos

  @ChequesSuspendidos @QA
  Escenario: El cliente podrá consultar sus cheques suspendidos desde la opción Cheques suspendidos
  y la información debe coincidir con los cheques en estado Revocado de la opción Consulta de chequeras
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando ingresa a los cheques suspendidos de la cuenta corriente a validar en un lote de cheques
      | cuentaOrigen                | referenciaCheque |
      | 1210039767 Cuenta Corriente | 907340           |
    Y realiza proceso para consulta de chequera con estado Revocado
      | cuentaOrigen                | chequera        | estadoCheques | referenciaCheque |
      | 1210039767 Cuenta Corriente | 907326 - 907350 | Revocado      | 907340           |
    Entonces la cantidad de registros en estado Revocado debe coincidir con los cheques suspendidos