package pageObjects.sytner;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.sytner.MenuItemsPUI;

public class MenuItemsPO extends BasePage {
    private WebDriver driver;
    public MenuItemsPO(WebDriver driver) {
        this.driver = driver;
    }

    public MenuItemsPO openPageByMenuItemName(WebDriver driver, String pageName) throws InterruptedException {
        waitForElementClickable(driver, MenuItemsPUI.DYNAMIC_NAV_LINK_BY_NAME,pageName);
        clickToElementByJS(driver, MenuItemsPUI.DYNAMIC_NAV_LINK_BY_NAME,pageName);
        switch (pageName) {
            case "About Us":
                return PageGenerator.getAboutUsPage(driver);
            case "Latest News":
                return PageGenerator.getNewsPage(driver);
            case "Customer Service & Complaints":
                return PageGenerator.getCustomerServicePage(driver);
            case "Careers":
                return PageGenerator.getCareersPage(driver);
            case "Finance":
                return PageGenerator.getFinancePage(driver);
            default:
                throw new RuntimeException("pageName is not valid");
        }
    }
}
