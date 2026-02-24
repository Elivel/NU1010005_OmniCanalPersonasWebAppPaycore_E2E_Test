#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar el pago de tarjetas de terceros desde sus cuentas

  @PagarTarjetaATerceros @QA
  Escenario: El cliente podra realizar el pago TDC de terceros desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica el saldo de la cuenta 3110481891 antes de transferir
    Y realiza el pago de tarjeta a tercero desde la cuenta propia
      | tituloCuenta                | cuentaOrigen | tarjetaCreditoTercero | monto | concepto                            | correo                        |
      | Resumen de cuenta ahorro CA | 3110481891   | 5293320007570689      | 0.01  | pagar tarjeta a terceros automatico | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.01  en el saldo cuenta origen

  @PagarTarjetaATerceros @QA
  Escenario: El cliente podra realizar el pago TDC de terceros desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica el saldo de la cuenta 1210025438 antes de transferir para CC
    Y realiza el pago de tarjeta a tercero desde CC
      | cuentaOrigen | tarjetaCreditoTercero | monto | concepto                            | correo                        |
      | 1210025438   | 5293320007570689      | 0.01  | pagar tarjeta a terceros automatico | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.01  en el saldo cuenta origen
