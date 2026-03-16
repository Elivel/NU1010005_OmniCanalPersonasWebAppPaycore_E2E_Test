package com.bancoagricola.tasks;

import com.bancoagricola.db.OracleConnectionManager;
import com.bancoagricola.db.UserResetQuery;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.sql.Connection;
import java.sql.SQLException;

public class UserResetTask implements Task {

    private final String user;
    private final OracleConnectionManager connectionManager;
    private final UserResetQuery userResetQuery;

    public UserResetTask(String user) {
        this(user, new OracleConnectionManager(), new UserResetQuery());
    }

    public UserResetTask(String user, OracleConnectionManager connectionManager, UserResetQuery userResetQuery) {
        this.user = user;
        this.connectionManager = connectionManager;
        this.userResetQuery = userResetQuery;
    }

    @Override
    @Step("{0} resetea el usuario de base de datos #user")
    public <T extends Actor> void performAs(T actor) {
        try (Connection connection = connectionManager.openConnection()) {
            int updatedRows = userResetQuery.resetUser(connection, user);
            if (updatedRows == 0) {
                throw new IllegalStateException("No se actualizo ningun registro para el usuario: " + user);
            }
        } catch (SQLException exception) {
            throw new IllegalStateException("Error SQL al resetear el usuario: " + user, exception);
        }
    }

    public static UserResetTask forUser(String user) {
        return Instrumented.instanceOf(UserResetTask.class).withProperties(user);
    }
}
