#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá solicitar y realizar transferencias internacionales desde CA y CC

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @TransferenciaInternacionalSinPlantilla @QA
  Escenario: El cliente podra realizar transferencias internacionales sin plantilla desde CA
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta                |
      | 3001329786   | Resumen de cuenta ahorro CA |
    Y diligencia los campos para realizar la transferencia internacional
      | cuentaOrigen | nroCuenta | nombreBeneficiario | direccionBeneficiario | pais           | tipoRed | codigoBan1 | codigoBan2 | moneda  | monto | nivel1                              | nivel2                              | detalle          |
      | 3001329786   | 115244556 | Alcides Aguila     | Arlington, Virgina    | Estados Unidos | ABA     | 1          | 221982389  | Dólares | 1     | Exportación e Importación de bienes | Exportación e Importación de bienes | automatizacionTI |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto |
      | 3001329786   | 29.25 |

  @TransferenciaInternacionalConPlantilla @QA
  Escenario: El cliente podra realizar transferencias internacionales con plantilla desde CA
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen |
      | 3001329786   |
    Y diligencia los campos para realizar la transferencia internacional y guarda la plantilla
      | cuentaOrigen | nroCuenta | nombreBeneficiario | direccionBeneficiario | pais           | tipoRed | codigoBan1 | codigoBan2 | moneda  | monto | nivel1                  | nivel2     | detalle          |
      | 3001329786   | 115244556 | Alcides Aguila     | Arlington, Virgina    | Estados Unidos | ABA     | 1          | 221982389  | Dólares | 1     | IMPORTACIONES DE BIENES | Al Contado | automatizacionTI |
    Y realiza una transferencia internacional usando una plantilla
      | cuentaOrigen | nroCuenta | nombreBeneficiario | direccionBeneficiario | pais           | tipoRed | codigoBan1 | codigoBan2 | moneda  | monto | nivel1                  | nivel2     | detalle          |
      | 3001329786   | 115244556 | Alcides Aguila     | Arlington, Virgina    | Estados Unidos | ABA     | 1          | 221982389  | Dólares | 1     | IMPORTACIONES DE BIENES | Al Contado | automatizacionTI |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto |
      | 3001329786   | 29.25 |

  @TransferenciaInternacionalSinPlantilla @QA
  Escenario: El cliente podra realizar transferencias internacionales sin plantilla desde CC
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen |
      | 1210039767   |
    Y diligencia los campos para realizar la transferencia internacional desde CC
      | cuentaOrigen | nroCuenta | nombreBeneficiario | direccionBeneficiario | pais           | tipoRed | codigoBan1 | codigoBan2 | moneda  | monto | nivel1                  | nivel2     | detalle          |
      | 1210039767   | 115244556 | Alcides Aguila     | Arlington, Virgina    | Estados Unidos | ABA     | 1          | 221982389  | Dólares | 1     | IMPORTACIONES DE BIENES | Al Contado | automatizacionTI |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen | monto |
      | 1210039767   | 29.25 |

  @TransferenciaInternacionalConPlantilla @QA
  Escenario: El cliente podra realizar transferencias internacionales con plantilla desde CC
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen |
      | 1210039767   |
    Y diligencia los campos para realizar la transferencia internacional y guarda la plantilla para CC
      | cuentaOrigen | nroCuenta | nombreBeneficiario | direccionBeneficiario | pais           | tipoRed | codigoBan1 | codigoBan2 | moneda  | monto | nivel1                  | nivel2     | detalle          |
      | 1210039767   | 115244556 | Alcides Aguila     | Arlington, Virgina    | Estados Unidos | ABA     | 1          | 221982389  | Dólares | 1     | IMPORTACIONES DE BIENES | Al Contado | automatizacionTI |
    Y realiza una transferencia internacional usando una plantilla desde CC
      | cuentaOrigen | nroCuenta | nombreBeneficiario | direccionBeneficiario | pais           | tipoRed | codigoBan1 | codigoBan2 | moneda  | monto | nivel1                  | nivel2     | detalle          |
      | 1210039767   | 115244556 | Alcides Aguila     | Arlington, Virgina    | Estados Unidos | ABA     | 1          | 221982389  | Dólares | 1     | IMPORTACIONES DE BIENES | Al Contado | automatizacionTI |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen | monto |
      | 1210039767   | 29.25 |