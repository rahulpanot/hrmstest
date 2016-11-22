Feature: Test HrmsEssProfileTest
  Scenario: Open the Home page
    Given I am logged in as an employee
    Feature:Test login Funtionality
      Scenario: login funtionality
        When:I enter Username as "username"and Password"password"
        Then login should be successful
        |username|password|
        |rahul   |rahul   |
        |xxxx    |xxxx    |
        Feature:SideBarButton
          Scenario: check the SideBarButton
            When:I click profile
            Then:view my profile page should open



