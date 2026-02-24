#language:es
#Author:lmenjiva@bancoagricola.com.sv

Característica: El cliente podrá consultar las tarjetas adicionales de una TDC

  @ConsultaTarjetasAdicionales @QA
  Escenario: El cliente podra consultar las tarjetas adicionales de una TDC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando el cliente ingresa a la opcion consulta de tarjetas adicionales
      | tarjetaCredito     |
      | **** 2455 Platinum |
    Entonces consulta el detalle de las tarjetas adicionales
      | tarjetaAdicional |
      | **** 6279        |