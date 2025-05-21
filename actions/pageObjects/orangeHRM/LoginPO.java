package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPageUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO (WebDriver driver) {
        this.driver = driver;
    }

    public void loginToSystem(String username, String password) {
        waitForElementVisible(driver,LoginPageUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPageUI.USERNAME_TEXTBOX,username);
        sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX,password);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
    }
}
