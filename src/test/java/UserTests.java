import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserTests extends BaseConfiguration {

    @BeforeAll
    public static void chargeSetup() throws IOException {
        setup("user");
    }

    @Test
    public void getUserByUserName() {
        given()
                .when()
                .get("/user1")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("username", equalTo("user1"));
    }
}
