#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias de Puntos BA a Lifemiles seleccionando CA y CC

  @PuntosBAaLifemiles @DEV
  Escenario: El cliente podrá realizar transferencias de Puntos BA a Lifemiles seleccionando CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando valida los puntos BA antes de realizar la transacción
    Y valida los saldos antes de realizar la transacción
      | cuentaOrigen                |
      | 31320008506 Cuenta de ahorro |
    Y realiza el proceso de transferencia de puntos BA a Lifemiles
      | cuentaOrigen                | cuentaCorta   | primerNombre | segundoNombre | primerApellido | segundoApellido | numeroLifemiles | puntos | codigoPais  | numeroTelefono |
      | 31320008506 Cuenta de ahorro | 31320008506 CA | Nelson       | Jose          | Perez          | Garcia          | 13539270721     | 5000   | El Salvador | 72893976       |
    Entonces valida los puntos BA posterior a realizar la transacción
      | monto |
      | 5000  |
    Y Valida los saldos posterior a realizar la transacción
      | cuentaOrigen                | monto |
      | 31320008506 Cuenta de ahorro | 16.25 |

  @PuntosBAaLifemiles @DEV
  Escenario: El cliente podrá realizar transferencias de Puntos BA a Lifemiles seleccionando CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD ahorro2020
    Cuando valida los puntos BA antes de realizar la transacción
    Y valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen                |
      | 1210039767 Cuenta corriente |
    Y realiza el proceso de transferencia de puntos BA a Lifemiles
      | cuentaOrigen                | cuentaCorta   | primerNombre | segundoNombre | primerApellido | segundoApellido | numeroLifemiles | puntos | codigoPais  | numeroTelefono |
      | 1210039767 Cuenta corriente | 1210039767 CC | Nelson       | Jose          | Perez          | Garcia          | 02938060705     | 5000   | El Salvador | 72893976       |
    Entonces valida los puntos BA posterior a realizar la transacción
      | monto |
      | 5000  |
    Y valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen                | monto |
      | 1210039767 Cuenta corriente | 16.25 |