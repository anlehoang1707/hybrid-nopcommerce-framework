package pageObjects.bankguru99;

import org.openqa.selenium.WebDriver;
import pageObjects.bankguru99.customer.AddNewCustomerPO;

public class PageGenerator {
    private WebDriver driver;

    public static LoginPO getLoginPage(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static AddNewCustomerPO getAddNewCustomerPage(WebDriver driver) {
        return new AddNewCustomerPO(driver);
    }

}
