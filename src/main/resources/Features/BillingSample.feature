@All
Feature: Calculate billing amount

  @Billing
  Scenario Outline: Billing amount
    Given user is on billing page
    When user enters billing amount "<billingAmount>"
    And user enters tax amount "<taxAmount>"
    And user clicks on calculate button
    Then it gives the final amount "<finalAmount>"

    Examples:
      | billingAmount | taxAmount | finalAmount |
      | 1000          | 10        | 1010        |
      | 500           | 20        | 520         |
      | 100           | 5.5       | 105.5       |