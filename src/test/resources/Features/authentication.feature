@login
Feature: Testing login and logout pages

  Background: 
    Given Launch the browser and open the respective url

  @negative
  Scenario: Validating with invalid credentials and error message
    Given User enters credentials as "acjdvi" and "invalid"
    And Validate the error message

  @positive
  Scenario: Successful login and login message
    Given User enters credentials as "student" and "Password123"
    And Validate the login message as "Logged In Successfully"

  @positive @logout
  Scenario: Successful logut
    Given User enters credentials as "student" and "Password123"
    And User clicks on logout button and returns to home page
    