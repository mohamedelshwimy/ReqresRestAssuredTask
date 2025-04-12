package utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JavaUtilities {

    private static String baseUrl = PropertiesLoader.configFile().get("baseUrl");
    private static String createUserEndPoint = PropertiesLoader.configFile().get("createUserEndPoint");
    private static String getUserEndPoint = PropertiesLoader.configFile().get("getUserEndPoint");
    private static String updateUserEndPoint = PropertiesLoader.configFile().get("getUserEndPoint");


    public static String getBaseUrl() {
        return baseUrl;
    }
    public static String getCreateUserEndPoint() {
        return createUserEndPoint;
    }
    public static String getGetUserEndPoint() {
        return getUserEndPoint;
    }
    public static String getUpdateUserEndPoint() {
        return updateUserEndPoint;
    }


    public static String jsonReader(String jsonFilePath) throws FileNotFoundException, IOException {

        final Gson g = new Gson();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJ;
        Object o = g.fromJson(new FileReader(jsonFilePath), Object.class);

        prettyJ = gson.toJson(o);

        return prettyJ;

    }
}
