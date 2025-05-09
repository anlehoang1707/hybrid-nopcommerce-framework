package pageObjects.nopcommerce.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.users.UserSideBarPO;

public class UserDownloadableProductsPO extends UserSideBarPO {
    private WebDriver driver;

    public UserDownloadableProductsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
