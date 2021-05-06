package stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationSteps {

    @Given("^Standard user goes to the swaglabs landing page$")
    public void standard_user_goes_to_the_swaglabs_landing_page() {
        Hooks.driver().get("https://www.saucedemo.com/");
    }

    @When("^Standard user enters standard user credentails$")
    public void standard_user_enters_standard_user_credentails() {
        
    }

    @When("^Standard user clicks LOGIN button$")
    public void standard_user_clicks_LOGIN_button()  {
       
    }

    @Then("^Standard user can see product home page$")
    public void standard_user_can_see_product_home_page() {
       
    }
}
