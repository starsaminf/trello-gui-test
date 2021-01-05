Feature: Login for trello

  In order to login in trello

  Scenario: I am trying login with the valid credentials
    Given I am on the login page
    When  I set username and password
    Then  I should view the "boards" suffix in the URL

  Scenario: I am trying login with the wrong credentials
    Given I am on the login page
    When  I set username and password with fields empty
    Then  I should view the "login" suffix in the URL
