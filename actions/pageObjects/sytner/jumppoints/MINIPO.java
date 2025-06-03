package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class MINIPO extends JumpPointsPO {
    private WebDriver driver;

    public MINIPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
