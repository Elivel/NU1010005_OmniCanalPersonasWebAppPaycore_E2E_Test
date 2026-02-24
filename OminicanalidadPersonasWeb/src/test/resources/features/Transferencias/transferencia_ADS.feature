#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá Realizar transferencias desde ADS (CA, CC y terceros)

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas

    Y inicia sesion como clienteD adsdev888

  @TransferenciaADSCA @DEV
  Escenario: El cliente podrá realizar transferencias de ADS a CA
    Cuando el cliente verifica los saldos al inicio de la transferencia de ADS a CA
      | cuentaOrigen                | cuentaDestino               |
      | 5160019435 Cuenta corriente | 3020314800 Cuenta de ahorro |
    Y realiza el traslado de saldo de la cuenta ADS a la cuenta destino CA
      | cuentaOrigen                | cuentaCorta   | cuentaDestino | cuentaTicket  | monto | concepto               |
      | 5160019435 Cuenta corriente | 5160019435 CC | 3020314800    | 3020314800 CA | 1     | transferencia ADS a CA |
    Entonces debe visualizar una disminucion de monto 1.03 en el saldo cuenta origen
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 1

  @TransferenciaADSCC @DEV
  Escenario: El cliente podrá realizar transferencias de ADS a CC
    Cuando el cliente verifica los saldos al inicio de la transferencia de ADS a CC
      | cuentaOrigen                | cuentaDestino               |
      | 5160019435 Cuenta corriente | 5986251951 Cuenta corriente |
    Y realiza el traslado de saldo de la cuenta ADS a la cuenta destino CC
      | cuentaOrigen                | cuentaCorta   | cuentaDestino | cuentaTicket  | monto | concepto                                   |
      | 5160019435 Cuenta corriente | 5160019435 CC | 5986251951    | 5986251951 CC | 1     | transferencia cuentas propias automatizada |
    Entonces debe visualizar una disminucion de monto 1.03 en el saldo cuenta origen
    Y debe visualizar un aumento en el saldo cuenta destino por el monto de 1

  @TransferenciaADSTercerosCuenta @DEV
  Escenario: El cliente podrá realizar transferencias de ADS a terceros ingresando cuenta (Nueva y favorito)
    Cuando el cliente verifica el saldo de la cuenta 5160019435 antes de transferir desde ADS
    Y realiza el traslado de saldo de la cuenta ADS a la cuenta tercero Nuevo
      | cuentaOrigen                | cuentaCorta   | cuentaTercero | cuentaTicket  | monto | concepto                        | correo                        | nombreFavorito | opcion              |
      | 5160019435 Cuenta corriente | 5160019435 CC | 3660465124    | 3420127380 CA | 1     | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv | Ter3660465124  | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta ADS a la cuenta tercero favorito
      | cuentaOrigen                | cuentaCorta   | cuentaTercero | cuentaTicket  | monto | concepto                           | nombreFavorito | opcion              | correo                        |
      | 5160019435 Cuenta corriente | 5160019435 CC | 3660465124    | 3420127380 CA | 1     | transferencia cta tercero Favorito | Ter3660465124  | Cuentas de terceros | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 2.06 en el saldo cuenta origen

  @TransferenciaADSTercerosCelular @DEV
  Escenario: El cliente podrá realizar transferencias de ADS a terceros ingresando celular (Nueva y favorito)
    Cuando el cliente verifica el saldo de la cuenta 5160019435 antes de transferir desde ADS
    Y realiza el traslado de saldo de la cuenta ADS a la cuenta tercero celular Nuevo
      | cuentaOrigen                | cuentaCorta   | celular  | monto | concepto                        | correo                        | nombreFavorito | opcion              |
      | 5160019435 Cuenta corriente | 5160019435 CC | 72607433 | 1     | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv | Ter72607433    | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta ADS a la cuenta tercero celular favorito
      | cuentaOrigen                | cuentaCorta   | celular  | monto | concepto                           | nombreFavorito | opcion              | correo                        |
      | 5160019435 Cuenta corriente | 5160019435 CC | 72607433 | 1     | transferencia cta tercero Favorito | Ter72607433    | Cuentas de terceros | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 2.06 en el saldo cuenta origen