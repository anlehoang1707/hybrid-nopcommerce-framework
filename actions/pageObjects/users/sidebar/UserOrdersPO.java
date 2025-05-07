package pageObjects.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.users.UserSideBarPO;

public class UserOrdersPO extends UserSideBarPO {
    private WebDriver driver;

    public UserOrdersPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
