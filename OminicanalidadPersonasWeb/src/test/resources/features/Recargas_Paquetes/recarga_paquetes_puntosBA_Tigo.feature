#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar recarga y compra de paquetes desde puntosBA para Tigo

  @RecargaCompraPaquetesPuntosBA @DEV
  Esquema del escenario: El cliente podrá realizar recargas y compra de paquetes a través de Puntos BA para Tigo
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto02
    Y valida los puntos BA antes de realizar la transacción
    Y realiza una recarga para la compañia desde Puntos BA
      | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza una recarga para la compañia desde Puntos BA con favorito
      | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces valida los puntos BA posterior a realizar la transacción
      | monto   |
      | <monto> |

    Ejemplos:
      | celular  | compania                      | montopaquete                                         | concepto        | nombreFavorito | opcion             | monto |
      | 72566095 | TIGO, PREPAGO (RECARGA)       | 1D 2GB+Redes Sociales $1 100 Puntos BA               | recarga/paquete | FavoritoPaqC5  | Recarga de Celular | 200   |
      | 72566095 | TIGO, PREPAGO (RECARGA)       | 100 Puntos BA                                        | recarga/paquete | FavoritoPaqC6  | Recarga de Celular | 200   |