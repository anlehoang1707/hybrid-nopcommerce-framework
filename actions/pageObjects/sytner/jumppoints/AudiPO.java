package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class AudiPO extends JumpPointsPO {
    private WebDriver driver;

    public AudiPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
