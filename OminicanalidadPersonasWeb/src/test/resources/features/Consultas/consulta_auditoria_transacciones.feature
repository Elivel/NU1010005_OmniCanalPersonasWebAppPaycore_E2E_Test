#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá validar que se muestren registros en Auditoria de transacciones para los canales e-banca Personas y Banca Móvil

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @RegistrosAuditoriaTipoTRX @QA
  Esquema del escenario: El cliente podrá validar que se muestren registros por tipo de transacción para una fecha especifica para los canales e-banca Personas y Banca Móvil
    Y valida que se muestren registros al buscar registros por Tipo de transacción
      | fechaDesde     | fechaHasta        | tipoTRX                       | canal         |
      | 1 Agosto, 2023 | 9 Noviembre, 2023 | Transferencia cuentas propias | <nombreCanal> |
    Ejemplos:
      | nombreCanal      |
      | Banca Móvil      |
      | e-banca Personas |

  @RegistrosAuditoriaRangoMonto @QA
  Esquema del escenario: El cliente podrá validar que se muestren registros por rango de monto para una fecha especifica para los canales e-banca Personas y Banca Móvil
    Y valida que se muestren registros al buscar registros por rango de monto
      | fechaDesde     | fechaHasta        | tipoTRX                       | montoDesde | montoHasta | canal         |
      | 1 Agosto, 2023 | 9 Noviembre, 2023 | Transferencia cuentas propias | 1.0        | 15.0       | <nombreCanal> |
    Ejemplos:
      | nombreCanal      |
      | Banca Móvil      |
      | e-banca Personas |

  @RegistrosAuditoriaEstado @QA
  Esquema del escenario: El cliente podrá validar que se muestren registros por estado de la transacción para una fecha especifica para los canales e-banca Personas y Banca Móvil
    Y valida que se muestren registros al buscar registros por estado
      | fechaDesde     | fechaHasta        | tipoTRX                       | estadoTRX  | canal         |
      | 1 Agosto, 2023 | 9 Noviembre, 2023 | Transferencia cuentas propias | FINALIZADO | <nombreCanal> |
    Ejemplos:
      | nombreCanal      |
      | Banca Móvil      |
      | e-banca Personas |