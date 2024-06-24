package steps.frontend;

import dto.MainDto;
import enums.Apps;
import lombok.AllArgsConstructor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.LoginPage;
import utils.AssertionUtils;
import utils.ClickUtils;
import utils.TypeUtils;

@AllArgsConstructor
public class LoginStep {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStep.class);
    private LoginPage loginPage;
    private MainDto mainDto;
    public void accessDashboard(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
    }
    public void loginUsingUsernameAndPassword(String username, String password) {
        TypeUtils.sendKeys(loginPage.getEMAIL_FIELD(),username);
        TypeUtils.sendKeys(loginPage.getPASSWORD_FIELD(),password);
        ClickUtils.click(loginPage.getBUTTON_LOGIN());
    }

    public void verifyMainDashboardPage() {

    }
}
