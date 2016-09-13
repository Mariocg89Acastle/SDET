Feature: Sales staff get a regular monthly fixed base salary and a monthly bonus 

  Scenario: Sales staff get a regular monthly fixed base salary on last weekday
    Given Employee within department "staff"
    When The current month ends on weekday
    Then The employee get paid the salary the last day of the month
    
  Scenario: Sales staff get a regular monthly fixed base salary on last weekday
    Given Employee within department "staff"
    When The current month ends on weekend
    Then The employee get paid the salary the last Friday of the month

  Scenario: Sales staff get a monthly bonus on 15th
    Given Employee within department "staff"
    When The 15th of this month is on weekday
    Then The employee get paid the bonus the 15th of the month

  Scenario: Sales staff get a monthly bonus on next Wednesday after 15th
    Given Employee within department "staff"
    When The 15th of this month is on weekend
    Then The employee get paid the bonus the first Wednesday after the 15th.