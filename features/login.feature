
Feature: Swaglabs user authentication 

   
    Scenario: Standard user can login to Swaglabs and see the product home page 
        Given Standard user goes to the swaglabs landing page 
        When Standard user enters standard user credentails
        And Standard user clicks LOGIN button 
        Then Standard user can see product home page

    