package pageObjects.nopcommerce.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.users.UserSideBarPO;

public class UserChangePasswordPO extends UserSideBarPO {
    private WebDriver driver;

    public UserChangePasswordPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
