package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class DownloadableProductsPageObject extends BasePage {
    private WebDriver driver;

    public DownloadableProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

}
