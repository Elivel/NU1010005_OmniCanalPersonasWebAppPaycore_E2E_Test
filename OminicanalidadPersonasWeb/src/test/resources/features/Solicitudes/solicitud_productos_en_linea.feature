#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar una solicitud de productos en linea

  @SolicitudProductosEnLinea @DEV
  Escenario: El cliente podrá realizar una solicitud de productos en linea
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando realiza el proceso de solicitud de productos en linea para CrediCash
      | pais        | telefono |
      | El Salvador | 73837380 |
    Entonces valida que se genere el numero de solicitud