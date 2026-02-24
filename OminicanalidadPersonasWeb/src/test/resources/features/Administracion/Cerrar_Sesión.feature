#language: es
#Author: efrender@bancoagricola.com.sv

  Característica: El cliente podra cerrar sesión con exitó.
    Antecedentes:
      Dado que el cliente ingresa a e-banca Personas
      Y inicia sesion como cliente auto01
      @CerrarSesión @QA
        Escenario: El cliente ingresa a ebanca web, luego realiza el loggin satisfactoriamente,
        posteriormente valida haber iniciado sesión y ejecuta el flujo de 'Cerrar Sesion'.
        Cuando El Usuario se encuentre dentro de Ebanca Persona
        Entonces Validar que el usuario puede Cerrar Sesión