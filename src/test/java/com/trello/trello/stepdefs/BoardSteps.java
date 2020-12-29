package com.trello.trello.stepdefs;

import com.trello.trello.entities.Context;
import com.trello.trello.ui.pages.BoardPage;
import core.selenium.WebDriverHelper;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BoardSteps {

    private Context context;
    private BoardPage board;

    /**
     * Constructor of a Board.
     * @param cont
     */
    public BoardSteps(final Context cont) {
        board = new BoardPage();
        this.context = cont;
    }

    /**
     * Create a new Board with a name.
     * @param nameBoard
     */
    @When("I create a new Board with name {string}")
    public void iCreateANewBoardWithName(final String nameBoard) {
        context.getBoard().setName(nameBoard);
        board.createBoard(nameBoard);
    }

    /**
     * Verify if the current url contains the slug name of the board.
     */
    @Then("I should see the name of Board in BoardPage")
    public void iShouldSeeTheNameOfBoardInBoardPage() {
        board.waitLoadBoardPage();
        String actual = WebDriverHelper.getCurrentUrl();
        String expected = context.getBoard().getSlugName();
        Assert.assertTrue(actual.contains(expected));
    }
}
