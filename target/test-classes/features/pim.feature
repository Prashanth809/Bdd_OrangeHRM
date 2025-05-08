@regression
Feature: pimmodule

  Background:
    Given i open "chrome" browser
When user launch site
Then user enters the validcredentials
And user cliks on submit button
When user clicks on PIM

@csscolor
Scenario: Check CSS properties of navigation bars
    Then the user should verify the CSS color and background color before action on "AddEmployee" navbar
    And the user mouseover to "AddEmployee" navigation bar
    Then the user verifies the CSS color and background color of the "AddEmployee" navigation bar after mouseover
    
    
@AddEmployee    
Scenario Outline: Add Employe
Then user clicks on AddEmployee
Then user enters the "<firstname>" and "<lastname>"
Then user click on save button
When user selects India from the nationality dropdown
Then user selects the marital status is unmarried from the dropdown
When I check if the radio button is visible and enabled
And I select the radio button
Then I should see that the radio button is selected

Examples:
|firstname|lastname|
|prashanth|rao     |
