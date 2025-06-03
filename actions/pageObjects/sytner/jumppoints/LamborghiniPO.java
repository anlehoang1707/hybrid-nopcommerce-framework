package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class LamborghiniPO extends JumpPointsPO {
    private WebDriver driver;

    public LamborghiniPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
