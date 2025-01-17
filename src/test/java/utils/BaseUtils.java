package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class BaseUtils {

    private static Response response;

    public static Response getResponse() {
        return response;
    }

    public static void setBaseURI(String uri){
        RestAssured.baseURI = uri;

    }

    public static String getBaseURI(){
        return RestAssured.baseURI;
    }

    public static Response post(Object json, ContentType contentType, String endpoint){
        return response = RestAssured.given()
                .contentType(contentType)
                .body(json)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();

    }

    public static Response post(Map<String, String> header, Object json, ContentType contentType, String endpoint){
        return response = RestAssured.given()
                .contentType(contentType)
                .headers(header)
                .body(json)
                .log().all()
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .extract().response();

    }

    public static Response get(Map<String, String> hearder, String endpoint){
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(hearder)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response get(Map<String, String> hearder,Map<String, Object> param, String endpoint){
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(hearder)
                .params(param)
                .log().all()
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response put(Map<String, String> header, Object json, ContentType contentType, String endpoint){
        return response = RestAssured.given()
                .contentType(contentType)
                .headers(header)
                .body(json)
                .log().all()
                .when()
                .put(endpoint)
                .then()
                .log().all()
                .extract().response();

    }

    public static Response delete(Map<String, String> hearder,Map<String, Object> param, String endpoint){
        return response = RestAssured.given()
                .relaxedHTTPSValidation()
                .headers(hearder)
                .params(param)
                .log().all()
                .when()
                .delete(endpoint)
                .then()
                .log().all()
                .extract().response();
    }
}
