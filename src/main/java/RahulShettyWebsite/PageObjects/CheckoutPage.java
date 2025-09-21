package RahulShettyWebsite.PageObjects;

import RahulShettyWebsite.AbstractComponents.AbstractComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {
    WebDriver driver;
    public CheckoutPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (css = ".input.txt.text-validated:first-child")
    private WebElement country;

    @FindBy (xpath = "(//button[@type='button'])[2]")
    private WebElement selectCountry;

    @FindBy (css = ".btnn.action__submit.ng-star-inserted")
    private WebElement submit;

    @Step("Select Country")
    public void selectCountry (String countryName) {
        country.sendKeys(countryName);
        selectCountry.click();
    }

    @Step("Submit Order")
    public ConfirmationPage submitOrder() {
        submit.click();
        return new ConfirmationPage(driver);
    }
}
