package com.trello.trello.ui.pages.components;

import com.trello.trello.ui.pages.BasePage;
import core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuComponent extends BasePage {

    @FindBy(css = "a[href$='boards']")
    private WebElement btnBoard;

    @FindBy(css = "a[href*='templates'])")
    private WebElement btnTemplate;

    @FindBy(css = "a[data-test-id='home-link']")
    private WebElement btnHome;

    @FindBy(css = "div#content button[data-test-id='home-navigation-create-team-button']")
    private WebElement btnTeams;

    /**
     * Does click the "+" button.
     */
    public void clickBtnTeams() {
        WebDriverHelper.clickElement(btnTeams);
    }

    /**
     * Does click the template button.
     */
    public void clickBtnTemplate() {
        WebDriverHelper.clickElement(btnTemplate);
    }

    /**
     * Does click the "+" button.
     */
    public void clickBtnHome() {
        WebDriverHelper.clickElement(btnHome);
    }

    /**
     * Method wait to load the component.
     */
    public LeftMenuComponent() {
        WebDriverHelper.waitUntil(btnTeams);
    }
}
