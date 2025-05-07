package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SideBarPageObject;

public class BackInStockSubscriptionsPageObject extends SideBarPageObject {
    private WebDriver driver;

    public BackInStockSubscriptionsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
