#language:es
#Author:efrender@bancoagricola.com.sv

Característica: El usuario/cliente podra emitir y consultar la constancia de su renta por año.

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01

  @EmisiónConstanciaRenta @QA
  Escenario: Validar Que El Usuario Puede Emitir La Constancia De Su Renta
    Cuando ingrese en el submenu en el apartado de servicios
    Y haga click en la opcion 'Constancia de renta'
    Y ingrese el año a emitir de su constancia de renta
      | añoRenta |
      | 2022     |
    Y da click en el boton emitir
    Entonces el cliente valida que se muestre el archivo de 'ConstanciaRenta.pdf' en la carpeta