Feature: Test HrmsEssProfileTest
  Scenario Outline: Login Functionality
    Given I am in the HRMS login screen
    When I enter Username as "<username>" and Password as "<password>" and click on the login button
    Then I am greeted to the welcome employee selfservice page
    When I click on Profile link on the side menu bar
    Then I am in the Employee Profile Page



Examples:
    |username|password|
    |rahul|rahul|
 #   |xxx|xxx|





