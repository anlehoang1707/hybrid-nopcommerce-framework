package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.EmployeeMenuPUI;

public class EmployeeMenuPO extends BasePage {
    WebDriver driver;

    public EmployeeMenuPO(WebDriver driver) {
        this.driver = driver;
    }

    public EmergencyContactsPO getEmergencyContactsPage() {
        waitForElementClickable(driver, EmployeeMenuPUI.EMERGENCY_CONTACTS_NAV_LINK);
        clickToElement(driver,EmployeeMenuPUI.EMERGENCY_CONTACTS_NAV_LINK);
        waitForAllLoadingIconsInvisible(driver);
        return PageGenerator.getEmergencyContactsPage(driver);
    }

    public ContactDetailsPO getContactDetailsPage() {
        waitForElementClickable(driver, EmployeeMenuPUI.CONTACT_DETAILS_NAV_LINK);
        clickToElement(driver, EmployeeMenuPUI.CONTACT_DETAILS_NAV_LINK);
        waitForAllLoadingIconsInvisible(driver);
        return PageGenerator.getContactDetailsPage(driver);
    }

    public PersonalDetailsPO getPersonalDetailsPage() {
        waitForElementClickable(driver,EmployeeMenuPUI.PERSONAL_DETAILS_NAV_LINK);
        clickToElement(driver,EmployeeMenuPUI.PERSONAL_DETAILS_NAV_LINK);
        waitForAllLoadingIconsInvisible(driver);
        return PageGenerator.getPersonalDetailsPage(driver);
    }

    public EmployeeMenuPO getPageByNavLinkText(String navLinkText) {
        waitForElementClickable(driver, EmployeeMenuPUI.DYNAMIC_NAV_LINK_BY_TEXT_AT_EMPLOYEE_MENU,navLinkText);
        clickToElement(driver,EmployeeMenuPUI.DYNAMIC_NAV_LINK_BY_TEXT_AT_EMPLOYEE_MENU,navLinkText);
        waitForAllLoadingIconsInvisible(driver);
        switch(navLinkText) {
            case "Emergency Contacts":
                return PageGenerator.getEmergencyContactsPage(driver);
            case "Personal Details":
                return PageGenerator.getPersonalDetailsPage(driver);
            case "Contact Details":
                return PageGenerator.getContactDetailsPage(driver);
            case "Dependents":
                return PageGenerator.getDependentsPage(driver);
            default:
                throw new RuntimeException("navLinkText is not valid");
        }
    }
}
