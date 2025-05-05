package com.nopcommerce.users;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Random;

public class Level_01_Repeat_Yourself {
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
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-register")));
        driver.findElement(By.cssSelector("a.ico-register")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.page-title>h1")).getText(),"Register");
        driver.findElement(By.cssSelector("input#gender-male"));
        driver.findElement(By.cssSelector("input#FirstName")).sendKeys("An");
        driver.findElement(By.cssSelector("input#LastName")).sendKeys("Le");
        driver.findElement(By.cssSelector("input#Email")).sendKeys(email);
        driver.findElement(By.cssSelector("input#Company")).sendKeys("Alex");
        driver.findElement(By.cssSelector("input#Password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button#register-button")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(),"Your registration completed");
        driver.findElement(By.cssSelector("a.register-continue-button")).click();
        driver.findElement(By.cssSelector("a.ico-logout")).click();

    }

    @Test
    public void TC_02_Login() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-login")));
        driver.findElement(By.cssSelector("a.ico-login")).click();
        driver.findElement(By.cssSelector("input.email")).sendKeys(email);
        driver.findElement(By.cssSelector("input.password")).sendKeys("12345678");
        driver.findElement(By.cssSelector("button.login-button")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("a.ico-account")).isDisplayed());
    }

    @Test
    public void TC_03_My_Account() {
        explicitWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a.ico-account")));
        driver.findElement(By.cssSelector("a.ico-account")).click();
        Assert.assertEquals(driver.findElement(By.cssSelector("input#FirstName")).getDomAttribute("value"),"An");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#LastName")).getDomAttribute("value"),"Le");
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Email")).getDomAttribute("value"),email);
        Assert.assertEquals(driver.findElement(By.cssSelector("input#Company")).getDomAttribute("value"),"Alex");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    private int generateRandom() {
        return new Random().nextInt(99999);
    };
}
