import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StoreTests extends BaseConfiguration {

    @BeforeAll
    public static void chargeSetup() throws IOException {
        orderSetup();
    }

    @Test
    @DisplayName("Get the inventory by status")
    public void getInventory() {
        given()
                .when()
                .get("/inventory")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }
}
