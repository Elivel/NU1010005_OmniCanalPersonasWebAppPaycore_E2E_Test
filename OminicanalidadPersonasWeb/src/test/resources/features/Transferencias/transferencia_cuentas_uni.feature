#language:es
#Author:lamartin@bancoagricola.com.sv
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias UNI: Operaciones entre bancos

  @TransferenciasUNI @DEV
  Esquema del escenario: El cliente podrá realizar transferencias UNI desde CA (Nueva y favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen   | tituloCuenta                 |
      | <cuentaOrigen> | Resumen de cuenta ahorro CA1 |
    Y realiza la transferencia a una ctaahorro o corriente de otro banco desde cero
      | cuentaOrigen   | cuentaTicket   | tipoCuenta   | banco   | cuentaDestino   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | monto   | concepto   | correo   | nombreFavorito   | opcion                  |
      | <cuentaOrigen> | <cuentaTicket> | <tipoCuenta> | <banco> | <cuentaDestino> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <monto> | <concepto> | <correo> | <nombreFavorito> | Cuentas de otros bancos |
    Y realiza la transferencia a una ctaahorro o corriente de otro banco desde un favorito
      | cuentaOrigen   | cuentaTicket   | tipoCuenta   | banco   | cuentaDestino   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | monto   | concepto   | correo   | nombreFavorito   | opcion                  |
      | <cuentaOrigen> | <cuentaTicket> | <tipoCuenta> | <banco> | <cuentaDestino> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <monto> | <concepto> | <correo> | <nombreFavorito> | Cuentas de otros bancos |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen   | monto | tituloCuenta                 |
      | <cuentaOrigen> | 2.00  | Resumen de cuenta ahorro CA1 |

    Ejemplos:
    #Favoritos tienen que definirse con 13 caracteres.
      | cuentaOrigen                 | cuentaTicket   | tipoCuenta                | banco           | cuentaDestino   | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | monto | concepto                     | correo                        | nombreFavorito   |
      | 31320008506 Cuenta de ahorro | 31320008506 CA | Cuenta de ahorro - propia | BANCO CUSCATLAN | 000000007900500 | DUI                | 026193512            | ALBERTO LOPEZ   | 1     | transferencia UNI Cta Propia | lmenjiva@bancoagricola.com.sv | TransferenciaDDD |

  @TransferenciasUNI @DEV
  Esquema del escenario: El cliente podrá realizar transferencias UNI desde CC (Nueva y favorito)
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD granadausr
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen   | tituloCuenta                |
      | <cuentaOrigen> | Resumen de cuenta corriente |
    Y realiza la transferencia a una ctaahorro o corriente de otro banco desde cero CC
      | cuentaOrigen   | cuentaTicket   | tipoCuenta   | banco   | cuentaDestino   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | monto   | concepto   | correo   | nombreFavorito   | opcion                  |
      | <cuentaOrigen> | <cuentaTicket> | <tipoCuenta> | <banco> | <cuentaDestino> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <monto> | <concepto> | <correo> | <nombreFavorito> | Cuentas de otros bancos |
    Y realiza la transferencia a una ctaahorro o corriente de otro banco desde un favorito
      | cuentaOrigen   | cuentaTicket   | tipoCuenta   | banco   | cuentaDestino   | tipoIdentificacion   | numeroIdentificacion   | nombreRecibidor   | monto   | concepto   | correo   | nombreFavorito   | opcion                  |
      | <cuentaOrigen> | <cuentaTicket> | <tipoCuenta> | <banco> | <cuentaDestino> | <tipoIdentificacion> | <numeroIdentificacion> | <nombreRecibidor> | <monto> | <concepto> | <correo> | <nombreFavorito> | Cuentas de otros bancos |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen   | monto | tituloCuenta                |
      | <cuentaOrigen> | 2.00  | Resumen de cuenta corriente |

    Ejemplos:
    #Favoritos tienen que definirse con 13 caracteres.
      | cuentaOrigen                | cuentaTicket  | tipoCuenta                 | banco           | cuentaDestino   | tipoIdentificacion | numeroIdentificacion | nombreRecibidor | monto | concepto                  | correo                        | nombreFavorito   |
      | 5496752185 Cuenta corriente | 5496752185 CC | Cuenta de ahorro - tercero | BANCO CUSCATLAN | 000000007900500 | DUI                | 026193512            | ROBERTO LOPEZ   | 1     | transferencia UNI Tercero | lmenjiva@bancoagricola.com.sv | TransferenciaDDD |