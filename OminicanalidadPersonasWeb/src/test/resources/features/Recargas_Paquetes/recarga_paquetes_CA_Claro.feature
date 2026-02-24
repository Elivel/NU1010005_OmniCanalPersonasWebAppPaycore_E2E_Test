#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar recarga y compra de paquetes desde CA para Claro

  @RecargaCompraPaquetesCtaAhorro @DEV
  Esquema del escenario: El cliente podrá realizar recargas y compra de paquetes a través de CA para Claro
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen   | tituloCuenta   |
      | <cuentaOrigen> | <tituloCuenta> |
    Y realiza una recarga para la compañia desde cuenta de ahorro
      | cuentaOrigen   | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza una recarga para la compañia desde cuenta de ahorro con favorito
      | cuentaOrigen   | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen   | monto   | tituloCuenta   |
      | <cuentaOrigen> | <monto> | <tituloCuenta> |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

    Ejemplos:
      | cuentaOrigen | celular  | compania                 | montopaquete                                 | concepto        | nombreFavorito | opcion             | monto | tituloCuenta                |
      | 31320008506  | 70116088 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | recarga/paquete | FavoritoPaqC3  | Recarga de Celular | 60    | Resumen de cuenta ahorro CA |
      #| 3740079056   | 70116088 | CLARO, PREPAGO (RECARGA) | $ 1.00                                       | recarga/paquete | FavoritoPaqC3  | Recarga de Celular | 2     | Resumen de cuenta ahorro |


  @RecargaCompraPaqueteCC @DEV
  Escenario: El Cliente podra realizar Recargas y Compra de Paquetes a través de CC para Claro
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta                |
      | 1210039767   | Resumen de cuenta corriente |
    Y realiza una recarga para la compañia desde Cuenta Corriente
      | cuentaOrigen | celular  | compania                 | montopaquete                                 | concepto        | nombreFavorito | opcion             |
      | 1210039767   | 70116088 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | Recarga/Paquete | FavoritoPaqC3  | Recarga de Celular |
    Y realiza una recarga para la compañía desde la Cuenta Corriente con favorito
      | cuentaOrigen | celular  | compania                 | montopaquete                                 | concepto        | nombreFavorito | opcion             |
      | 1210039767   | 70116088 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS $ 30.00 | Recarga/Paquete | FavoritoPaqC3  | Recarga de Celular |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | tituloCuenta                | monto |
      | 1210039767   | Resumen de cuenta corriente | 60    |