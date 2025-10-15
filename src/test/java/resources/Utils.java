package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    public RequestSpecification requestSpecification() throws IOException {
        PrintStream log = new PrintStream(Files.newOutputStream(Paths.get("logging.txt")));
        return new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
    }

    public ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON).build();
    }

    //driving from global variables
    public static String getGlobalValue(String propKey) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\LAPTOPS24\\Documents\\GitHub\\CucumberBDDAutomation\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(propKey);
    }
}
