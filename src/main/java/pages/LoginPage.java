package pages;

import dto.MainDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverUtils;

@Getter
@AllArgsConstructor
public class LoginPage {
    private MainDto mainDto;
    public LoginPage(MainDto mainDto) {
        DriverUtils.initializePage(mainDto, this);
    }

//    public static final By EMAIL_FIELD = By.name("username");
//    public static final By PASSWORD_FIELD = By.name("password");
//    public static final By LOGIN_BUTTON = By.xpath("//button[@type='submit']");

    @FindBy(name = "username")
    private WebElement EMAIL_FIELD;

    @FindBy(name = "password")
    private WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement BUTTON_LOGIN;
}
