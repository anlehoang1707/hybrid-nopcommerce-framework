package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class MaseratiPO extends JumpPointsPO {
    private WebDriver driver;

    public MaseratiPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
