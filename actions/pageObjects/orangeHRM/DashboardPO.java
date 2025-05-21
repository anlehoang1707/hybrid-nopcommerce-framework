package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.PimEmployeeListPO;
import pageUIs.orangeHRM.DashboardPageUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public PimEmployeeListPO getPimListPage(WebDriver driver) {
        clickToElement(driver, DashboardPageUI.PIM_NAVIGATION_LINK);
        return PageGenerator.getPimEmployeeListPage(driver);
    }
}
