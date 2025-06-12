package commons;

import factoryBrowser.BrowserNotSupportedException;
import factoryBrowser.ChromeDriverManager;
import factoryBrowser.EdgeDriverManager;
import factoryBrowser.FirefoxDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait explicitWait;
    public Platform platform;

    public WebDriver getDriver() {
        return driver;
    }

    protected int generateRandom() {
        return new Random().nextInt(9999);
    }

    protected WebDriver getBrowserDriver(String browserName, String url, String osName, String ipAddress, String portNumber) {
        Capabilities capability = null;

        if (osName.toLowerCase().contains("windows")) {
            platform = Platform.WINDOWS;
        } else if (osName.toLowerCase().contains("mac")){
            platform = Platform.MAC;
        } else {
            platform = Platform.LINUX;
        }

        switch (browserName) {
            case "firefox":
                FirefoxOptions fOptions = new FirefoxOptions();
                fOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = fOptions;
                break;
            case "chrome":
                ChromeOptions cOptions = new ChromeOptions();
                cOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = cOptions;
                break;
            case "edge":
                EdgeOptions eOptions = new EdgeOptions();
                eOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = eOptions;
                break;
            case "safari":
                SafariOptions sOptions = new SafariOptions();
                sOptions.setCapability(CapabilityType.PLATFORM_NAME, platform);
                capability = sOptions;
                break;
            default:
                throw new RuntimeException("Browser is not valid!");
        }

        try {
            driver = new RemoteWebDriver(new URL(String.format("http://%s:%s/", ipAddress, portNumber)), capability);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }


    protected WebDriver getBrowser(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Microsoft/Edge/User Data/");
                edgeOptions.addArguments("--profile-directory=Profile 4");
                driver = new EdgeDriver(edgeOptions);
                break;
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Google/Chrome/User Data/");
                chromeOptions.addArguments("--profile-directory=Profile 6");
                driver = new ChromeDriver(chromeOptions);
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Please enter valid Browser name");
        };
        driver.get("https://demo.nopcommerce.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }

    protected WebDriver getBrowserUsingFactoryPattern(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case EDGE:
                driver = new EdgeDriverManager().getDriverBrowser();
                break;
            case CHROME:
                driver = new ChromeDriverManager().getDriverBrowser();
                break;
            case FIREFOX:
                driver = new FirefoxDriverManager().getDriverBrowser();
                break;
            default:
                throw new BrowserNotSupportedException(browserName);
        };

        driver.get("https://demo.nopcommerce.com/");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }

    protected WebDriver getBrowser(String browserName,String url) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case EDGE:
//                EdgeOptions edgeOptions = new EdgeOptions();
//                edgeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Microsoft/Edge/User Data/");
//                edgeOptions.addArguments("--profile-directory=Default");
//                driver = new EdgeDriver(edgeOptions);
                driver = new EdgeDriver();
                break;
            case CHROME:
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Google/Chrome/User Data/");
//                chromeOptions.addArguments("--profile-directory=Profile 6");
//                driver = new ChromeDriver(chromeOptions);
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Please enter valid Browser name");
        };
        driver.get(url);
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }

//
//    protected boolean verifyTrue(boolean condition) {
//        boolean status = true;
//        try {
//            Assert.assertTrue(condition);
//            log.info("---------------------- Passed -----------------------");
//        } catch (Throwable e) {
//            status = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//            log.info("---------------------- Failed -----------------------");
//        }
//        return status;
//    }
//
//    protected boolean verifyFalse(boolean condition) {
//        boolean status = true;
//        try {
//            Assert.assertFalse(condition);
//            log.info("---------------------- Passed -----------------------");
//        } catch (Throwable e) {
//            status = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//            log.info("---------------------- Failed -----------------------");
//        }
//        return status;
//    }
//
//    protected boolean verifyEquals(Object actual, Object expected) {
//        boolean status = true;
//        try {
//            Assert.assertEquals(actual, expected);
//            log.info("---------------------- Passed -----------------------");
//        } catch (Throwable e) {
//            status = false;
//            VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
//            Reporter.getCurrentTestResult().setThrowable(e);
//            log.info("---------------------- Failed -----------------------");
//        }
//        return status;
//    }

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)
        deleteAllFileInFolder("reportNGImage");

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-results");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.PROJECT_PATH + File.separator + folderName;
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

    protected void closeBrowserDriver() {
        String cmd = null;
        try {
            String osName = System.getProperty("os.name").toLowerCase();
            System.out.println("OS name = " + osName);

            String driverInstanceName = driver.toString().toLowerCase();
            System.out.println("Driver instance name = " + driverInstanceName);

            String browserDriverName = null;

            if (driverInstanceName.contains("chrome")) {
                browserDriverName = "chromedriver";
            } else if (driverInstanceName.contains("internetexplorer")) {
                browserDriverName = "IEDriverServer";
            } else if (driverInstanceName.contains("firefox")) {
                browserDriverName = "geckodriver";
            } else if (driverInstanceName.contains("edge")) {
                browserDriverName = "msedgedriver";
            } else if (driverInstanceName.contains("opera")) {
                browserDriverName = "operadriver";
            } else {
                browserDriverName = "safaridriver";
            }

            if (osName.contains("window")) {
                cmd = "taskkill /F /FI \"IMAGENAME eq " + browserDriverName + "*\"";
            } else {
                cmd = "pkill " + browserDriverName;
            }

            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                Process process = Runtime.getRuntime().exec(cmd);
                process.waitFor();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
