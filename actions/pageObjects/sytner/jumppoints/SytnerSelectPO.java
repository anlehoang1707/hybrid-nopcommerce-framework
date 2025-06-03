package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class SytnerSelectPO extends JumpPointsPO {
    private WebDriver driver;

    public SytnerSelectPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
