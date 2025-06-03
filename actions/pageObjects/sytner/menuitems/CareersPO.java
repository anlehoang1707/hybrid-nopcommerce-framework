package pageObjects.sytner.menuitems;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.MenuItemsPO;

public class CareersPO extends MenuItemsPO {
    private WebDriver driver;

    public CareersPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
