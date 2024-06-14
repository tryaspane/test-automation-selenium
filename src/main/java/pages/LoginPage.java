package pages;

import org.openqa.selenium.By;

public class LoginPage {

    public static final By EMAIL_FIELD = By.name("username");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
}
