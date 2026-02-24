#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle de las compras a plazo realizadas con su tarjeta

  @VisualizacionCompraDetalleaPlazo @QA
  Escenario: El cliente podrá visualizar desde los movimientos de sus tarjetas el registro y detalle de las compras a plazo
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente userjona01
    Cuando el cliente ingresa a los movimientos de la tarjeta
      | tarjetaCredito             | numeroAutorizacion      |
      | **** 4740 Clásica Selectos | 09999999980703000010017 |
    Entonces consulta el detalle de las compras a plazo
      | numeroAutorizacion      |
      | 09999999980703000010017 |