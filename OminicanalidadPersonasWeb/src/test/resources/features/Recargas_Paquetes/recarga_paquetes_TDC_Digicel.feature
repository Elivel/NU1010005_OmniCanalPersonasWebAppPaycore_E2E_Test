#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar recarga y compra de paquetes desde TDC para Digicel

  @RecargaCompraPaquetesTarjetas @DEV
  Esquema del escenario: El cliente podrá realizar recargas y compra de paquetes a través de TDC para Digicel
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD javierrosales
    Cuando valida los saldos antes de realizar la transaccion desde Tarjetas
      | tarjetaCredito   |
      | <tarjetaCredito> |
    Y realiza una recarga para la compañia desde tarjetas desde cero
      | tarjetaCredito   | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <tarjetaCredito> | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza una recarga para la compañia desde tarjetas con favorito
      | tarjetaCredito   | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <tarjetaCredito> | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces debe visualizar una disminucion en el saldo cuenta de la TC
      | monto   |
      | <monto> |

    Ejemplos:
      | tarjetaCredito                | celular  | compania                   | montopaquete                              | concepto        | nombreFavorito | opcion             | monto |
      | **** 4810 VISA CLASICA PILOTO | 73226255 | DIGICEL, PREPAGO (RECARGA) | Paquete Chivo 2 dias x $1 2022 DTS $ 1.00 | recarga/paquete | FavoritoPaqC2  | Recarga de Celular | 2     |
      | **** 4810 VISA CLASICA PILOTO | 73226255 | DIGICEL, PREPAGO (RECARGA) | $ 1.00                                    | recarga/paquete | FavoritoPaqC2  | Recarga de Celular | 2     |