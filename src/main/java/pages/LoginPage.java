package pages;

import dto.MainDto;
import lombok.Getter;
import org.openqa.selenium.By;
import utils.DriverUtils;

@Getter
public class LoginPage {
    private MainDto mainDto;
    public LoginPage(MainDto mainDto) {
        DriverUtils.initializePage(mainDto, this);
    }

    public static final By EMAIL_FIELD = By.name("username");
    public static final By PASSWORD_FIELD = By.name("password");
    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
}
