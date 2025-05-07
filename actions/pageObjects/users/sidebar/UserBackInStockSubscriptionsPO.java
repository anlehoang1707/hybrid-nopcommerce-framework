package pageObjects.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.users.UserSideBarPO;

public class UserBackInStockSubscriptionsPO extends UserSideBarPO {
    private WebDriver driver;

    public UserBackInStockSubscriptionsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
