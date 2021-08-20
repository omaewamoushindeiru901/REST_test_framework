package configs;

import utils.PropertiesReader;

public class ServiceConfig {
    public static final String HOST = ServiceConfig.getHost();

    private static String getHost() {
        return new PropertiesReader("src/main/resources/config.properties").get("host");
    }
}
