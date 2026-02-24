#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar el detalle ahorro navideño

  @ConsultaDetalleAhorroNavideno @QA
  Escenario: El cliente validará que se muestre el detalle del ahorro navideno asociado a la cuenta
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente usrcert9
    Cuando ingresa a la sección de ahorro navideño
      | cuentaOrigen |
      | 3007040110   |
    Entonces consulta el detalle de ahorro navideno para el contrato
      | numeroContrato |
      | 000000035082   |
