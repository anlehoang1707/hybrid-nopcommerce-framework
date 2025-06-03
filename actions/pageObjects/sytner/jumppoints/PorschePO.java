package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class PorschePO extends JumpPointsPO {
    private WebDriver driver;

    public PorschePO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
