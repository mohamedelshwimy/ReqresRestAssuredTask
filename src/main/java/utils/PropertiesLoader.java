package utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesLoader {
    public static Map<String, String> propLoader = new HashMap<String, String>();
    public static Properties propMain = new Properties();

    public static Map<String, String> configFile() {
        try {
                FileInputStream fisTest = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
                propMain.load(fisTest);
                propLoader.put("baseUrl", propMain.getProperty("baseUrl"));
                propLoader.put("createUserEndPoint", propMain.getProperty("createUserEndPoint"));
                propLoader.put("getUserEndPoint", propMain.getProperty("getUserEndPoint"));
                propLoader.put("updateUserEndPoint", propMain.getProperty("updateUserEndPoint"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return propLoader;
    }
}