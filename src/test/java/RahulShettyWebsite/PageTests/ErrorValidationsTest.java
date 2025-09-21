package RahulShettyWebsite.PageTests;

import RahulShettyWebsite.PageObjects.*;
import RahulShettyWebsite.TestComponents.BaseTest;
import RahulShettyWebsite.TestComponents.Retry;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationsTest extends BaseTest {

    @Description("Validate that user can't login with invalid data")
    @Severity(SeverityLevel.CRITICAL)
    @Test (groups = {"Error Handling"}, retryAnalyzer = Retry.class)
    public void loginErrorValidation() throws IOException {
        landingPage.loginSteps("mazen@RahulShettyAcademy.com", "Ab1##");
        Assert.assertEquals(landingPage.getErrorMessage(),"Incorrect email or password.");
    }

    @Description("Validate that user's order contains selected products")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void productErrorValidation() {
        String productName = "ZARA COAT 3";
        ProductCatalouge productCatalouge = landingPage.loginSteps("mazen@gmail.com", "Iamking@000");
        productCatalouge.addProductToCart(productName);
        CartPage cartPage = productCatalouge.goToShoppingCart();
        Assert.assertFalse(cartPage.verifyProductDisplay("ZARA COAT 33"));
    }
}
