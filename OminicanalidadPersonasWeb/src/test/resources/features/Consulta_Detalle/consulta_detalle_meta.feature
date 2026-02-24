#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de meta

  @ValidaciónDetalleMeta @QA
  Escenario: El cliente validará que se muestre el detalle de meta
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
   # Cuando completa el proceso para crear meta
      #| nombreMeta                 | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      #| 3009267649 Sueño Realizado | 100.00    | 12        | 2            | 3111466124        |
    Entonces valida el detalle para la meta
      | nombreMeta                 | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      | MetaPORTAL                 | 400.00    | 25        | 8            | 1210039767        |
    #Entonces realiza el proceso de eliminacion de la meta
     # | nombreMeta                 | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
     # | 3009267649 Sueño Realizado | 100.00    | 12        | 2            | 3111466124        |