#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá realizar recarga y compra de paquetes desde puntosBA para Digicel

  @RecargaCompraPaquetesPuntosBA @DEV
  Esquema del escenario: El cliente podrá realizar recargas y compra de paquetes a través de Puntos BA para Digicel
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
      | 73226851 | DIGICEL, PREPAGO (RECARGA)    | Paquete Chivo 2 dias x $1 2022 DTS 100 Puntos BA     | recarga/paquete | FavoritoPaqC1  | Recarga de Celular | 200   |
      | 73226255 | DIGICEL, PREPAGO (RECARGA)    | 100 Puntos BA                                        | recarga/paquete | FavoritoPaqC2  | Recarga de Celular | 200   |