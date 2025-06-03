package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class SmartPO extends JumpPointsPO {
    private WebDriver driver;

    public SmartPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
