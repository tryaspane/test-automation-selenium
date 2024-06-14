package stepdefinitions.frontend;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import steps.frontend.DashboardStep;

public class Dashboard {
    public DashboardStep dashboardStep;
    @Given("user url dashboard")
    public void setUrlDashboard() {
        dashboardStep.setUrlDashboard();
    }

    @When("user access the landing page")
    public void accessTheLandingPage() {
        dashboardStep.accessTheLandingPage();
    }

    @Then("user can see details of landing page")
    public void verifyDetailsOfLandingPage() {
        dashboardStep.verifyDetailsOfLandingPage();
    }
}
