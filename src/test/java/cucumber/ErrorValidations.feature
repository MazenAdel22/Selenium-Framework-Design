Feature: As a user , i want to login with valid username and password
  Background:
    Given User navigates to Ecommerce page

  @ErrorValidation
  Scenario Outline: Negative Test of Login feature
    Given Logged in with username <name> and password <password>
    When the error message is displayed on login page

    Examples:
      |            name              |  password  |
      | mazen@RahulShettyAcademy.com | Ab1##      |

