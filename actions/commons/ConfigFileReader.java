package commons;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private Properties properties;
    private final String propertyFilePath = GlobalConstants.ENVIRONMENT_CONFIG_PATH + "%s.properties";

    //Constructor
    public ConfigFileReader(String serverName) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(String.format(propertyFilePath, serverName)));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
        }
    }

    public String getApplicationUrl() {
        String url = properties.getProperty("App.url");
        if (url != null) return url;
        else throw new RuntimeException("url not specified in the Configuration.properties file.");
    }

    public String getApplicationAdminUserName() {
        String adminUsername = properties.getProperty("App.adminUsername");
        if (adminUsername != null) return adminUsername;
        else throw new RuntimeException("adminUsername is not specified in the Configurations.properties file.");

    }

    public String getApplicationAdminPassword() {
        String adminPassword = properties.getProperty("App.adminPassword");
        if (adminPassword != null) return adminPassword;
        else throw new RuntimeException("adminPassword is not specified in the Configurations.properties file.");

    }
}
