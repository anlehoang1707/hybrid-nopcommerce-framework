package pageObjects.storewise;

import org.openqa.selenium.WebDriver;

public class PageGenerator {
    public static HomePO getHomePage(WebDriver driver) {
        return new HomePO(driver);
    }

    public static ProductListPO getProductListPage(WebDriver driver) {
        return new ProductListPO(driver);
    }

}
