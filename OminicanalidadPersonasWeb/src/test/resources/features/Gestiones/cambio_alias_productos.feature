#language:es
#Author:efrender@bancoagricola.com.sv

Característica: EL usuario podra cambiar de Alias a los productos: CA, CC, EXTRAFINANCIMIENTO, ADS, PRESTAMO, TARJETA

  @CambioAliasProductoCA @QA
  Escenario: El cliente podrá realizar cambio de Alias a una Cuenta de Ahorro:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y El cliente Selecciona el producto
      | cuentaOrigen |
      | 3001329786   |
    Cuando Se dirige a la opción de 'Más detalle'
    Entonces Cambia el Alias del producto y se regresa a su nombre original 3001329786 Cuenta de Ahorro

  @CambioAliasProductoCC @QA
  Escenario: El cliente podrá realizar cambio de Alias a una Cuenta de Corriente:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y El cliente Selecciona el producto
      | cuentaOrigen |
      | 1210039767   |
    Cuando Se dirige a la opción de 'Más detalle'
    Entonces Cambia el Alias del producto y se regresa a su nombre original 1210039767 Cuenta Corriente

  @CambioAliasProductoExtrafinancimiento @QA
  Escenario: El cliente podrá realizar cambio de Alias a un Prestamo de Extrafinanciemiento:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y El cliente Selecciona el producto
      | cuentaOrigen |
      | 2131973328   |
    Cuando Se dirige a la opción de 'Más detalle'
    Entonces Cambia el Alias del producto y se regresa a su nombre original 2131973328 Prestamo de Extrafi

  @CambioAliasProductoADS @QA
  Escenario: El cliente podrá realizar cambio de Alias a una Cuenta de Corriente ADS:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente 007312393
    Y El cliente Selecciona el producto
      | cuentaOrigen |
      | 5160017076   |
    Cuando Se dirige a la opción de 'Más detalle'
    Entonces Cambia el Alias del producto y se regresa a su nombre original 5162423588 Cuenta Corriente

  @CambioAliasProductoPrestamo @QA
  Escenario: El cliente podrá realizar cambio de Alias a un Prestamo de Consumo:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto01
    Y El cliente Selecciona el producto
      | cuentaOrigen |
      | 2131947871   |
    Cuando Se dirige a la opción de 'Más detalle'
    Entonces Cambia el Alias del producto y se regresa a su nombre original 2131947871 Prstamo de Consumo
