package utils;

import dto.MainDto;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@AllArgsConstructor
public class ClickUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ClickUtils.class);
    private static MainDto mainDto;

    public static void click(WebElement element){
        LOGGER.debug("clicking element = {}", element);
        try{
            element.click();
        }
        catch (StaleElementReferenceException e){
            LOGGER.debug("StaleElementReferenceException encountered on click, will try to click again!");
            ElementUtils.getRefreshedStaleElement((MainDto) mainDto.getDriver(), element).click();
        }
        catch (Exception e){
            LOGGER.debug("general error occured! reclicking the element! ", e);
            element.click();
        }
        LOGGER.debug("clicked element! = {}", element);
    }

    public static void click(MainDto mainDto, By by){
        LOGGER.debug("clicking by = {}", by);
        WebElement element = mainDto.getDriver().findElement(by);
        click(element);
    }
}
