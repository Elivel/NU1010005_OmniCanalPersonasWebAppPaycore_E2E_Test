#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá validar los movimientos de meta

  @ValidaciónMovimientosDeMeta @QA
  Escenario: El cliente validará que se muestren los movimientos de la meta
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    #Cuando completa el proceso para crear meta
     # | nombreMeta | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      #| Prueba CM4 | 100 | 12 | 2 | 3111466124 |
    Y realiza el proceso de aporte a la meta y valida los cambios
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM4 | 5.00             | 100       |
    Y realiza el proceso de retiro a la meta y valida los cambios
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM4 | 5.00             | 100       |
    Y valida que para la meta se muestren los movimientos
      | nombreMeta | aporteRetiroMeta | montoMeta |
      | Prueba CM4 | 5.00             | 100       |
    #Entonces realiza el proceso de eliminacion de la meta
     # | nombreMeta | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      #| Prueba CM4 | 100              | 12        | 2 | 3111466124 |