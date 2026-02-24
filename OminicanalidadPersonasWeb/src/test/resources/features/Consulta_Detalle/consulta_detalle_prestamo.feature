#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar la consulta del detalle de un préstamo, validando las 3 capas de información

  @ConsultaDetallePrestamos @QA
  Escenario: El cliente validará que se muestre el detalle de préstamo
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Entonces valida que se muestren de forma correcta los datos de préstamo
      | numeroPrestamo                |
      | 2131947871 Prstamo de Consumo |