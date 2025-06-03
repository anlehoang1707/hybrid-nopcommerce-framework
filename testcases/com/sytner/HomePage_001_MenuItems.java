package com.sytner;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.sytner.menuitems.*;
import pageObjects.sytner.HomePO;
import pageObjects.sytner.PageGenerator;

public class HomePage_001_MenuItems extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private AboutUsPO aboutUsPage;
    private NewsPO newsPage;
    private CustomerServicePO customerServicePage;
    private CareersPO careersPage;
    private FinancePO financePage;
    private BusinessUsersPO businessUsersPage;

    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeClass(String browserName, String url) throws InterruptedException {
        driver = getBrowser(browserName,url);

        homePage = PageGenerator.getHomePage(driver);
        homePage.waitForCookiePopupVisible();
        homePage.clickToAcceptCookieButton();

    }

    @Test
    public void MenuItems_001_AboutUs() throws InterruptedException {
        homePage.clickToMenuItemsByName("About Us");
        aboutUsPage = PageGenerator.getAboutUsPage(driver);
        Assert.assertEquals(aboutUsPage.getPageUrl(driver),"https://www.sytner.co.uk/about-us");
    }

    @Test
    public void MenuItems_002_News() throws InterruptedException {
        homePage.clickToMenuItemsByName("Latest News");
        newsPage = PageGenerator.getNewsPage(driver);
        Assert.assertEquals(newsPage.getPageUrl(driver),"https://www.sytner.co.uk/news");

    }

    @Test
    public void MenuItems_003_CustomerService() throws InterruptedException {
        homePage.clickToMenuItemsByName("Customer Service & Complaints");
        customerServicePage = PageGenerator.getCustomerServicePage(driver);
        Assert.assertEquals(customerServicePage.getPageUrl(driver),"https://www.sytner.co.uk/customer-service");

    }

    @Test
    public void MenuItems_004_Careers() throws InterruptedException {
        homePage.clickToMenuItemsByName("Careers");
        careersPage = PageGenerator.getCareersPage(driver);
        Assert.assertEquals(careersPage.getPageUrl(driver),"https://www.sytner.co.uk/careers");

    }

    @Test
    public void MenuItems_005_Finance() throws InterruptedException {
        homePage.clickToMenuItemsByName("Finance");
        financePage = PageGenerator.getFinancePage(driver);
        Assert.assertEquals(financePage.getPageUrl(driver),"https://www.sytner.co.uk/finance");
    }

    @Test
    public void MenuItems_006_SavedVehicles() {

    }

    @Test
    public void MenuItems_007_UsedCarSearch() {

    }

    @Test
    public void MenuItems_008_NewCars() {

    }

    @Test
    public void MenuItems_009_CarMaintenance() {

    }

    @Test
    public void MenuItems_010_Promotions() {

    }

    @Test
    public void MenuItems_011_BusinessUsers() throws InterruptedException {
        homePage.clickToMenuItemsByName("Business Users");
        businessUsersPage = PageGenerator.getBusinessUsersPage(driver);
        Assert.assertEquals(businessUsersPage.getPageUrl(driver),"https://www.sytner.co.uk/business-users");
    }

    @Test
    public void MenuItems_012_SellYourCar() {

    }

    @Test
    public void MenuItems_013_DealerLocator() {

    }

    @Test
    public void MenuItems_014_HomeIcon() {

    }

    @Test
    public void MenuItems_015_SytnerGroupLogo() {

    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
