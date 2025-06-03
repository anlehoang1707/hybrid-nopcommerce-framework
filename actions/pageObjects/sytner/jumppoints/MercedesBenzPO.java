package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class MercedesBenzPO extends JumpPointsPO {
    private WebDriver driver;

    public MercedesBenzPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
