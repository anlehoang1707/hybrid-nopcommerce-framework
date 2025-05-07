package pageObjects.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.PageGenerator;
import pageUIs.users.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForRegisterLinkToClick() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK,15);
    }

    public UserRegisterPO openRegisterPage() {
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }
    public void waitForLogoutLinkToClick() {
        waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK,15);
    }

    public void clickToLogoutLink() {
        clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
    }

    public void waitForLoginLinkToClick() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK,15);
    }

    public UserLoginPO openLoginPage() {
        clickToElement(driver, UserHomePageUI.LOGIN_LINK);
        return PageGenerator.getUserLoginPage(driver);
    }

    public UserCustomerInfoPO openCustomerInfoPage() {
        clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
        return PageGenerator.getUserCustomerInfoPage(driver);
    }

    public boolean isDisplayedMyAccountLink() {
        if (isControlDisplayed(driver, UserHomePageUI.MY_ACCOUNT_LINK)) {
            return true;
        } else
        return false;
    }

}
