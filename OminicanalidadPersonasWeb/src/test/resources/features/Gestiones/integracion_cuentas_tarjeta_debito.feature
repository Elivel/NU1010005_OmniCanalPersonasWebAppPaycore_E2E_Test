#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá integrar cuentas a una tarjeta debito

  @IntegrarCuentasServicio @QA
  Escenario: El cliente podra integrar cuentas a una tarjeta debito, cuenta principal y asociadas desde Servicios.
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente selecciona una cuenta principal e incluye una cuenta para asociar
      | ctaPrincipal1               | ctaPrincipal2               | ctaAsociar                  |
      | 1210025438 Cuenta corriente | 3113482664 Cuenta de ahorro | 3114480675 Cuenta de ahorro |
    Entonces valida que se muestre el mensaje de cuentas integradas
    Y verifica que se pueda desasociar una cuenta 3114480675 Cuenta de ahorro


  @IntegrarCuentasTarjeta @QA
  Escenario: El cliente podra integrar cuentas a una tarjeta debito, cuenta principal y asociadas desde Tarjetas.
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Cuando el cliente se dirige a Tarjetas y selecciona una TDD para integrar cuentas
      | tarjetaDebito                     |
      | **** 6603 Preferencial |
    Y valida que se encuentre dentro de operaciones la opción 'Integración de cuentas a tarjeta de débito'
      | ctaPrincipal1               | ctaPrincipal2               | ctaAsociar                  |
      | 1210025438 Cuenta corriente | 3113482664 Cuenta de ahorro | 3114480675 Cuenta de ahorro |
    Entonces valida que se muestre el mensaje de cuentas integradas
    Y verifica que se pueda desasociar de la TDD una cuenta
      | tarjetaDebito                     | cuentaOrigen |
      | **** 6603 Preferencial | 3114480675   |