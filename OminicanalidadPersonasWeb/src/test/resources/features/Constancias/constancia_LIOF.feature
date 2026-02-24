#language:es
#Author:efrender@bancoagricola.com.sv

Característica: El usuario/cliente podra emitir y consultar la constancia LIOF por año y mes.

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @EmisionConstanciaLIOF @QA
  Escenario: Validar que el usuario pueda emitir una constancia LIOF por año y por mes
    Cuando ingrese en el submenu en el apartado de servicios
    Y haga click en la opción 'Emisión de Constancia LIOF'
    Entonces Selecciona el año y mes de emisión y hace click en el boton de emitir verá el archivo 'ConstanciaLIOF.pdf'.
      | año  | mes   |
      | 2024 | Enero |