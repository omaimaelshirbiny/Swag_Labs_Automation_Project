package utilities;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DataUtils {
    private static final String testDataPath = "src/test/resources/Test-Data/";

    //    TODO: Read from JSON File
    public static String getJsonData(String fileName , String field) throws FileNotFoundException //file , field
    {
        FileReader reader = new FileReader(testDataPath + fileName + ".json");
//        src/test/resources/testData
//        src/test/resources/testData/loginData.json
//        testDataPath with slath/ + file name + .json
        JsonElement jsonElement = JsonParser.parseReader(reader);
        return jsonElement.getAsJsonObject().get(field).getAsString();
    }

    //    TODO: READ DATA FROM PROPERTIES FILE
    public static String getPropertyValue(String fileName , String key) throws IOException
    {
        Properties properties = new Properties();
        properties.load(new FileInputStream(testDataPath + fileName + ".properties"));
        return properties.getProperty(key);
    }
}
