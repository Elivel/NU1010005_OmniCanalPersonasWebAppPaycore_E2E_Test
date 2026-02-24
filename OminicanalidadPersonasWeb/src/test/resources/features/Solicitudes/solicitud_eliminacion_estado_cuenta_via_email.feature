#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar la solicitud de consulta y eliminacion del estado de su cuenta de tarjeta de credito

  @SolicitudEliminacionEstadoCuenta @QA
  Escenario: El cliente podrá realizar la solicitud y eliminacion de envio de estado de cuenta
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto04
    Cuando el cliente selecciona una tarjeta para solicitar el envio de estado cuenta
      | tarjetaCredito      | tarjetaCreditoLista |
      | **** 3144 VISA Gold | **** 3144 VISA Gold |
    Entonces valida que se muestre el mensaje de solicitud
    Y verifica que se pueda eliminar la solicitud de envio de estado de cuenta
      | tarjetaCredito      | tarjetaCreditoLista |
      | **** 3144 VISA Gold | **** 3144 VISA Gold |