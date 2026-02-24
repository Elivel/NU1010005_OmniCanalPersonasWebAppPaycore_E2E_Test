#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá agregar, modificar, eliminar, realizar aporte y retiro a una meta (Relacionando CA y CC)

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente code15

  @ProcesoDeCreacionModificacionEliminacionMetaCA @QA
  Escenario: El cliente podrá añadir, modificar, eliminar una meta relacionando CA
    #Cuando completa el proceso para crear meta
     # | nombreMeta | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
     # | Prueba CM7 | 120       | 12        | 2            | 1490181539        |
    Y realiza el proceso de modificación de la meta y valida los cambios
      | nombreMeta | montoMeta | plazoMeta | diaRetencion |
      | test       | 120       | 8         | 6            |
    #Entonces realiza el proceso de eliminacion de la meta
      #| nombreMeta | montoMeta | plazoMeta | diaRetencion |
      #| Prueba CM7 | 120       | 8         | 6            |

  @ProcesoDeAporteRetiroMetaCA @QA
  Escenario: El cliente podrá realizar aporte y retiro a una meta relacionando CA
    #Cuando completa el proceso para crear meta
     # | nombreMeta | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
     # | Prueba CM8 | 100       | 12        | 2            | 1490181539        |
    Y realiza el proceso de aporte a la meta y valida los cambios
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM8 | 5                | 100       |
    Y realiza el proceso de retiro a la meta y valida los cambios
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM8 | 5                | 100       |
   # Entonces realiza el proceso de eliminacion de la meta
    #  | nombreMeta | montoMeta | plazoMeta | diaRetencion |
    #  | Prueba CM8 | 100              | 12        | 2 |

  @ProcesoDeCreacionModificacionEliminacionMetaCC @QA
  Escenario: El cliente podrá añadir, modificar, eliminar una meta relacionando CC
   # Cuando completa el proceso para crear meta
   #   | nombreMeta | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
  #    | Prueba CM7 | 100       | 12        | 2            | 5220371769        |
    Y realiza el proceso de modificación de la meta y valida los cambios
      | nombreMeta | montoMeta | plazoMeta | diaRetencion |
      | Prueba CM7 | 120       | 8         | 6            |
   # Entonces realiza el proceso de eliminacion de la meta
   #   | nombreMeta | montoMeta | plazoMeta | diaRetencion |
    #  | Prueba CM7 | 120       | 8         | 6            |

  @ProcesoDeAporteRetiroMetaCC @QA
  Escenario: El cliente podrá realizar aporte y retiro a una meta relacionando CC
  #  Cuando completa el proceso para crear meta
    #  | nombreMeta | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
    #  | Prueba CM8 | 100       | 12        | 2            | 5220371769        |
    Y realiza el proceso de aporte a la meta y valida los cambios
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM8 | 5                | 100       |
    Y realiza el proceso de retiro a la meta y valida los cambios
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM8 | 5                | 100       |
   # Entonces realiza el proceso de eliminacion de la meta
    #  | nombreMeta | montoMeta | plazoMeta | diaRetencion |
    #  | Prueba CM8 | 100              | 12        | 2 |