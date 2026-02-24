#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá validar registros generados en auditoria de transacciones para e-banca

  @RegistroAudutoriaHoy @QA
  Escenario: El cliente podrá validar registros generados para hoy en auditoria de transacciones para e-banca
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.39  | transferencia cuentas propias AP |
    Y valida la generacion de la transaccion en Auditoria de transacciones para hoy
      | monto |
      | 0.39  |