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
    Given A user launches the HRMS Appplication
    Given A user login to HRMS application with username <"rahul"> and password <"rahul">
    Then The user is directed to the Employee Self Service Page
    And A Welcome, <"rahul"> text is present in the right top corner of the navigation bar.
    And The view selection menu is selected with <"Employee Self Service"> in the navigation bar.

  Scenario: Successful Login of a manager
    Given A user launches the HRMS Appplication
    Given A user login to HRMS application with username <"rahulsmanager"> and password <"rahulsmanager">
    Then The user is directed to the Employee Self Service Page
    And A Welcome, <"rahulsmanager"> text is present in the right top corner of the navigation bar.
    And The view selection menu is selected with <"Employee Self Service"> in the navigation bar.


  Scenario: UnSuccessful Login when using a unknown user id
    Given A user launches the HRMS Appplication
    Given A user login to HRMS application with username <"xxxx"> and password <"yyyy">
    Then The user is directed to the login screen
    And The navigation Bar is empty except for the HRMS brand text.
    And The following error message is displayed in the screen
    |Unknown user|

  Scenario: UnSuccessful Login when using a known user id but wrong password
    Given A user launches the HRMS Appplication
    Given A user login to HRMS application with username <"rahul"> and password <"xxx">
    Then The user is directed to the login screen
    And The navigation Bar is empty except for the HRMS brand text.
    And The following error message is displayed in the screen
    |Bad Credentials. Your username password combination is invalid|





