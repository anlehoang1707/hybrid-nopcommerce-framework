package pageObjects.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.nopcommerce.users.UserHomePageUI;

public class UserHomePO extends BasePage {
    private WebDriver driver;

    public UserHomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForRegisterLinkToClick() {
        waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
    }

    public UserRegisterPO openRegisterPage() {
        clickToElement(driver, UserHomePageUI.REGISTER_LINK);
        return PageGenerator.getUserRegisterPage(driver);
    }
    public void waitForLogoutLinkToClick() {
        waitForElementClickable(driver, UserHomePageUI.LOGOUT_LINK);
    }

    public void clickToLogoutLink() {
        clickToElement(driver, UserHomePageUI.LOGOUT_LINK);
    }

    public void waitForLoginLinkToClick() {
        waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
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
