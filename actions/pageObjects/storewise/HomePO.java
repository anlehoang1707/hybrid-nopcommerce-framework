package pageObjects.storewise;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.storewise.HomePUI;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAcceptCookiePopup() {
        waitForElementClickable(driver, HomePUI.ACCEPT_COOKIE_POPUP_BUTTON);
        clickToElement(driver, HomePUI.ACCEPT_COOKIE_POPUP_BUTTON);
    }

    public void changeToEnglishLanguage() {
        waitForElementClickable(driver, HomePUI.LANGUAGE_DROPDOWN_PARENT);
        selectItemInCustomDropdown(driver,HomePUI.LANGUAGE_DROPDOWN_PARENT,HomePUI.LANGUAGE_DROPDOWN_CHILD,"Eng");
    }

    public void clickToCloseCountDownPopup() {
        waitForElementClickable(driver, HomePUI.CLOSE_COUNTDOWN_POPUP_BUTTON);
        clickToElement(driver,HomePUI.CLOSE_COUNTDOWN_POPUP_BUTTON);
    }

    public void clickToCloseToggleCart() {
        waitForElementClickable(driver, HomePUI.TOGGLE_CART);
        clickToElement(driver,HomePUI.TOGGLE_CART);
    }
}
