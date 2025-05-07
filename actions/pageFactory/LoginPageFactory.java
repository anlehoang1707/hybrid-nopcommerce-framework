package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePageFactory{

    private WebDriver driver;

    public LoginPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id = 'Email']")
    private WebElement emailTextBox;

    @FindBy(xpath= "//input[@id = 'Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath = "//button[contains(@class,'login-button')]")
    private WebElement loginButton;

    public void inputToEmailTextBox(String emailAddress) {
        sendkeyToElement(emailTextBox,emailAddress);
    }

    public void inputToPasswordTextBox(String password) {
        sendkeyToElement(passwordTextBox,password);
    }

    public void clickToLoginButton() {
        clickToElement(loginButton);
    }
}
