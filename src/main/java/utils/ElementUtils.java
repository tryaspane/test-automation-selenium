package utils;

import dto.MainDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementUtils.class);

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
}
