package pageObjects.orangeHRM;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.EmployeeListPO;
import pageUIs.orangeHRM.DashboardPUI;

public class DashboardPO extends BasePage {
    private WebDriver driver;

    public DashboardPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmployeeListPO getPimListPage(WebDriver driver) {
        clickToElement(driver, DashboardPUI.PIM_NAVIGATION_LINK);
        return PageGenerator.getPimEmployeeListPage(driver);
    }
}
