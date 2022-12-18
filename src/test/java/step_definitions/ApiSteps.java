package step_definitions;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;

public class ApiSteps {
    public static String baseUrl = "https://tla-school-api.herokuapp.com" ;
    String path = "/api/school/resources/students";
    String pathDev = "/api/school/programs/devcourse";
    String pathSdet = "/api/school/programs/sdetcourse";
    Response response;
    String studentId;
    String devName;
    String sdetName;
    static Map<String, Object> variables;

//    public ApiSteps() {
//    }

    @Then("Get all students")
    public void getAllStudents() {

        RestAssured.baseURI = baseUrl;
        Response response =
            given()
                .contentType(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I add new student to db with fields using end point {string}")
    public void iAddNewStudentToDbWithFieldsUsingEndPoint(String path) {
        RestAssured.baseURI = baseUrl;
        String requestBody =  "{\n" +
                "  \"batch\": 6,\n" +
                "  \"firstName\": \"Anne2222\",\n" +
                "  \"lastName\": \"Iem\",\n" +
                "  \"email\": \"test@test.com\"\n" +
                "}";

        response = given()
                .header("Content-Type" , "application/json")
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
        RestAssured.baseURI = baseUrl;
        response = given()
                .with()
                .pathParams("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .when()
                .delete(path + variables.get("id") + "?key=" + "{key}")
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I update existing student with _id parameter using end point {string}")
    public void iUpdateExistingStudentWith_idParameterUsingEndPoint(String path) {
        RestAssured.baseURI = baseUrl;

        String updateInfo = "{\"_id\":\""+variables.get("id")+"\"," +
                "\"batch\":6.5,\"firstName\":\"Pinkbox\"," +
                "\"lastName\":\"Team\"," +
                "\"email\":\"test1234@test.com\",\"__v\":0}";

        //System.out.println("update====" + updateInfo);

        response = given()
                .header("Content-type", "application/json")
                //.header("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .pathParams("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .and()
                .body(updateInfo)
                .when()
                .put(path + variables.get("id") + "?key=" + "{key}")
                .then()
                .log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());

    }

    @Then("I should see an update existing student")
    public void iShouldSeeAnUpdateExistingStudent() {
        RestAssured.baseURI = baseUrl;
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(path + "/" + variables.get("id"))
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
        RestAssured.baseURI = baseUrl;
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
        RestAssured.baseURI = baseUrl;
        String requestBody =  "{\n" +
                "            \"duration\": \"6 months\",\n" +
                "            \"name\": \"DevOps\",\n" +
                "            \"__v\": 0\n" +
                "        }";

        response = given()
                .header("Content-Type" , "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(path)
                .then().log().all()
                .extract()
                .response();

        Assert.assertEquals(SC_OK, response.statusCode());

        devName = response.jsonPath().getString("data.name");

        variables = new HashMap<>();
        variables.put("name", devName);

    }

    @Then("Get all sdet courses")
    public void getAllSdetCourses() {
        RestAssured.baseURI = baseUrl;
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
        RestAssured.baseURI = baseUrl;
        String requestBody =  "{\n" +
                "            \"duration\": \"3 months\",\n" +
                "            \"name\": \"API\",\n" +
                "            \"__v\": 0\n" +
                "        }";

        response = given()
                .header("Content-Type" , "application/json")
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
        RestAssured.baseURI = baseUrl;
        response = given()
                .with()
                .pathParams("name", "DevOps")
                .when()
                .delete(path + variables.get("name"))
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());
    }

    @Then("I delete an existing sdet course with name using endpoint {string}")
    public void iDeleteAnExistingSdetCourseWithNameUsingEndpoint(String path) {
        RestAssured.baseURI = baseUrl;
        response = given()
                .with()
                .pathParams("name", "API")
                .when()
                .delete(path + variables.get("name"))
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());
    }
}

