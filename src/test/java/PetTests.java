import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PetTests extends BaseConfiguration {

    @BeforeAll
    public static void chargeSetup() throws IOException {
        setup("pet");
    }

    @Test
    public void getPetByAvailableStatus() {
        given()
                .queryParam("status", "available")
                .when()
                .get("findByStatus")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("size()", greaterThan(0))
                .body("id", everyItem(notNullValue()));
    }
}
