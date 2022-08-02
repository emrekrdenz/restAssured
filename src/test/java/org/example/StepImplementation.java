package org.example;

import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;


public class StepImplementation {

    Map<String, String> headers = new HashMap<>();

    JSONObject jObject = null;
    Response response = null;
    public static final String BASE_URL = "https://petstore.swagger.io/v2/";
   //public static final String BASE_URL = "https://testinium.io/Testinium.RestApi/api/";


    @BeforeScenario
    public void before() {
        RestAssured.baseURI = BASE_URL;
    }


    @Step("Jobject Oluştur")
    public void createJObject()
    {
        jObject = new JSONObject();
        System.out.println("Yeni bir JObject Olusturuldu");
    }

    @Step("<key> key ve <value> value degerini JObjecte ekle")
    public void addToRequestBody(String key, String value)
    {
        jObject.put(key, value);
        System.out.println("JObject'e " + key + ":" + value + " degeri eklendi");
    }


    @Step("<api> apiye <type> methoduyla istek at")
    public void setApi(String api,String type)
    {
        if(type.equals("post"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .body(jObject.toString())
                    .post(api);
        }
        else if(type.equals("put"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .body(jObject.toString())
                    .put(api);
        }
        else if(type.equals("get"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .queryParam(jObject.toString())
                    .get(api);
        }
        else if(type.equals("delete"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .body(jObject.toString())
                    .delete(api);
        }
        else {
        System.out.println("Lütfen geçerli bir deger giriniz");
        }
        System.out.println("Response:"+response.getBody().asString());
    }

    @Step("status kod <statusCode> ile ayni mi kontrol et")
    public void checkStatusCode2(int statusCode)
    {
        Assertions.assertEquals(statusCode, response.getStatusCode(), "Status code eslesmiyor...");
        System.out.println("status kod hata kodu " + response.getStatusCode() + " ile ayni mi kontrol edildi");
    }

    @Step("response <key> alanı <value> iceriyor mu kontrol et")
    public void checkResponseMethod(String key, String value) {
        if (value.contains("null")) {
            Assertions.assertNull(response.jsonPath().get(key), key + " değeri null değil");
        } else {
            Assertions.assertTrue(value.equals(response.jsonPath().get(key).toString()), value + " degeri ile " + response.jsonPath().getString(key) + " degeri uyusmuyor");
        }
        System.out.println("response " + key + " alani  " + value + " iceriyor mu kontrol edildi");
    }

    @Step("<key> key <value> value degerini headera ekle")
    public void addHeader(String key, String value)
    {
        headers.put(key,value);
        System.out.println("Header'a " +key+ "," +value+ " degeri eklendi");
    }



}
