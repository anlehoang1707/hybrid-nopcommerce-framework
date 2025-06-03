package pageObjects.sytner.menuitems;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.MenuItemsPO;
import pageUIs.sytner.HomePUI;

public class NewsPO extends MenuItemsPO {
    private WebDriver driver;

    public NewsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToMenuItemsByName(String navMenuItemName) throws InterruptedException {
        scrollToElementOnTopByJS(driver,HomePUI.DYNAMIC_NAV_LINK_BY_SUB_CATEGORY_NAME,navMenuItemName);
        waitForElementClickable(driver, HomePUI.DYNAMIC_NAV_LINK_BY_SUB_CATEGORY_NAME,navMenuItemName);
        clickToElementByJS(driver, HomePUI.DYNAMIC_NAV_LINK_BY_SUB_CATEGORY_NAME,navMenuItemName);
    }

    public void waitForCookiePopupVisible() {
        waitForElementVisible(driver, HomePUI.ACCEPT_ALL_COOKIES_BUTTON);
    }

    public void clickToAcceptCookieButton() {
        if (isControlDisplayed(driver,HomePUI.ACCEPT_ALL_COOKIES_BUTTON)) {
            clickToElement(driver,HomePUI.ACCEPT_ALL_COOKIES_BUTTON);
        }
    }
}
