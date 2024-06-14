package stepdefinitions.backend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;
import steps.backend.EnvironmentStep;
import steps.backend.GenerateTokenStep;

@AllArgsConstructor
public class GenerateTokenStepDefinition {
    public GenerateTokenStep generateTokenStep;
    public EnvironmentStep environmentStep;

    @Given("user on test environment")
    public void setEnvironment() {
        environmentStep.setEnvironment();
    }

    @When("user generate token using {string} and {string} credential account")
    public void generateTokenUsingAndCredentialAccount(String email, String password) {
        generateTokenStep.generateTokenUsingAndCredentialAccount(email, password);
    }

    @Then("user get http request status code of {string}")
    public void getHttpRequestStatusCodeOf(String status) {
        generateTokenStep.getHttpRequestStatusCodeOf(status);
    }
}
