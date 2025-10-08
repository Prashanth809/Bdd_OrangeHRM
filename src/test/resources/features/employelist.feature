Feature: employelist

  Background: open browser
    Given i open "chrome" browser
    When user launch site
    Then user enters the validcredentials
    And user cliks on submit button
    
    Scenario Outline: add employee
    When user clicks on PIM
    Then user clicks on AddEmployee
    Then user enters the "<firstname>" and "<lastname>"
    Then user click on save button
    Then employelist page should be displayed with employee personal details
    Then User should see first name, last name
    Then user enter the "<Licensenumber>"
        
    Examples:
      |firstname | lastname | Licensenumber|
      |prashanth | test     | 257406       |
      
  
