#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar movimientos de ADS

  @ValidaMovimientosADS @DEV
  Escenario: El cliente podrá consultar movimientos de ADS para semana actual
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD adsdev888
    Y realiza el traslado de saldo de la cuenta origen ADS a la cuenta destino
      | cuentaOrigen                | cuentaCorta   | cuentaDestino | monto | concepto                |
      | 5160019435 Cuenta corriente | 5160019435 CC | 3020314800 CA | 1     | transferencia desde ADS |
    Entonces valida los movimientos de ADS para semana actual
      | cuentaOrigen                | periodo       |
      | 5160019435 Cuenta corriente | Semana actual |