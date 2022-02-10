package selenium;

import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void getProperties() throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("src/main/resources/properties/config.properties");
        prop.load(input);
        prop.getProperty("browser");
        System.out.println(prop);
    }

    @Test
    public void setProperties() throws IOException {
        Properties prop = new Properties();
        OutputStream output = new FileOutputStream("src/main/resources/properties/config.properties");
        prop.setProperty("browser", "Firefox");
        prop.store(output, null);
    }
}
