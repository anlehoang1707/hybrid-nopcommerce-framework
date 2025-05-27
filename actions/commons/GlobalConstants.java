package commons;

public class GlobalConstants {
    // System Info
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");


    // App Info User
    public static final String DEV_USER_URL = "https://dev.techpanda.org/";
    public static final String STAGING_USER_URL = "https://staging.techpanda.org/";
    public static final String LIVE_USER_URL = "https://live.techpanda.org/";

    // App Info Admin
    public static final String DEV_ADMIN_URL = "https://dev.techpanda.org/index.php/backendlogin";
    public static final String STAGING_ADMIN_URL = "https://staging.techpanda.org/index.php/backendlogin";
    public static final String LIVE_ADMIN_URL = "https://live.techpanda.org/index.php/backendlogin";

    public static final String ADMIN_USERNAME = "user01";
    public static final String ADMiN_PASSWORD = "guru99com";

    // Wait Info
    public static final long SHORT_TIMEOUT = 5;
    public static final long LONG_TIMEOUT = 5;

    // Download/ Upload file
    public static final String UPLOAD_PATH = PROJECT_PATH +"/uploadFiles/";
    public static final String DOWNLOAD_PATH = PROJECT_PATH + "/downloadFiles/";

    // Retry Case Failed
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/ Extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + "/browserExtensions/";

    // HTML Report Folder
    public static final String REPORTING_PATH = PROJECT_PATH + "/htmlReportNG/";
    public static final String EXTENT_PATH = PROJECT_PATH + "/htmlExtent/";
    public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";

    // Data Test/ Environment
    public static final String DATA_TEST_PATH = PROJECT_PATH + "/testData/";
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + "/environmentConfig/";

    //For OrangeHRM5
    public static final String EMPLOYEE_DATA_TEST_PATH = PROJECT_PATH + "/testData/com/orangeHRM/pim/";


}
