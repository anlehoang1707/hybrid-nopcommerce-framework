package pageObjects.orangeHRM.pim;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.orangeHRM.PageGenerator;
import pageUIs.orangeHRM.pim.PimAddEmployeePageUI;
import pageUIs.orangeHRM.pim.PimEmployeeListPageUI;

public class PimEmployeeListPO extends BasePage {
    private WebDriver driver;

    public PimEmployeeListPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewEmployeeButton() {
        waitForElementClickable(driver, PimEmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
        clickToElement(driver, PimEmployeeListPageUI.ADD_EMPLOYEE_BUTTON);
    }

}
