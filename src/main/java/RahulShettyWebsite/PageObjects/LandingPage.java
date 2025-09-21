package RahulShettyWebsite.PageObjects;

import RahulShettyWebsite.AbstractComponents.AbstractComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponents {

    WebDriver driver ;

    public LandingPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy (id = "userEmail")
    private WebElement userEmail;

    @FindBy (id = "userPassword")
    private WebElement userPassword;

    @FindBy (id = "login")
    private WebElement submit;

    @FindBy (xpath = "//div[@class='toast-bottom-right toast-container']" )
    private WebElement errorMessage;

    @Step("Navigate to Landing Page")
    public void goToLandingPage() {
        driver.get("https://rahulshettyacademy.com/client/#/auth/login");
    }

    @Step("Login Feature")
    public ProductCatalouge loginSteps(String username , String password){
        userEmail.sendKeys(username);
        userPassword.sendKeys(password);
        submit.click();
        return new ProductCatalouge(driver);
    }

    @Step("Get Error Message")
    public String getErrorMessage (){
        waitForWebElementToBeVisible(errorMessage);
        return errorMessage.getText();
    }

}
