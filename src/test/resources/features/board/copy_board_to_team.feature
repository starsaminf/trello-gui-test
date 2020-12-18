Feature: Create Board

  In order to copy a board to team
  Authenticated as valid user of Trello

  Background: Sets authentication
    Given I am logged with valid credentials

  @createTeam @deleteBoard @deleteTeam
  Scenario: Copy a Board to Team "Team test".
    When I create a new Board with name "New Board team"
    And I copy this Board to Team with same title Board
    Then I should verify that this Board belongs to Team
    When I go to the Home page
    Then I should see the Board in the Team to test section