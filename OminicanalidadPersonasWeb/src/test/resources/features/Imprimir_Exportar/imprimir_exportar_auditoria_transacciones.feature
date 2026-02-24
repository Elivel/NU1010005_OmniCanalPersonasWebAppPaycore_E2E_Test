#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá imprimir y exportar registros generados en auditoria de transacciones

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9

  @ExportarAuditoria @excel @QA
  Escenario: El cliente podra exportar registros generados en auditoria de transacciones para e-banca
    Cuando realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino  | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.75  | transferencia cuentas propias AP |
    Y filtra la generacion de la transaccion en Auditoria de transacciones
    Entonces el cliente ve el archivo Auditoria.xlsx en la carpeta

  @ImprimirAuditoriaTransacciones @QA
  Escenario: El cliente podra imprimir registros generados en auditoria de transacciones para e-banca
    Cuando realiza el proceso de transferencia de saldo de la cuenta origen a la cuenta destino inicial
      | cuentaOrigen               | cuentaDestino | monto | concepto                         |
      | Sueño Realizado Programado | 3007040110 CA | 0.85  | transferencia cuentas propias AP |
    Y filtra para generar las transacciones en Auditoria transacciones e imprime
    Entonces el cliente ve sus movimientos en una nueva pestana a la derecha
