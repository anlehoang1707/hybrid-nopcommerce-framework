package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerInfoPageFactory extends BasePageFactory{
    private WebDriver driver;

    public CustomerInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath =  "//input[@id = 'gender-male']")
    private WebElement maleRadio;

    @FindBy(xpath= "//input[@id = 'FirstName']")
    private WebElement firstNameTextBox;

    @FindBy(xpath = "//input[@id = 'LastName']")
    private WebElement lastNameTextBox;

    @FindBy(xpath = "//input[@id = 'Email']")
    private WebElement emailTextBox;

    @FindBy(xpath = "//input[@id = 'Company']")
    private WebElement companyTextBox;

    public boolean isMaleRadioSelected() {
        if (isControlSelected(maleRadio)) {
            return true;
        } else
            return false;
    }

    public boolean isFirstNameDisplayed(String firstName) {
        if (getAttributeValue(firstNameTextBox,"value")
                .equals(firstName)) {
            return true;
        } else
            return false;
    }

    public boolean isLastNameDisplayed(String lastName) {
        if (getAttributeValue(lastNameTextBox,"value")
                .equals(lastName)) {
            return true;
        } else
            return false;
    }

    public boolean isEmailDisplayed(String emailAddress) {
        if (getAttributeValue(emailTextBox,"value")
                .equals(emailAddress)) {
            return true;
        } else
            return false;
    }

    public boolean isCompanyDisplayed(String companyName) {
        if (getAttributeValue(companyTextBox,"value")
                .equals(companyName)) {
            return true;
        } else
            return false;
    }
}
