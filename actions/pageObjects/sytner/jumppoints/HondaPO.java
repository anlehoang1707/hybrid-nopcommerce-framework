package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class HondaPO extends JumpPointsPO {
    private WebDriver driver;

    public HondaPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
