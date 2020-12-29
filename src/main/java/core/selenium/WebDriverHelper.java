package core.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class is helper of WebDriverManager class.
 */
public final class WebDriverHelper {

    private WebDriverHelper() {

    }

    /**
     * Gets CurrentUrl.
     * @return current URL
     */
    public static String getCurrentUrl() {
        return WebDriverManager.getInstance().getWebDriver().getCurrentUrl();
    }
    /**
     * Sets a text in the webElement.
     * @param webElement
     * @param text
     */
    public static void setElement(final WebElement webElement, final String text) {
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * Sets a text in the By.
     * @param by
     * @param text
     */
    public static void setElement(final By by, final String text) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebElement webElement = webDriver.findElement(by);
        setElement(webElement, text);
    }

    /**
     * Clicks an element.
     * @param webElement
     */
    public static void clickElement(final WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * Clicks an by.
     * @param by
     */
    public static void clickElement(final By by) {
        WebDriver webDriver = WebDriverManager.getInstance().getWebDriver();
        WebElement webElement = webDriver.findElement(by);
        clickElement(webElement);
    }

    /**
     * Method wait to load a webElement.
     * @param webElement
     */
    public static void waitUntil(final WebElement webElement) {
        WebDriverWait webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Selects an element from a html select tag.
     * @param optionName
     */
    public static void selectDropDownOptionByName(final String optionName) {
        By dropDownOption = By.xpath("//*[contains(text(),'" + optionName + "')]");
        WebDriverHelper.clickElement(dropDownOption);
    }
}
