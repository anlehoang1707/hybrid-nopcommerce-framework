package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.admin.AdminLoginPageUI;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputUserNameTextBox(String adminUserName) {
        sendkeyToElement(driver, AdminLoginPageUI.USER_NAME_TEXT_BOX,adminUserName);
    }

    public void inputPasswordTextBox(String adminPassword) {
        sendkeyToElement(driver,AdminLoginPageUI.PASSWORD_TEXT_BOX,adminPassword);
    }

    public AdminDashboardPO clickToLoginButton() {
        clickToElement(driver,AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }
}
