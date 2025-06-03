package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class McLarenPO extends JumpPointsPO {
    private WebDriver driver;

    public McLarenPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
