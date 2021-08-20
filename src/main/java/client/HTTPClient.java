package client;

import configs.ServiceConfig;
import io.qameta.allure.Step;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import response.BaseResponse;

import static io.restassured.RestAssured.*;

public class HTTPClient {
    @Step("GET method on {0} endpoint")
    public static BaseResponse get(String endpoint) {
        return HTTPClient.sendRequest(Method.GET, endpoint);
    }

    @Step("POST method on {0} endpoint")
    public static BaseResponse post(String endpoint, Object body) {
        return HTTPClient.sendRequest(Method.POST, endpoint, body);
    }

    @Step("PUT method on {0} endpoint")
    public static BaseResponse put(String endpoint, Object body) {
        return HTTPClient.sendRequest(Method.PUT, endpoint, body);
    }

    @Step("DELETE method on {0} endpoint")
    public static BaseResponse delete(String endpoint) {
        return HTTPClient.sendRequest(Method.DELETE, endpoint);
    }

    private static BaseResponse sendRequest(Method method, String endpoint) {
        return HTTPClient.sendRequest(method, endpoint, null);
    }

    private static BaseResponse sendRequest(Method method, String endpoint, Object body) {
        String url = ServiceConfig.HOST + endpoint;
        RequestSpecification spec = given().header("Content-Type","application/json");;
        if (body != null) spec.body(body);
        Response rawResponse = spec.request(method, url);
        return new BaseResponse(rawResponse);
    }

}
