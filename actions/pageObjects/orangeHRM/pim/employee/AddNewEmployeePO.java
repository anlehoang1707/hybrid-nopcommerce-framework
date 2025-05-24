package pageObjects.orangeHRM.pim.employee;

import com.orangeHRM.pim.EmployeeData;
import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.AddNewEmployeePUI;

public class AddNewEmployeePO extends BasePage {
    private WebDriver driver;

    public AddNewEmployeePO(WebDriver driver) {
        this.driver = driver;
    }



    public void inputEmployeeFirstName(String firstName) {
        sendkeyToElement(driver, AddNewEmployeePUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputEmployeeMiddleName(String middleName) {
        sendkeyToElement(driver, AddNewEmployeePUI.MIDDLE_NAME_TEXTBOX,middleName);
    }

    public void inputEmployeeLastName(String lastName) {
        sendkeyToElement(driver, AddNewEmployeePUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void inputEmployeeId(String employeeID) {
        sendkeyToElement(driver, AddNewEmployeePUI.EMPLOYEE_ID_TEXTBOX,employeeID);
    }

    public void toggleCreateLoginDetailsToggle() throws InterruptedException {
        clickToElementByJS(driver, AddNewEmployeePUI.CREATE_LOGIN_DETAILS_TOGGLE);
    }


    public void inputEmployeeUsername(String username) {
        sendkeyToElement(driver, AddNewEmployeePUI.USERNAME_TEXTBOX,username);
    }

    public void inputEmployeePassword(String password) {
        sendkeyToElement(driver, AddNewEmployeePUI.PASSWORD_TEXTBOX,password);
    }

    public void inputEmployeeConfirmPassword(String confirmPassword) {
        sendkeyToElement(driver, AddNewEmployeePUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToSaveButton() {
        clickToElement(driver, AddNewEmployeePUI.SAVE_BUTTON);
    }

    public boolean isDisplayedUsernameTextbox() {
        if (isControlDisplayed(driver, AddNewEmployeePUI.USERNAME_TEXTBOX)) {
            return true;
        }
        else
            return false;
    }

    public String getFullNameError() {
        return getTextElement(driver, AddNewEmployeePUI.FIRST_NAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getLastNameError() {
        return getTextElement(driver, AddNewEmployeePUI.LAST_NAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getUsernameError() {
        return getTextElement(driver, AddNewEmployeePUI.USERNAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getPasswordError() {
        return getTextElement(driver, AddNewEmployeePUI.PASSWORD_TEXTBOX_ERROR_MESSAGE);
    }

    public String getConfirmPasswordError() {
        return getTextElement(driver, AddNewEmployeePUI.CONFIRM_PASSWORD_TEXTBOX_ERROR_MESSAGE);
    }

    public String getInitialEmployeeID() {
        return getTextElement(driver, AddNewEmployeePUI.EMPLOYEE_ID_TEXTBOX);
    }

    public String getSuccessCreateToastMessage() {
        waitForElementVisible(driver, AddNewEmployeePUI.CREATE_SUCCESS_TOAST_MESSAGE);
        return getTextElement(driver, AddNewEmployeePUI.CREATE_SUCCESS_TOAST_MESSAGE);
    }

    public void inputEmployeeInfo(EmployeeData employeeData) {
        inputEmployeeFirstName(employeeData.getFirstName());
        inputEmployeeMiddleName(employeeData.getMiddleName());
        inputEmployeeLastName(employeeData.getLastName());
        inputEmployeeUsername(employeeData.getUsername());
        inputEmployeePassword(employeeData.getPassword());
        inputEmployeeConfirmPassword(employeeData.getPassword());
    }
}
