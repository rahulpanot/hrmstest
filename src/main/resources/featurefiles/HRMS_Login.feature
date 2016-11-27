Feature: Login Functionality.

  Users having manager role, employee role should be able to login successfully to the HRMS application
  using their user id and password. Once successfully authenticated they will be directed to the employee self service
  page. Providing a wrong user id and/or password will throw error message and will prevent the user to login to the application.

  Scenario: User is presented with a login screen on launching the application
    When A user launches the HRMS Appplication
    Then The user is directed to the login screen
    And The screen contains field to enter User Name
    And The screen contains field to enter Password
    And The screen contains a remember me check box
    And The screen contains a Log in button
    And The navigation Bar is empty except for the HRMS brand text.


  Scenario: Successful Login of an employee
    Given A user login to HRMS application with username <"rahul"> and password <"rahul">
    Then The user is directed to the Employee Self Service Page
    And A Welcome, <"rahul"> text is present in the right top corner of the navigation bar.

  Scenario: Successful Login of a manager
    Given A user login to HRMS application with username <"username"> and password <"password">
    Then The user is directed to the Employee Self Service Page
    And A Welcome, <"username"> text is present in the right top corner of the navigation bar.


  Scenario: UnSuccessful Login when using a unknown user id
    Given A user login to HRMS application with username <"username"> and password <"password">
    Then The user is directed to the login screen
    And The navigation Bar is empty except for the HRMS brand text.
    And The following error messages is displayed in the screen
    |"Unknown user"|

  Scenario: UnSuccessful Login when using a unknown user id
    Given A user login to HRMS application with username <"username"> and password <"password">
    Then The user is directed to the login screen
    And The navigation Bar is empty except for the HRMS brand text.
    And The following error messages is displayed in the screen
      |"Unknown user"|





