package com.trello.trello.ui.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * TopMenuComponent class.
 */
public class TopMenuComponent {
    @FindBy(css = "div#header span[aria-label='AddIcon']")
    private WebElement btnAdd;

    @FindBy(css = "div#header span[aria-label='InformationIcon']")
    private WebElement btnInfo;

    @FindBy(css = "div#header span[aria-label='NotificationIcon']")
    private WebElement btnNotification;

    @FindBy(css = "div#header button[data-test-id='header-member-menu-button']")
    private WebElement btnMenu;
}
