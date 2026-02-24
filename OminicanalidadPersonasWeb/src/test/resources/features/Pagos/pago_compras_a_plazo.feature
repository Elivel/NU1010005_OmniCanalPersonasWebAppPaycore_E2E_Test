#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar pagos de compras a plazo desde CA y CC

  @PagoComprasAPlazo @QA
  Escenario: El cliente podrá realizar pagos de compras a plazo desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Auto04
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen                | tituloCuenta                |
      | 3005942047 Cuenta de ahorro | Resumen de cuenta ahorro CA |
    Cuando se realiza el proceso de pagos de compras a plazo
      | cuentaOrigen                | tarjetaCredito      | compraPlazo                | monto | concepto            |
      | 3005942047 Cuenta de ahorro | **** 3144 VISA Gold | Samsung galaxy s22fe 256gb | 0.01  | Pago compra a plazo |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen                | monto | tituloCuenta                |
      | 3005942047 Cuenta de ahorro | 0.01  | Resumen de cuenta ahorro CA |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

  @PagoComprasAPlazo @QA
  Escenario: El cliente podrá realizar pagos de compras a plazo desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente Auto04
    Y valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen                | tituloCuenta                |
      | 5000117825 Cuenta corriente | Resumen de cuenta corriente |
    Cuando se realiza el proceso de pagos de compras a plazo desde CC
      | cuentaOrigen                | tarjetaCredito      | compraPlazo                | monto | concepto            |
      | 5000117825 Cuenta corriente | **** 3144 VISA Gold | Samsung galaxy s22fe 256gb | 0.01  | Pago compra a plazo |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen                | monto | tituloCuenta                |
      | 5000117825 Cuenta corriente | 0.01  | Resumen de cuenta corriente |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket





