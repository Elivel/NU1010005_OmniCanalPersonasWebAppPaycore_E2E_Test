#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar recarga y compra de paquetes desde puntosBA para Claro

  @RecargaCompraPaquetesPuntosBA @DEV
  Esquema del escenario: El cliente podrá realizar recargas y compra de paquetes a través de Puntos BA para Claro
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Y valida los puntos BA antes de realizar la transacción
    Y realiza una recarga para la compañia desde Puntos BA
      | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza una recarga para la compañia desde Puntos BA con favorito
      | celular   | compania   | montopaquete   | concepto   | nombreFavorito   | opcion   |
      | <celular> | <compania> | <montopaquete> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces valida los puntos BA posterior a realizar la transacción
      | monto   | tituloCuenta             |
      | <monto> | Resumen de cuenta ahorro |

    Ejemplos:
      | celular  | compania                 | montopaquete                                         | concepto        | nombreFavorito | opcion             | monto |
      | 70116088 | CLARO, PREPAGO (RECARGA) | SUPERPACK TODO INCLUIDO M POR 7 DIAS 4,285 Puntos BA | recarga/paquete | FavoritoPaqC3  | Recarga de Celular | 4,285 |
      | 76294996 | CLARO, PREPAGO (RECARGA) | 142 Puntos BA                                        | recarga/paquete | FavoritoPaqC4  | Recarga de Celular | 142   |