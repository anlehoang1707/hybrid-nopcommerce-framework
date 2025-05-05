package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.LoginPageUI;

public class LoginPageObject extends BasePage {
    private WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextBox(String emailAddress) {
        sendkeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX,emailAddress);
    }

    public void inputToPasswordTextBox(String password) {
        sendkeyToElement(driver,LoginPageUI.PASSWORD_TEXT_BOX,password);
    }

    public void clickToLoginButton() {
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
