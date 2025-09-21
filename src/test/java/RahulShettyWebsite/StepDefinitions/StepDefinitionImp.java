package RahulShettyWebsite.StepDefinitions;

import RahulShettyWebsite.PageObjects.*;
import RahulShettyWebsite.TestComponents.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

public class StepDefinitionImp extends BaseTest {

public LandingPage landingPage;
public ProductCatalouge productCatalouge;
public CartPage cartPage;
public ConfirmationPage confirmationPage;

    @Given("User navigates to Ecommerce page")
    public void user_Navigates_To_Ecommerce_Page () throws IOException {
        landingPage = launchApplication();
    }

    @Given("^Logged in with username (.*) and password (.*)$")
    public void logged_in_username_and_password (String username ,String password) {
        productCatalouge = landingPage.loginSteps(username, password);
    }

    @When("^Add product (.*) to cart$")
    public void add_product_to_cart (String productName) {
        productCatalouge.addProductToCart(productName);
    }


    @And ("^Checkout (.*) and submit the order$")
    public void checkout_and_submit_order (String productName) {
        cartPage = productCatalouge.goToShoppingCart();
        Assert.assertTrue(cartPage.verifyProductDisplay(productName));
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("ind");
        confirmationPage = checkoutPage.submitOrder();
    }

    @Then("the confirmation message is displayed on confirmation page")
    public void message_displayed_on_confirmationPage() {
        Assert.assertTrue(confirmationPage.getConifrmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @When("the error message is displayed on login page")
    public void errorMessage_displayed_on_loginPage() {
        Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
    }

    @After
    public void user_closeBrowser () {
        driver.quit();
    }

}
