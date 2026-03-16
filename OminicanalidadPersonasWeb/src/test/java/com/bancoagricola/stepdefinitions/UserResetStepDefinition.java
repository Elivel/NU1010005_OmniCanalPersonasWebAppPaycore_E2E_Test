package com.bancoagricola.stepdefinitions;

import com.bancoagricola.tasks.UserResetTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class UserResetStepDefinition {

    @Before("@db-reset")
    public void prepareActorStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("we reset the database user {string}")
    public void resetDatabaseUser(String user) {
        OnStage.theActorCalled("DatabaseOperator").attemptsTo(UserResetTask.forUser(user));
    }
}
