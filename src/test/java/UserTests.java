import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class UserTests extends BaseConfiguration {

    @BeforeAll
    public static void chargeSetup() throws IOException {
        userSetup();
    }

    @Test
    public void getUserByUserName() {
        given()
                .when()
                .get("/test")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
