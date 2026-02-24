#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá gestionar los límites del canal y actualizar los límites por transacción

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02

  @ValidaciónLimiteTRX @QA
  Escenario: El cliente actualizara los limites por transacción y validará que sean efectivos los cambios
    Cuando actualiza los valores de limites de transacción y valida que se muestren los nuevos limites
      | limitePorTRX |
      | 1            |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero superando el limite por transacción
      | cuentaOrigen | cuentaTercero | monto | concepto                        | correo                        |
      | 3110481891   | 3001329786    | 2     | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv |
    Entonces reestablece los valores de limite de transacción por defecto
      | limitePorTRX |
      | 1            |

  @ValidaciónLimiteAcum @QA
  Escenario: El cliente actualizara los limites por transacción y los limites acumulables semanales y validará que sean efectivos los cambios
    Cuando actualiza los valores de limites de canal y limites de transacción y valida que se muestren los nuevos limites
      | limitePorTRX | limiteSem |
      | 500          | 500       |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero Nuevo
      | cuentaOrigen | cuentaCorta   | cuentaTercero | monto | concepto                        | correo                        | nombreFavorito  | opcion              |
      | 3110481891   | 3110481891 CA | 3001329786    | 1.00  | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv | favChrome99ACEP | Cuentas de terceros |
    Y realiza el traslado de saldo de la cuenta propia a la cuenta tercero superando el limite por acumulado semanal
      | cuentaOrigen | cuentaTercero | monto | concepto                        | correo                        |
      | 3110481891   | 3001329786    | 500   | transferencia cta tercero Nuevo | lmenjiva@bancoagricola.com.sv |
    Entonces reestablece todos los valores de limite de transacción por defecto
      | limitePorTRX | limiteSem |
      | 999999       | 999999    |