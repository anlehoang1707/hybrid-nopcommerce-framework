package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class WolkswagenPO extends JumpPointsPO {
    private WebDriver driver;

    public WolkswagenPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
