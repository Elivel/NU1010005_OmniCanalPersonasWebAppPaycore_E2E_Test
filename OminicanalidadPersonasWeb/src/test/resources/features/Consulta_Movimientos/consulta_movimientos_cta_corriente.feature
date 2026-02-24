#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de Cuentas Corriente

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02

  @ValidaMovimientosSemanaActual @QA
  Escenario: El cliente podrá consultar movimientos de cuenta corriente para semana actual
    Y realiza el proceso de pago de préstamo propio desde la cuenta corriente
      | cuentaOrigen                | numeroPrestamo | monto | concepto        |
      | 1210025438 Cuenta corriente | 2130433813     | 0.01  | Movimientos CC1 |
    Entonces valida los movimientos de la cuenta corriente para semana actual
      | cuentaOrigen                | periodo       |
      | 1210025438 Cuenta corriente | Semana actual |

  @ValidaMovimientosMesActual @QA
  Escenario: El cliente podrá consultar movimientos de cuenta corriente para mes actual
    Y realiza el proceso de pago de préstamo propio desde la cuenta corriente
      | cuentaOrigen                | numeroPrestamo | monto | concepto        |
      | 1210025438 Cuenta corriente | 2130433813     | 0.01  | Movimientos CC2 |
    Entonces valida los movimientos de la cuenta corriente para mes actual
      | cuentaOrigen                | periodo    |
      | 1210025438 Cuenta corriente | Mes actual |

  @ValidaMovimientosUltimosSeisMeses @QA
  Escenario: El cliente podrá consultar movimientos de cuenta corriente para últimos seis meses
    Y realiza el proceso de pago de préstamo propio desde la cuenta corriente
      | cuentaOrigen                | numeroPrestamo | monto | concepto        |
      | 1210025438 Cuenta corriente | 2130433813     | 0.01  | Movimientos CC3 |
    Entonces valida los movimientos de la cuenta corriente para Últimos seis meses
      | cuentaOrigen                | periodo            |
      | 1210025438 Cuenta corriente | Últimos seis meses |

  @ValidaMovimientosFechaEspecifica @QA
  Escenario: El cliente podrá consultar movimientos de cuenta corriente para una fecha especifica
    Entonces valida los movimientos de la cuenta corriente para una fecha especifica
      | cuentaOrigen                | fechaDesde          | fechaHasta          |
      | 1210025438 Cuenta corriente | 21 Septiembre, 2023 | 29 Septiembre, 2023 |