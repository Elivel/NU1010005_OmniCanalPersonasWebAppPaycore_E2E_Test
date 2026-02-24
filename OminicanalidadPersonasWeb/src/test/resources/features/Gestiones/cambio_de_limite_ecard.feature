#language:es
#Author:lmenjiva@bancoagricola.com.sv

Característica: El cliente podrá realizar el cambio de limite de su tarjeta ecard desde EBP

  @CambioLimiteEcard @QA
  Escenario: El cliente podra realizar el cambio de limite de su tarjeta ecard
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando el cliente realiza la gestion de cambio de limite en tarjeta ecard
      | tarjetaCredito  | nuevoLimiteEcard |
      | **** 6279 ECARD | 200              |
    Entonces debe visualizarse el limite actualizado en la tarjeta ecard
      | tarjetaCredito  | numTarjetaEcard | nuevoLimiteEcard |
      | **** 6279 ECARD | **** 6279       | 200              |