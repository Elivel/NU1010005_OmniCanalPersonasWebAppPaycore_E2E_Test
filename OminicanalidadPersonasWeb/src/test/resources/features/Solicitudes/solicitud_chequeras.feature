#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá solicitar chequeras con y sin taco

  @SolicitudChequeras @QA
  Esquema del escenario: El cliente podrá solicitar chequeras
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Entonces realiza proceso para solicitud de chequeras
      | cuentaOrigen   | tipoChequera   | cantidadCheques   | departamentoEntrega   | agenciaEntrega   |
      | <cuentaOrigen> | <tipoChequera> | <cantidadCheques> | <departamentoEntrega> | <agenciaEntrega> |

    Ejemplos:
      | cuentaOrigen                | tipoChequera | cantidadCheques | departamentoEntrega | agenciaEntrega    |
      | 1210039767 | Sin Taco     | 50            | LA LIBERTAD         | AGENCIA MERLIOT   |
      | 1210039767 | Con Taco     | 50            | SANTA ANA           | AGENCIA SANTA ANA |