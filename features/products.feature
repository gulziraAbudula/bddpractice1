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
