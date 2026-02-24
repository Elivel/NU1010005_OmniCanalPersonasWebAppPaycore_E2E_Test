#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar los movimientos de su ahorro programado

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9

  @ExportarMovimientosAhorroProgramado @excel @QA
  Escenario: El cliente podra exportar movimientos de Ahorro Programado
    Cuando realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.5   | transferencia cuentas propias AP |
    Entonces valida los movimientos de la cuenta de ahorro programado para semana actual
      | cuentaOrigen               | periodo       |
      | Sueño Realizado Programado | Semana actual |
    Y realiza la accion de exportar
    Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta

  @ImprimirMovimientosAhorroProgramado @QA
  Escenario: El cliente podra imprimir movimientos de Ahorro Programado
    Cuando realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.5   | transferencia cuentas propias AP |
    Entonces valida los movimientos de la cuenta de ahorro programado para semana actual
      | cuentaOrigen               | periodo       |
      | Sueño Realizado Programado | Semana actual |
    Y realiza la accion de imprimir
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha
