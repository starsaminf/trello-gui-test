package com.trello.trello.stepdefs;

import com.trello.trello.entities.Context;
import com.trello.trello.ui.pages.TeamPage;
import com.trello.trello.ui.pages.components.LeftMenuComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.Map;

/**
 * TeamSteps class.
 */
public class TeamSteps {

    private Context context;
    private LeftMenuComponent leftMenu;
    private TeamPage teamPage;

    /**
     * Inject the Context class.
     * @param cont
     */
    public TeamSteps(final Context cont) {
        this.context = cont;
    }

    /**
     * The method created a leftMenuComponent instance.
     */
    @When("I navigate to create team button")
    public void iNavigateToCreateTeamButton() {
        leftMenu = new LeftMenuComponent();
        leftMenu.waitLoadPage();
        leftMenu.clickBtnTeams();
    }

    /**
     * The method created a TeamPage instance and creates a team.
     * @param dataTable
     */
    @And("I create a team with the following information")
    public void iCreateATeamWithTheFollowingInformation(final Map<String, String> dataTable) {
        teamPage = new TeamPage();
        teamPage.waitLoadPage();
        teamPage.createTeam(dataTable);
    }
}
