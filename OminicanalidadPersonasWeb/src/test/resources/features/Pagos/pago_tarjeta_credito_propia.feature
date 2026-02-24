#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar el pago de tarjetas propias desde sus cuentas

  @PagarTarjetaCreditoPropiaCuentas @QA
  Escenario: El cliente podra realizar el pago de las tarjeta de credito propia desde CA desde el menu de cuentas y menu tarjetas
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica el saldo de la cuenta 3110481891 antes de transferir
    Y realiza el pago de tarjeta desde cuentas con CA
      | tituloCuenta                | cuentaOrigen | tarjetaCredito                    | monto | concepto                     |
      | Resumen de cuenta ahorro CA | 3110481891   | **** 7722 VISA Selectos Clásica 3 | 1.0   | pago tarjeta credito propia2 |
    Y realiza el pago de tarjeta desde tarjetas con CA
      | tituloCuenta                | cuentaOrigen | tarjetaCredito                    | monto | concepto                     |
      | Resumen de cuenta ahorro CA | 3110481891   | **** 7722 VISA Selectos Clásica 3 | 1.0   | pago tarjeta credito propia3 |
    Entonces debe visualizar una disminucion de monto 2 en el saldo cuenta origen

  @PagarTarjetaCreditoPropiaCuentas @QA
  Escenario: El cliente podra realizar el pago de las tarjeta de credito propia desde CC desde el menu de cuentas y menu tarjetas
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente verifica el saldo de la cuenta 1210025438  antes de transferir para CC
    Y realiza el pago de tarjeta desde cuentas con CC
      | cuentaOrigen | tarjetaCredito                    | monto | concepto                    |
      | 1210025438   | **** 7722 VISA Selectos Clásica 3 | 1.0   | pago tarjeta credito propia |
    Y realiza el pago de tarjeta desde tarjetas con CC
      | cuentaOrigen | tarjetaCredito                    | monto | concepto                    |
      | 1210025438   | **** 7722 VISA Selectos Clásica 3 | 1.0   | pago tarjeta credito propia |
    Entonces debe visualizar una disminucion de monto 2 en el saldo cuenta origen