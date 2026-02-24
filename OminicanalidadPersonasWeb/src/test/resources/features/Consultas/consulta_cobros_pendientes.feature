#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar la sección de Cobros Pendientes

  @ConsultaCobrosPendientes @QA
  Escenario: El cliente podrá consultar la sección de cobros pendientes
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Cuando ingresa a la sección resumen de movimientos para la cuenta 5110002623
    Entonces valida que se muestren registros en Cobros Pendientes
      | cuentaOrigen                |
      | 5110002623 Cuenta corriente |