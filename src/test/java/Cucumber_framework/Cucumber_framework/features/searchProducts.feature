Feature: Search and place the order for products

Scenario: Search experience for product search in both home and offers page

Given User in on GreenCart Landing page
When user searched with shortname "Tom" and extracted actual name of product
Then user searched for same shortname in offers page to check if product exists
