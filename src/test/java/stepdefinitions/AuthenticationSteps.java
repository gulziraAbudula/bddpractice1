package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AuthenticationSteps {

    private void pause(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException ignore) {
            // do nothing
        }
    }

    @Given("^Standard user goes to the swaglabs landing page$")
        public void standard_user_goes_to_the_swaglabs_landing_page() {
        Hooks.driver().get("https://www.saucedemo.com/");
        }

    @When("^Standard user enters standard user credentails$")
    public void standard_user_enters_standard_user_credentials() {
        By loc_user_name = By.id("user-name");
        pause(2);
        By loc_pass = By.id("password");
        pause(2);
        WebElement emailInput = Hooks.driver().findElement(loc_user_name);
        WebElement passInput = Hooks.driver().findElement(loc_pass);
        emailInput.sendKeys("standard_user");
        passInput.sendKeys("secret_sauce");
    }

    @When("^Standard user clicks LOGIN button$")
    public void standard_user_clicks_LOGIN_button() {
        By loc_log_bttn = By.id("login-button");
        WebElement loginBttn = Hooks.driver().findElement(loc_log_bttn);
        pause(2);
        loginBttn.click();
        pause(2);
    }

    @Then("^Standard user can see product home page$")
    public void standard_user_can_see_product_home_page() {
        By loc_product_banner = By.xpath("//div[@id='header_container']//span[@class='title']");
        WebElement productBanner = Hooks.driver().findElement(loc_product_banner);
        boolean result = productBanner.isDisplayed();
        Assert.assertTrue(result);
    }
}
