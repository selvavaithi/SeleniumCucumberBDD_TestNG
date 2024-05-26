package Common;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public class ConfigLoader {
    public static final String env = System.getProperty("env","test");
    public static final String propertiesFile = "configs/"+env+"/_env.properties";
    public static final Config config = ConfigFactory.load(propertiesFile)
            .withFallback(ConfigFactory.load("configs/general.properties"))
            .withFallback(ConfigFactory.load("uiMap/uiItems.properties"));

    public static final int plsWaitTimeOut = config.getInt("plsWaitTimeOut");
    public static final int hourglassTimeout = config.getInt("hourglassTimeout");

}
