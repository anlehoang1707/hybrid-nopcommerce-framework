package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class BentleyPO extends JumpPointsPO {
    private WebDriver driver;

    public BentleyPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
