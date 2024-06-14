package dto;

import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
public class MainDto {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainDto.class);
    private WebDriver driver;

    public WebDriver getDriver() {
        LOGGER.debug("getting driver = {}", driver);
        return driver;
    }

}
