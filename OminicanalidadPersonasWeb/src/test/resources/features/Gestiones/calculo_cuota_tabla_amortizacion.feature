#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar Cálculo de Cuota y Tabla de Amortización

  @CalculaCuotaTablaAmortizacion @QA
  Escenario: El cliente podrá realizar Cálculo de Cuota y Tabla de Amortización
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Cuando realiza el proceso de calculo de cuota y tabla de amortizacion
      | monto | tasa | selectorPlazo | plazo | frecuencia |
      | 1000  | 15   | Meses         | 6     | Mensual    |
    Entonces valida que la cantidad de registros en la tabla sea igual a 6