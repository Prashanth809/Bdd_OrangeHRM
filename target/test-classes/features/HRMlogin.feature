Feature: orangeHRM
Background: open browser
Given i open "chrome" browser
When user launch site

 @smoke
  Scenario: Validating if all the elements in the Login Page are present correctly
    #Then I should see the Login Header in the Login Page
    #And I should see the Username and Password Headers
    #And I should see the Username and Password fields
    #And I should see the Forgot Password Link and all the footer elements
    #And I should see the Login button
    Then user enters the validcredentials
    And user cliks on submit button
    And close site
    
   


