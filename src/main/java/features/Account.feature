Feature: Opportunity scenarios

Background: Download WebDriver
    Given I login to Salesforce application
Scenario Outline: Create Opportunity
    Given I click on toggle button
    And I click on View All button
    And I search for <search>
Examples:
|search|
|sales|