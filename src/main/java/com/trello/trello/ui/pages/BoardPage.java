package com.trello.trello.ui.pages;

import core.selenium.WebDriverHelper;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BoardPage extends BasePage {

    @FindBy(css = "div#header span[aria-label='AddIcon']")
    WebElement btnAdd;

    @FindBy(css = "button[data-test-id='header-create-board-button']")
    WebElement btnAddBoard;

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    WebElement inputBoardName;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    WebElement submit;

    @FindBy(id = "trello-root")
    private  WebElement trelloRoot;

    private WebDriverWait webDriverWait;

    public Board(){
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(trelloRoot));
    }

    public void createBoard(String nameBoard){
        WebDriverHelper.clickElement(btnAdd);
        WebDriverHelper.clickElement(btnAddBoard);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(inputBoardName));
        WebDriverHelper.setElement(inputBoardName, nameBoard);
        WebDriverHelper.clickElement(submit);
    }

    public String getCurrentUrl() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(trelloRoot));
        return webDrive.getCurrentUrl();
    }
}
