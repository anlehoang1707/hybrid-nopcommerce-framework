package com.nopcommerce.users;

import commons.BaseTest;
import commons.ConfigFileReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Level_24_Multiple_Environments extends BaseTest {

    private WebDriver driver;
    private String url;
    private String adminUsername;
    private String adminPassword;
    private ConfigFileReader configFileReader;
    @Parameters({"browser","server"})
    @BeforeClass
    public void beforeClass(String browserName,String serverName) {
        configFileReader = new ConfigFileReader(serverName);
        url = configFileReader.getApplicationUrl();
        adminUsername = configFileReader.getApplicationAdminUserName();
        adminPassword = configFileReader.getApplicationAdminPassword();
    }

    @Test
    public void User_01_Register() {
        System.out.println(url);
        System.out.println(adminUsername);
        System.out.println(adminPassword);

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
    }
}
