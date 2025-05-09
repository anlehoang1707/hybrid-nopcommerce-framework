package pageObjects.nopcommerce.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.users.UserSideBarPO;

public class UserRewardPointsPO extends UserSideBarPO {
    private WebDriver driver;

    public UserRewardPointsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
