package pageObjects.nopcommerce.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.users.UserSideBarPO;

public class UserAddressPO extends UserSideBarPO {
    private WebDriver driver;

    public UserAddressPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
