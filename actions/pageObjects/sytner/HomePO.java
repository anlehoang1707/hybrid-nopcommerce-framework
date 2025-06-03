package pageObjects.sytner;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.sytner.HomePUI;

public class HomePO extends BasePage {
    private WebDriver driver;

    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToMenuItemsByName(String navMenuItemName) throws InterruptedException {
        waitForElementClickable(driver, HomePUI.OPEN_MENU_BUTTON);
        clickToElementByJS(driver, HomePUI.OPEN_MENU_BUTTON);
        waitForElementClickable(driver, HomePUI.DYNAMIC_MENU_ITEM_LINK_BY_SUB_CATEGORY_NAME,navMenuItemName);
        clickToElementByJS(driver, HomePUI.DYNAMIC_MENU_ITEM_LINK_BY_SUB_CATEGORY_NAME,navMenuItemName);
    }

    public void waitForCookiePopupVisible() {
        waitForElementVisible(driver, HomePUI.ACCEPT_ALL_COOKIES_BUTTON);
    }

    public void clickToAcceptCookieButton() throws InterruptedException {
        if (isControlDisplayed(driver,HomePUI.ACCEPT_ALL_COOKIES_BUTTON)) {
            clickToElementByJS(driver,HomePUI.ACCEPT_ALL_COOKIES_BUTTON);
        }
    }

    public void clickToMenuItemsByBrandName(String brandName) throws InterruptedException {
        waitForElementClickable(driver, HomePUI.OPEN_MENU_BUTTON);
        clickToElementByJS(driver, HomePUI.OPEN_MENU_BUTTON);
        waitForElementClickable(driver, HomePUI.DYNAMIC_MENU_ITEM_LINK_BY_BRAND_NAME,brandName);
        clickToElementByJS(driver, HomePUI.DYNAMIC_MENU_ITEM_LINK_BY_BRAND_NAME,brandName);
    }
}
