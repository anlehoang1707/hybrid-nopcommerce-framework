package pageObjects.nopcommerce.users.sidebar;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.users.UserSideBarPO;

public class UserMyProductReviewsPO extends UserSideBarPO {
    private WebDriver driver;

    public UserMyProductReviewsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
