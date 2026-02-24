#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá consultar chequeras

  @ChequesActivos @QA
  Escenario: El cliente podrá consultar chequeras con cheques activos
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Cuando realiza proceso para consultar de chequera con cheques activos
      | cuentaOrigen | chequera | estadoCheques |
      |              | 51 - 350 | Activo        |
    Entonces la cantidad de cheques filtrados por estado Activo debe coincidir

  @TodosCheques @QA
  Escenario: El cliente podrá consultar chequeras mostrando todos los cheques
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Cuando realiza proceso para consultar de chequera mostrando todos los cheques
      | cuentaOrigen                | chequera | estadoCheques |
      | 5110002623 Cuenta corriente | 51 - 350 | Todos         |
    Entonces la cantidad de cheques filtrados por estado Todos debe coincidir

  @EstadosCheques @QA
  Esquema del escenario: El cliente podrá consultar chequeras con cheques con diferentes estados
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando realiza proceso para consultar de chequera
      | cuentaOrigen   | chequera   | estadoCheques   |
      | <cuentaOrigen> | <chequera> | <estadoCheques> |
    Entonces valida que se muestren solamente los cheques con el estado seleccionado
      | cuentaOrigen   | chequera   | estadoCheques   |
      | <cuentaOrigen> | <chequera> | <estadoCheques> |

    Ejemplos:
      | cuentaOrigen                | chequera        | estadoCheques |
      | 1210039767 Cuenta Corriente | 301 - 350       | Revocado      |
      | 1210042016 Cuenta corriente | 809001 - 809025 | Imprenta      |
      | 5110002623 Cuenta corriente | 301 - 350       | Anulado       |
      | 1210039767 Cuenta Corriente | 301 - 350       | Activo        |
      | 1210039767 Cuenta Corriente | 301 - 350       | Pagado        |





