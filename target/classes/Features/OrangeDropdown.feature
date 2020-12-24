Feature: Check dropdown for Orange HRM site

  Background: User logging in
    Given user gets into orange hrm site

  Scenario: Entering values in industry and country dropdown
    When user makes different selection in industry and country dropdown
    Then test is successful