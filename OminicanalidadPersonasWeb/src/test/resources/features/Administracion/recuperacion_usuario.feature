#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá recuperar usuario

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas

  @RecuperarUsuario @QA
  Esquema del escenario: El cliente podrá recuperar su usuario desde la pagina de Ebanca Personas de acuerdo a su número de identificación
    Cuando ingresa a recuperar usuario e ingresa los datos de identificacion
      | numeroIdentificacion   | tipoDocumento   |
      | <numeroIdentificacion> | <tipoDocumento> |
    Entonces se visualiza el resultado de "¡Tu usuario ha sido recuperado con éxito!"

    Ejemplos:
      | numeroIdentificacion | tipoDocumento       |
      | 055977799            | DUI                 |
      | 1011324              | Carnet de residente |
      | 499549443            | Pasaporte           |
