#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar pago de tarjetas entre bancos desde su cuenta propia

  @PagoTarjetasEntreBancos @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas UNI desde CA (Nueva y favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD usrcert1
    Cuando el cliente verifica el saldo de la cuenta 3430120479 antes de transferir
    Y realiza el pago de tarjeta entre banco sin favorito
      | cuentaOrigen                | banco      | tarjetaOtroBanco | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | monto | concepto               | correo                        | nombreFavorito | opcion                   |
      | 3430120479 Cuenta de ahorro | BANCO AZUL | 4007310000001519 | DUI                | 000205901            | LUIS LOPEZ      | 1     | Pago tarjeta UNI Nuevo | eguevara@bancoagricola.com.sv | PagoTarjetaUni | Tarjetas de otros bancos |
    Y realiza el pago de tarjeta entre banco con favorito
      | cuentaOrigen                | nombreFavorito | monto | concepto                  | opcion                   | tituloCuenta                |
      | 3430120479 Cuenta de ahorro | PagoTarjetaUni | 1     | Pago tarjeta UNI Favorito | Tarjetas de otros bancos | Resumen de cuenta ahorro CA |
    Entonces debe visualizar una disminucion de monto 2.00 en el saldo cuenta origen

  @PagoTarjetasEntreBancos @DEV
  Escenario: El cliente podrá realizar el pago de tarjetas UNI desde CC (Nueva y favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD usrcert1
    Cuando el cliente verifica el saldo de la cuenta 5660004649 antes de transferir para CC
    Y realiza el pago de tarjeta entre banco sin favorito desde CC
      | cuentaOrigen                | banco      | tarjetaOtroBanco | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | monto | concepto               | correo                        | nombreFavorito | opcion                   |
      | 5660004649 Cuenta corriente | BANCO AZUL | 4007310000001519 | DUI                | 000205901            | LUIS LOPEZ      | 1     | Pago tarjeta UNI Nuevo | eguevara@bancoagricola.com.sv | PagoTarjetaUni | Tarjetas de otros bancos |
    Y realiza el pago de tarjeta entre banco con favorito desde CC
      | cuentaOrigen                | nombreFavorito | monto | concepto                  | opcion                   |
      | 5660004649 Cuenta corriente | PagoTarjetaUni | 1     | Pago tarjeta UNI Favorito | Tarjetas de otros bancos |
    Entonces debe visualizar una disminucion de monto 2.00 en el saldo cuenta origen