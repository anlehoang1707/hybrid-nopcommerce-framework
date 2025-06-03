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
import pageObjects.orangeHRM.pim.employee.*;

public class PIM_01_Employee_POJO_Plain_Old_Java_Object_Local extends BaseTest {
    private AddNewEmployeePO addNewEmployeePage;
    private LoginPO loginPage;
    private EmployeeListPO EmployeeListPage;
    private DashboardPO dashboardPage;
    private PersonalDetailsPO PersonalDetailsPage;
    private ContactDetailsPO contactDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private DependentsPO dependentsPage;
    private WebDriver driver;
    private String adminUsername, adminPassword;
    private int randomNumber;
    private String initialEmployeeID;
    private EmployeeData employeeData;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
//        driver = getBrowser(browserName,url);
        driver = getBrowser(browserName,url);
        adminUsername ="automationfc";
        adminPassword ="Automation@123";
        randomNumber = generateRandom();

        employeeData = EmployeeData.getEmployeeData();
        employeeData.setUsername("anlh" + randomNumber);
        employeeData.setPassword("AnTest@123");
        employeeData.setFirstName("An");
        employeeData.setMiddleName("Hoang");
        employeeData.setLastName("Le");
        employeeData.setStreet1("Street 1 Name");
        employeeData.setStreet2("Street 2 Name");
        employeeData.setCity("HCMC");
        employeeData.setStateProvince("Q1");
        employeeData.setZipPostalCode("700000");
        employeeData.setCountryName("Viet Nam");
        employeeData.setHomePhone("0123456789");
        employeeData.setMobilePhone("0913351349");
        employeeData.setWorkPhone("0123456789");
        employeeData.setWorkEmail("anlh" + randomNumber + "@company.com");
        employeeData.setOtherEmail("an.lehoang" + randomNumber + "@gmail.com");
        employeeData.setEmergencyContactName("Alex");
        employeeData.setEmergencyContactRelationship("Brother");
        employeeData.setEmergencyHomePhone("9123456789");
        employeeData.setDependentName("Alexi");

        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.loginToSystem(adminUsername,adminPassword);
    }

    @Test
    public void Employee_01_Add_New_Employee () throws InterruptedException {
        dashboardPage = PageGenerator.getDashboardPage(driver);

        EmployeeListPage = dashboardPage.getPimListPage(driver);

        EmployeeListPage.clickToAddNewEmployeeButton();

        addNewEmployeePage = PageGenerator.getPimAddEmployeePage(driver);

        addNewEmployeePage.toggleCreateLoginDetailsToggle();
        Assert.assertTrue(addNewEmployeePage.isDisplayedUsernameTextbox());

        addNewEmployeePage.clickToSaveButton();

        Assert.assertEquals(addNewEmployeePage.getFullNameError(),"Required");
        Assert.assertEquals(addNewEmployeePage.getLastNameError(),"Required");
        Assert.assertEquals(addNewEmployeePage.getUsernameError(),"Required");
        Assert.assertEquals(addNewEmployeePage.getPasswordError(),"Required");
        Assert.assertEquals(addNewEmployeePage.getConfirmPasswordError(),"Passwords do not match");

        addNewEmployeePage.inputEmployeeInfo(employeeData);

        employeeData.setInitialEmployeeID(addNewEmployeePage.getInitialEmployeeID());
        initialEmployeeID = employeeData.getInitialEmployeeID();

        addNewEmployeePage.clickToSaveButton();

        Assert.assertEquals(addNewEmployeePage.getSuccessCreateToastMessage(),"Successfully Saved");
    }

    @Test
    public void Employee_02_Add_Upload_Avatar () {

    }

    @Test
    public void Employee_03_Personal_Details () {
        PersonalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);

        Assert.assertEquals(PersonalDetailsPage.getFirstNameText(),employeeData.getFirstName());
        Assert.assertEquals(PersonalDetailsPage.getMiddleNameText(),employeeData.getMiddleName());
        Assert.assertEquals(PersonalDetailsPage.getLastNameText(),employeeData.getLastName());

    }
    @Test
    public void Employee_04_Contact_Details () throws InterruptedException {

        contactDetailsPage = PersonalDetailsPage.getContactDetailsPage(driver);

        Thread.sleep(2000);

        contactDetailsPage.inputEmployeeContactDetailsInfo(employeeData);

        contactDetailsPage.clickToSaveButton();

        Assert.assertEquals(contactDetailsPage.getSuccessUpdateToastMessageContent(),"Successfully Updated");

    }

    @Test
    public void Employee_05_Emergency_Details () {
        //emergencyContactsPage = PageGenerator.getEmergencyContactsPage(driver);
        emergencyContactsPage = (EmergencyContactsPO) contactDetailsPage.getPageByNavLinkText("Emergency Contacts");

        // Apply POM
        //emergencyContactsPage.clickToAddButtonAtAssignedEmergencyContactContainer();
        //emergencyContactsPage.inputEmergencyContactName(emergencyContactName);
        //emergencyContactsPage.inputEmergencyContactRelationship(emergencyContactRelationship);

        //Apply Pattern Object
        emergencyContactsPage.clickToAddButtonByContainerText(driver,"Assigned Emergency Contacts");
        emergencyContactsPage.sendKeyToTextBoxByLabelText(driver,"Name", employeeData.getEmergencyContactName());
        emergencyContactsPage.sendKeyToTextBoxByLabelText(driver,"Relationship", employeeData.getEmergencyContactRelationship());
        emergencyContactsPage.sendKeyToTextBoxByLabelText(driver,"Home Telephone", employeeData.getEmergencyHomePhone());
        emergencyContactsPage.clickToSaveButtonByContainerText(driver,"Save Emergency Contact");

        Assert.assertTrue(emergencyContactsPage.isDisplayedSuccessMessage(driver));

    }

    @Test
    public void Employee_06_Assigned_Dependents () {
        dependentsPage = (DependentsPO) emergencyContactsPage.getPageByNavLinkText("Dependents");

        //Apply POM
        dependentsPage.clickToAddButtonByContainerText(driver,"Assigned Dependents");
        dependentsPage.sendKeyToTextBoxByLabelText(driver,"Name",employeeData.getDependentName());
        dependentsPage.selectItemInCustomDropdownByLabelText(driver,"Relationship","Child");
        dependentsPage.clickToSaveButtonByContainerText(driver,"Add Dependent");

        Assert.assertTrue(dependentsPage.isDisplayedSuccessMessage(driver));


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        closeBrowserDriver();
//        driver.quit();
    }
}
