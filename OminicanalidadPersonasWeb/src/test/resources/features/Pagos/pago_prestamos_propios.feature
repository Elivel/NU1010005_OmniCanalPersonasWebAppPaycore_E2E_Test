#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar pago de préstamos propios desde CA y CC (Desde cuenta y desde prestamo)


  @PagoPrestamosPropiosCtaAhorro @QA
  Escenario: El cliente podrá realizar pagos de prestamos propios, desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta                |
      | 3001329786   | Resumen de cuenta ahorro CA |
    Y realiza el proceso de pago de préstamo propio desde la cuenta de ahorro
      | cuentaOrigen | cuentaCorta                 | numeroPrestamo | monto | concepto                      |
      | 3001329786   | 3001329786 Cuenta de Ahorro | 2131947871     | 0.01  | Pago prestamo propio desde CA |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto | tituloCuenta                |
      | 3001329786   | 0.01  | Resumen de cuenta ahorro CA |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

  @PagoPrestamosPropiosPrestamo @QA
  Escenario: El cliente podrá realizar pagos de préstamos propios, desde préstamo seleccionando CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta                |
      | 3001329786   | Resumen de cuenta ahorro CA |
    Y realiza el proceso de pago de préstamo propio desde el préstamo
      | cuentaOrigen | cuentaCorta                 | numeroPrestamo | monto | concepto                            |
      | 3001329786   | 3001329786 Cuenta de Ahorro | 2131947871     | 0.01  | Pago prestamo propio desde prestamo |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto | tituloCuenta                |
      | 3001329786   | 0.01  | Resumen de cuenta ahorro CA |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

  @PagoPrestamosPropiosCtaCorriente @QA
  Escenario: El cliente podrá realizar pagos de prestamos propios, desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen | tituloCuenta                |
      | 1210039767   | Resumen de cuenta corriente |
    Y realiza el proceso de pago de préstamo propio desde la cuenta corriente
      | cuentaOrigen | cuentaCorta                 | numeroPrestamo | monto | concepto                      |
      | 1210039767   | 1210039767 Cuenta Corriente | 2131947871     | 0.01  | Pago prestamo propio desde CC |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen | monto | tituloCuenta                |
      | 1210039767   | 0.01  | Resumen de cuenta corriente |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

  @PagoPrestamosPropiosPrestamo @QA
  Escenario: El cliente podrá realizar pagos de préstamos propios, desde préstamo seleccionando CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen | tituloCuenta                |
      | 1210039767   | Resumen de cuenta corriente |
    Y realiza el proceso de pago de préstamo propio desde el préstamo
      | cuentaOrigen | cuentaCorta                 | numeroPrestamo | monto | concepto                            |
      | 1210039767   | 1210039767 Cuenta Corriente | 2131947871     | 0.01  | Pago prestamo propio desde prestamo |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen | monto | tituloCuenta                |
      | 1210039767   | 0.01  | Resumen de cuenta corriente |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket