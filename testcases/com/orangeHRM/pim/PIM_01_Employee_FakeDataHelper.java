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
import utilities.FakerConfig;

public class PIM_01_Employee_FakeDataHelper extends BaseTest {
    private AddNewEmployeePO addNewEmployeePage;
    private LoginPO loginPage;
    private EmployeeListPO EmployeeListPage;
    private DashboardPO dashboardPage;
    private PersonalDetailsPO PersonalDetailsPage;
    private ContactDetailsPO contactDetailsPage;
    private EmergencyContactsPO emergencyContactsPage;
    private DependentsPO dependentsPage;
    private WebDriver driver;
    private String username;
    private String password;
    private String firstName, lastName, middleName;
    private String adminUsername, adminPassword;
    private int randomNumber;
    private String initialEmployeeID;
    private String street1,street2,city,stateProvince,zipPostalCode,countryName,homePhone,workPhone,mobilePhone,workEmail,otherEmail;
    private String emergencyContactName, emergencyContactRelationship, emergencyHomePhone;
    private String dependentName;
    private FakerConfig faker;

    @Parameters({"browser","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowser(browserName,url);
        faker = FakerConfig.getFaker();
        adminUsername ="automationfc";
        adminPassword ="Automation@123";
        randomNumber = generateRandom();
        username = faker.getUserName();
        password = faker.getPassword();
        firstName = faker.getFirstName();
        middleName = faker.getMiddleName();
        lastName = faker.getLastName();
        loginPage = PageGenerator.getLoginPage(driver);
        loginPage.loginToSystem(adminUsername,adminPassword);
        street1 = faker.getStreetAddress();
        street2 = faker.getStreetAddress();
        city = faker.getCity();
        stateProvince = faker.getCity();
        zipPostalCode = faker.getZipCode();
        countryName = faker.getCountry();
        homePhone = faker.getPhone();
        mobilePhone= faker.getMobilePhone();
        workPhone = faker.getPhone();
        workEmail = faker.getEmail();
        otherEmail = faker.getEmail();
        emergencyContactName = faker.getFullName();
        emergencyContactRelationship = faker.getRelationship();
        emergencyHomePhone = faker.getPhone();
        dependentName = faker.getFullName();

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

        addNewEmployeePage.inputEmployeeFirstName(firstName);
        addNewEmployeePage.inputEmployeeMiddleName(middleName);
        addNewEmployeePage.inputEmployeeLastName(lastName);
        initialEmployeeID = addNewEmployeePage.getInitialEmployeeID();
        addNewEmployeePage.inputEmployeeUsername(username);
        addNewEmployeePage.inputEmployeePassword(password);
        addNewEmployeePage.inputEmployeeConfirmPassword(password);

        addNewEmployeePage.clickToSaveButton();

        Assert.assertEquals(addNewEmployeePage.getSuccessCreateToastMessage(),"Successfully Saved");
    }

    @Test
    public void Employee_02_Add_Upload_Avatar () {

    }

    @Test
    public void Employee_03_Personal_Details () {
        PersonalDetailsPage = PageGenerator.getPersonalDetailsPage(driver);

        Assert.assertEquals(PersonalDetailsPage.getFirstNameText(),firstName);
        Assert.assertEquals(PersonalDetailsPage.getMiddleNameText(),middleName);
        Assert.assertEquals(PersonalDetailsPage.getLastNameText(),lastName);

    }
    @Test
    public void Employee_04_Contact_Details () throws InterruptedException {

        contactDetailsPage = PersonalDetailsPage.getContactDetailsPage(driver);

        Thread.sleep(2000);
        contactDetailsPage.inputStreet1(street1);
        contactDetailsPage.inputStreet2(street2);
        contactDetailsPage.inputCity(city);
        contactDetailsPage.inputStateProvince(stateProvince);
        contactDetailsPage.inputZipPostalCode(zipPostalCode);
        contactDetailsPage.selectCountryByVisibleTextValue(countryName);
        contactDetailsPage.inputHomePhone(homePhone);
        contactDetailsPage.inputMobilePhone(mobilePhone);
        contactDetailsPage.inputWorkPhone(workPhone);
        contactDetailsPage.inputWorkEmail(workEmail);
        contactDetailsPage.inputOtherEmail(otherEmail);
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
        emergencyContactsPage.sendKeyToTextBoxByLabelText(driver,"Name",emergencyContactName);
        emergencyContactsPage.sendKeyToTextBoxByLabelText(driver,"Relationship",emergencyContactRelationship);
        emergencyContactsPage.sendKeyToTextBoxByLabelText(driver,"Home Telephone",emergencyHomePhone);
        emergencyContactsPage.clickToSaveButtonByContainerText(driver,"Save Emergency Contact");

        Assert.assertTrue(emergencyContactsPage.isDisplayedSuccessMessage(driver));

    }

    @Test
    public void Employee_06_Assigned_Dependents () {
        dependentsPage = (DependentsPO) emergencyContactsPage.getPageByNavLinkText("Dependents");

        //Apply POM
        dependentsPage.clickToAddButtonByContainerText(driver,"Assigned Dependents");
        dependentsPage.sendKeyToTextBoxByLabelText(driver,"Name",dependentName);
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
