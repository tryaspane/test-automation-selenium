package utils;

import dto.MainDto;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class AssertionUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(AssertionUtils.class);

    public static void assertIsDisplayed(MainDto mainDto, WebElement element){
        LOGGER.debug("asserting if element = {} is displayed", element);
        boolean isDisplayed = ElementUtils.isElementDisplayed(mainDto, element);
        LOGGER.debug("element = {} displayed = {}", element, isDisplayed);
        assertTrue(isDisplayed);
    }

    public static void assertTrue(boolean isTrue) {
        LOGGER.debug("checking if = {}", isTrue);
        Assert.assertTrue(isTrue);
    }
}
