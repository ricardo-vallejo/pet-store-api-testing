import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;
import java.util.Properties;

import static org.apache.logging.log4j.core.util.Loader.getClassLoader;

public class ApplicationProperties {

    private static Properties instance = null;
    private static final String APPLICATION_SUFFIX = "properties";
    private static final Logger LOGGER = LogManager.getLogger();

    public static synchronized Properties getInstance() throws IOException {
        if (instance == null) {
            instance = loadPropertiesFile();
        }

        return instance;
    }

    private ApplicationProperties(){}

    private static Properties loadPropertiesFile() throws IOException {
        String environment = Optional.ofNullable(System.getenv("env")).orElse("application");

        String fileName = String.format("%s.%s", environment, APPLICATION_SUFFIX);
        LOGGER.info("Property file to read: {}", fileName);

        Properties properties = new Properties();
        properties.load(getClassLoader().getResourceAsStream(fileName));

        return properties;
    }
}
