Feature: Search and place the order for products

Scenario: Search experience for product search in both home and offers page

Given User in on GreenCart Landing page
When user searched with shortname "<ProductShortName>" and extracted actual name of product
Then user searched for "<ProductShortName>" shortname in offers page 
And validate product name in offers page matches with Landing page
Examples:
|ProductShortName|
|Tom|
