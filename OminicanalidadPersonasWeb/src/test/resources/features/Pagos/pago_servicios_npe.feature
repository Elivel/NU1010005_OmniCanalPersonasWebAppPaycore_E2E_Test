#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar pago de servicios con NPE desde cuenta de ahorro y tarjeta de crédito

    #------------Pruebas unicamente para pago NPE CREDISIMAN--------

  @PagoServiciosConNPE_CA @QA
  Escenario: El cliente podrá realizar pago de servicios con NPE desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen                | tituloCuenta                |
      | 3115267968 Cuenta de ahorro | Resumen de cuenta ahorro CA |
    Y realiza el proceso de pago de servicio con NPE desde CA
      | cuentaOrigen                | cuentaTicket  | npe                          | monto  | concepto       |
      | 3115267968 Cuenta de ahorro | 3001329786 CA | 2307000000023900061186308236 | $28.00 | Pago Siman NPE |
    Entonces Valida los saldos posterior a realizar la transacción
      | tituloCuenta             | cuentaOrigen                | monto  |
      | Resumen de cuenta ahorro | 3115267968 Cuenta de ahorro | $$4.09 |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

  @PagoServiciosConNPE_CC @QA
  Escenario: El cliente podrá realizar pago de servicios con NPE desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Y valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen                |
      | 1210039767 Cuenta corriente |
    Y realiza el proceso de pago de servicio con NPE desde CC
      | cuentaOrigen                | cuentaTicket  | npe                              | monto | concepto       |
      | 1210039767 Cuenta corriente | 1210039767 CC | 13930002549000525050702583863967 | 1     | Pago Siman NPE |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen                | monto |
      | 1210039767 Cuenta corriente | 1     |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

  @PagoServiciosConNPE_TC @QA
  Escenario: El cliente podrá realizar pago de servicios con NPE desde TDC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Cuando valida los saldos antes de realizar la transaccion con tarjeta de credito
      | tarjetaCredito                |
      | **** 4810 VISA CLASICA PILOTO |
    Y realiza el proceso de pago de servicio con NPE desde tarjeta de crédito
      | tarjetaCredito                | npe                              | monto | concepto       |
      | **** 4810 VISA CLASICA PILOTO | 13930002549000525050702583863967 | 1     | Pago Siman NPE |
    Entonces valida los saldos posterior a realizar la transacción con tarjeta de credito
      | tarjetaCredito                | monto |
      | **** 4810 VISA CLASICA PILOTO | 1     |