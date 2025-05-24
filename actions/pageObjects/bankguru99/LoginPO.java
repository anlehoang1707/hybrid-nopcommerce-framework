package pageObjects.bankguru99;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.bankguru99.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToLoginButton() {
        waitForElementVisible(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPUI.LOGIN_BUTTON);
    }
}
