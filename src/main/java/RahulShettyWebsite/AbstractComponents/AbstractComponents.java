package RahulShettyWebsite.AbstractComponents;

import RahulShettyWebsite.PageObjects.CartPage;
import RahulShettyWebsite.PageObjects.OrderPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {
    WebDriver driver;

    public AbstractComponents(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement shoppingCartHeader;

    @FindBy(xpath = "//button[@routerlink='/dashboard/myorders']")
    WebElement orderHeader;

    public void waitForElementToBeVisible (By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToBeVisible (WebElement findWebElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(findWebElement));
    }

    public void waitElementToBeINVisible (By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy)); //BlackScreen
    }

    @Step ("Navigate To Shopping Cart")
    public CartPage goToShoppingCart(){
        shoppingCartHeader.click();
        return new CartPage(driver);
    }

    @Step ("Navigate to Orders Page")
    public OrderPage goToOrderPage(){
        orderHeader.click();
        return new OrderPage(driver);
    }

}
