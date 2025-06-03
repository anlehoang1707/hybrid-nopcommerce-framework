package pageObjects.sytner.menuitems;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.sytner.MenuItemsPO;

public class AboutUsPO extends MenuItemsPO {
    private WebDriver driver;

    public AboutUsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public String getAboutUsUrl() {
        return driver.getCurrentUrl();
    }
}
