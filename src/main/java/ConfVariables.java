import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Optional;

public class ConfVariables {

    private static final Logger LOGGER = LogManager.getLogger();

    public static String getHost() throws IOException {
        LOGGER.info("Default host loaded.");
        return Optional.ofNullable(System.getenv("host")).orElse(ApplicationProperties.getInstance().getProperty("host"));
    }

    public static String getPath(String option) throws IOException {
        switch (option) {
            case "user":
                LOGGER.info("Path loaded: {}", option);
                return Optional.ofNullable(System.getenv("userPath")).orElse(ApplicationProperties.getInstance().getProperty("userPath"));
            case "store":
                LOGGER.info("Path loaded: {}", option);
                return Optional.ofNullable(System.getenv("storePath")).orElse(ApplicationProperties.getInstance().getProperty("storePath"));
            case "pet":
                LOGGER.info("Path loaded: {}", option);
                return Optional.ofNullable(System.getenv("petPath")).orElse(ApplicationProperties.getInstance().getProperty("petPath"));
            default:
                LOGGER.info("Path loaded: {}", option);
                return Optional.ofNullable(System.getenv("empty")).orElse(ApplicationProperties.getInstance().getProperty("empty"));
        }
    }
}
