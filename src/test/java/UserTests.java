import com.github.javafaker.Faker;
import io.restassured.http.ContentType;
import model.User;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static builder.UserRequestBuilder.createUser;
import static data.factory.UserDataFactory.nullInformation;
import static data.factory.UserDataFactory.validUser;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

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
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("username", equalTo("test"));
    }

    @Test
    public void getNotExistingUser() {
        given()
                .when()
                .get("/foo")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_NOT_FOUND)
                .and()
                .body("type", equalTo("error"))
                .body("message", equalTo("User not found"));
    }

    @Test
    public void createValidUser() {
        User validUser = validUser();
        given()
                .body(validUser)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("code", equalTo(200));
    }

    @Test
    public void createInvalidUser() {
        User nullInformation = nullInformation();
        given()
                .body(nullInformation)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("code", equalTo(200));
    }

    @Test
    public void loginUser() {
        given()
                .queryParam("username", "toya.hayes")
                .queryParam("password", "flzp9h9o67q09")
                .when()
                .get("login")
                .then()
                .assertThat()
                .header("X-Expires-After", notNullValue())
                .header("X-Rate-Limit", equalTo("5000"));
    }

    @Test
    public void updateUser() {
        String username = "barabara.daugherty";
        String firstName = new Faker().name().firstName();
        User updateUser = createUser()
                .withId(44675981)
                .withUserName(username)
                .withFirstName(firstName)
                .withLastName("Shanahan")
                .withEmail("sol.mraz@hotmail.com")
                .withPassword("3jok9mw4vr")
                .withPhone("1-182-993-6067 x18680")
                .withUserStatus(0)
                .build();

        given()
                .body(updateUser)
                .when()
                .put(username)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

        given()
                .when()
                .get(username)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("firstName", equalTo(firstName));
    }
}
