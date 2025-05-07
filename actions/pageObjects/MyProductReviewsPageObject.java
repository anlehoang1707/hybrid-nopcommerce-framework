package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class MyProductReviewsPageObject extends BasePage {
    private WebDriver driver;

    public MyProductReviewsPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
