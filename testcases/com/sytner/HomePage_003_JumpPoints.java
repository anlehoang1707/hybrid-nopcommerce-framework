package com.sytner;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.sytner.HomePO;
import pageObjects.sytner.PageGenerator;
import pageObjects.sytner.jumppoints.*;

public class HomePage_003_JumpPoints extends BaseTest {
    private WebDriver driver;
    private HomePO homePage;
    private AlpinaPO alpinaPage;
    private AudiPO audiPage;
    private BentleyPO bentleyPage;
    private BMWPO bmwPage;
    private FerrariPO ferrariPage;
    private HondaPO hondaPage;
    private JaguarPO jaguarPage;
    private LandRoverPO landRoverPage;
    private LamborghiniPO lamborghiniPage;
    private LexusPO lexusPage;
    private MaseratiPO maseratiPage;
    private McLarenPO mcLarenPage;
    private MercedesBenzPO mercedesBenzPage;
    private MINIPO miniPage;
    private PorschePO porschePage;
    private RollsRoycePO rollsRoycePage;
    private SEATPO seatPage;
    private SmartPO smartPage;
    private WolkswagenPO wolkswagenPage;
    private VolvoPO volvoPage;
    private SytnerSelectPO sytnerSelectPage;
    private GraypaulClassicCarsPO graypaulClassicCarsPage;


    @Parameters({"browser","url"})
    @BeforeMethod
    public void beforeClass(String browserName, String url) throws InterruptedException {
        driver = getBrowser(browserName,url);

        homePage = PageGenerator.getHomePage(driver);
        homePage.waitForCookiePopupVisible();
        homePage.clickToAcceptCookieButton();

    }

    @Test
    public void JumpPoints_001_Alpina() throws InterruptedException {
        homePage.clickToMenuItemsByBrandName("Alpina");
        alpinaPage = PageGenerator.getAlpinaPage(driver);
        Assert.assertTrue(alpinaPage.getPageTitle(driver).contains("Alpina"));
    }

    @AfterMethod(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
