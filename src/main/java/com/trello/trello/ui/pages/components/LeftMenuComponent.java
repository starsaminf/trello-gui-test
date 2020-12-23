package com.trello.trello.ui.pages.components;

import com.trello.trello.ui.pages.BasePage;
import core.selenium.WebDriverHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeftMenuComponent extends BasePage {

    //boards
    //templates
    //home
    @FindBy(css = "div#content button[data-test-id='home-navigation-create-team-button']")
    private WebElement btnTeams;

    /**
     * Method wait to load the component.
     */
    public LeftMenuComponent() {
        WebDriverHelper.waitUntil(btnTeams);
    }

    /**
     * Does click the "+" button.
     */
    public void clickBtnTeams() {
        WebDriverHelper.clickElement(btnTeams);
    }

    /**
     * Method wait to load the page.
     */
    public void waitLoadPage() {
        WebDriverHelper.waitUntil(btnTeams);
    }
}
