Feature: Reset de usuario en base de datos

  @db-reset
  Scenario: Resetear usuario antes de ejecutar pruebas
    Given we reset the database user "usuario_prueba"
