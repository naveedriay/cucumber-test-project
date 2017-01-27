Feature: As a seller, I want to get all the selling record for today

  @regression
  Scenario: Fetch all the selling record for a Seller for today
    Given user is on internet
    When I load the ebay home page
    And I am on EbayHomepage
    Then I should see Ebayhomepage loaded successfully
    When I click on myEbayLink
    Then I am on EbayLoginpage
    And I should see EbayLoginpage loaded successfully
    When I entered username in user_email_field
    And I entered password in user_password_field
    And I click on submit_button