#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar el pago de prestamos por extrafinanciamiento desde CA y CC

  @PagoExtrafinanciamientoDesdeCtaPropia @QA
  Escenario: El cliente podrá realizar el pago de los prestamos por extrafinanciamiento desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta 3001329786  antes de transferir
    Y realiza el pago de extrafinanciamiento usando CA
      | tituloCuenta                | cuentaOrigen | numeroPrestamo | tipoCobro  | monto | concepto                          |
      | Resumen de cuenta ahorro CA | 3001329786   | 2131973328     | Otro monto | 0.01  | pago prestamo extrafinanciamiento |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen

  @PagoExtrafinanciamientoDesdeCtaPropia @QA
  Escenario: El cliente podrá realizar el pago de los prestamos por extrafinanciamiento desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta 1210039767 antes de transferir para CC
    Y realiza el pago de extrafinanciamiento usando CC
      | cuentaOrigen | numeroPrestamo | tipoCobro  | monto | concepto                          |
      | 1210039767   | 2131973328     | Otro monto | 0.01  | pago prestamo extrafinanciamiento |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen