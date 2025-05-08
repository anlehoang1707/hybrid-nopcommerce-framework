package com.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_02_BasePage_II_StaticMethod {
    WebDriver driver;
    private String email;
    WebDriverWait explicitWait;
    JavascriptExecutor javascriptExecutor;
    BasePage basePage; //Declare basePage

    @BeforeClass
    public void beforeClass() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 4");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.nopcommerce.com/");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        basePage = BasePage.getBasePage();
        email = "anle" + generateRandom() + "@gmail.com";
    }

    @Test
    public void TC_01_Register() throws InterruptedException {
        basePage.waitForElementClickable(driver,"//a[@class = 'ico-register']");
        basePage.clickToElement(driver,"//a[@class = 'ico-register']");

        Assert.assertEquals(basePage.getTextElement(driver,"//div[@class='page-title']//h1"),"Register");
        basePage.checkTheCheckboxOrRadio(driver,"//input[@id='gender-male']");
        basePage.sendkeyToElement(driver,"//input[@id = 'FirstName']","An");
        basePage.sendkeyToElement(driver,"//input[@id = 'LastName']","Le");
        basePage.sendkeyToElement(driver,"//input[@id = 'Email']",email);
        basePage.sendkeyToElement(driver,"//input[@id = 'Company']","Alex");
        basePage.sendkeyToElement(driver,"//input[@id = 'Password']","12345678");
        basePage.sendkeyToElement(driver,"//input[@id = 'ConfirmPassword']","12345678");
        basePage.clickToElement(driver,"//button[contains(@id,'register-button')]");

        Assert.assertEquals(basePage.getTextElement(driver,"//div[@class = 'result']"),"Your registration completed");

        basePage.clickToElement(driver,"//a[contains(@class,'register-continue-button')]");
        basePage.clickToElement(driver,"//a[@class = 'ico-logout']");

    }

    @Test
    public void TC_02_Login() {
        basePage.waitForElementClickable(driver,"//a[@class = 'ico-login']");
        basePage.clickToElement(driver,"//a[@class = 'ico-login']");

        basePage.sendkeyToElement(driver,"//input[@id = 'Email']",email);
        basePage.sendkeyToElement(driver,"//input[@id = 'Password']","12345678");
        basePage.clickToElement(driver,"//button[contains(@class,'login-button')]");
        Assert.assertTrue(basePage.isControlDisplayed(driver,"//a[@class = 'ico-account']"));
    }

    @Test
    public void TC_03_My_Account() {
        basePage.waitForElementClickable(driver,"//a[@class = 'ico-account']");
        basePage.clickToElement(driver,"//a[@class = 'ico-account']");
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id = 'FirstName']","value"),"An");
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id = 'LastName']","value"),"Le");
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id = 'Email']","value"),email);
        Assert.assertEquals(basePage.getAttributeValue(driver,"//input[@id = 'Company']","value"),"Alex");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandom() {
        return new Random().nextInt(99999);
    };
}
