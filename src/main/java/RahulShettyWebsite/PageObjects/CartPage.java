package RahulShettyWebsite.PageObjects;

import RahulShettyWebsite.AbstractComponents.AbstractComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponents {
    WebDriver driver;
    public CartPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='cartSection']/h3")
    private List<WebElement> cartProducts;

    @FindBy(xpath = "//button[text()='Checkout']")
    private WebElement checkoutButton;

    @Step("Verify Product is Displayed")
    public boolean verifyProductDisplay(String productName) {
        boolean result = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
        return result;
    }

    @Step("Navigate to Checkout Page")
    public CheckoutPage goToCheckout() {
        checkoutButton.click();
        return new CheckoutPage(driver);
    }

}
