package RahulShettyWebsite.PageObjects;

import RahulShettyWebsite.AbstractComponents.AbstractComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalouge extends AbstractComponents {
    WebDriver driver ;

    public ProductCatalouge (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".col-lg-4")
    private List<WebElement> products ;

    private By productsBy = By.cssSelector(".col-lg-4");
    private By productBy = By.cssSelector("b");
    private By addToCartBy = By.cssSelector(".btn.w-10.rounded:last-of-type");
    private By toastMessage = By.cssSelector("#toast-container");
    private By blackScreen = By.cssSelector(".ng-tns-c31-0.ng-star-inserted");
    private By shoppingCartBy = By.xpath("//button[@routerlink='/dashboard/cart']");

    @Step("Get Products List")
    public List<WebElement> getProductList () {
        waitForElementToBeVisible(productsBy);
        return products;
    }

    @Step("Get Choosen Product")
    public WebElement getProduct (String productName ) {
        WebElement product = getProductList().stream().filter(s->s.findElement(productBy).getText().equals(productName)).findFirst().orElse(null);
        return product;
    }

    @Step("Click on add to cart")
    public void addToCart (String productName ) {
        getProduct(productName).findElement(addToCartBy).click();
    }

    @Step("Add Product To Cart")
    public void addProductToCart(String productName){
        getProductList();
        getProduct(productName);
        addToCart(productName);
        waitForElementToBeVisible(toastMessage);
        waitElementToBeINVisible(blackScreen);
    }


}
