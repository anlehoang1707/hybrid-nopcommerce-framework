package pageObjects.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.nopcommerce.users.UserRegisterPageUI;

public class UserRegisterPO extends BasePage {
    private WebDriver driver;

    public UserRegisterPO(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForMaleRadioClickable() {
        waitForElementClickable(driver, UserRegisterPageUI.MALE_RADIO);
    }

    public void checkMaleRadio() {
        checkTheCheckboxOrRadio(driver, UserRegisterPageUI.MALE_RADIO);
    }

    public void inputToFirstNameTextBox(String firstName) {
        sendkeyToElement(driver, UserRegisterPageUI.FIRST_NAME_TEXT_BOX,firstName);
    }

    public void inputToLastNameTextBox(String lastName) {
        sendkeyToElement(driver, UserRegisterPageUI.LAST_NAME_TEXT_BOX,lastName);
    }

    public void inputToEmailTextBox(String emailAddress) {
        sendkeyToElement(driver, UserRegisterPageUI.EMAIL_TEXT_BOX,emailAddress);
    }

    public void inputToCompanyTextBox(String companyName) {
        sendkeyToElement(driver, UserRegisterPageUI.COMPANY_TEXT_BOX,companyName);
    }

    public void inputToPasswordTextBox(String password) {
        sendkeyToElement(driver, UserRegisterPageUI.PASSWORD_TEXT_BOX,password);
    }

    public void inputToConfirmPasswordTextBox(String confirmPassword) {
        sendkeyToElement(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessageText() {
        return getTextElement(driver, UserRegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public UserHomePO clickToContinueButton() {
        clickToElement(driver, UserRegisterPageUI.CONTINUE_BUTTON);
        return PageGenerator.getUserHomePage(driver);
    }
}
