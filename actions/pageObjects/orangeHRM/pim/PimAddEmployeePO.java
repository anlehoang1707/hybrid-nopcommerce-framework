package pageObjects.orangeHRM.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.PimAddEmployeePageUI;

public class PimAddEmployeePO extends BasePage {
    private WebDriver driver;

    public PimAddEmployeePO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputEmployeeFirstName(String firstName) {
        sendkeyToElement(driver, PimAddEmployeePageUI.FIRST_NAME_TEXTBOX,firstName);
    }

    public void inputEmployeeMiddleName(String middleName) {
        sendkeyToElement(driver, PimAddEmployeePageUI.MIDDLE_NAME_TEXTBOX,middleName);
    }

    public void inputEmployeeLastName(String lastName) {
        sendkeyToElement(driver, PimAddEmployeePageUI.LAST_NAME_TEXTBOX,lastName);
    }

    public void inputEmployeeId(String employeeID) {
        sendkeyToElement(driver,PimAddEmployeePageUI.EMPLOYEE_ID_TEXTBOX,employeeID);
    }

    public void toggleCreateLoginDetailsToggle() throws InterruptedException {
        clickToElementByJS(driver,PimAddEmployeePageUI.CREATE_LOGIN_DETAILS_TOGGLE);
    }


    public void inputEmployeeUsername(String username) {
        sendkeyToElement(driver, PimAddEmployeePageUI.USERNAME_TEXTBOX,username);
    }

    public void inputEmployeePassword(String password) {
        sendkeyToElement(driver,PimAddEmployeePageUI.PASSWORD_TEXTBOX,password);
    }

    public void inputEmployeeConfirmPassword(String confirmPassword) {
        sendkeyToElement(driver,PimAddEmployeePageUI.CONFIRM_PASSWORD_TEXTBOX,confirmPassword);
    }

    public void clickToSaveButton() {
        clickToElement(driver, PimAddEmployeePageUI.SAVE_BUTTON);
    }

    public boolean isDisplayedUsernameTextbox() {
        if (isControlDisplayed(driver, PimAddEmployeePageUI.USERNAME_TEXTBOX)) {
            return true;
        }
        else
            return false;
    }

    public String getFullNameError() {
        return getTextElement(driver, PimAddEmployeePageUI.FIRST_NAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getLastNameError() {
        return getTextElement(driver, PimAddEmployeePageUI.LAST_NAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getUsernameError() {
        return getTextElement(driver, PimAddEmployeePageUI.USERNAME_TEXTBOX_ERROR_MESSAGE);
    }

    public String getPasswordError() {
        return getTextElement(driver, PimAddEmployeePageUI.PASSWORD_TEXTBOX_ERROR_MESSAGE);
    }

    public String getConfirmPasswordError() {
        return getTextElement(driver, PimAddEmployeePageUI.CONFIRM_PASSWORD_TEXTBOX_ERROR_MESSAGE);
    }

    public String getInitialEmployeeID() {
        return getTextElement(driver, PimAddEmployeePageUI.EMPLOYEE_ID_TEXTBOX);
    }

    public boolean isDisplayedSuccessCreateToastMessage() {
        waitForElementVisible(driver,PimAddEmployeePageUI.CREATE_SUCCESS_TOAST_MESSAGE);
        if (isControlDisplayed(driver, PimAddEmployeePageUI.CREATE_SUCCESS_TOAST_MESSAGE)) {
            return true;
        }
        else
            return false;
    }
}
