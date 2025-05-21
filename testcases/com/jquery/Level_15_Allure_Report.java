package com.jquery;

import commons.BaseTest;
import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jquery.HomePO;
import pageObjects.jquery.PageGenerator;

@Epic("Regression Test")
@Feature("Table_Grid_Test")
public class Level_15_Allure_Report extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName,url);
        homePage = PageGenerator.getHomePage(driver);

    }

    @Description("Table_01_SwitchPage")
    @Story("As a User, I want to switch to different page")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_01_Switch_Page() throws InterruptedException {
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        homePage.waitForPageButtonClickable("1");
        homePage.clickToPageButton("1");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageButtonActive("1"));

        homePage.waitForPageButtonClickable("10");
        homePage.clickToPageButton("10");
        homePage.sleepInSeconds(2);

        Assert.assertTrue(homePage.isPageButtonActive("10"));

        homePage.waitForPageButtonClickable("14");
        homePage.clickToPageButton("14");
        homePage.sleepInSeconds(2);
        Assert.assertTrue(homePage.isPageButtonActive("14"));



    }

    @Description("Table_02_InputSearchBar")
    @Story("As a User, I want to input data to Search Bar of Column Header")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_02_Search_Bar() throws InterruptedException {
        //input value to searchbox Country
        homePage.enterToTextBoxByHeaderName("Contact Person", "Georgia");
        homePage.sleepInSeconds(2);
        homePage.refreshCurrentPage(driver);

        //validate data in row
    }

    //@Test
    public void TC_03_Delete_Record() {

    }

    @Description("Table_03_InputMultipleCells")
    @Story("As a User, I want to input data to Table Grid")
    @Severity(SeverityLevel.NORMAL)
    @Test
    public void TC_04_Input_Data_To_Grid() throws InterruptedException {
        homePage.clickToLoadDataButton();

        homePage.sendkeyToCellByRowIndexAndColumnName("3","Contact Person", "Seiko Ayase");
        homePage.sleepInSeconds(2);

        homePage.sendkeyToCellByRowIndexAndColumnName("5","Company", "Google");
        homePage.sleepInSeconds(2);

        homePage.sendkeyToCellByRowIndexAndColumnName("1","Contact Person", "Mikasa Ackerman");
        homePage.sleepInSeconds(1);

        homePage.sendkeyToCellByRowIndexAndColumnName("1","Order Placed", "123");
        homePage.sleepInSeconds(1);

        homePage.selectToDropdownByIndex("6","Country","Hong Kong");
        homePage.sleepInSeconds(1);

        homePage.checkToCheckboxByIndex("6","NPO?",true);
        homePage.sleepInSeconds(1);

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
