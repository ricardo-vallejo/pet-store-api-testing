import java.io.IOException;
import java.util.Optional;

public class ConfVariables {

    public static String getHost() throws IOException{
        return Optional.ofNullable(System.getenv("host")).orElse(ApplicationProperties.getInstance().getProperty("host"));
    }

    public static String getUserPath() throws IOException{
        return Optional.ofNullable(System.getenv("userPath")).orElse(ApplicationProperties.getInstance().getProperty("userPath"));
    }

    public static String getStorePath() throws IOException{
        return Optional.ofNullable(System.getenv("storePath")).orElse(ApplicationProperties.getInstance().getProperty("storePath"));
    }

    public static String getPetPath() throws IOException{
        return Optional.ofNullable(System.getenv("petPath")).orElse(ApplicationProperties.getInstance().getProperty("petPath"));
    }
}
