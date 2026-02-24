#language:es
#Author:aeaguila@bancoagricola.com.sv

Característica: El cliente podrá crear la gestión de notificación de viajeros

  Antecedentes:
    Dado que el cliente ingresa a e-banca Personas
    Y inicia sesion como cliente auto04

  @NotificacionViajeroUna @QA
  Escenario: El cliente podrá crear la gestión de notificación de viajeros para una tarjeta
    Y crea la gestion para notificación de viajeros para una tarjeta
      | tarjetaCredito      | fechaSalida    | fechaRegreso     | paisDestino | comentarios    |
      | **** 3144 VISA Gold | 4 Agosto, 2026 | 25 Octubre, 2026 | Qatar       | PruebaNFAutUna |
    Entonces valida que se muestre mensaje de confirmación de creación de gestión

  @NotificacionViajeroTodas @QA
  Escenario: El cliente podrá crear la gestión de notificación de viajeros para todas las tarjetas
    Y crea la gestion para notificación de viajeros para todas las tarjetas
      | fechaSalida    | fechaRegreso     | paisDestino | comentarios      |
      | 4 Agosto, 2026 | 25 Octubre, 2026 | Qatar       | PruebaNFAutTodas |
    Entonces valida que se muestre mensaje de confirmación de creación de gestión

  @NotificacionViajeroTDD @QA
  Escenario: El cliente podrá crear la gestión de notificación de viajeros para una TDD
    Y crea la gestion para notificación de viajeros para una tarjeta
      | tarjetaCredito    | fechaSalida    | fechaRegreso     | paisDestino | comentarios    |
      | **** 0551 Clásica | 4 Agosto, 2026 | 25 Octubre, 2026 | Qatar       | PruebaNFAutUna |
    Entonces valida que se muestre mensaje de confirmación de creación de gestión

