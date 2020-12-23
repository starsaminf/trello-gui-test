package com.trello.trello.ui.pages;

import com.trello.trello.entities.Team;
import core.selenium.WebDriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

/**
 * TeamPage class.
 */
public class TeamPage extends BasePage {

    @FindBy(css = "input[data-test-id='header-create-team-name-input']")
    private WebElement inputTeamName;

    @FindBy(css = "div[data-test-id='header-create-team-type-input']")
    private WebElement dropDownTeamType;

    @FindBy(css = "textarea[id$='create-team-org-description']")
    private WebElement inputTeamDescription;

    @FindBy(css = "button[data-test-id='header-create-team-submit-button']")
    private WebElement btnContinue;

    @FindBy(css = "a[data-test-id='show-later-button']")
    private WebElement btnThisLater;


    private Team team;

    /**
     * Constructor.
     */
    public TeamPage() {
        team = new Team();
    }

    /**
     * Method to create a team which parameters of the user.
     * @param dataTable
     */
    public void createTeam(final Map<String, String> dataTable) {
        team.processInformation(dataTable);
        WebDriverHelper.waitUntil(inputTeamName);
        WebDriverHelper.setElement(inputTeamName, team.getName());
        WebDriverHelper.clickElement(dropDownTeamType);
        By dropDownOption = By.xpath("//*[contains(text(),'" + team.getType() + "')]");
        WebDriverHelper.clickElement(dropDownOption);
        WebDriverHelper.setElement(inputTeamDescription, team.getDescription());
        WebDriverHelper.clickElement(btnContinue);
        WebDriverHelper.waitUntil(btnThisLater);
        WebDriverHelper.clickElement(btnThisLater);
    }

    /**
     * Method wait to load BoardPage.
     */
    public void waitLoadPage() {
        WebDriverHelper.waitUntil(inputTeamName);
    }
}
