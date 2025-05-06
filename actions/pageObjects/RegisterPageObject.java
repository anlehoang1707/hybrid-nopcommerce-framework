package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.RegisterPageUI;

public class RegisterPageObject extends BasePage {
    private WebDriver driver;

    public RegisterPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForMaleRadioClickable() {
        waitForElementClickable(driver, RegisterPageUI.MALE_RADIO,15);
    }

    public void checkMaleRadio() {
        checkTheCheckboxOrRadio(driver, RegisterPageUI.MALE_RADIO);
    }

    public void inputToFirstNameTextBox(String firstName) {
        sendkeyToElement(driver,RegisterPageUI.FIRST_NAME_TEXT_BOX,firstName);
    }

    public void inputToLastNameTextBox(String lastName) {
        sendkeyToElement(driver,RegisterPageUI.LAST_NAME_TEXT_BOX,lastName);
    }

    public void inputToEmailTextBox(String emailAddress) {
        sendkeyToElement(driver,RegisterPageUI.EMAIL_TEXT_BOX,emailAddress);
    }

    public void inputToCompanyTextBox(String companyName) {
        sendkeyToElement(driver,RegisterPageUI.COMPANY_TEXT_BOX,companyName);
    }

    public void inputToPasswordTextBox(String password) {
        sendkeyToElement(driver,RegisterPageUI.PASSWORD_TEXT_BOX,password);
    }

    public void inputToConfirmPasswordTextBox(String confirmPassword) {
        sendkeyToElement(driver,RegisterPageUI.CONFIRM_PASSWORD_TEXT_BOX,confirmPassword);
    }

    public void clickToRegisterButton() {
        clickToElement(driver,RegisterPageUI.REGISTER_BUTTON);
    }

    public String getRegisterSuccessMessageText() {
        return getTextElement(driver,RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    public HomePageObject clickToContinueButton() {
        clickToElement(driver,RegisterPageUI.CONTINUE_BUTTON);
        return PageGenerator.getHomePage(driver);
    }
}
