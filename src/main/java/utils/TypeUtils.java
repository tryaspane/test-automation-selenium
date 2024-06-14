package utils;

import dto.MainDto;
import lombok.AllArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class TypeUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(TypeUtils.class);

    public static void sendKeys(WebElement element, String text){
        LOGGER.debug("sending keys = {} to element = {}", text, element);
        try{
            element.sendKeys(text);
        }
        catch (Exception e){
            LOGGER.debug("general error occured on sendKeys! will retry! error - ", e);
            SystemUtils.threadSleep(500);
            element.sendKeys(text);
        }
    }
    public static void sendKeys(MainDto mainDto, By by, String text){
        LOGGER.debug("sending keys by = {}", by);
        sendKeys(ElementUtils.findByElementNoWait(mainDto, by), text);
    }
}
