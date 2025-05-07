package pageObjects.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class AdminDashboardPO extends BasePage {
    private WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        this.driver = driver;
    }
}
