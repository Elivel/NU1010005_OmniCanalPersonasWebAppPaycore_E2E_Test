#language:es
#Author:lmenjiva@bancoagricola.com.sv

Característica: El cliente podrá realizar transferencias Transfer365: CA-RD (Desde CA y CC)

  @TransferenciasTransfer365SIPA @DEV
  Escenario: El cliente podrá realizar transferencias a otros bancos usando Transfer365 CA-RD desde una CA
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando valida los saldos antes de realizar la transacción
      | cuentaOrigen | tituloCuenta                |
      | 31320008506  | Resumen de cuenta ahorro CA |
    Y diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 CA-RD
      | cuentaOrigen | cuentaCorta    | tipoDePago                        | monto | descripcion        | paisBancoBeneficiario | bancoBeneficiario                   | numeroCuentaIban | nombreBeneficiario | numeroDocumentoBeneficiario | ciudad   | direccion                                      | nombreFavorito    | opcion            | montoComision |
      | 31320008506  | 31320008506 CA | Transporte, postales y mensajería | 1     | Transferencia SIPA | Costa Rica            | BANCO NACIONAL DE COSTA RICA (BNCR) | ANTGGTG1         | Juan Perez         | 046574818                   | San Jose | Boulevard de San Jose costado norte Av Central | Transfer365 CA RD | Transfer365 CA-RD | $1.13         |
    Y realiza la transferencia a otro banco usando Transfer 365 CA-RD desde un favorito
      | cuentaOrigen | cuentaCorta    | tipoDePago                        | monto | descripcion        | paisBancoBeneficiario | bancoBeneficiario                   | numeroCuentaIban | nombreBeneficiario | numeroDocumentoBeneficiario | ciudad   | direccion                                      | nombreFavorito    | opcion            | montoComision |
      | 31320008506  | 31320008506 CA | Transporte, postales y mensajería | 1     | Transferencia SIPA | Costa Rica            | BANCO NACIONAL DE COSTA RICA (BNCR) | ANTGGTG1         | Juan Perez         | 046574818                   | San Jose | Boulevard de San Jose costado norte Av Central | Transfer365 CA RD | Transfer365 CA-RD | $1.13         |
    Entonces Valida los saldos posterior a realizar la transacción
      | cuentaOrigen | monto | tituloCuenta                |
      | 31320008506  | 4     | Resumen de cuenta ahorro CA |

  @TransferenciasTransfer365SIPA @DEV
  Escenario: El cliente podrá realizar transferencias a otros bancos usando Transfer365 CA-RD desde una CC
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como clienteD auto01
    Cuando valida los saldos antes de realizar la transacción para CC
      | cuentaOrigen | tituloCuenta                |
      | 5490402996   | Resumen de cuenta corriente |
    Y diligencia los campos para realizar la transferencia a otro banco usando Transfer 365 CA-RD CC
      | cuentaOrigen | cuentaCorta   | tipoDePago                        | monto | descripcion        | paisBancoBeneficiario | bancoBeneficiario                   | numeroCuentaIban | nombreBeneficiario | numeroDocumentoBeneficiario | ciudad   | direccion                                      | nombreFavorito    | opcion            | montoComision |
      | 5490402996   | 5490402996 CC | Transporte, postales y mensajería | 1     | Transferencia SIPA | Costa Rica            | BANCO NACIONAL DE COSTA RICA (BNCR) | ANTGGTG1         | Juan Perez         | 046574818                   | San Jose | Boulevard de San Jose costado norte Av Central | Transfer365 CA RD | Transfer365 CA-RD | $1.13         |
    Y realiza la transferencia a otro banco usando Transfer 365 CA-RD desde un favorito
      | cuentaOrigen | cuentaCorta   | tipoDePago                        | monto | descripcion        | paisBancoBeneficiario | bancoBeneficiario                   | numeroCuentaIban | nombreBeneficiario | numeroDocumentoBeneficiario | ciudad   | direccion                                      | nombreFavorito    | opcion            | montoComision |
      | 5490402996   | 5490402996 CC | Transporte, postales y mensajería | 1     | Transferencia SIPA | Costa Rica            | BANCO NACIONAL DE COSTA RICA (BNCR) | ANTGGTG1         | Juan Perez         | 046574818                   | San Jose | Boulevard de San Jose costado norte Av Central | Transfer365 CA RD | Transfer365 CA-RD | $1.13         |
    Entonces valida los saldos posterior a realizar la transacción para CC
      | cuentaOrigen | monto | tituloCuenta                |
      | 5490402996   | 4     | Resumen de cuenta corriente |