package stepdefinitions.backend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GenerateTokenStepDefinition {
    @Given("user on test environment")
    public void userOnTestEnvironment() {
        
    }

    @When("user generate token using {string} and {string} credential account")
    public void userGenerateTokenUsingAndCredentialAccount(String arg0, String arg1) {
        
    }

    @Then("user get http request status code of {string}")
    public void userGetHttpRequestStatusCodeOf(String arg0) {
    }
}
