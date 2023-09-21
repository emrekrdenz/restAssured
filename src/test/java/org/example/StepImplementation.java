package org.example;

import com.thoughtworks.gauge.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;


public class StepImplementation {

    JSONObject jObject = null;
    Response response = null;
    String jsonBody=null;

    static HashMap<String, Object> hashMap = new HashMap<String, Object>();
    static HashMap<String, String> headers = new HashMap<>();
    static HashMap<String, String> params = new HashMap<>();

    @Step("Jobject Oluştur")
    public void createJObject()
    {
        jObject = new JSONObject();
        System.out.print("Yeni bir JObject Olusturuldu");
    }

    @Step("<key> key ve <value> value degerini JObjecte ekle")
    public void addToRequestBody(String key, String value)
    {
        jObject.put(key, value);
        System.out.print("JObject'e " + key + ":" + value + " degeri eklendi");
    }

    @Step("<api> apiye <type> methoduyla istek at")
    public void setApi(String api,String type)
    {
        System.out.println(api + " servisine " + type + " istegi atildi" );
        if(type.equals("post"))
        {
            response= RestAssured.given().headers(headers).queryParams(params)
                    .body(jObject.toString())
                    .post(api);
        }
        else if(type.equals("put"))
        {
            response= RestAssured.given().headers(headers).queryParams(params)
                    .contentType(ContentType.JSON)
                    .body(jObject.toString())
                    .put(api);
        }
        else if(type.equals("get"))
        {
            response= RestAssured.given().headers(headers).queryParams(params)
                    .contentType(ContentType.JSON)
                    .queryParam(jObject.toString())
                    .get(api);
        }
        else if(type.equals("delete"))
        {
            response= RestAssured.given().headers(headers).queryParams(params)
                    .contentType(ContentType.JSON)
                    .body(jObject.toString())
                    .delete(api);
        }
        else {
            System.out.println("Lütfen geçerli bir deger giriniz");
        }
        System.out.println("Request:"+jObject.toString());
        System.out.println("Response:"+response.getBody().asString());
    }



    @Step("status kod <statusCode> ile ayni mi kontrol et")
    public void checkStatusCode2(int statusCode)
    {
        Assertions.assertEquals(statusCode, response.getStatusCode(), "Status code eslesmiyor...");
        System.out.print("status kod hata kodu " + response.getStatusCode() + " ile ayni mi kontrol edildi");
    }

    @Step("response <key> alanı <value> iceriyor mu kontrol et")
    public void checkResponseMethod(String key, String value) {
        if (value.contains("null")) {
            Assertions.assertNull(response.jsonPath().get(key), key + " değeri null değil");
        } else {
            Assertions.assertTrue(value.equals(response.jsonPath().get(key).toString()), value + " degeri ile " + response.jsonPath().getString(key) + " degeri uyusmuyor");
        }
        System.out.print("response " + key + " alani  " + value + " iceriyor mu kontrol edildi");
    }

    @Step("response <key> keyinin degerini <hashmapKey> olarak kaydet")
    public void responseHashmap(String key, String hashmapKey) {
        hashMap.put(hashmapKey, response.jsonPath().get(key).toString());
        System.out.println("response " + key + " keyinin degerini " + hashmapKey + " olarak kaydedildi");
    }

    @Step("<key> keyine hashmapdeki <value> keyli değeri JObjecte ekle")
    public void AddElementHashmapToRest(String key,String value){
        jObject.put(key, hashMap.get(value).toString());
        System.out.print("JObject'e " + key + ":" + hashMap.get(value).toString() + " degeri eklendi");
    }


    @Step("<request> json pathindeki requestBodyi hazırla")
    public void requestBody(String path) throws IOException {
        jsonBody = generateStringFromResource("src/test/resources/".concat(path).concat(".json"));
    }


    @Step("<api> requestBodydeki degerlerle servise <type> methoduyla istek at")
    public void setApiJson(String api,String type) throws IOException {

        System.out.println(RestAssured.baseURI + RestAssured.basePath + " servisine " + type + " istegi atildi" );
        if(type.equals("post"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                    .post(api);
        }
        else if(type.equals("put"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                    .put(api);
        }
        else if(type.equals("get"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .queryParam(jsonBody.toString())
                    .get(api);
        }
        else if(type.equals("delete"))
        {
            response= RestAssured.given().headers(headers)
                    .contentType(ContentType.JSON)
                    .body(jsonBody)
                    .delete(api);
        }
        else {
            System.out.println("Lütfen geçerli bir deger giriniz");
        }
        System.out.println("Request:"+jsonBody);
        System.out.println("Response:"+response.getBody().asString());
    }



    public String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }

    @Step("<key> keyli <value> degeri hashmap'e ekle")
    public void addHashmapManuel(String key, String value) {
        hashMap.put(key, value);
        System.out.println(key + " keyli " + value + " degeri manuel olarak hashmap'e eklendi");
    }


    @Step("<key> key <value> value degerini headera ekle")
    public void addHeader(String key, String value) {
        headers.put(key, value);
        System.out.println("Header'a " + key + "," + value + " degeri eklendi");
    }

    @Step("<key> key <value> value degerini queryParam olarak ekle")
    public void addQuery(String key, String value) {
        params.put(key, value);
        System.out.println("Query parametreleri " + key + "," + value + " olarak eklendi");
    }

    @Step("Hashmapten <key> key <value> value degerini queryParam olarak ekle")
    public void addQueryHashmapten(String key, String value) {
        params.put(key, hashMap.get(value).toString());
        System.out.println("Query parametreleri " + key + "," + value + " olarak eklendi");
    }

    @Step("Hashmapin icindeki <hashmapKey> keyinin degeri <hashmapKey2> keyinin degeri ile <type> mı kontrol et")
    public void checkDifferenceHashmap(String hashmapKey, String hashmapKey1, String type) {
        if ("aynı".equals(type)) {
            Assertions.assertEquals(hashMap.get(hashmapKey).toString(), hashMap.get(hashmapKey1).toString(), "hashmapteki degerler eslesiyor...");
            System.out.println(hashMap.get(hashmapKey).toString() + " , " + hashMap.get(hashmapKey1).toString() + " ile " + type + "mi kontrol edildi");
        } else if ("farklı".equals(type)) {
            Assertions.assertNotEquals(hashMap.get(hashmapKey).toString(), hashMap.get(hashmapKey1).toString(), "hashmapteki degerler eslesmiyor...");
            System.out.println(hashMap.get(hashmapKey).toString() + " , " + hashMap.get(hashmapKey1).toString() + " ile " + type + " mi kontrol edildi");
        } else {
            Assertions.fail("Lütfen Gecerli bir tip giriniz");
        }
    }



}




