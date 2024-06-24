package utils;

import dto.MainDto;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ElementUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementUtils.class);
    private static final int WAIT_TIME = Integer.parseInt(SystemUtils.getConfig("explicit.wait.limit"));

    public static boolean isElementDisplayed(MainDto mainDto, WebElement element, int waitTimeInSeconds) {
        LOGGER.debug("Checking if WebElement: {} is displayed", element);
        if (element == null) {
            LOGGER.debug("Element is null ..");
            return false;
        }
        WebDriverWait wait = new WebDriverWait(mainDto.getDriver(), Duration.ofSeconds(waitTimeInSeconds));
        try {
            boolean isElementDisplayed = wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
            LOGGER.debug("element is displayed? = {}", isElementDisplayed);
            return isElementDisplayed;
        }
        catch (TimeoutException | NoSuchElementException | IndexOutOfBoundsException exception) {
            LOGGER.debug("Element: {} is not displayed", element);
            return false;
        }
        catch (StaleElementReferenceException e){
            LOGGER.debug("StaleElementReferenceException encountered, will try to fix!");
            return wait.until(ExpectedConditions.elementToBeClickable(getRefreshedStaleElement(mainDto, element))).isDisplayed();
        }
    }

    public static By getElementLocator(WebElement element){
        LOGGER.debug("getting web element locator of = {}", element);
        String elementString = element.toString();
        By by = null;
        String locator = "";
        if(elementString.contains("id:")){
            locator = elementString.substring(elementString.indexOf("id:") + 3, elementString.length()-1);
            by = new By.ById(locator);
        }
        if(elementString.contains("xpath:")){
            locator = elementString.substring(elementString.indexOf("xpath:") + 7, elementString.length()-1);
            by = new By.ByXPath(locator);
        }
        if(elementString.contains("name:")){
            locator = elementString.substring(elementString.indexOf("name:") + 5, elementString.length()-1);
            by = new By.ByName(locator);
        }
        LOGGER.debug("locator = {}", locator);
        return by;
    }

    public static WebElement getRefreshedStaleElement(MainDto mainDto, WebElement element){
        LOGGER.debug("refreshing element from DOM = {}", element);
        return mainDto.getDriver().findElement(getElementLocator(element));
    }

    public static WebElement findByElementNoWait(MainDto mainDto, By by){
        LOGGER.debug("finding by element by = {}", by);
        return mainDto.getDriver().findElement(by);
    }

    public static boolean isElementDisplayed(MainDto mainDto, WebElement element){
        return isElementDisplayed(mainDto, element, WAIT_TIME);
    }
}
