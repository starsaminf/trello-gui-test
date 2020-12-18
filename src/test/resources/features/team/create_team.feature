Feature: Create Team

  In order to create a new team in trello
  Authenticated as valid user of Trello

  Background: Sets authentication
    Given I am logged with a valid credentials

  @deleteTeam
  Scenario: Creates a new team without members
    When I navigate to create team button
    And I create a tea with the following information
      | teamDisplayName | teamTypeSelect |
      | Team Test       | Education      |
    And I Should click on "I'll do this later"
    Then I should see team name in Teams section