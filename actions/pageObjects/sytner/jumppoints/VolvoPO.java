package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class VolvoPO extends JumpPointsPO {
    private WebDriver driver;

    public VolvoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
