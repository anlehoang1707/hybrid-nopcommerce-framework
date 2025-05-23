package pageUIs.orangeHRM;

public class BasePUI {

    public static final String TEXTBOX_BY_NAME = "Css=input[name='%s']";

    public static final String TEXTBOX_BY_LABEL = "Xpath=//label[text()='%s']/parent::div/following-sibling::div//input";

    public static final String LOADING_ICON = "Xpath=//div[contains(@class,'oxd-loading-spinner-container')]";

    public static final String UPLOAD_FILE_TYPE = "Css=input[type = 'file']";

    public static final String ADD_BUTTON_BY_CONTAINER_TEXT = "Xpath=//h6[text()='%s']//following-sibling::button[contains(string(),'Add')]";

    public static final String SUCCESS_MESSSAGE ="Xpath=//div[contains(@class,'oxd-toast--success')]";

    public static final String SAVE_BUTTON_BY_CONTAINER_TEXT = "Xpath=//h6[text() = '%s']//following-sibling::form//button[contains(string(),'Save')]";

    public static final String DROPDOWN_PARENT_LOCATOR_BY_LABEL_TEXT = "Xpath=//label[text()='%s']/parent::div/following-sibling::div/div[@class = 'oxd-select-wrapper']";

    public static final String DROPDOWN_CHILD_LOCATOR_BY_LABEL_TEXT = "Xpath=//label[text()='%s']/parent::div/following-sibling::div/div[@class = 'oxd-select-wrapper']//div[@class = 'oxd-select-option']";
}
