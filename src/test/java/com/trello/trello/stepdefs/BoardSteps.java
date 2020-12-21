package com.trello.trello.stepdefs;

import com.trello.trello.ui.pages.Board;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class BoardSteps {

    private Board board;

    public BoardSteps(){
        board = new Board();
    }

    @When("I create a new Board with name {string}")
    public void iCreateANewBoardWithName(String nameBoard) {
        board.createBoard(nameBoard);
    }

    @Then("I should see the name of Board in BoardPage")
    public void iShouldSeeTheNameOfBoardInBoardPage() {
        String actual = board.getCurrentUrl();
        System.out.println(actual);
        Assert.assertTrue(actual.contains("new-board-test"));
    }
}
