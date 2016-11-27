Feature: Login Screen Features

  Check the login screen has the fields to enter the user name , password , has remember me feature option as well as the
  Log in button for the user to sign in.
  The Welcome username as well as the view menu are not visible until the user signs in.

  Scenario: User is presented with a login screen on launching the application
    When A user launches the HRMS Appplication
    Then The user is directed to the login screen
    And The screen contains field to enter User Name
    And The screen contains field to enter Password
    And The screen contains a remember me check box
    And The screen contains a Log in button
    And The navigation Bar does not show welcome user name and view menu.