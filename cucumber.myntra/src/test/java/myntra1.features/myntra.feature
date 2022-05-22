Feature: Item added to Mybag
Scenario: select item and adding to mybag and check add or not

Given myntra app
Then select item size
Then add to bag
Then check item will add or not
And Closebrowser
