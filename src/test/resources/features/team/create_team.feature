Feature: Create Team

  In order to create a new team in trello
  Authenticated as valid user of Trello

  Background: Sets authentication
    Given I am logged with valid credentials

  @deleteTeam
  Scenario: Creates a new team without members
    When I navigate to create team button
    And I create a team with the following information
      | Name        | Team GUI UNIQUE_ID |
      | Type        | Marketing          |
      | Description | Team description   |
    Then I should see team name in Teams section