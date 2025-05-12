package com.jquery;

import commons.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

public class Level_14_Log4j1 extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

    }

    //@Test
    public void TC_01_Switch_Page() throws InterruptedException {
        System.out.println(driver.findElement(By.xpath("//h1")).getText());

        log.info("Table_01_Data_Grid STEP_01: Click to Page Button");
        homePage.waitForPageButtonClickable("1");
        homePage.clickToPageButton("1");
        homePage.sleepInSeconds(2);


        verifyTrue(homePage.isPageButtonActive("1"));

        homePage.waitForPageButtonClickable("10");
        homePage.clickToPageButton("10");
        homePage.sleepInSeconds(2);

        verifyTrue(homePage.isPageButtonActive("10"));

        homePage.waitForPageButtonClickable("14");
        homePage.clickToPageButton("14");
        homePage.sleepInSeconds(2);

        verifyTrue(homePage.isPageButtonActive("14"));



    }

    //@Test
    public void TC_02_Search_Bar() throws InterruptedException {
        //input value to searchbox Country
        homePage.enterToTextBoxByHeaderName("headerName", "Georgia");
        homePage.sleepInSeconds(2);
        homePage.refreshCurrentPage(driver);

        //validate data in row
    }

    //@Test
    public void TC_03_Delete_Record() {

    }

    @Test
    public void TC_04_Input_Data_To_Grid() throws InterruptedException {
        log.info("Table_Feature_01 STEP 01: Click to Load Button");
        homePage.clickToLoadDataButton();
        verifyTrue(driver.findElement(By.cssSelector("a.download")).isDisplayed());


        log.info("Table_Feature_01 STEP 02: Send Key to Cell");
        homePage.sendkeyToCellByRowIndexAndColumnName("3","Contact Person", "Seiko Ayase");
        homePage.sleepInSeconds(2);


        log.info("Table_Feature_01 STEP 03: Send Key to Cell");
        homePage.sendkeyToCellByRowIndexAndColumnName("5","Company", "Google");
        homePage.sleepInSeconds(2);


        log.info("Table_Feature_01 STEP 04: Send Key to Cell");
        homePage.sendkeyToCellByRowIndexAndColumnName("1","Contact Person", "Mikasa Ackerman");
        homePage.sleepInSeconds(1);

        log.info("Table_Feature_01 STEP 05: Send Key to Cell");
        homePage.sendkeyToCellByRowIndexAndColumnName("1","Order Placed", "123");
        homePage.sleepInSeconds(1);

        log.info("Table_Feature_01 STEP 06: Send Key to Cell");
        homePage.selectToDropdownByIndex("6","Country","Hong Kong");
        homePage.sleepInSeconds(1);

        log.info("Table_Feature_01 STEP 07: Check Text Box");
        homePage.checkToCheckboxByIndex("6","NPO?",true);
        homePage.sleepInSeconds(1);

        log.info("Table_Feature_01 STEP 08: Uncheck Text Box");
        homePage.checkToCheckboxByIndex("6","NPO?",false);
        homePage.sleepInSeconds(1);

        homePage.clickToButtonByIndex("4", "Insert");
        homePage.sleepInSeconds(1);

        homePage.clickToButtonByIndex("3","Move Up");
        homePage.sleepInSeconds(1);

        homePage.clickToButtonByIndex("6","Remove");
        homePage.sleepInSeconds(1);

        homePage.getAllValueOfColumnByColumnName("Order Placed");
        //Text will be blank because these element doesn't have text values but placeholder;

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
