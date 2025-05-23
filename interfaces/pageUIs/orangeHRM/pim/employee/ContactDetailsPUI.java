package pageUIs.orangeHRM.pim.employee;

public class ContactDetailsPUI {
    public static final String STREET_1_TEXTBOX = "xpath=//label[text() = 'Street 1']//parent::div//following-sibling::div//input";

    public static final String STREET_2_TEXTBOX = "xpath=//label[text() = 'Street 2']//parent::div//following-sibling::div//input";

    public static final String CITY_TEXTBOX = "xpath=//label[text() = 'City']//parent::div//following-sibling::div//input";

    public static final String STATE_PROVINCE_TEXTBOX = "xpath=//label[text() = 'State/Province']//parent::div//following-sibling::div//input";

    public static final String ZIP_POSTAL_CODE_TEXTBOX ="xpath=//label[text() = 'Zip/Postal Code']//parent::div//following-sibling::div//input";

    public static final String COUNTRY_DROPDOWN = "xpath=//label[text() = 'Country']//parent::div//following-sibling::div";

    public static final String HOME_PHONE_TEXTBOX = "xpath=//label[text() = 'Home']//parent::div//following-sibling::div//input";

    public static final String MOBILE_PHONE_TEXTBOX = "xpath=//label[text() = 'Mobile']//parent::div//following-sibling::div//input";

    public static final String WORK_PHONE_TEXTBOX = "xpath=//label[text() = 'Work']//parent::div//following-sibling::div//input";

    public static final String WORK_EMAIL_TEXTBOX = "xpath=//label[text() = 'Work Email']//parent::div//following-sibling::div//input";

    public static final String OTHER_EMAIL_TEXTBOX = "xpath=//label[text() = 'Other Email']//parent::div//following-sibling::div//input";

    public static final String SAVE_BUTTON ="xpath=//button[text()=' Save ']";

    public static final String UPDATE_SUCCESS_TOAST_MESSAGE = "xpath=//div[contains(@class, 'oxd-toast-content')]//p[contains(@class,'toast-message')]";
}
