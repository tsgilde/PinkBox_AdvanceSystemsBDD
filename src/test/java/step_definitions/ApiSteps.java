package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class ApiSteps {
    public ApiSteps() {

    }
   // public static String baseUrl = "https://tla-school-api.herokuapp.com";
    private static final String pathStudent = "/api/school/resources/students";
    private static final String pathDev = "/api/school/programs/devcourse";
    private static final String pathSdet = "/api/school/programs/sdetcourse";
    private static final String pathToken = "/api/school/departments/gettoken";
    Response response;
    String studentId;
    String devName;
    String sdetName;
    static Map<String, Object> variables;

    @Given("User gets Base URL")
    public void userGetsBaseURL() {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        //RestAssured.baseURI = baseUrl;
        System.out.println(RestAssured.baseURI);
    }

    @When("User send GET request to the endpoint {string}")
    public void userSendGETRequestToTheEndpoint(String endPoint) {
        response = RestAssured.given()
                .when()
                .get(pathDev)
                .then()
                .log().all()
                .extract()
                .response();
        System.out.println(response);

    }

    @Then("User should get status code {int}")
    public void userShouldGetStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.statusCode());
    }

    @Then("the response should include fields called {string}, {string} and {string}")
    public void theResponseShouldIncludeFieldsCalledAnd(String field1, String field2, String field3) {
        Assert.assertNotNull(response.jsonPath().getString("data." + field1 + "[0]"));
        Assert.assertNotNull(response.jsonPath().getString("data." + field2 + "[0]"));
        Assert.assertNotNull(response.jsonPath().getString("data." + field3 + "[0]"));
    }

    @Then("the response should include following fields")
    public void theResponseShouldIncludeFollowingFields(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            Assert.assertNotNull(response.jsonPath().getString("data." + list.get(i) + "[0]"));
        }
    }

    @Then("Get all students")
    public void getAllStudents() {

        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(pathStudent)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }


    @Then("I add new student to db with fields using end point {string}")
    public void iAddNewStudentToDbWithFieldsUsingEndPoint(String path) {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        String requestBody = "{\n" +
                "  \"batch\": 6,\n" +
                "  \"firstName\": \"Anne2222\",\n" +
                "  \"lastName\": \"Iem\",\n" +
                "  \"email\": \"test@test.com\"\n" +
                "}";

        response = given()
                .header("Content-Type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(path)
                .then().log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());

        studentId = response.jsonPath().getString("data._id");

        variables = new HashMap<>();
        variables.put("id", studentId);
    }

    @Then("I delete existing student with _id parameter using end point {string}")
    public void iDeleteExistingStudentWith_idParameterUsingEndPoint(String path) {
        System.out.println("====================");
        System.out.println(variables);
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        response = given()
                .with()
                .queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .when()
                .delete(path + variables.get("id"))
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I update existing student with _id parameter using end point {string}")
    public void iUpdateExistingStudentWith_idParameterUsingEndPoint(String path) {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        String updateInfo = "{\"_id\":\"" + variables.get("id") + "\"," +
                "\"batch\":6.5,\"firstName\":\"Pinkbox\"," +
                "\"lastName\":\"Team\"," +
                "\"email\":\"test1234@test.com\",\"__v\":0}";

        //System.out.println("update====" + updateInfo);

        response = given()
                .header("Content-type", "application/json")
                .queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .and()
                .body(updateInfo)
                .when()
                .put(path + variables.get("id"))
                .then()
                .log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I should see an update existing student")
    public void iShouldSeeAnUpdateExistingStudent() {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(pathStudent + "/" + variables.get("id"))
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response();

        Assert.assertEquals(SC_OK, response.statusCode());
        System.out.println(response.jsonPath().getString("data"));
    }

    @Then("Get all dev courses")
    public void getAllDevCourses() {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(pathDev)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I add a new dev course to db with fields using endpoint {string}")
    public void iAddANewDevCourseToDbWithFieldsUsingEndpoint(String path) {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        String requestBody = "{\n" +
                "  \"duration\": \"6 months .....\",\n" +
                "  \"name\": \"Develop%\"\n" +
                "}";

        response = given()
                .header("Content-Type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(path)
                .then().log().all()
                .extract()
                .response();
        System.out.println(response);

        Assert.assertEquals(SC_OK, response.statusCode());
        System.out.println("======response======");
        System.out.println(response);

        devName = response.jsonPath().getString("data.name");
        System.out.println(devName);
        variables = new HashMap<>();
        variables.put("name", devName);
        System.out.println("Variable-========" + variables);
    }

    @Then("Get all sdet courses")
    public void getAllSdetCourses() {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(pathSdet)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I add a new sdet course to db with fields using endpoint {string}")
    public void iAddANewSdetCourseToDbWithFieldsUsingEndpoint(String path) {

        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");
        String requestBody = "{\n" +
                "  \"duration\": \"2 months .....\",\n" +
                "  \"name\": \"API..\"\n" +
                "}";

        response = given()
                .header("Content-Type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(path)
                .then().log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());

        sdetName = response.jsonPath().getString("data.name");

        variables = new HashMap<>();
        variables.put("name", sdetName);
    }

    @Then("I delete an existing dev course with name using endpoint {string}")
    public void iDeleteAnExistingDevCourseWithNameUsingEndpoint(String path) {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        response = given()
                .with()
                .queryParam("name", variables.get("name"))
                .when()
                .delete(path)
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I delete an existing sdet course with name using endpoint {string}")
    public void iDeleteAnExistingSdetCourseWithNameUsingEndpoint(String path) {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        response = given()
                .with()
                .queryParam("name", variables.get("name"))
                .when()
                .delete(path)
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I send a GET request with username and password using end point {string}")
    public void iSendAGETRequestWithUsernameAndPasswordUsingEndPoint(String arg0) {

        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        response = given()
                .auth()
                .preemptive()
                .basic("user", "user123")
                .when()
                .get(pathToken)
                .then()
                .assertThat()
                .statusCode(SC_OK)
                .log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("Verify error message {string} when send invalid credentials")
    public void verifyErrorMessageWhenSendInvalidCredentials(String arg0) {
        RestAssured.baseURI = ConfigReader.readProperty("BASE_URL");

        response = given()
                .auth()
                .basic("user", "user123")
                .when()
                .get(pathToken)
                .then()
                .assertThat()
                .statusCode(401)
                .log().all()
                .extract()
                .response();
        Assert.assertEquals("Valid username and password required",
                response.jsonPath().getString("message"));
    }
}


