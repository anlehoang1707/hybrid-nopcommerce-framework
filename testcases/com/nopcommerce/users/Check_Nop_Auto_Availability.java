package com.nopcommerce.users;

import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Check_Nop_Auto_Availability {
    WebDriver driver;
    WebDriverWait explicitWait;

    @BeforeClass
    public void beforeClass() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 4");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.nopcommerce.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
    }

    @Test
    public void Test_Availability() {
        driver.findElement(By.xpath("//a[@class = 'ico-register']")).click();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
