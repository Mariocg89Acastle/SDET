Feature: As a payroll accountant, I can get a report of the dates when the salaries and bonuses need to be paid

  Scenario: Payroll Accountant will get the report of the dates when the salaries and bonuses need to be paid
    Given I am logged in with "Payroll Accountant" role
    When I try to get a report of salaries and bonuses
    Then I should get the report