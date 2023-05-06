package book.store.steps;

import book.store.JsonClasses.CreateUser;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class GlobalActions {

    public GlobalActions globalActions;

    public static Response sendRequestToRest(String typeOfRequest, RequestSpecification reqSpec, Integer statusCode, String body) {
        switch (typeOfRequest.toLowerCase()) {
            case "get":
                return given().spec(reqSpec).get().then().assertThat().statusCode(statusCode).extract().response();
            case "post":
                return given().spec(reqSpec).post().then().assertThat().statusCode(statusCode).extract().response();
            case "post_body":
                return given().spec(reqSpec).body(body).post().then().assertThat().statusCode(statusCode).extract().response();
            case "put":
                return given().spec(reqSpec).put().then().assertThat().statusCode(statusCode).extract().response();
            case "patch":
                return given().spec(reqSpec).body(body).patch().then().assertThat().statusCode(statusCode).extract().response();
            case "delete":
                return given().spec(reqSpec).delete().then().assertThat().statusCode(statusCode).extract().response();
            case "delete_body":
                return given().spec(reqSpec).body(body).delete().then().assertThat().statusCode(statusCode).extract().response();
            default:
                System.out.println("Doesn't work");
        }
        return null;
    }

    public static String sendBodyCreatingUser(String userName, String password) {
        CreateUser createUser = new CreateUser(userName, password);
        return new Gson().toJson(createUser);
    }
}
