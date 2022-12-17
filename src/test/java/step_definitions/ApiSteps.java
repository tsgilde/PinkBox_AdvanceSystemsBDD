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
    Response response;
    String studentId;
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

    @Then("I add new student to db with fields with end point {string}")
    public void iAddNewStudentToDbWithFieldsWithEndPoint(String path) {
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
        System.out.println(response.jsonPath().getString("data"));
        System.out.println("========");
        studentId = response.jsonPath().getString("data._id");
        System.out.println("id--------" + studentId);

        variables = new HashMap<>();
        variables.put("id", studentId);
        System.out.println(variables);
    }

    @Then("I delete existing student with _id parameter with end point {string}")
    public void iDeleteExistingStudentWith_idParameterWithEndPoint(String path) {
        System.out.println("====================");
        System.out.println(variables);
        RestAssured.baseURI = baseUrl;
        response = given()
                .with()
                .pathParams("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .when()
                .delete(path + variables.get("id") +"?key=" + "{key}")
                .then()
                .log().all()
                .extract()
                .response();

        System.out.println("Deleted: " + response.getStatusCode());
        Assert.assertEquals(SC_OK, response.statusCode());

    }

}
