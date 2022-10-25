


@tag
Feature: Log in on Login Page
  I want to use this template for my feature file
  
	Background:
	Given I landed on Login Page
 
  @Regression
  Scenario Outline: Log in with restricted account and nonrestricted account
  
    Given Enter username <username> and password <password>
    When I click on Login button
    Then Homepage is displayed
    
    Examples: 
      | username                    | password |
      | restricteduser@gmail.com    |	1232323  | 
      | nonrestricteduser@gmail.com |	348478   | 
