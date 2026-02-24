#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá actualizar clave

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas

  @ActualizarClaveLogueado @QA
  Escenario: El cliente podrá actualizar su clave desde adentro de la aplicacion (usuario logueado)
    Y inicia sesion como cliente automatizada04
    Cuando realiza el cambio de password
      | password    |
      | Agricola10# |
      | Agricola11# |
      | Agricola12# |
      | Agricola13# |
      | Agricola14# |
      | Agricola15# |
      | Agricola16# |
      | Agricola17# |
      | Agricola18# |
      | Agricola19# |
      | Agricola20# |
      | Agricola21# |
      | Agricola2$ |
    Entonces cierra sesion e inicia sesion como cliente automatizada04
