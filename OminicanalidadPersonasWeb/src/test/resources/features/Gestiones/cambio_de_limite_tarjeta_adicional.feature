#language:es
#Author:lmenjiva@bancoagricola.com.sv

Característica: El cliente podrá realizar el cambio de limite una tarjeta adicional desde EBP

  @CambioLimiteTarjetaAdicional @QA
  Escenario: El cliente podra realizar el cambio de limite de su tarjeta adicional
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente realiza la gestion de cambio de limite en tarjeta adicional
      | tarjetaCredito                    | tarjetaAdicional | nuevoLimiteTarjetaAdicional |
      | **** 5577 VISA Business           | **** 1392        | 200                         |
    Entonces debe visualizarse el limite actualizado en la tarjeta adicional
      | tarjetaCredito                    | tarjetaAdicional | nuevoLimiteTarjetaAdicional |
      | **** 5577 VISA Business           | **** 1392        | 200                         |