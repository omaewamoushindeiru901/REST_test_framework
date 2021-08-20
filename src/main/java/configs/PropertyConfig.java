package configs;

import utils.PropertiesReader;

public class PropertyConfig {

    public static String getProps(String props){
        PropertiesReader properties=new PropertiesReader("src/main/resources/config.properties");
        if ("host".equals(props)) {
            return properties.get("host");
        } else if ("lib".equals(props)) {
            return properties.get("lib");
        } else if ("jsonPath".equals(props)) {
            return properties.get("json.file.path");
        }
        throw new RuntimeException("Invalid properties");
    }
}
