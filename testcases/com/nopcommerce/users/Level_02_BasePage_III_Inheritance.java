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

public class Level_02_BasePage_III_Inheritance extends BasePage{
    WebDriver driver;
    private String email;
    WebDriverWait explicitWait;
    JavascriptExecutor javascriptExecutor;

    @BeforeClass
    public void beforeClass() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Microsoft/Edge/User Data/");
        edgeOptions.addArguments("--profile-directory=Profile 4");
        driver = new EdgeDriver(edgeOptions);
        driver.get("https://demo.nopcommerce.com/");
        explicitWait = new WebDriverWait(driver,Duration.ofSeconds(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        email = "anle" + generateRandom() + "@gmail.com";
    }

    @Test
    public void TC_01_Register() throws InterruptedException {
        waitForElementClickable(driver,"//a[@class = 'ico-register']");
        clickToElement(driver,"//a[@class = 'ico-register']");
        Assert.assertEquals(getTextElement(driver,"//div[@class='page-title']//h1"),"Register");
        checkTheCheckboxOrRadio(driver,"//input[@id='gender-male']");
        sendkeyToElement(driver,"//input[@id = 'FirstName']","An");
        sendkeyToElement(driver,"//input[@id = 'LastName']","Le");
        sendkeyToElement(driver,"//input[@id = 'Email']",email);
        sendkeyToElement(driver,"//input[@id = 'Company']","Alex");
        sendkeyToElement(driver,"//input[@id = 'Password']","12345678");
        sendkeyToElement(driver,"//input[@id = 'ConfirmPassword']","12345678");
        clickToElement(driver,"//button[contains(@id,'register-button')]");

        Assert.assertEquals(getTextElement(driver,"//div[@class = 'result']"),"Your registration completed");

        clickToElement(driver,"//a[contains(@class,'register-continue-button')]");
        clickToElement(driver,"//a[@class = 'ico-logout']");

    }

    @Test
    public void TC_02_Login() {
        waitForElementClickable(driver,"//a[@class = 'ico-login']");
        clickToElement(driver,"//a[@class = 'ico-login']");

        sendkeyToElement(driver,"//input[@id = 'Email']",email);
        sendkeyToElement(driver,"//input[@id = 'Password']","12345678");
        clickToElement(driver,"//button[contains(@class,'login-button')]");
        Assert.assertTrue(isControlDisplayed(driver,"//a[@class = 'ico-account']"));
    }

    @Test
    public void TC_03_My_Account() {
        waitForElementClickable(driver,"//a[@class = 'ico-account']");
        clickToElement(driver,"//a[@class = 'ico-account']");
        Assert.assertEquals(getAttributeValue(driver,"//input[@id = 'FirstName']","value"),"An");
        Assert.assertEquals(getAttributeValue(driver,"//input[@id = 'LastName']","value"),"Le");
        Assert.assertEquals(getAttributeValue(driver,"//input[@id = 'Email']","value"),email);
        Assert.assertEquals(getAttributeValue(driver,"//input[@id = 'Company']","value"),"Alex");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandom() {
        return new Random().nextInt(99999);
    };
}
