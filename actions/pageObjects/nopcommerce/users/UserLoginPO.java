package pageObjects.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.nopcommerce.users.UserLoginPageUI;

public class UserLoginPO extends BasePage {
    private WebDriver driver;

    public UserLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputToEmailTextBox(String emailAddress) {
        sendkeyToElement(driver, UserLoginPageUI.EMAIL_TEXT_BOX,emailAddress);
    }

    public void inputToPasswordTextBox(String password) {
        sendkeyToElement(driver, UserLoginPageUI.PASSWORD_TEXT_BOX,password);
    }

    public UserHomePO clickToLoginButton() {
        clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
}
