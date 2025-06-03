package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;
import pageObjects.sytner.MenuItemsPO;

public class AlpinaPO extends JumpPointsPO {
    private WebDriver driver;

    public AlpinaPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
