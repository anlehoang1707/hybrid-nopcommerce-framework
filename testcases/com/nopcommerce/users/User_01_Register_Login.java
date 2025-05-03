package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_01_Register_Login {
    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.get("https://demo.nopcommerce.com/");

    }

    @Test
    public void TC_01_Register() {

    }

    @Test
    public void TC_02_Login() {

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
