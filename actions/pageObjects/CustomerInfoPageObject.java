package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.CustomerInfoPageUI;

public class CustomerInfoPageObject extends BasePage {
    private WebDriver driver;

    public CustomerInfoPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMaleRadioSelected() {
        if (isControlSelected(driver,CustomerInfoPageUI.MALE_RADIO)) {
            return true;
        } else
            return false;
    }

    public boolean isFirstNameDisplayed(String firstName) {
        if (getAttributeValue(driver,CustomerInfoPageUI.FIRST_NAME_TEXT_BOX,"value")
                .equals(firstName)) {
            return true;
        } else
            return false;
    }

    public boolean isLastNameDisplayed(String lastName) {
        if (getAttributeValue(driver,CustomerInfoPageUI.LAST_NAME_TEXT_BOX,"value")
                .equals(lastName)) {
            return true;
        } else
            return false;
    }

    public boolean isEmailDisplayed(String emailAddress) {
        if (getAttributeValue(driver,CustomerInfoPageUI.EMAIL_TEXT_BOX,"value")
                .equals(emailAddress)) {
            return true;
        } else
            return false;
    }

    public boolean isCompanyDisplayed(String companyName) {
        if (getAttributeValue(driver,CustomerInfoPageUI.COMPANY_TEXT_BOX,"value")
                .equals(companyName)) {
            return true;
        } else
            return false;
    }
}
