package dto;

import enums.Apps;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class MainDto {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainDto.class);
    private WebDriver driver;
    private Apps app;

    public WebDriver getDriver() {
        LOGGER.debug("getting driver = {}", driver);
        return driver;
    }

    public void setApp(String app){
        LOGGER.debug("setting app");
        this.app = Apps.valueOf(app);
        LOGGER.debug("setting app = {}", this.app);
    }

}
