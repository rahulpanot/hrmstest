Feature: Login Functionality.

  Users having manager role, employee role should be able to login successfully to the HRMS application
  using their user id and password. Once successfully authenticated they will be directed to the employee self service
  page. Providing a wrong user id and/or password will throw error message and will prevent the user to login to the application.


 Background:
   Given A user launches the HRMS Appplication

  Scenario: Successful Login of an employee
    Given A user login to HRMS application with username <"rahul"> and password <"rahul">
    Then The user is directed to the Employee Self Service Page
    And A Welcome, <"rahul"> text is present in the right top corner of the navigation bar.
    And The view selection menu is selected with <"Employee Self Service"> in the navigation bar.

  Scenario: Successful Login of a manager
    Given A user login to HRMS application with username <"rahulsmanager"> and password <"rahulsmanager">
    Then The user is directed to the Employee Self Service Page
    And A Welcome, <"rahulsmanager"> text is present in the right top corner of the navigation bar.
    And The view selection menu is selected with <"Employee Self Service"> in the navigation bar.


  Scenario: UnSuccessful Login when using a unknown user id
    Given A user login to HRMS application with username <"xxxx"> and password <"yyyy">
    Then The user is directed to the login screen
    And The navigation Bar does not show welcome user name and view menu.
    And The following error message is displayed in the screen
    |Unknown user|

  Scenario: UnSuccessful Login when using a known user id but wrong password
    Given A user login to HRMS application with username <"rahul"> and password <"xxx">
    Then The user is directed to the login screen
    And The navigation Bar does not show welcome user name and view menu.
    And The following error message is displayed in the screen
    |Bad Credentials. Your username password combination is invalid|





