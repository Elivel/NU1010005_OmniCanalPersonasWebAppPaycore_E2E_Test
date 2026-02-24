#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar el pago de tarjetas entre bancos usando transfer 365 desde CA y CC (Normal y con favorito)

  @PagoTarjetasEntreBancos @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas entre bancos usando transfer 365 desde CA (Normal y con favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando el cliente verifica el saldo de la cuenta 31320008506 antes de transferir
    Y diligencia los campos para realizar el pago de tarjeta a otro banco usando Transfer 365 desde CA
      | cuentaOrigen                 | cuentaCorta | banco      | cuentaDestino    | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                 |
      | 31320008506 Cuenta de ahorro | 3132000850  | DAVIVIENDA | 4815322515962467 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | jegranad@bancoagricola.com.sv | PagoTarjeta365 | Tarjetas de otros bancos - transfer365 |
    Y realiza el pago de tarjeta a otro banco usando Transfer 365 desde un favorito
      | tituloCuenta                | cuentaOrigen                 | cuentaCorta | nombreFavorito | monto | concepto                               | banco      | cuentaDestino    | tipoCliente | nombreRecibidor | apellidoRecibidor | correo                        | opcion                                 |
      | Resumen de cuenta ahorro CA | 31320008506 Cuenta de ahorro | 3132000850  | PagoTarjeta365 | 1     | Tarjetas de otros bancos - transfer365 | DAVIVIENDA | 4815322515962467 | Natural     | LUIS            | LOPEZ             | jegranad@bancoagricola.com.sv | Tarjetas de otros bancos - transfer365 |
    Entonces debe visualizar una disminucion de monto 2 en el saldo cuenta origen

  @PagoTarjetasEntreBancos @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas entre bancos usando transfer 365 desde CC (Normal y con favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr

    Cuando el cliente verifica el saldo de la cuenta 5496752185 antes de transferir desde CC
    Y diligencia los campos para realizar el pago de tarjeta a otro banco usando Transfer 365 desde CC
      | cuentaOrigen                | cuentaCorta | banco      | cuentaDestino    | tipoCliente | nombreRecibidor | apellidoRecibidor | monto | concepto    | correo                        | nombreFavorito | opcion                                 |
      | 5496752185 Cuenta corriente | 5496752185  | DAVIVIENDA | 4815322515962467 | Natural     | LUIS            | LOPEZ             | 1     | transfer365 | lmenjiva@bancoagricola.com.sv | PagoTarjeta365 | Tarjetas de otros bancos - transfer365 |
    Y realiza el pago de tarjeta a otro banco usando Transfer 365 desde un favorito CC
      | cuentaOrigen                | cuentaCorta | nombreFavorito | monto | concepto                               | banco      | cuentaDestino    | tipoCliente | nombreRecibidor | apellidoRecibidor | correo                        | opcion                                 |
      | 5496752185 Cuenta corriente | 5496752185  | PagoTarjeta365 | 1     | Tarjetas de otros bancos - transfer365 | DAVIVIENDA | 4295185516887952 | Natural     | LUIS            | LOPEZ             | lmenjiva@bancoagricola.com.sv | Tarjetas de otros bancos - transfer365 |
    Entonces debe visualizar una disminucion de monto 2 en el saldo cuenta origen
