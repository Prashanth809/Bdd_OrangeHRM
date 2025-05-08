Feature: orangeHRM
Background: open browser
Given i open "chrome" browser
When user launch site

 @smoke
  Scenario: Validating if all the elements in the Login Page are present correctly
    Then I should see the Login Header in the Login Page
    And I should see the Username and Password Headers
    And I should see the Username and Password fields
    And I should see the Forgot Password Link and all the footer elements
    And I should see the Login button
    Then user enters the validcredentials
    And user cliks on submit button
    And close site
    
    


#Scenario Outline: Add Employe
#Then user enters the validcredentials
#And user cliks on submit button
#When user clicks on PIM
#Then user clicks on AddEmployee
#Then user enters the "<firstname>" and "<lastname>"
#Then user click on save button
#When user selects India from the nationality dropdown
#Then user selects the marital status is unmarried from the dropdown
#When I check if the radio button is visible and enabled
#And I select the radio button
#Then I should see that the radio button is selected
#
#Examples:
#|firstname|lastname|
#|prashanth|rao     |


