#language:es
#Author:lmenjiva@bancoagricola.com.sv

Característica: El cliente podrá agendar recargas y compra de paquetes desde una TDC

  @RecargaCompraPaquetesTDCAgendar @QA
  Esquema del escenario: El cliente podra agendar recargas/compra de paquetes para la compañia indicada
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente ahorro2020
    Y realiza agenda de recargas para la compañia indicada desde una TDC
      | tarjetaCredito   | celular   | compania   | montopaquete   | concepto   | opcion   |
      | <tarjetaCredito> | <celular> | <compania> | <montopaquete> | <concepto> | <opcion> |

    Ejemplos:
      | tarjetaCredito          | celular  | compania                | montopaquete                                               | concepto | opcion             |
      | **** 6607 VISA Platinum | 75893727 | TIGO, PREPAGO (RECARGA) | 2D 1GB+RedesSoc+10minOtraRed/USA/CAN+IlimTigo $1.10 $ 1.10 | paquete  | Recarga de Celular |
      | **** 6607 VISA Platinum | 75893727 | TIGO, PREPAGO (RECARGA) | $ 1.10                                                     | recarga  | Recarga de Celular |