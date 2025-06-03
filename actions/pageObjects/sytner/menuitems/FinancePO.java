package pageObjects.sytner.menuitems;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.MenuItemsPO;

public class FinancePO extends MenuItemsPO {
    private WebDriver driver;

    public FinancePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
