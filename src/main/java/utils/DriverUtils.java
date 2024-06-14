package utils;

import dto.MainDto;
import lombok.AllArgsConstructor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

@AllArgsConstructor
public class DriverUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(DriverUtils.class);
    private static final int explicitWaitTime = Integer.parseInt(SystemUtils.getConfig("explicit.wait.limit"));
    private static final int ajaxWaitTime = Integer.parseInt(SystemUtils.getConfig("ajax.wait.limit"));


    public static void initializePage(MainDto mainDto, Object claz) {
        LOGGER.debug("[Initializing Page]Using time from explicit.wait.limit: {}", SystemUtils.getConfig("explicit.wait.limit"));
        if(!(mainDto.getDriver() == null))
            initializePage(mainDto, claz, ajaxWaitTime);
    }

    public static void initializePage(MainDto mainDto, Object claz, int waitSeconds) {
        LOGGER.debug("[Initializing Page]: {}", claz);
        PageFactory.initElements(new AjaxElementLocatorFactory(mainDto.getDriver(), waitSeconds), claz);
        waitForPageToLoad(mainDto.getDriver());
    }

    public static void waitForPageToLoad(WebDriver driver) {
        LOGGER.debug("waiting for page to load!");
        new WebDriverWait(driver, Duration.ofSeconds(explicitWaitTime)).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }
}
