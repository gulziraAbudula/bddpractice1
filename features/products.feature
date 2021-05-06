## This is a practice feature file

Feature: Swaglabs products page functionality

    @editing
    Scenario: User can see correct product name and price for Back-pack and Bolt T-shirt
        Given Standard user goes to the swaglabs landing page
        When Standard user enters standard user credentails
        And Standard user clicks LOGIN button
        Then user should be able to see following product information
            | Sauce Labs Backpack     | $29.99 |
            | Sauce Labs Bolt T-Shirt | $15.99 |

    @editing
    Scenario Outline: Only allowed user information can be entered on checkout info page
        Given Standard user goes to the swaglabs landing page
        When Standard user enters standard user credentails
        And Standard user clicks LOGIN button
        And Standard user clicks first prodct ADD TO CART button
        And Goes to the Your Cart page and clicks CHECKOUT button
        Then On the CHECKOUT page user can enter "<first name>" and "<last name>" and "<zipcode>" of the allowed User


    Example: Allowed users
            | first name | last name | zipcode |
            | John       | Smith     | 20176   |
            | Allen      | Duke      | 30982   |
            | Bob        | Tylor     | 29920   |



