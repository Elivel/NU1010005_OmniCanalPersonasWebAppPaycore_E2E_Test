#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar la consulta del detalle de un fondo de inversión, validando las 3 capas de información

  @ConsultaDetalleFondoInversion @QA
  Escenario: El cliente validará que se muestre el detalle de fondo de inversión
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente mavelar2
    Entonces valida que se muestren de forma correcta los datos de fondo de inversion
      | fondoInversion                     | numeroFondoInversion |
      | 1-000835-000634 Fondo de inversión | 1-000835-000634      |
