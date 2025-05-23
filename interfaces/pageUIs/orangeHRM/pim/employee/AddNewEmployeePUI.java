package pageUIs.orangeHRM.pim.employee;

public class AddNewEmployeePUI {
    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@name='firstName']";

    public static final String MIDDLE_NAME_TEXTBOX = "xpath=//input[@name='middleName']";

    public static final String LAST_NAME_TEXTBOX = "xpath=//input[@name='lastName']";

    public static final String EMPLOYEE_ID_TEXTBOX = "xpath=//label[text() = 'Employee Id']//parent::div//following-sibling::div//input";

    public static final String CREATE_LOGIN_DETAILS_TOGGLE ="xpath=//p[text() = 'Create Login Details']//following-sibling::div//input";

    public static final String USERNAME_TEXTBOX = "xpath=//label[text() = 'Username']//parent::div//following-sibling::div//input";

    public static final String PASSWORD_TEXTBOX = "xpath=//label[text() = 'Password']//parent::div//following-sibling::div//input";


    public static final String CONFIRM_PASSWORD_TEXTBOX = "xpath=//label[text() = 'Confirm Password']//parent::div//following-sibling::div//input";

    public static final String SAVE_BUTTON = "xpath=//button[@type = 'submit' and text() =' Save ']";

    public static final String FIRST_NAME_TEXTBOX_ERROR_MESSAGE = FIRST_NAME_TEXTBOX +"//parent::div//following-sibling::span";

    public static final String LAST_NAME_TEXTBOX_ERROR_MESSAGE = LAST_NAME_TEXTBOX + "//parent::div//following-sibling::span";

    public static final String PASSWORD_TEXTBOX_ERROR_MESSAGE = PASSWORD_TEXTBOX + "//parent::div//following-sibling::span";

    public static final String CONFIRM_PASSWORD_TEXTBOX_ERROR_MESSAGE = CONFIRM_PASSWORD_TEXTBOX + "//parent::div//following-sibling::span";

    public static final String USERNAME_TEXTBOX_ERROR_MESSAGE = USERNAME_TEXTBOX + "//parent::div//following-sibling::span";

    public static final String CREATE_SUCCESS_TOAST_MESSAGE = "xpath=//div[contains(@class, 'oxd-toast-content')]//p[contains(@class,'toast-message')]";

    public static final String CONTACT_DETAILS_NAVIGATION_LINK = "xpath =//a[text()='Contact Details']";



}
