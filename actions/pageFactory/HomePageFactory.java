package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageFactory extends BasePageFactory{
    private WebDriver driver;


    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@class = 'ico-register']")
    private WebElement registerLink;

    @FindBy(xpath = "//a[@class = 'ico-logout']")
    private WebElement logoutLink;

    @FindBy(xpath = "//a[@class = 'ico-login']")
    private WebElement loginLink;

    @FindBy(xpath = "//input[@id = 'Email']")
    private WebElement emailTextBox;

    @FindBy(xpath="//input[@id = 'Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath="//button[contains(@class,'login-button')]")
    private WebElement loginButton;

    @FindBy(xpath="//a[@class = 'ico-account']")
    private WebElement myAccountLink;

    public void waitForRegisterLinkToClick() {
        waitForElementClickable(driver,registerLink,15);
    }

    public void clickToRegisterLink() {
        clickToElement(registerLink);
    }
    public void waitForLogoutLinkToClick() {
        waitForElementClickable(driver,logoutLink,15);
    }

    public void clickToLogoutLink() {
        clickToElement(logoutLink);
    }

    public void waitForLoginLinkToClick() {
        waitForElementClickable(driver,loginLink,15);
    }

    public void clickToLoginLink() {
        clickToElement(loginLink);
    }

    public void clickToMyAccountLink() {
        clickToElement(myAccountLink);
    }

    public boolean isDisplayedMyAccountLink() {
        if (isControlDisplayed(myAccountLink)) {
            return true;
        } else
            return false;
    }

}
