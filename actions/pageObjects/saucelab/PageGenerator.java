package pageObjects.saucelab;

import org.openqa.selenium.WebDriver;

public class PageGenerator {

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static ProductListPO getProductListPage(WebDriver driver) {
        return new ProductListPO(driver);
    }
}
