package com.bancoagricola.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserResetQuery {

    private static final String RESET_USER_SQL =
            "UPDATE SEGURIDAD.USUARIOS " +
            "SET ESTADO = ?, INTENTOS_FALLIDOS = ?, FECHA_BLOQUEO = NULL " +
            "WHERE USUARIO = ?";

    public int resetUser(Connection connection, String user) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(RESET_USER_SQL)) {
            preparedStatement.setString(1, "ACTIVO");
            preparedStatement.setInt(2, 0);
            preparedStatement.setString(3, user);
            return preparedStatement.executeUpdate();
        }
    }
}
