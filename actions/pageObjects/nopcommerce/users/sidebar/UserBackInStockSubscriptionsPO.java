package pageObjects.nopcommerce.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.users.UserSideBarPO;

public class UserBackInStockSubscriptionsPO extends UserSideBarPO {
    private WebDriver driver;

    public UserBackInStockSubscriptionsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
