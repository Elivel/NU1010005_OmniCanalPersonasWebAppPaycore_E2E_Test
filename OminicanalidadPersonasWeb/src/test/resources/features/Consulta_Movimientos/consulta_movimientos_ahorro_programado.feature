#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de la cuenta de ahorro programado

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9

  @ValidaMovimientosSemanaActual @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro programado para semana actual
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.01  | transferencia cuentas propias AP |
    Entonces valida los movimientos de la cuenta de ahorro programado para semana actual
      | cuentaOrigen               | periodo       |
      | Sueño Realizado Programado | Semana actual |

  @ValidaMovimientosMesActual @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro programado para mes actual
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.01  | transferencia cuentas propias AP |
    Entonces valida los movimientos de la cuenta de ahorro programado para mes actual
      | cuentaOrigen               | periodo    |
      | Sueño Realizado Programado | Mes actual |

  @ValidaMovimientosUltimosSeisMeses @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro programado para últimos seis meses
    Y realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.01  | transferencia cuentas propias AP |
    Entonces valida los movimientos de la cuenta de ahorro programado para Últimos seis meses
      | cuentaOrigen               | periodo            |
      | Sueño Realizado Programado | Últimos seis meses |

  @ValidaMovimientosFechaEspecifica @QA
  Escenario: El cliente podrá consultar movimientos de cuenta de ahorro programado para una fecha especifica
    Entonces valida los movimientos de la cuenta de ahorro programado para una fecha especifica
      | cuentaOrigen               | fechaDesde         | fechaHasta         |
      | Sueño Realizado Programado | 02 Diciembre, 2024 | 02 Diciembre, 2024 |
