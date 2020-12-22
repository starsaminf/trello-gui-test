package com.trello.trello.ui.pages;

import core.selenium.WebDriverHelper;
import core.selenium.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BoardPage class.
 */
public class BoardPage extends BasePage {

    @FindBy(css = "div#header span[aria-label='AddIcon']")
    private WebElement btnAdd;

    @FindBy(css = "button[data-test-id='header-create-board-button']")
    private WebElement btnAddBoard;

    @FindBy(css = "input[data-test-id='create-board-title-input']")
    private WebElement inputBoardName;

    @FindBy(css = "button[data-test-id='create-board-submit-button']")
    private WebElement submit;

    @FindBy(css = "div.board-header")
    private WebElement boardHeader;

    @FindBy(id = "trello-root")
    private WebElement trelloRoot;

    private WebDriverWait webDriverWait;

    /**
     * Constructor of BoardPage.
     */
    public BoardPage() {
        webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(trelloRoot));
    }

    /**
     * Method createBoard.
     * @param nameBoard
     */
    public void createBoard(final String nameBoard) {
        WebDriverHelper.clickElement(btnAdd);
        WebDriverHelper.clickElement(btnAddBoard);
        WebDriverHelper.waitUntil(inputBoardName);
        WebDriverHelper.setElement(inputBoardName, nameBoard);
        WebDriverHelper.clickElement(submit);
    }

    /**
     * Method wait to load BoardPage.
     */
     public void waitLoadBoardPage() {
         WebDriverHelper.waitUntil(boardHeader);
    }
}
