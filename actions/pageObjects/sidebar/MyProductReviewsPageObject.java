package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SideBarPageObject;

public class MyProductReviewsPageObject extends SideBarPageObject {
    private WebDriver driver;

    public MyProductReviewsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
