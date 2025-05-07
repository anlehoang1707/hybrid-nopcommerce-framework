package pageObjects.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.users.UserSideBarPO;

public class UserAddressPO extends UserSideBarPO {
    private WebDriver driver;

    public UserAddressPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
