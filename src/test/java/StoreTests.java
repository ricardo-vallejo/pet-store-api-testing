import model.PlaceOrder;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static data.factory.OrderDataFactory.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

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

    @Test
    @DisplayName("Create a new order in the store with status Approved")
    public void createOrderApproved() {
        PlaceOrder newOrder = validApprovedOrder();
        given()
                .body(newOrder)
                .when()
                .post("/order")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("status", equalTo("APPROVED"));
    }

    @Test
    @DisplayName("Create a new order in the store with status Delivered")
    public void createOrderDelivered() {
        PlaceOrder newOrder = validDeliveredOrder();
        given()
                .body(newOrder)
                .when()
                .post("/order")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("status", equalTo("DELIVERED"));
    }

    @Test
    @DisplayName("Create a new order in the store")
    public void createOrder() {
        PlaceOrder newOrder = validOrder();
        given()
                .body(newOrder)
                .when()
                .post("/order")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("status", equalTo("PLACED"));
    }

    @Test
    @DisplayName("Get purchase order by ID")
    public void getOrderById() {
        given()
                .when()
                .get("/order/7")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("id", equalTo(7));
    }

    @Test
    @DisplayName("Get purchase order by not existing ID")
    public void getNotExistingOrder() {
        given()
                .when()
                .get("/order/4")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .and()
                .body("message", equalTo("Order not found"));
    }

}
