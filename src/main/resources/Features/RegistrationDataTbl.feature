#@All
Feature: User registration

  @Registration @Skip
  Scenario: user registration with different data
    Given user is on registration page
    When user enters following user details
      | bablu | chaudhary | babch@gmail.com | 687687678 | Mumbai |
      | sonia | chaudhary | sonch@gmail.com | 547758578 | Delhi  |
      | mannu | gangster  | manG@gmail.com  | 455435656 | Dubai  |
    Then user registration should be successful


  @Registration
  Scenario: user registration with different data with columns
    Given user is on registration page
    When user enters following user details with columns
      | firstName | lastName  | emailId         | phoneNumber | city   |
      | bablu     | chaudhary | babch@gmail.com | 687687678   | Mumbai |
      | sonia     | chaudhary | sonch@gmail.com | 547758578   | Delhi  |
      | mannu     | gangster  | manG@gmail.com  | 455435656   | Dubai  |
    Then user registration should be successful