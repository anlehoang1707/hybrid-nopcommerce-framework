package pageObjects.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.users.UserCustomerInfoPageUI;

public class UserCustomerInfoPO extends BasePage {
    private WebDriver driver;

    public UserCustomerInfoPO(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isMaleRadioSelected() {
        if (isControlSelected(driver, UserCustomerInfoPageUI.MALE_RADIO)) {
            return true;
        } else
            return false;
    }

    public boolean isFirstNameDisplayed(String firstName) {
        if (getAttributeValue(driver, UserCustomerInfoPageUI.FIRST_NAME_TEXT_BOX,"value")
                .equals(firstName)) {
            return true;
        } else
            return false;
    }

    public boolean isLastNameDisplayed(String lastName) {
        if (getAttributeValue(driver, UserCustomerInfoPageUI.LAST_NAME_TEXT_BOX,"value")
                .equals(lastName)) {
            return true;
        } else
            return false;
    }

    public boolean isEmailDisplayed(String emailAddress) {
        if (getAttributeValue(driver, UserCustomerInfoPageUI.EMAIL_TEXT_BOX,"value")
                .equals(emailAddress)) {
            return true;
        } else
            return false;
    }

    public boolean isCompanyDisplayed(String companyName) {
        if (getAttributeValue(driver, UserCustomerInfoPageUI.COMPANY_TEXT_BOX,"value")
                .equals(companyName)) {
            return true;
        } else
            return false;
    }
}
