import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.config.MultiPartConfig;
import io.restassured.http.ContentType;
import model.Pet;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static data.factory.PetDataFactory.*;
import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static org.hamcrest.Matchers.*;

public class PetTests extends BaseConfiguration {

    @BeforeAll
    public static void chargeSetup() throws IOException {
        petSetup();
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

    @Test
    public void getPetByPendingStatus() {
        given()
                .queryParam("status", "pending")
                .when()
                .get("findByStatus")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("size()", greaterThan(0))
                .body("id", everyItem(notNullValue()));
    }

    @Test
    public void getPetBySoldStatus() {
        given()
                .queryParam("status", "sold")
                .when()
                .get("findByStatus")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("size()", greaterThan(0))
                .body("id", everyItem(notNullValue()));
    }

    @Test
    public void getPetById() {
        given()
                .when()
                .get("7574746")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void registerNewPet() {
        Pet newPet = availablePet();

        given()
                .body(newPet)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", notNullValue())
                .body("id", notNullValue())
                .body("status", equalTo("AVAILABLE"));
    }

    @Test
    public void registerPendingPet() {
        Pet newPet = pendingPet();

        given()
                .body(newPet)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", notNullValue())
                .body("id", notNullValue())
                .body("status", equalTo("PENDING"));
    }

    @Test
    public void registerSoldPet() {
        Pet newPet = soldPet();

        given()
                .body(newPet)
                .when()
                .post()
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", notNullValue())
                .body("id", notNullValue())
                .body("status", equalTo("SOLD"));
    }

    @Test
    public void updatePetWithId() {
        String newName = new Faker().dog().name();
        String petId = "594973";
        given()
                .body("name="+newName+"&status=pending")
                .contentType(ContentType.URLENC)
                .when()
                .post(petId)
                .then();

        given()
                .when()
                .get(petId)
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("name", equalTo(newName));
    }

    @Test
    public void uploadImageToPet() {
        given()
                .multiPart("Cute-Pet.jpg", new File("/home/avallejo/Pictures/Cute-Pet.jpg"))
                .contentType(ContentType.MULTIPART)
                .formParam("file", "Cute-Pet.jpg")
                .formParam("type", "image/jpeg")
                .when()
                .post("13061/uploadImage")
                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .and()
                .body("message", containsString("File uploaded to "));

    }

}
