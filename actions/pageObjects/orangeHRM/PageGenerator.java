package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.PimAddEmployeePO;
import pageObjects.orangeHRM.pim.PimEmployeeListPO;
import pageObjects.orangeHRM.pim.PimEmployeePersonalDetailPO;

public class PageGenerator {
    public static PimAddEmployeePO getPimAddEmployeePage(WebDriver driver) {
        return new PimAddEmployeePO(driver);
    }

    public static PimEmployeeListPO getPimEmployeeListPage(WebDriver driver) {
        return new PimEmployeeListPO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static PimEmployeePersonalDetailPO getPimEmployeePersonalDetailPage(WebDriver driver) {
        return new PimEmployeePersonalDetailPO(driver);
    }
}
