package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SideBarPageObject;

public class RewardPointsPageObject extends SideBarPageObject {
    private WebDriver driver;

    public RewardPointsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
