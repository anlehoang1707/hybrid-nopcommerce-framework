package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class BMWPO extends JumpPointsPO {
    private WebDriver driver;

    public BMWPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
