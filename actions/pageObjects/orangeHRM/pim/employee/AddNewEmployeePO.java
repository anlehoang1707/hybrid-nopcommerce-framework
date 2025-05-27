package pageObjects.orangeHRM.pim.employee;

import com.orangeHRM.pim.EmployeeData;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.AddNewEmployeePUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }


    @Step("Input Employee First Name")
    public void inputEmployeeFirstName(String firstName) {
        sendkeyToElement(driver, AddNewEmployeePUI.FIRST_NAME_TEXTBOX,firstName);
    }

    @Step("Input Employee Middle Name")
    public void inputEmployeeMiddleName(String middleName) {
        sendkeyToElement(driver, AddNewEmployeePUI.MIDDLE_NAME_TEXTBOX,middleName);
    }

    @Step("Input Employee Last Name")
    public void inputEmployeeLastName(String lastName) {
        sendkeyToElement(driver, AddNewEmployeePUI.LAST_NAME_TEXTBOX,lastName);
    }

    @Step("Input Employee ID")
    public void inputEmployeeId(String employeeID) {
        sendkeyToElement(driver, AddNewEmployeePUI.EMPLOYEE_ID_TEXTBOX,employeeID);
    }

    @Step("Toggle Create Login Details")
    public void toggleCreateLoginDetailsToggle() throws InterruptedException {
        clickToElementByJS(driver, AddNewEmployeePUI.CREATE_LOGIN_DETAILS_TOGGLE);
    }

    @Step("Input Employee Username")
    public void inputEmployeeUsername(String username) {
        sendkeyToElement(driver, AddNewEmployeePUI.USERNAME_TEXTBOX,username);
    }

    @Step("Input Employee Password")
    public void inputEmployeePassword(String password) {
        sendkeyToElement(driver, AddNewEmployeePUI.PASSWORD_TEXTBOX,password);
    }

    @Step("Input Employee Confirm Password")
    public void inputEmployeeConfirmPassword(String confirmPassword) {
        sendkeyToElement(driver, AddNewEmployeePUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    @Step("Click to Save Button at 'Add New Employee' Page")
    public void clickToSaveButton() {
        clickToElement(driver, AddNewEmployeePUI.SAVE_BUTTON);
    }

    @Step("Check Username Textbox is displayed")
    public boolean isDisplayedUsernameTextbox() {
        if (isControlDisplayed(driver, AddNewEmployeePUI.USERNAME_TEXTBOX)) {
            return true;
        }
        else
            return false;
    }

    @Step("Get Full Name Textbox Error Message")
    public String getFullNameError() {
        return getTextElement(driver, AddNewEmployeePUI.FIRST_NAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Get Last Name Textbox Error Message")
    public String getLastNameError() {
        return getTextElement(driver, AddNewEmployeePUI.LAST_NAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Get Username Textbox Error Message")
    public String getUsernameError() {
        return getTextElement(driver, AddNewEmployeePUI.USERNAME_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Get Password Textbox Error Message")
    public String getPasswordError() {
        return getTextElement(driver, AddNewEmployeePUI.PASSWORD_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Get Confirm Password Textbox Error Message")
    public String getConfirmPasswordError() {
        return getTextElement(driver, AddNewEmployeePUI.CONFIRM_PASSWORD_TEXTBOX_ERROR_MESSAGE);
    }

    @Step("Get Employee ID")
    public String getInitialEmployeeID() {
        return getTextElement(driver, AddNewEmployeePUI.EMPLOYEE_ID_TEXTBOX);
    }

    @Step("Get Success Create Toast Message")
    public String getSuccessCreateToastMessage() {
        waitForElementVisible(driver, AddNewEmployeePUI.CREATE_SUCCESS_TOAST_MESSAGE);
        return getTextElement(driver, AddNewEmployeePUI.CREATE_SUCCESS_TOAST_MESSAGE);
    }

    @Step("Input Employee Information")
    public void inputEmployeeInfo(EmployeeData employeeData) {
        inputEmployeeFirstName(employeeData.getFirstName());
        inputEmployeeMiddleName(employeeData.getMiddleName());
        inputEmployeeLastName(employeeData.getLastName());
        inputEmployeeUsername(employeeData.getUsername());
        inputEmployeePassword(employeeData.getPassword());
        inputEmployeeConfirmPassword(employeeData.getPassword());
    }
}
