#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá Reservar y liberar fondos p@goes desde Tarjetas

  @ReservarLiberarFondosTarjetas @QA
  Escenario: El cliente podra reservar y liberar fondos desde el menú Tarjetas
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando valida los saldos antes de realizar la transaccion desde Tarjetas
      | tarjetaCredito     |
      | **** 2455 Platinum |
    Y realiza la reserva de fondos
      | tarjetaCredito     | monto | vigencia | concepto                  |
      | **** 2455 Platinum | 1     | 1        | Reserva de fondos tarjeta |
    Entonces debe visualizar una disminucion en el saldo cuenta de la TC
      | monto |
      | 1     |
    Y realiza la liberacion de fondos de la tarjeta **** 2455 Platinum

    #Considerar que el cliente no tenga compras a plazo