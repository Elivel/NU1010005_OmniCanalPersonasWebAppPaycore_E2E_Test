#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar el pago al prestamo de un tercero desde CA y CC

  @PagoPrestamoATerceros @QA
  Escenario: El cliente podra realizar el pago de prestamo de un tercero desde CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando el cliente verifica el saldo de la cuenta 3001329786 antes de transferir
    Y realiza el pago de prestamo a tercero Nuevo desde CA
      | tituloCuenta                | cuentaOrigen | numeroPrestamo | monto | concepto                          | correo                        |
      | Resumen de cuenta ahorro CA | 3001329786   | 8094639832     | 0.01  | pago prestamo terceros automatico | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen

  @PagoPrestamoATerceros @QA
  Escenario: El cliente podra realizar el pago de prestamo de un tercero desde CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Cuando el cliente verifica el saldo de la cuenta 5110002623 antes de transferir para CC
    Y realiza el pago de prestamo a tercero Nuevo desde CC
      | tituloCuenta                | cuentaOrigen | numeroPrestamo | monto | concepto                          | correo                        |
      | Resumen de cuenta corriente | 5110002623   | 8094639832     | 0.01  | pago prestamo terceros automatico | lmenjiva@bancoagricola.com.sv |
    Entonces debe visualizar una disminucion de monto 0.01 en el saldo cuenta origen