package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class RollsRoycePO extends JumpPointsPO {
    private WebDriver driver;

    public RollsRoycePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
