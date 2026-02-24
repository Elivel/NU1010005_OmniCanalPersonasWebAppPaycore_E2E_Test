#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar pago de préstamos entre bancos UNI

  @PagoPrestamoUNI @DEV
  Esquema del escenario: El cliente podrá realizar pagos de préstamos UNI desde CA (Nueva y favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen   | tituloCuenta                |
      | <cuentaOrigen> | Resumen de cuenta ahorro CA |
    Y realiza el pago de prestamo UNI
      | cuentaOrigen   | cuentaTicket   | banco   | numeroPrestamo   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | correo   | monto   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <cuentaTicket> | <banco> | <numeroPrestamo> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <correo> | <monto> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza el pago de prestamo UNI desde favorito
      | cuentaOrigen   | cuentaTicket   | banco   | numeroPrestamo   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | correo   | monto   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <cuentaTicket> | <banco> | <numeroPrestamo> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <correo> | <monto> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen   | monto | tituloCuenta                |
      | <cuentaOrigen> | 2.00  | Resumen de cuenta ahorro CA |

    Ejemplos:
    #Favoritos tienen que definirse con 13 caracteres.
      | cuentaOrigen                 | cuentaTicket   | banco      | numeroPrestamo | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | correo                        | monto | concepto  | nombreFavorito | opcion                    |
      | 31320008506 Cuenta de ahorro | 31320008506 CA | BANCO AZUL | 10000000327687 | DUI                | 123456789            | Juan Perez      | lmenjiva@bancoagricola.com.sv | 1     | PruebaUNI | FavoritoPRHIP  | Préstamos de otros bancos |

  @PagoPrestamoUNI @DEV
  Esquema del escenario: El cliente podrá realizar pagos de préstamos UNI desde CC (Nueva y favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen   |
      | <cuentaOrigen> |
    Y realiza el pago de prestamo UNI desde CC
      | cuentaOrigen   | cuentaTicket   | banco   | numeroPrestamo   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | correo   | monto   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <cuentaTicket> | <banco> | <numeroPrestamo> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <correo> | <monto> | <concepto> | <nombreFavorito> | <opcion> |
    Y realiza el pago de prestamo UNI desde favorito
      | cuentaOrigen   | cuentaTicket   | banco   | numeroPrestamo   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | correo   | monto   | concepto   | nombreFavorito   | opcion   |
      | <cuentaOrigen> | <cuentaTicket> | <banco> | <numeroPrestamo> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <correo> | <monto> | <concepto> | <nombreFavorito> | <opcion> |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen   | monto |
      | <cuentaOrigen> | 2.00  |

    Ejemplos:
    #Favoritos tienen que definirse con 13 caracteres.
      | cuentaOrigen                | cuentaTicket  | banco      | numeroPrestamo | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | correo                        | monto | concepto  | nombreFavorito | opcion                    |
      | 5496752185 Cuenta corriente | 5496752185 CC | BANCO AZUL | 10000000327687 | DUI                | 123456789            | Juan Perez      | lmenjiva@bancoagricola.com.sv | 1     | PruebaUNI | FavoritoPRHIP  | Préstamos de otros bancos |