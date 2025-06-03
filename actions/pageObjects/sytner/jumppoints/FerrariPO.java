package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class FerrariPO extends JumpPointsPO {
    private WebDriver driver;

    public FerrariPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
