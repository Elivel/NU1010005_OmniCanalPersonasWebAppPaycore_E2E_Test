#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar fondos reservados de una transacción

  @ConsultarFondosReservados @QA
  Escenario: El cliente podrá consultar fondos reservados de una transacción
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y realiza la reserva de fondos para cuentas
      | cuentaOrigen | cuentaCorta                 | monto | vigencia | concepto              |
      | 3115267968   | 3115267968 Cuenta de Ahorro | 1     | 1        | Reserva de fondos cta |
    Entonces valida que se muestre el registros en fondos reservados
      | cuentaOrigen | tituloCuenta                |
      | 3115267968   | Resumen de cuenta ahorro CA |