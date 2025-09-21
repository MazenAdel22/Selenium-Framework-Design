package RahulShettyWebsite.PageTests;

import RahulShettyWebsite.TestComponents.DataProviderImp;
import RahulShettyWebsite.PageObjects.*;
import RahulShettyWebsite.TestComponents.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class SubmitOrderTest extends BaseTest {

    String productName = "ZARA COAT 3";

    @Description ("End-to-End Test")
    @Severity (SeverityLevel.CRITICAL)
    @Test (dataProviderClass = DataProviderImp.class, dataProvider = "getData", groups = {"Purchase"})
    public void submitOrder(HashMap<String,String> input) throws IOException {
        ProductCatalouge productCatalouge = landingPage.loginSteps(input.get("email"), input.get("password"));
        productCatalouge.addProductToCart(input.get("productName"));
        CartPage cartPage = productCatalouge.goToShoppingCart();
        Assert.assertTrue(cartPage.verifyProductDisplay(input.get("productName")));
        CheckoutPage checkoutPage = cartPage.goToCheckout();
        checkoutPage.selectCountry("ind");
        ConfirmationPage confirmationPage = checkoutPage.submitOrder();
        Assert.assertTrue(confirmationPage.getConifrmationMessage().equalsIgnoreCase("THANKYOU FOR THE ORDER."));
    }

    @Description ("Validate that user's order exsits in order page ")
    @Severity (SeverityLevel.CRITICAL)
    @Test (dependsOnMethods = {"submitOrder"})
    public void checkOrder() throws IOException {
        ProductCatalouge productCatalouge = landingPage.loginSteps("mazen@RahulShettyAcademy.com", "Ab1##Ab1##");
        OrderPage orderPage = productCatalouge.goToOrderPage();
        Assert.assertTrue(orderPage.verifyProductDisplay(productName));
    }

}