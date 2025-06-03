package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class GraypaulClassicCarsPO extends JumpPointsPO {
    private WebDriver driver;

    public GraypaulClassicCarsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
