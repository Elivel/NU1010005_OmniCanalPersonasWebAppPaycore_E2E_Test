#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar Transferencias Transfer365: Operaciones entre bancos (Desde CA y CC)

  @TransferenciasTransfer365 @DEV
  Escenario: El cliente podrá realizar transferencias a bancos usando Transfer 365 desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta                 |
      | 31320008506  | Resumen de cuenta ahorro CA1 |
    Y diligencia los campos para realizar la transferencia a otro banco usando Transfer 365
      | cuentaOrigen | tipoCuenta                | banco            | cuentaDestino  | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                |
      | 31320008506  | Cuenta de ahorro - propia | BANCO AZUL, S.A. | 10000001224978 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | lmenjiva@bancoagricola.com.sv | Transfer365CTA | Cuentas de otros bancos - transfer365 |
    Y realiza la transferencia a otro banco usando Transfer 365 desde un favorito
      | cuentaOrigen | tipoCuenta                | banco            | cuentaDestino  | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                |
      | 31320008506  | Cuenta de ahorro - propia | BANCO AZUL, S.A. | 10000001224978 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | lmenjiva@bancoagricola.com.sv | Transfer365CTA | Cuentas de otros bancos - transfer365 |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto | tituloCuenta                 |
      | 31320008506  | 2     | Resumen de cuenta ahorro CA1 |

  @TransferenciasTransfer365 @DEV
  Escenario: El cliente podrá realizar transferencias a bancos usando Transfer 365 desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen |
      | 5496752185   |
    Y diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 desde CC
      | cuentaOrigen | tipoCuenta                | banco            | cuentaDestino  | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                |
      | 5496752185   | Cuenta de ahorro - propia | BANCO AZUL, S.A. | 10000001224978 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | lmenjiva@bancoagricola.com.sv | Transfer365CTA | Cuentas de otros bancos - transfer365 |
    Y realiza la transferencia a otro banco usando Transfer 365 desde un favorito
      | cuentaOrigen | tipoCuenta                | banco            | cuentaDestino  | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                |
      | 5496752185   | Cuenta de ahorro - propia | BANCO AZUL, S.A. | 10000001224978 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | lmenjiva@bancoagricola.com.sv | Transfer365CTA | Cuentas de otros bancos - transfer365 |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen | monto |
      | 5496752185   | 2     |

      #Favoritos tienen que definirse con 13 caracteres.