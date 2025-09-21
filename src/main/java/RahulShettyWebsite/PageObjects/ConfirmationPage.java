package RahulShettyWebsite.PageObjects;

import RahulShettyWebsite.AbstractComponents.AbstractComponents;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractComponents {
    WebDriver driver;
    public ConfirmationPage (WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hero-primary")
    private WebElement confirmationMessage;

    @Step("Get Conifrmation Message")
    public String getConifrmationMessage(){
        return confirmationMessage.getText();
    }
}
