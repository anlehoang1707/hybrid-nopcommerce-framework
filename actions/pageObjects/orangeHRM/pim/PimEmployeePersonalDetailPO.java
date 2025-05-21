package pageObjects.orangeHRM.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.orangeHRM.pim.PimEmployeePersonalDetailPageUI;

public class PimEmployeePersonalDetailPO extends BasePage {
    private WebDriver driver;

    public PimEmployeePersonalDetailPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getFirstNameText() {
        return getAttributeValue(driver, PimEmployeePersonalDetailPageUI.FIRST_NAME_TEXTBOX,"value");
    }

    public String getMiddleNameText() {
        return getAttributeValue(driver, PimEmployeePersonalDetailPageUI.MIDDLE_NAME_TEXTBOX,"value");
    }

    public String getLastNameText() {
        return getAttributeValue(driver, PimEmployeePersonalDetailPageUI.LAST_NAME_TEXTBOX,"value");
    }

    public String getEmployeeIDText() {
        return getAttributeValue(driver, PimEmployeePersonalDetailPageUI.EMPLOYEE_ID_TEXTBOX,"value");
    }
}
