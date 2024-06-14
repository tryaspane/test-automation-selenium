package steps.frontend;

import dto.MainDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;

@AllArgsConstructor
public class LoginStep {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStep.class);
    private LoginPage loginPage;
    private MainDto mainDto;
    public void accessDashboard(String url) {
    }
    public void loginUsingUsernameAndPassword(String username, String password) {
    }

    public void verifyMainDashboardPage() {
    }
}
