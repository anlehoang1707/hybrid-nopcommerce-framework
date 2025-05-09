package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.admin.AdminDashboardPageUI;

public class AdminDashboardPO extends BasePage {
    private WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToPromotionNavigationLink() {
        clickToElement(driver, AdminDashboardPageUI.PROMOTIONS_NAVIGATION_LINK);
    }

    public int getChildrenCountInPromotionNavigationLink() {
        return getElementsSize(driver,AdminDashboardPageUI.PROMOTIONS_NAVIGATION_CHILDREN_LINKS);
    }
}
