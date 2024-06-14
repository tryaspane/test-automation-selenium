package utils;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;
@AllArgsConstructor
public class SystemUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(SystemUtils.class);
    private static final String configFilepath = "src/main/resources/config.properties";
    public static Properties configReader(String path) {
        File propertyFilePath = new File(path);
        BufferedReader reader;
        Properties properties;

        try {
            reader = new BufferedReader(new FileReader(propertyFilePath));
            properties = new Properties();
            try {
                properties.load(reader);
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration not found at " + propertyFilePath);
        }
        return properties;
    }

    public static String getConfig(String configName) {
        LOGGER.debug("getting config of = {}", configName);
        String value = configReader(configFilepath).getProperty(configName);
        LOGGER.debug("value = {}", value);
        return value;
    }

    public static void threadSleep(long millis){
        LOGGER.debug("sleeping thread in = {} milliseconds", millis);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
