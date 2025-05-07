package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BasePageFactory{
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//input[@id='gender-male']")
    private WebElement maleRadio;

    @FindBy(xpath ="//input[@id = 'FirstName']")
    private WebElement firstNameTextBox;

    @FindBy(xpath ="//input[@id = 'LastName']")
    private WebElement lastNameTextBox;

    @FindBy(xpath ="//input[@id = 'Email']")
    private WebElement emailTextBox;

    @FindBy(xpath ="//input[@id = 'Company']")
    private WebElement companyTextBox;

    @FindBy(xpath ="//input[@id = 'Password']")
    private WebElement passwordTextBox;

    @FindBy(xpath ="//input[@id = 'ConfirmPassword']")
    private WebElement confirmPasswordTextBox;

    @FindBy(xpath ="//button[contains(@id,'register-button')]")
    private WebElement registerButton;

    @FindBy(xpath = "//div[@class = 'result']")
    private WebElement registerSuccessMessage;

    @FindBy(xpath ="//a[contains(@class,'register-continue-button')]")
    private WebElement continueButton;


    public void waitForMaleRadioClickable() {
        waitForElementClickable(driver, maleRadio,15);
    }

    public void checkMaleRadio() {
        checkTheCheckboxOrRadio(maleRadio);
    }

    public void inputToFirstNameTextBox(String firstName) {
        sendkeyToElement(firstNameTextBox,firstName);
    }

    public void inputToLastNameTextBox(String lastName) {
        sendkeyToElement(lastNameTextBox,lastName);
    }

    public void inputToEmailTextBox(String emailAddress) {
        sendkeyToElement(emailTextBox,emailAddress);
    }

    public void inputToCompanyTextBox(String companyName) {
        sendkeyToElement(companyTextBox,companyName);
    }

    public void inputToPasswordTextBox(String password) {
        sendkeyToElement(passwordTextBox,password);
    }

    public void inputToConfirmPasswordTextBox(String confirmPassword) {
        sendkeyToElement(confirmPasswordTextBox,confirmPassword);
    }

    public void clickToRegisterButton() {
        clickToElement(registerButton);
    }

    public String getRegisterSuccessMessageText() {
        return getTextElement(registerSuccessMessage);
    }

    public void clickToContinueButton() {
        clickToElement(continueButton);
    }
}
