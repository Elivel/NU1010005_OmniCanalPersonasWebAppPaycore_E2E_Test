#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar proceso de recuperacion de clave

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas

  @RecuperarClave @QA
  Escenario: El cliente podrá recuperar su clave desde la pagina de Ebanca Personas ingresando su usuario
    Cuando ingresa a recuperar clave para el usuario e ingresa los datos de la nueva clave
      | password      |
      | Agricola4151# |
      | Agricola4153# |
      | Agricola4157# |
      | Agricola4158# |
      | Agricola4136# |
      | Agricola4137# |
      | Agricola4138# |
      | Agricola4139# |
      | Agricola4250# |
      | Agricola4251# |
      | Agricola4252# |
      | Agricola4253# |
      | Agricola2$    |
    Entonces inicia sesion como cliente automatizada04