Feature:Edit My Profile Functionality

    Scenario: Edit Profile Navigation
      As the user clicks on the edit button the user is navigated to the Edit Profile Screen.
      Given A user is at the View My Profile Page after logging in with "rahul" and "rahul"
      When The user clicks on edit button
      Then The user is directed to edit my profile page of "rahul"

    Scenario Outline: Edit Profile Functionality
      As the user clicks on the edit button on the view profile screen, the user is directed to the edit profile screen
      where he/she is given option to enter new values for the profile attributes. On clicking the Update Button
      the user is directed back to the View Profile screen where the values are updated.

      Given the user is in the edit profile screen after logging in as "<username>" and "<password>"
      When The First Name value "<firstname>" is entered
      And The Last Name  value "<lastname>" is entered
      And The Email value "<email>" is entered
      And The value for Address Line one "<addressline1>"is entered
      And The value for Address Line Two "<addressline2>"is entered
      And The value for Address Line Three "<addressline3>"is entered
      And The user click on the update button
      Then The user is directed to View My Profile Page.
      And The First Name label and the value "<firstname>" is displayed
      And The Last Name label and the value "<lastname>" is displayed
      And The Email label and the value "<email>" is displayed
      And The value for Address Line One is displayed as "<addressline1>"
      And The value for Address Line Two is displayed as "<addressline2>"
      And The value for Address Line Three is displayed as "<addressline3>"

    Examples:
    |username|password|firstname|lastname|email|addressline1|addressline2|addressline3|
      |rahul|rahul|Rahul|Panot|rahul@test.com|Infopark|Kakkanad|Kochi|