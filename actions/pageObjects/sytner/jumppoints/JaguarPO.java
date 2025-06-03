package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class JaguarPO extends JumpPointsPO {
    private WebDriver driver;

    public JaguarPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
