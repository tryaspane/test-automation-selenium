package stepdefinitions.frontend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.frontend.LoginStep;

public class LoginStepDefinition {
    public LoginStep loginStep;

    @Given("user access {string} dashboard")
    public void accessDashboard(String url) {
        loginStep.accessDashboard(url);
    }

    @When("user login using username {string} and password {string}")
    public void loginUsingUsernameAndPassword(String username, String password) {
        loginStep.loginUsingUsernameAndPassword(username, password);
    }

    @Then("user can see main dashboard page")
    public void verifyMainDashboardPage() {
        loginStep.verifyMainDashboardPage();
    }
}
