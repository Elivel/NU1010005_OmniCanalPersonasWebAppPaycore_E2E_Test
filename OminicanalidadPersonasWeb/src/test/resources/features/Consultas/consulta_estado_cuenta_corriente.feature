#language:es
#Author:lamartin@bancoagricola.com.sv

Característica: El cliente podrá validar que se genere y se descargue estado de cuenta corriente

  @GenerarDescargarEstadoCuentaCorriente @pdf @QA
  Escenario: El cliente podrá validar que se genere y descargue el estado de cuenta corriente
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente javierrosales
    Cuando realiza proceso para generación y descarga de estado de cuenta corriente
      | cuentaOrigen                | periodo       |
      | 5110002623 Cuenta corriente | Agosto / 2024 |
    Entonces el cliente valida que se muestre el archivo de 'EstadoCuenta.pdf' en la carpeta

