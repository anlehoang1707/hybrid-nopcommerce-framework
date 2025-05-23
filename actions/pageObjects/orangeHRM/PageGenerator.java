package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.pim.employee.*;

public class PageGenerator {
    public static AddNewEmployeePO getPimAddEmployeePage(WebDriver driver) {
        return new AddNewEmployeePO(driver);
    }

    public static EmployeeListPO getPimEmployeeListPage(WebDriver driver) {
        return new EmployeeListPO(driver);
    }

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static DashboardPO getDashboardPage(WebDriver driver) {
        return new DashboardPO(driver);
    }

    public static PersonalDetailsPO getPersonalDetailsPage(WebDriver driver) {
        return new PersonalDetailsPO(driver);
    }

    public static ContactDetailsPO getContactDetailsPage(WebDriver driver) {
        return new ContactDetailsPO(driver);
    }

    public static EmergencyContactsPO getEmergencyContactsPage(WebDriver driver) {
        return new EmergencyContactsPO(driver);
    }

    public static EmployeeMenuPO getDependentsPage(WebDriver driver) {
        return new DependentsPO(driver);
    }
}
