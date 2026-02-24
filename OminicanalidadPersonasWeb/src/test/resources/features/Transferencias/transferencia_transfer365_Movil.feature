#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar Transfer365 Móvil (Desde CA y CC)

  @TransferenciasTransfer365Movil @DEV
  Escenario: El cliente podrá realizar transferencias a bancos usando Transfer 365 movil desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta             |
      | 3111963027   | Resumen de cuenta ahorro CA |

    Y diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 movil
      | cuentaOrigen | cuentaTicket | banco            | celular  | nombreRecibidor | monto | concepto         | correo                        | nombreFavorito | opcion            |
      | 3111963027   | 3111963027   | BANCO AZUL, S.A. | 78054161 | LUIS PEREZ      | 1     | transfer365Movil | lmenjiva@bancoagricola.com.sv | Transfer365Mo  | Transfer365 Móvil |
    Y realiza la transferencia a otro banco usando Transfer 365 movil desde un favorito
      | cuentaOrigen | cuentaTicket | banco            | celular  | nombreRecibidor | monto | concepto         | correo                        | nombreFavorito | opcion            |
      | 3111963027   | 3111963027   | BANCO AZUL, S.A. | 78054161 | LUIS PEREZ      | 1     | transfer365Movil | lmenjiva@bancoagricola.com.sv | Transfer365Mo  | Transfer365 Móvil |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto | tituloCuenta             |
      | 3111963027   | 2     | Resumen de cuenta ahorro CA|

  @TransferenciasTransfer365Movil @DEV
  Escenario: El cliente podrá realizar transferencias a bancos usando Transfer 365 movil desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen                | tituloCuenta                |
      | 5496752185 Cuenta corriente | Resumen de cuenta corriente |
    Y diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 movil CC
      | cuentaOrigen                | cuentaTicket | banco            | celular  | nombreRecibidor | monto | concepto         | correo                        | nombreFavorito | opcion            |
      | 5496752185 Cuenta corriente | 5496752185   | BANCO AZUL, S.A. | 78054161 | LUIS PEREZ      | 1     | transfer365Movil | lmenjiva@bancoagricola.com.sv | Transfer365Mo  | Transfer365 Móvil |
    Y realiza la transferencia a otro banco usando Transfer 365 movil desde un favorito
      | cuentaOrigen                | cuentaTicket | banco            | celular  | nombreRecibidor | monto | concepto         | correo                        | nombreFavorito | opcion            |
      | 5496752185 Cuenta corriente | 5496752185   | BANCO AZUL, S.A. | 78054161 | LUIS PEREZ      | 1     | transfer365Movil | lmenjiva@bancoagricola.com.sv | Transfer365Mo  | Transfer365 Móvil |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen                | monto | tituloCuenta                |
      | 5496752185 Cuenta corriente | 2     | Resumen de cuenta corriente |

      #Favoritos tienen que definirse con 13 caracteres.