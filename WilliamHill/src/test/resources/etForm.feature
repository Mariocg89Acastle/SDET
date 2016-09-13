Feature: Exploratory Test for the "Old money to new" website. http://www.nationalarchives.gov.uk/currency/default0.asp#mid

  Scenario: The user try to convert £1 from 2000
    Given The user is browsing the website
    And The user leave 1 on the second pound field
    When The user try to select the year 2000 with the second year selector
    And The user try to submit the form
    Then The website should send the form correctly

  Scenario: The user try to convert £1 from 2003
    Given The user is browsing the website
    And The user leave 1 on the second pound field
    When The user try to select the year 2003 with the second year selector
    And The user try to submit the form
    Then The year 2003 is not available
    
  Scenario: The user try to convert £1 without any year selected
    Given The user is browsing the website
    And The user leave 1 on the second pound field
    When The user try to submit the form
    And The user leave both year fields blank
    Then The website will throw an error