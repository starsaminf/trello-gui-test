Feature: Create Board

  In order to create a board in trello
  Authenticated as valid user of Trello

  Background: Sets authentication
    Given I am logged with valid credentials

  @deleteBoard
  Scenario: Verify board is created with minimum required.
    When I create a new Board with name "New Board test"
    Then I should see the name of Board in BoardPage
    When I go to the Home page using top menu
    Then I should see the Board in the Recently Viewed section
    And I should see the Board in the Personal Boards section
