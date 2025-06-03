package pageObjects.sytner.jumppoints;

import org.openqa.selenium.WebDriver;
import pageObjects.sytner.JumpPointsPO;

public class SEATPO extends JumpPointsPO {
    private WebDriver driver;

    public SEATPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
