#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá Reservar y liberar fondos p@goes desde CA y CC

  @PReservarLiberarFondosCuentas @QA
  Escenario: El cliente podra reservar y liberar fondos para CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen                | tituloCuenta                |
      | 3110481891 Cuenta de ahorro | Resumen de cuenta ahorro CA |
    Y realiza la reserva de fondos desde CA
      | cuentaOrigen                | cuentaCorta   | monto | vigencia | concepto              | tituloCuenta                |
      | 3110481891 Cuenta de ahorro | 3110481891 CA | 1     | 1        | Reserva de fondos cta | Resumen de cuenta ahorro CA |
    Y Valida los saldos posterior a realizar la transacción
      | cuentaOrigen                | monto | tituloCuenta                |
      | 3110481891 Cuenta de ahorro | 1     | Resumen de cuenta ahorro CA |
    Entonces valida que se muestren registros en fondos reservados
      | cuentaOrigen                |
      | 3110481891 Cuenta de ahorro |
    Y realiza la liberacion de fondos desde CA
      | cuentaOrigen                | cuentaCorta   | monto | vigencia | concepto              |
      | 3110481891 Cuenta de ahorro | 3110481891 CA | 1     | 1        | Reserva de fondos cta |
    Y valida los saldos posterior a realizar la transacción visualizando un incremento
      | cuentaOrigen                | monto |
      | 3110481891 Cuenta de ahorro | 1     |
    Entonces valida que se no se muestre el registro en fondos reservados de la liberacion
      | cuentaOrigen                |
      | 3110481891 Cuenta de ahorro |

  @PReservarLiberarFondosCuentas @QA
  Escenario: El cliente podra reservar y liberar fondos para CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Y valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen                | tituloCuenta                |
      | 1210025438 Cuenta corriente | Resumen de cuenta corriente |
    Y realiza la reserva de fondos desde CC
      | cuentaOrigen                | cuentaCorta   | monto | vigencia | concepto              |
      | 1210025438 Cuenta corriente | 1210025438 CC | 1     | 1        | Reserva de fondos cta |
    Y valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen                | monto | tituloCuenta                |
      | 1210025438 Cuenta corriente | 1     | Resumen de cuenta corriente |
    Entonces valida que se muestren registros en fondos reservados
      | cuentaOrigen                |
      | 1210025438 Cuenta corriente |
    Y realiza la liberacion de fondos desde CC
      | cuentaOrigen                | cuentaCorta   | monto | vigencia | concepto              |
      | 1210025438 Cuenta corriente | 1210025438 CC | 1     | 1        | Reserva de fondos cta |
    Y valida los saldos posterior a realizar la transacción visualizando un incremento CC
      | cuentaOrigen                | monto |
      | 1210025438 Cuenta corriente | 1     |
    Entonces valida que se no se muestre el registro en fondos reservados de la liberacion
      | cuentaOrigen                |
      | 1210025438 Cuenta corriente |