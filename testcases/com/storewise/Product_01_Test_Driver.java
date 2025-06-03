package com.storewise;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.storewise.HomePO;
import pageObjects.storewise.PageGenerator;
import pageObjects.storewise.ProductListPO;

public class Product_01_Test_Driver extends BaseTest {
    private WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://facebook.com/");
        System.out.println(driver);


    }

    @Test
    public void TC_01_Sort() {
        driver.get("https://google.com/");
        System.out.println(driver);



    }

    @Test
    public void TC_02_Sort() {
        driver.get("https://google.com.vn/");
        System.out.println(driver);


    }

    @Test
    public void TC_03_Sort() {


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}
