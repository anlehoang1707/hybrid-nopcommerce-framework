package pageObjects.orangeHRM.pim.employee;

import com.orangeHRM.pim.EmployeeData;
import commons.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.employee.ContactDetailsPUI;

public class ContactDetailsPO extends EmployeeMenuPO {
    private WebDriver driver;

    public ContactDetailsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Input Street 1 {0}")
    public void inputStreet1(String street1) {
        sendkeyToElement(driver, ContactDetailsPUI.STREET_1_TEXTBOX,street1);
    }

    @Step("Input Street 2 {0}")
    public void inputStreet2(String street2) {
        sendkeyToElement(driver, ContactDetailsPUI.STREET_2_TEXTBOX,street2);
    }

    @Step("Input City {0}")
    public void inputCity(String city) {
        sendkeyToElement(driver, ContactDetailsPUI.CITY_TEXTBOX,city);
    }

    @Step("Input State Province {0}")
    public void inputStateProvince(String stateProvince) {
        sendkeyToElement(driver, ContactDetailsPUI.STATE_PROVINCE_TEXTBOX,stateProvince);
    }

    @Step("Input Zip Postal Code {0}")
    public void inputZipPostalCode(String zipPostalCode) {
        sendkeyToElement(driver, ContactDetailsPUI.ZIP_POSTAL_CODE_TEXTBOX,zipPostalCode);
    }

    @Step("Select Country By Visible Text Value {0}")
    public void selectCountryByVisibleTextValue(String countryName) {
        selectItemInCustomDropdown(driver, ContactDetailsPUI.COUNTRY_DROPDOWN,"xpath=//div[@role='option']",countryName);
    }

    @Step("Input Home Phone {0}")
    public void inputHomePhone(String homePhone) {
        sendkeyToElement(driver, ContactDetailsPUI.HOME_PHONE_TEXTBOX,homePhone);
    }

    @Step("Input Mobile Phone {0}")
    public void inputMobilePhone(String mobilePhone) {
        sendkeyToElement(driver, ContactDetailsPUI.MOBILE_PHONE_TEXTBOX,mobilePhone);
    }

    @Step("Input Work Phone {0}")
    public void inputWorkPhone(String workPhone) {
        sendkeyToElement(driver, ContactDetailsPUI.WORK_PHONE_TEXTBOX,workPhone);
    }

    @Step("Input Work Email {0}")
    public void inputWorkEmail(String workEmail) {
        sendkeyToElement(driver, ContactDetailsPUI.WORK_EMAIL_TEXTBOX,workEmail);
    }

    @Step("Input Other Email {0}")
    public void inputOtherEmail(String otherEmail) {
        sendkeyToElement(driver, ContactDetailsPUI.OTHER_EMAIL_TEXTBOX,otherEmail);
    }

    @Step("Click To Save Button")
    public void clickToSaveButton() {
        clickToElement(driver, ContactDetailsPUI.SAVE_BUTTON);
    }

    @Step("Get Success Update Toast Message Content")
    public String getSuccessUpdateToastMessageContent() {
        waitForElementVisible(driver, ContactDetailsPUI.UPDATE_SUCCESS_TOAST_MESSAGE);
        return getTextElement(driver, ContactDetailsPUI.UPDATE_SUCCESS_TOAST_MESSAGE);
    }
    @Step("Input Employee Contact Details Info")
    public void inputEmployeeContactDetailsInfo(EmployeeData employeeData) {
        inputStreet1(employeeData.getStreet1());
        inputStreet2(employeeData.getStreet2());
        inputCity(employeeData.getCity());
        inputStateProvince(employeeData.getStateProvince());
        inputZipPostalCode(employeeData.getZipPostalCode());
        selectCountryByVisibleTextValue(employeeData.getCountryName());
        inputHomePhone(employeeData.getHomePhone());
        inputMobilePhone(employeeData.getMobilePhone());
        inputWorkPhone(employeeData.getWorkPhone());
        inputWorkEmail(employeeData.getWorkEmail());
        inputOtherEmail(employeeData.getOtherEmail());
    }
}
