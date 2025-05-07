package pageObjects.sidebar;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.SideBarPageObject;

public class DownloadableProductsPageObject extends SideBarPageObject {
    private WebDriver driver;

    public DownloadableProductsPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
