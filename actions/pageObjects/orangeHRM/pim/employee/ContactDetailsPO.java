package pageObjects.orangeHRM.pim.employee;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ContactDetailsPUI;

public class ContactDetailsPO extends EmployeeMenuPO {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void inputStreet1(String street1) {
        sendkeyToElement(driver, ContactDetailsPUI.STREET_1_TEXTBOX,street1);
    }

    public void inputStreet2(String street2) {
        sendkeyToElement(driver, ContactDetailsPUI.STREET_2_TEXTBOX,street2);
    }

    public void inputCity(String city) {
        sendkeyToElement(driver, ContactDetailsPUI.CITY_TEXTBOX,city);
    }

    public void inputStateProvince(String stateProvince) {
        sendkeyToElement(driver, ContactDetailsPUI.STATE_PROVINCE_TEXTBOX,stateProvince);
    }

    public void inputZipPostalCode(String zipPostalCode) {
        sendkeyToElement(driver, ContactDetailsPUI.ZIP_POSTAL_CODE_TEXTBOX,zipPostalCode);
    }

    public void selectCountryByVisibleTextValue(String countryName) {
        selectItemInCustomDropdown(driver, ContactDetailsPUI.COUNTRY_DROPDOWN,"xpath=//div[@role='option']",countryName);
    }

    public void inputHomePhone(String homePhone) {
        sendkeyToElement(driver, ContactDetailsPUI.HOME_PHONE_TEXTBOX,homePhone);
    }

    public void inputMobilePhone(String mobilePhone) {
        sendkeyToElement(driver, ContactDetailsPUI.MOBILE_PHONE_TEXTBOX,mobilePhone);
    }

    public void inputWorkPhone(String workPhone) {
        sendkeyToElement(driver, ContactDetailsPUI.WORK_PHONE_TEXTBOX,workPhone);
    }

    public void inputWorkEmail(String workEmail) {
        sendkeyToElement(driver, ContactDetailsPUI.WORK_EMAIL_TEXTBOX,workEmail);
    }

    public void inputOtherEmail(String otherEmail) {
        sendkeyToElement(driver, ContactDetailsPUI.OTHER_EMAIL_TEXTBOX,otherEmail);
    }

    public void clickToSaveButton() {
        clickToElement(driver, ContactDetailsPUI.SAVE_BUTTON);
    }

    public String getSuccessUpdateToastMessageContent() {
        waitForElementVisible(driver, ContactDetailsPUI.UPDATE_SUCCESS_TOAST_MESSAGE);
        return getTextElement(driver, ContactDetailsPUI.UPDATE_SUCCESS_TOAST_MESSAGE);
    }
}
