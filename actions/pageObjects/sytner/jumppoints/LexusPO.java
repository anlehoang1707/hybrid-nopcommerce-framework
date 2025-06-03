package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class LexusPO extends JumpPointsPO {
    private WebDriver driver;

    public LexusPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
