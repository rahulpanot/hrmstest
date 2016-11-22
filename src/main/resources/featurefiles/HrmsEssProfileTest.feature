Feature: Test HrmsEssProfileTest
  Scenario Outline: Login Functionality
    Given I am in the HRMS login screen
    When I enter Username as "<username>" and Password as "<password>" and click on the login button
    Then login should be successful

Examples:
    |username|password|
    |rahul|rahul|

