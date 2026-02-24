#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias de cuentas propias a terceros

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @TransferenciaCtaPropiaATerceros @QA
  Escenario: El cliente podrá realizar transferencias desde CA a terceros ingresando cuenta (Nueva y favorito)
    Cuando el cliente verifica el saldo de la cuenta 3001329786 antes de transferir
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero Nuevo
      | tituloCuenta                | cuentaOrigen | cuentaCorta                 | cuentaTercero | monto | concepto                        | correo                     | nombreFavorito | opcion              |
      | Resumen de cuenta ahorro CA | 3001329786   | 3001329786 Cuenta de Ahorro | 3680554613    | 0.01  | transferencia cta tercero Nuevo | adcastil@bancoagricola.com | OKTERCERO      | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero favorito
      | tituloCuenta                | cuentaOrigen | cuentaCorta                 | cuentaTercero | monto | concepto                           | nombreFavorito | opcion              | correo                     |
      | Resumen de cuenta ahorro CA | 3001329786   | 3001329786 Cuenta de Ahorro | 3680554613    | 0.01  | transferencia cta tercero Favorito | OKTERCERO      | Cuentas de terceros | adcastil@bancoagricola.com |
    Entonces debe visualizar una disminucion de monto 0.02 en el saldo cuenta origen

  @TransferenciaCtaPropiaATercerosCC @QA
  Escenario: El cliente podrá realizar transferencias desde CC a terceros ingresando cuenta (Nueva y favorito)
    Cuando el cliente verifica el saldo de la cuenta 1210039767 antes de transferir para CC
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero Nuevo para CC
      | cuentaOrigen | cuentaCorta                 | cuentaTercero | monto | concepto                        | correo                        | nombreFavorito | opcion              |
      | 1210039767   | 1210039767 Cuenta Corriente | 3680554613    | 0.01  | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv | Ter3020054561  | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero favorito para CC
      | cuentaOrigen | cuentaCorta                 | cuentaTercero | monto | concepto                           | nombreFavorito | opcion              | correo                        |
      | 1210039767   | 1210039767 Cuenta Corriente | 3680554613    | 0.01  | transferencia cta tercero Favorito | Ter3020054561  | Cuentas de terceros | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.02 en el saldo cuenta origen

  @TransferenciaCtaPropiaATercerosCelularCA @QA
  Escenario: El cliente podrá realizar transferencias desde CA a terceros ingresando celular (Nueva y favorito)
    Cuando el cliente verifica el saldo de la cuenta 3001329786 antes de transferir
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular Nuevo desde CA
      | tituloCuenta                | cuentaOrigen | cuentaCorta                 | celular  | monto | concepto                        | correo                      | nombreFavorito | opcion              |
      | Resumen de cuenta ahorro CA | 3001329786   | 3001329786 Cuenta de Ahorro | 72893976 | 0.01  | transferencia cta tercero Nuevo | kceron@bancoagricola.com.sv | OKTERCERO      | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular favorito desde CA
      | tituloCuenta                | cuentaOrigen | cuentaCorta                 | celular  | monto | concepto                           | nombreFavorito | opcion              | correo                      |
      | Resumen de cuenta ahorro CA | 3001329786   | 3001329786 Cuenta de Ahorro | 72893976 | 0.01  | transferencia cta tercero Favorito | OKTERCERO      | Cuentas de terceros | kceron@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.02 en el saldo cuenta origen

  @TransferenciaCtaPropiaATercerosCelularCC @QA
  Escenario: El cliente podrá realizar transferencias desde CC a terceros ingresando celular (Nueva y favorito)
    Cuando el cliente verifica el saldo de la cuenta 1210039767 antes de transferir para CC
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular Nuevo desde CC
      | cuentaOrigen | cuentaCorta                 | celular  | monto | concepto                        | correo                        | nombreFavorito | opcion              |
      | 1210039767   | 1210039767 Cuenta Corriente | 60231191 | 0.01  | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv | Ter3020054561  | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero celular favorito desde CC
      | cuentaOrigen | cuentaCorta                 | celular  | monto | concepto                           | nombreFavorito | opcion              | correo                        |
      | 1210039767   | 1210039767 Cuenta Corriente | 60231191 | 0.01  | transferencia cta tercero Favorito | Ter3020054561  | Cuentas de terceros | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.02 en el saldo cuenta origen