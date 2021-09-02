@all @UITests
Feature: Login Test

  Background:
    Given Login page
    When I input 'username'
    And I input 'password'
    And I click login
    Then I wait loading main page

  @UI @E2E
  Scenario: Create user with affiliate manager type
    When I go to 'Users Management' page
    Then I wait loading create user button
    When I click create user button
    Then I wait loading create user page
    When I fill random data to 'email' field
    And I fill random data to 'password' field
    And I fill random data to 'name' field
    And I fill random data to 'surname' field
    And I select 'affiliate manager' radio button
    And I click on 'permission tab'
    And I click on 'general button'
    And I click on 'marketplace button'
    And I select 'deny' radio button
    And I click on 'users button'
    And I click on 'affiliates editing button'
    And I select 'deny' radio button
    And I click on 'read search field'
    And I fill defined data 'iktest' to 'input search' field
    And I click on 'first value from list'
    Then I click on 'save button'
    When I search created user
    Then I see created user with type 'Affiliate Manager'