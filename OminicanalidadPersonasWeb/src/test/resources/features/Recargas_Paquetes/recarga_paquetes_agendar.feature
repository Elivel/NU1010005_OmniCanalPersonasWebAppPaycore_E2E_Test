#language:es
#Author:aeaguila@bancoagricola.com.sv
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá agendar recargas y compra de paquetes desde CA

  @RecargaCompraPaquetesCtaAhorroAgendar @QA
  Esquema del escenario: El cliente podra agendar recargas/compra de paquetes para la compañia indicada
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y realiza agenda de recargas para la compañia indicada desde cuenta de ahorro
      | cuentaOrigen   | celular   | compania   | montopaquete   | concepto   | opcion   |
      | <cuentaOrigen> | <celular> | <compania> | <montopaquete> | <concepto> | <opcion> |

    Ejemplos:
      | cuentaOrigen                | celular  | compania                | montopaquete                                               | concepto | opcion             |
      | 3111466124 Cuenta de ahorro | 72491237 | TIGO, PREPAGO (RECARGA) | 2D 1GB+RedesSoc+10minOtraRed/USA/CAN+IlimTigo $1.10 $ 1.10 | paquete  | Recarga de Celular |
      | 3111466124 Cuenta de ahorro | 72491237 | TIGO, PREPAGO (RECARGA) | $ 1.10                                                     | recarga  | Recarga de Celular |