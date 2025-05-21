package com.orangeHRM.pim;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.orangeHRM.DashboardPO;
import pageObjects.orangeHRM.LoginPO;
import pageObjects.orangeHRM.PageGenerator;
import pageObjects.orangeHRM.pim.PimAddEmployeePO;
import pageObjects.orangeHRM.pim.PimEmployeeListPO;
import pageObjects.orangeHRM.pim.PimEmployeePersonalDetailPO;

public class PIM_01_Employee extends BaseTest {
    private PimAddEmployeePO pimAddEmployeePage;
    private LoginPO loginPage;
    private PimEmployeeListPO pimEmployeeListPage;
    private DashboardPO dashboardPage;
    private PimEmployeePersonalDetailPO pimEmployeePersonalDetailPage;
    private WebDriver driver;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String middleName;
    private String adminUsername;
    private String adminPassword;
    private int randomNumber;
    private String initialEmployeeID;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName,url);
        adminUsername ="automationfc";
        adminPassword ="Automation@123";
        randomNumber = generateRandom();
        username = "anlh" + randomNumber ;
        password = "AnTest@123";
        firstName = "An";
        middleName = "Hoang";
        lastName = "Le";
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.loginToSystem(adminUsername,adminPassword);
    }

    @Test
    public void Employee_01_Add_New_Employee () throws InterruptedException {
        dashboardPage = PageGenerator.getDashboardPage(driver);

        pimEmployeeListPage = dashboardPage.getPimListPage(driver);

        pimEmployeeListPage.clickToAddNewEmployeeButton();

        pimAddEmployeePage = PageGenerator.getPimAddEmployeePage(driver);

        pimAddEmployeePage.toggleCreateLoginDetailsToggle();
        Assert.assertTrue(pimAddEmployeePage.isDisplayedUsernameTextbox());

        pimAddEmployeePage.clickToSaveButton();

        Assert.assertEquals(pimAddEmployeePage.getFullNameError(),"Required");
        Assert.assertEquals(pimAddEmployeePage.getLastNameError(),"Required");
        Assert.assertEquals(pimAddEmployeePage.getUsernameError(),"Required");
        Assert.assertEquals(pimAddEmployeePage.getPasswordError(),"Required");
        Assert.assertEquals(pimAddEmployeePage.getConfirmPasswordError(),"Passwords do not match");

        pimAddEmployeePage.inputEmployeeFirstName(firstName);
        pimAddEmployeePage.inputEmployeeMiddleName(middleName);
        pimAddEmployeePage.inputEmployeeLastName(lastName);
        initialEmployeeID = pimAddEmployeePage.getInitialEmployeeID();
        pimAddEmployeePage.inputEmployeeUsername(username);
        pimAddEmployeePage.inputEmployeePassword(password);
        pimAddEmployeePage.inputEmployeeConfirmPassword(password);

        pimAddEmployeePage.clickToSaveButton();

        Assert.assertTrue(pimAddEmployeePage.isDisplayedSuccessCreateToastMessage());

    }

    @Test
    public void Employee_02_Add_Upload_Avatar () {

    }

    @Test
    public void Employee_03_Personal_Details () {
        pimEmployeePersonalDetailPage = PageGenerator.getPimEmployeePersonalDetailPage(driver);

        Assert.assertEquals(pimEmployeePersonalDetailPage.getFirstNameText(),firstName);
        Assert.assertEquals(pimEmployeePersonalDetailPage.getMiddleNameText(),middleName);
        Assert.assertEquals(pimEmployeePersonalDetailPage.getLastNameText(),lastName);


    }

    @Test
    public void Employee_04_Contact_Details () {

    }

    @Test
    public void Employee_05_Emergency_Details () {

    }

    @Test
    public void Employee_06_Assigned_Dependents () {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
//        driver.quit();
    }
}
