import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseConfiguration {

    private static final Logger LOGGER = LogManager.getLogger();

    public static void userSetup() throws IOException{
        LOGGER.info("Starting Configuration");
        RestAssured.requestSpecification = userRequestSpecification();
        LOGGER.info("Finishing Configuration");
    }

    public static void orderSetup() throws IOException{
        LOGGER.info("Starting Configuration");
        RestAssured.requestSpecification = orderRequestSpecification();
        LOGGER.info("Finishing Configuration");
    }

    public static void petSetup() throws IOException{
        LOGGER.info("Starting Configuration");
        RestAssured.requestSpecification = petRequestSpecification();
        LOGGER.info("Finishing Configuration");
    }

    private static RequestSpecification userRequestSpecification() throws IOException {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new AllureRestAssured());

        return new RequestSpecBuilder().setBaseUri(ConfVariables.getHost())
                .setBasePath(ConfVariables.getUserPath())
                .addFilters(filters)
                .setContentType(ContentType.JSON)
                .build();
    }

    private static RequestSpecification orderRequestSpecification() throws IOException {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new AllureRestAssured());

        return new RequestSpecBuilder().setBaseUri(ConfVariables.getHost())
                .setBasePath(ConfVariables.getStorePath())
                .addFilters(filters)
                .setContentType(ContentType.JSON)
                .build();
    }

    private static RequestSpecification petRequestSpecification() throws IOException {
        List<Filter> filters = new ArrayList<>();
        filters.add(new RequestLoggingFilter());
        filters.add(new ResponseLoggingFilter());
        filters.add(new AllureRestAssured());

        return new RequestSpecBuilder().setBaseUri(ConfVariables.getHost())
                .setBasePath(ConfVariables.getPetPath())
                .addFilters(filters)
                .setContentType(ContentType.JSON)
                .build();
    }
}
