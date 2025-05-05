package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.HomePageUI;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForRegisterLinkToClick() {
        waitForElementClickable(driver,HomePageUI.REGISTER_LINK,15);
    }

    public void clickToRegisterLink() {
        clickToElement(driver,HomePageUI.REGISTER_LINK);
    }
    public void waitForLogoutLinkToClick() {
        waitForElementClickable(driver,HomePageUI.LOGOUT_LINK,15);
    }

    public void clickToLogoutLink() {
        clickToElement(driver,HomePageUI.LOGOUT_LINK);
    }

    public void waitForLoginLinkToClick() {
        waitForElementClickable(driver,HomePageUI.LOGIN_LINK,15);
    }

    public void clickToLoginLink() {
        clickToElement(driver,HomePageUI.LOGIN_LINK);
    }

    public void clickToMyAccountLink() {
        clickToElement(driver,HomePageUI.MY_ACCOUNT_LINK);
    }

    public boolean isDisplayedMyAccountLink() {
        if (isControlDisplayed(driver,HomePageUI.MY_ACCOUNT_LINK)) {
            return true;
        } else
        return false;
    }

}
