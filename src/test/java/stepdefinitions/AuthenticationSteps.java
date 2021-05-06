package stepdefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
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

    @Then("^user should be able to see following product information$")
    public void user_should_be_able_to_see_following_product_information(DataTable dataTable) {
        // Actual WebElements 
        WebElement firstProduct =  Hooks.driver().findElement(By.cssSelector("a#item_4_title_link > div"));
        WebElement firstProductPrice = Hooks.driver().findElement(By.xpath("(//div[@class='inventory_item_price'])[1]"));
        WebElement secondProduct =  Hooks.driver().findElement(By.cssSelector("a#item_1_title_link > div"));
        WebElement secondProductPrice =Hooks.driver().findElement(By.xpath("(//div[@class='inventory_item_price'])[3]"));;

        // Actual Texts 
        String actualFirstProductName = firstProduct.getText();
        String firstProdPrice = firstProductPrice.getText();
        String actualSecondProductName = secondProduct.getText();
        String secondProdPrice = secondProductPrice.getText();

        List<List<String>> table = dataTable.asLists(String.class);
        String expectedFirstProdTitle = table.get(0).get(0);
        String expectedFirstProdPrice = table.get(0).get(1);
        String expectedSecondProdTitle = table.get(1).get(0);
        String expectedSecondProdPrice = table.get(1).get(1);

        // Compare and assert
        Assert.assertEquals(expectedFirstProdTitle, actualFirstProductName);
        Assert.assertTrue(firstProdPrice.contains(expectedFirstProdPrice));

        Assert.assertEquals(expectedSecondProdTitle, actualSecondProductName);
        Assert.assertTrue(secondProdPrice.contains(expectedSecondProdPrice));

    }   
}
