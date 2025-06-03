package pageObjects.sytner.menuitems;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.MenuItemsPO;

public class BusinessUsersPO extends MenuItemsPO {

    private WebDriver driver;

    public BusinessUsersPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
