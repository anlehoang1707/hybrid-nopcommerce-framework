package pageObjects.saucelab;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.saucelab.LoginPUI;

public class LoginPO extends BasePage {
    private WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Login to system using default username is {0} and password is {1}")
    public ProductListPO loginToSystem(String username, String password) {
        waitForElementVisible(driver, LoginPUI.USERNAME_TEXTBOX);
        sendkeyToElement(driver,LoginPUI.USERNAME_TEXTBOX,username);
        waitForElementVisible(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendkeyToElement(driver,LoginPUI.PASSWORD_TEXTBOX,password);
        waitForElementClickable(driver,LoginPUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPUI.LOGIN_BUTTON);
        return PageGenerator.getProductListPage(driver);
    }


}
