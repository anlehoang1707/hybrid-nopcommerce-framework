package com.storewise;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.storewise.HomePO;
import pageObjects.storewise.PageGenerator;
import pageObjects.storewise.ProductListPO;

public class Product_01_Sort extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private ProductListPO productListPage;

    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName, url);

        homePage = PageGenerator.getHomePage(driver);

        homePage.clickToCloseCountDownPopup();

        homePage.clickToAcceptCookiePopup();

        homePage.changeToEnglishLanguage();

        homePage.clickToCloseToggleCart();

    }

    @Test
    public void TC_01_Sort_Price_Asc() {
        driver.get("https://storewisetest.sites.self-point.com/categories/79698/products");

        productListPage = PageGenerator.getProductListPage(driver);

        productListPage.clickToSortPriceAsc();

        Assert.assertTrue(productListPage.isProductPriceDataSortedAsc());


    }

    @Test
    public void TC_02_Sort_Price_Desc() {
        driver.get("https://storewisetest.sites.self-point.com/categories/79698/products");

        productListPage.clickToSortPriceDesc();

        Assert.assertTrue(productListPage.isProductPriceDataSortedDesc());
    }

    @Test
    public void TC_03_Sort() {


    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
    }

}
