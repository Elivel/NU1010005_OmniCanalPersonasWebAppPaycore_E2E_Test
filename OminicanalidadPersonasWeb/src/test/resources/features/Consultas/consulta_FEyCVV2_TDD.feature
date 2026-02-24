#language:es
#author: efrender@bancoagricola.com.sv

Característica: El Cliente Podra Consultar Fecha de Vencimiento (FE) y CVV2 de TDD

  @FEYCVV2TDD @QA
  Escenario: El Cliente Podra Consultar Fecha de Vencimiento (FE) y CVV2 de TDD
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto02
    Y realiza validación de datos de TDD
      | tarjetaDebito     | cvv | fechaVencimiento |
      | **** 7912 Clásica | 132 | 06/25            |

