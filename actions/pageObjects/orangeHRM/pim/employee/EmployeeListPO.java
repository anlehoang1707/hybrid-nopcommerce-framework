package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.EmployeeListPUI;

public class EmployeeListPO extends BasePage {
    private WebDriver driver;

    public EmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click To Add New Employee Button")
    public void clickToAddNewEmployeeButton() {
        waitForElementClickable(driver, EmployeeListPUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, EmployeeListPUI.ADD_EMPLOYEE_BUTTON);
    }

}
