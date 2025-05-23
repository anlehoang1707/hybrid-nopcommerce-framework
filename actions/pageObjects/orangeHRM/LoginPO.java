package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO (WebDriver driver) {
        this.driver = driver;
    }

    public void loginToSystem(String username, String password) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver, LoginPUI.USERNAME_TEXTBOX,username);
        sendkeyToElement(driver, LoginPUI.PASSWORD_TEXTBOX,password);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
    }
}
