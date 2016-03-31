Feature: Login to user account
  As a user
  I want to login to user account
  So that I can use account services


  Scenario: Testing Login with correct credentials
    Given I load the ubluknetremit page
    And I am on Homepage
    And I should see homepage loaded successfully
    When I click on pkr_button
    Then I am on Loginpage
    And I should see Loginpage loaded successfully
    And element user_email_field is visible
    And element user_password_field is visible
    When I entered username in user_email_field
    And I entered password in user_password_field
    And I click on submit_button
    Then I am on SubscriptionPage
    And the following elements are visible
      | accountTypePanel |
      |   bank_account   |
      | account_btn_next |
    And I click on bank_account
    When I click on account_btn_next
    Then the following elements are visible
      | beneficiary_panel    |
      | existing_beneficiary |
      | beneficiary_btn_next |
    And I click on existing_beneficiary
    When I click on beneficiary_btn_next
    Then I should see SubscriptionPage loaded successfully
    And I should see selected_product_type containing text "Credit beneficiary account"
    And I click on btn_logout

  Scenario: Testing Login with incorrect credentials
    Given I load the ubluknetremit page
    And I am on Homepage
    And I should see homepage loaded successfully
    When I click on pkr_button
    Then I am on Loginpage
    And I should see Loginpage loaded successfully
    And element user_email_field is visible
    And element user_password_field is visible
    When I entered username in user_email_field
    And I enter "password01" in user_password_field
    And I click on submit_button
    Then I should see login_error_msg containing text "Your Login Information is Incorrect"
    And I should see varification_image loaded successfully