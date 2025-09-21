Feature: As a user , i want to purchase order from E-commerce Website
  Background:
    Given User navigates to Ecommerce page

  @Regression
  Scenario Outline: Positive Test of submitting the order
    Given Logged in with username <name> and password <password>
    When Add product <productName> to cart
    And Checkout <productName> and submit the order
    Then the confirmation message is displayed on confirmation page

    Examples:
     |            name              |  password  | productName |
     | mazen@RahulShettyAcademy.com | Ab1##Ab1## | ZARA COAT 3 |

