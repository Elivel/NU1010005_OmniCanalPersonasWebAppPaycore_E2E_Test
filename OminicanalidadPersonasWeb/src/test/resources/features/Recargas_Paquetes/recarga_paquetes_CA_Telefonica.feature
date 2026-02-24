#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar recarga y compra de paquetes desde CA para Telefonica

  @RecargaCompraPaquetesCtaAhorro @DEV
  Esquema del escenario: El cliente podrá realizar recargas y compra de paquetes a través de CA para Telefonica
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen   | tituloCuenta             |
      | <cuentaOrigen> | Resumen de cuenta ahorro |
    Y realiza una recarga para la compañia desde cuenta de ahorro
      | cuentaOrigen   | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza una recarga para la compañia desde cuenta de ahorro con favorito
      | cuentaOrigen   | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen   | monto   | tituloCuenta             |
      | <cuentaOrigen> | <monto> | Resumen de cuenta ahorro |
    Y valida que se muestre el movimiento con la referencia indicada en el ticket

    Ejemplos:
      | cuentaOrigen | celular  | compania                      | montopaquete | concepto        | nombreFavorito | opcion             | monto |
      | 3740079056   | 77496825 | TELEFONICA, PREPAGO (RECARGA) | $ 1.00       | recarga/paquete | FavoritoPaqC7  | Recarga de Celular | 2     |