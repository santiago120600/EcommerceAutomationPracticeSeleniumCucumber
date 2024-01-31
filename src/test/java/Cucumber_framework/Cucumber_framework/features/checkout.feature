Feature: Search and add items to the cart

@Checkout
Scenario Outline: Search experience for product search in both home and offers page

Given User in on GreenCart Landing page
When user searched with shortname "<ProductName>" and extracted actual name of product
Then add <productQuantity> items to cart
And navigate to checkout page
And validate apply and place order buttons are displayed 
Examples:
|ProductName|productQuantity|
|Tomato|3|


 