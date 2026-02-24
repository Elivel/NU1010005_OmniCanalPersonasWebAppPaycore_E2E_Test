#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar pago de préstamos entre bancos a través de transfer 365 desde CA y CC (Normal y con favorito)

  @PagoPrestamoTransfer365 @DEV
  Escenario: El cliente podrá realizar el pago de prestamos entre bancos usando Transfer 365 desde CA (Normal y con favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando el cliente verifica el saldo de la cuenta 31320008506  antes de transferir
    Y diligencia los campos para realizar el pago de prestamo a otro banco usando Transfer 365
      | cuentaOrigen                 | cuentaCorta | banco           | cuentaDestino | tipoCliente | apellidoRecibidor | nombreRecibidor | monto | concepto | correo                        | nombreFavorito | opcion                                  |
      | 31320008506 Cuenta de ahorro | 31320008506 | BANCO PROMERICA | 950632        | Jurídico    | LOPEZ             | LUIS            | 1     | Prestamo | lmenjiva@bancoagricola.com.sv | FavoritoPRHIP  | Préstamos de otros bancos - transfer365 |
    Y realiza el pago de prestamo a otro banco usando Transfer 365 desde un favorito
      | cuentaOrigen                 | cuentaCorta | nombreFavorito | monto | concepto    | banco           | cuentaDestino | tipoCliente | apellidoRecibidor | nombreRecibidor | correo                        | opcion                                  |
      | 31320008506 Cuenta de ahorro | 31320008506 | FavoritoPRHIP  | 1     | transfer365 | BANCO PROMERICA | 950632        | Jurídico    | LOPEZ             | LUIS            | lmenjiva@bancoagricola.com.sv | Préstamos de otros bancos - transfer365 |
    Entonces debe visualizar una disminucion de monto 2 en el saldo cuenta origen

  @PagoPrestamoTransfer365 @DEV
  Escenario: El cliente podrá realizar el pago de prestamos entre bancos usando Transfer 365 desde CC (Normal y con favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr
    Cuando el cliente verifica el saldo de la cuenta 5496752185 antes de transferir desde CC
    Y diligencia los campos para realizar el pago de prestamo a otro banco usando Transfer 365 desde CC
      | cuentaOrigen                | cuentaCorta | banco           | cuentaDestino | tipoCliente | apellidoRecibidor | nombreRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                  |
      | 5496752185 Cuenta corriente | 5496752185  | BANCO PROMERICA | 950632        | Jurídico    | LOPEZ             | LUIS            | 1     | transfer365 | lmenjiva@bancoagricola.com.sv | FavoritoPRHIP  | Préstamos de otros bancos - transfer365 |
    Y realiza el pago de prestamo a otro banco usando Transfer 365 desde un favorito desde CC
      | cuentaOrigen                | cuentaCorta | nombreFavorito | monto | concepto    | banco           | cuentaDestino | tipoCliente | apellidoRecibidor | nombreRecibidor | correo                        | opcion                                  |
      | 5496752185 Cuenta corriente | 5496752185  | FavoritoPRHIP  | 1     | transfer365 | BANCO PROMERICA | 950632        | Jurídico    | LOPEZ             | LUIS            | lmenjiva@bancoagricola.com.sv | Préstamos de otros bancos - transfer365 |
    Entonces debe visualizar una disminucion de monto 2 en el saldo cuenta origen