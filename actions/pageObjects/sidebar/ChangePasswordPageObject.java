package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SideBarPageObject;

public class ChangePasswordPageObject extends SideBarPageObject {
    private WebDriver driver;

    public ChangePasswordPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
