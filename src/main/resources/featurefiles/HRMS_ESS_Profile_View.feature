Feature: View My Profile functionality
  As the user navigates to the Profile Scree, the users profile details must be displayed. This consists of the user name, First Name, Last Name, Email Address and Address Details.

  Scenario: When the user clicks on the profile link, the user is directed to view my profile page.
    Given A user completes login to the HRMS application with username "<rahul>" and password "<rahul>"
    When The user clicks on the profile link from the side bar menu
    Then The user is directed to View My Profile Page.

  Scenario Outline: When the user is in the view my profile page, the user is able to see his or her profile details
    Given A user is at the View My Profile Page after logging in with "<username>" and "<password>"
    Then The uid label and the value "<username>" is displayed
    And The First Name label and the value "<firstname>" is displayed
    And The Last Name label and the value "<lastname>" is displayed
    And The Email label and the value "<email>" is displayed
    And The Address label is displayed
    And The value for Address Line One is displayed as "<addressline1>"
    And The value for Address Line Two is displayed as "<addressline2>"
    And The value for Address Line Three is displayed as "<addressline3>"

    Examples:
    |username|password|firstname|lastname|email|addressline1|addressline2|addressline3|
    |rahul   |rahul   |Rahul    |Panot   |rahul@test.com|Tetgs|Test Address Line 2|Test Address Line 3|
    |rahulsmanager|rahulsmanager|TBD|TBD |TBD           |TBD  |TBD                |TBD                |




