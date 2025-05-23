package pageObjects.orangeHRM.pim.employee;

import org.openqa.selenium.WebDriver;

public class DependentsPO extends EmployeeMenuPO{
    private WebDriver driver;

    public DependentsPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
