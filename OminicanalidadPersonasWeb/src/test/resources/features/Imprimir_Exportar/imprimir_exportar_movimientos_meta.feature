#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá visualizar los movimientos de meta de dos formas,a través de una vista en el navegador (Imprimir), generando un archivo de excel (Exportar)

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9

  @ExportarMovimientosMeta @excel @QA
  Escenario: El cliente podra exportar movimientos de Meta
    #Cuando completa el proceso para crear meta
     # | nombreMeta    | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
      #| ExportarMeta1 | 2         | 2         | 2            | 3110481891      |
    Y realiza un aporte para generar movimientos
      | nombreMeta                 | aporteRetiroMeta | montoMeta |
      | Sueño Realizado Programado | 1                | 2         |
    Entonces ingresa a los movimientos de Sueño Realizado Programado para exportar el archivo
    #Y realiza la accion de exportar
    #Entonces el cliente ve el archivo de Movimientos.xlsx en la carpeta

  @ImprimirMovimientosMeta @QA
  Escenario: El cliente podra imprimir movimientos de Meta
   # Cuando completa el proceso para crear meta
    #  | nombreMeta    | montoMeta | plazoMeta | diaRetencion | cuentaARelacionar |
     # | ImprimirMeta2 | 2         | 2         | 2            | 3110481891       |
    Y realiza un aporte para generar movimientos
      | nombreMeta                 | aporteRetiroMeta | montoMeta |
      | Sueño Realizado Programado | 1                | 2         |
    Entonces ingresa a los movimientos de ImprimirMeta2 para imprimir el documento