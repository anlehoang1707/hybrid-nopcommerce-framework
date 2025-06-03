package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class LandRoverPO extends JumpPointsPO {
    private WebDriver driver;

    public LandRoverPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
