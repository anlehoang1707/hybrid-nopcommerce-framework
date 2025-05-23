package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.employee.PersonalDetailsPUI;

public class PersonalDetailsPO extends EmployeeMenuPO {
    private WebDriver driver;

    public PersonalDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getFirstNameText() {
        return getAttributeValue(driver, PersonalDetailsPUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getMiddleNameText() {
        return getAttributeValue(driver, PersonalDetailsPUI.MIDDLE_NAME_TEXTBOX,"value");
    }

    public String getLastNameText() {
        return getAttributeValue(driver, PersonalDetailsPUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getEmployeeIDText() {
        return getAttributeValue(driver, PersonalDetailsPUI.EMPLOYEE_ID_TEXTBOX,"value");
    }

    public ContactDetailsPO getContactDetailsPage(WebDriver driver) {
        clickToElement(driver, PersonalDetailsPUI.CONTACT_DETAILS_NAVIGATION_LINK);
        return PageGenerator.getContactDetailsPage(driver);
    }
}
