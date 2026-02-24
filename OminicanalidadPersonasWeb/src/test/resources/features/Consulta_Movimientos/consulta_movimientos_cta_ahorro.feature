#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de Cuentas de Ahorro

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9

  @ValidaMovimientosSemanaActual @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro para semana actual
    Y realiza el proceso de pago de préstamo propio desde la cuenta de ahorro
      | cuentaOrigen                | cuentaCorta                 | numeroPrestamo | monto | concepto        |
      | 3007040110 Cuenta de ahorro | 3007040110 CA               | 2128370116     | 0.01  | Movimientos CA1 |
    Entonces valida los movimientos de la cuenta de ahorro para semana actual
      | cuentaOrigen                | periodo       | tituloCuenta                |
      | 3007040110 Cuenta de ahorro | Semana actual | Resumen de cuenta ahorro CA |

  @ValidaMovimientosMesActual @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro para mes actual
    Y realiza el proceso de pago de préstamo propio desde la cuenta de ahorro
      | cuentaOrigen                | cuentaCorta                 | numeroPrestamo | monto | concepto        |
      | 3007040110 Cuenta de ahorro | 3007040110 CA               | 2128370116     | 0.01  | Movimientos CA2 |
    Entonces valida los movimientos de la cuenta de ahorro para mes actual
      | cuentaOrigen                | periodo    | tituloCuenta                |
      | 3007040110 Cuenta de ahorro | Mes actual | Resumen de cuenta ahorro CA |

  @ValidaMovimientosUltimosSeisMeses @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro para últimos seis meses
    Y realiza el proceso de pago de préstamo propio desde la cuenta de ahorro
      | cuentaOrigen                | cuentaCorta   | numeroPrestamo | monto | concepto        |
      | 3007040110 Cuenta de ahorro | 3007040110 CA | 2128370116     | 0.01  | Movimientos CA3 |
    Entonces valida los movimientos de la cuenta de ahorro para Últimos seis meses
      | cuentaOrigen                | periodo            | tituloCuenta                |
      | 3007040110 Cuenta de ahorro | Últimos seis meses | Resumen de cuenta ahorro CA |

  @ValidaMovimientosFechaEspecifica @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro para una fecha especifica
    Entonces valida los movimientos de la cuenta de ahorro para una fecha especifica
      | cuentaOrigen                | fechaDesde         | fechaHasta         | tituloCuenta                |
      | 3007040110 Cuenta de ahorro | 02 Diciembre, 2024 | 02 Diciembre, 2024 | Resumen de cuenta ahorro CA |
